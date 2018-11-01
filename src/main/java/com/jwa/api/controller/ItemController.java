package com.jwa.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwa.api.payload.request.ItemRequestObject;
import com.jwa.api.payload.request.ItemUpdateRequestObject;
import com.jwa.api.payload.response.ApiResponseObject;
import com.jwa.api.payload.response.ItemResponseObject;
import com.jwa.api.payload.response.PagedResponseObject;

import com.jwa.security.CurrentUser;
import com.jwa.security.UserObject;
import com.jwa.service.ItemService;

/**
 * 
 * @author John Anderson
 * Controllers all user with jwt token to access their information related to their accounts items
 */
@RestController
@RequestMapping("/api/items")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	/**
	 * attempts to create an item for the user
	 * 
	 * @param ItemRequest Request payload that has the information to create an item in the database for their account
	 * @return APIResponseObject, true if action was completed successfully or false if error is through within
	 */
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ApiResponseObject createItem(@Valid @RequestBody ItemRequestObject ItemRequest ) {
    	return (new ApiResponseObject(itemService.addItem(ItemRequest, null), "item Created Successfully"));
    }
    
    /**
     * Checks to make sure that they don't have multiple items with same name
     * 
     * @param currentUser The information of the current user
     * @param name The Item name to check for duplicates in user only
     * @return APIResponseObject, true if name was available or false if error is through within
     */
    @GetMapping("/task")
    @PreAuthorize("hasRole('USER')")
    public ApiResponseObject checkItemNameAvailable(@CurrentUser UserObject currentUser, @RequestParam(value = "name") String name) {
        if(itemService.checkItemNameAvailable(currentUser.getUsername(), name))
        	return (new ApiResponseObject( true, "item Created Successfully"));
        else
        	return (new ApiResponseObject( false, "item Created Successfully"));
    }
    
    /**
     * Gets all of the users items
     * 
     * @param currentUser The information of the current user
     * @return PagedResponseObject , with ItemResponseObject with information of each item
     */
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public PagedResponseObject<ItemResponseObject> getItems(@CurrentUser UserObject currentUser){
		return (new PagedResponseObject<ItemResponseObject>(itemService.getItems(currentUser.getUsername())));
    }
    
    /**
     * Attempts to update a item if possible
     * 
     * @param itemUpdateRequest The information of the to update item
     * @return ApiResponseObject true if item was updated or false if error is through within
     */
    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public ApiResponseObject updateItem(@Valid @RequestBody ItemUpdateRequestObject itemUpdateRequest ) {
		return (new ApiResponseObject(itemService.editItem(itemUpdateRequest), "item updated Successfully"));
    }
    
    /**
     * Attempts to delete a item
     * 
     * @param itemUpdateRequest The information of the item to delete
     * @return ApiResponseObject true if item was deleted or false if error is through within
     */
    @DeleteMapping
    @PreAuthorize("hasRole('USER')")
    public ApiResponseObject deleteItem(@Valid @RequestBody ItemRequestObject itemUpdateRequest ) {
    	return (new ApiResponseObject(itemService.deleteItem(itemUpdateRequest.getName(), itemUpdateRequest.getUserName()), "item updated Successfully"));
    }
    
}
