package com.jwa.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jwa.model.Dates;

public interface DatesRepository extends JpaRepository<Dates, Long> {
	
	Optional<Dates> findByThedate(LocalDate date);

}
