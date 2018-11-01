package com.jwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwa.model.User;

import java.util.List;
import java.util.Optional;
/**
 * @author John Anderson
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * @param email the email of the user
	 * @return the user object
	 */
    Optional<User> findByEmail(String email);

    /**
     * @param username the user of the user
     * @param email the email of the user
     * @return the user object
     */
    Optional<User> findByUsernameOrEmail(String username, String email);

    /**
     * @param username the user of the user
     * @return the user object
     */
    Optional<User> findByUsername(String username);

    /**
     * @param username the user of the user
     * @return boolean , true if exists else false
     */
    Boolean existsByUsername(String username);

    /**
     * @param email the email of the user
     * @return boolean , true if exists else false
     */
    Boolean existsByEmail(String email);
}