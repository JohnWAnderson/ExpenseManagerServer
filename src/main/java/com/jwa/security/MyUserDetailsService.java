package com.jwa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jwa.model.User;
import com.jwa.repository.UserRepository;
/**
 * @author John Anderson
 */
@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

	/**
	 * @param usernameOrEmail email or user name to try to load
	 * @return userObject of existing user
	 */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
    	User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() -> 
                        (new UsernameNotFoundException("User with username or email Deosn't exist: " + usernameOrEmail)));
     return UserObject.create(user);
    }
    
	/**
	 * @param id of the user to load
	 * @return userObject of created user
	 */
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> 
        	(new UsernameNotFoundException("User id not found : " + id)));
        return UserObject.create(user);
    }
}
