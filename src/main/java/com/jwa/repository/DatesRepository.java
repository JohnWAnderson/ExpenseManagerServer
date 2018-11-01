package com.jwa.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jwa.model.Dates;
/**
 * 
 * @author John Anderson
 *
 * Date Repository
 */
public interface DatesRepository extends JpaRepository<Dates, Long> {
	/**
	 * @param date the date to look for
	 * @return return date if found
	 */
	Optional<Dates> findByThedate(LocalDate date);

}
