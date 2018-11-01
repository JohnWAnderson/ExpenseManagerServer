package com.jwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwa.model.Role;
import com.jwa.model.RoleType;

import java.util.Optional;

/**
 * @author John Anderson
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	/**
	 * @param roleName the enum role type
	 * @return return the role model object
	 */
    Optional<Role> findByName(RoleType roleName);
}