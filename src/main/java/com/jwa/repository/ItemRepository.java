package com.jwa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jwa.model.Item;

/**
 * @author John Anderson
 *  
 */
public interface ItemRepository extends JpaRepository<Item, Long>{
	/**
	 * @param name the name to look for
	 * @return returns name if found
	 */
     Optional<Item> findByName(String name);
     
     /**
      * @param userId the id of the user to look for
      * @return the list of Items to the user
      */
     List<Item> findByUserId(Long userId);
     
     /**
      * @param name the name of the item
      * @param username the user name of the user
      * @return the list of Items to the user 
      */
     @Query("Select i FROM Item i JOIN i.user u where i.name = ?1 and u.username = ?2 ")
     List<Item> findItemByUser(String name, String username);
}
