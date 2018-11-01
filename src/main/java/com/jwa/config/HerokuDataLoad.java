package com.jwa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jwa.model.Dates;
import com.jwa.model.Recurring;
import com.jwa.model.RecurringType;
import com.jwa.model.Role;
import com.jwa.model.RoleType;
import com.jwa.repository.DatesRepository;
import com.jwa.repository.RecurringRepository;
import com.jwa.repository.RoleRepository;
/**
 * 
 * @author John Anderson
 *
 * User for heroku and having it restart the server a lot, so need to load data in the first time, but not each time
 * using a data.sql will load every time and case errors
 */
@Component
public class HerokuDataLoad implements ApplicationRunner {

	@Autowired
	private DatesRepository datesRepository;
	@Autowired	
	private RecurringRepository recurringRepository;
	@Autowired	
	private RoleRepository roleRepository;
	
	/**
	 * Just for heroku because server restarts when not in use
	 */
    public void run(ApplicationArguments args) {
    	if(datesRepository.count() == 0) {
    		datesRepository.save(new Dates(null));
    	}
    	if(recurringRepository.count() == 0) {
    		recurringRepository.save(new Recurring(false, RecurringType.none));
    		recurringRepository.save(new Recurring(true, RecurringType.daily));
    		recurringRepository.save(new Recurring(true, RecurringType.weekly));
    		recurringRepository.save(new Recurring(true, RecurringType.biweekly));
    		recurringRepository.save(new Recurring(true, RecurringType.monthly));
    	}
    	if(roleRepository.count() == 0) {
    		roleRepository.save(new Role(RoleType.ROLE_USER));
    		roleRepository.save(new Role(RoleType.ROLE_ADMIN));
    	}
    }
}