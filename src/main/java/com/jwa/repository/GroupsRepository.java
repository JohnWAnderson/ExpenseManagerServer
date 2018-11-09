package com.jwa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwa.model.Groups;


public interface GroupsRepository  extends JpaRepository<Groups, Long> {

	Optional<Groups> findByThegroup(String thegroup);
}
