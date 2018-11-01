package com.jwa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwa.model.Recurring;
import com.jwa.model.RecurringType;
/**
 * @author John Anderson
 */
public interface RecurringRepository extends JpaRepository<Recurring, Long> {

	/**
	 * @param type The enum type to look up
	 * @return returns the Recurring object based on the enum type
	 */
	Optional<Recurring> findByRecurringsize(RecurringType type);
}
