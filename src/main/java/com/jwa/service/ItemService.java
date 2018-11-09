package com.jwa.service;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwa.api.payload.request.ItemRequestObject;
import com.jwa.api.payload.request.ItemUpdateRequestObject;
import com.jwa.api.payload.response.ItemResponseObject;
import com.jwa.exception.ApiError;
import com.jwa.model.Dates;
import com.jwa.model.Groups;
import com.jwa.model.Item;
import com.jwa.model.Recurring;
import com.jwa.model.RecurringType;
import com.jwa.model.User;
import com.jwa.repository.DatesRepository;
import com.jwa.repository.GroupsRepository;
import com.jwa.repository.ItemRepository;
import com.jwa.repository.RecurringRepository;
import com.jwa.repository.UserRepository;
/**
 * @author John Anderson
 * Handles the item controller in spring service 
 */

@Service
public class ItemService {
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RecurringRepository recurringRepository;
	
	@Autowired
	private DatesRepository datesRepository;
	
	@Autowired 
	private GroupsRepository groupsRepository;
	
	/**
	 * 
	 * @param ItemRequest payload object with item information
	 * @param item empty if non update and has existing item update
	 * @return boolean if successful
	 */
	@Transactional
	public boolean addItem(ItemRequestObject ItemRequest, Item item) {
    	if(ItemRequest.getCost() < 0) {
    		throw (new ApiError("Can't have negitive cost"));
    	}
    	
    	User theUser = loadUser(ItemRequest.getUserName());
    	if(item== null) {
    		checkItem(theUser, ItemRequest.getName());
    		item = new Item();
    	}
		item.setUser(theUser);
		item.setName(ItemRequest.getName());
		item.setCost(ItemRequest.getCost());
		item.setDescription(ItemRequest.getDescription());
		item.setDuedate(addDate(ItemRequest.getDuedate()));
		item.setIgroup(addGroup(ItemRequest.getGroup()));
		item.setRecurring(addRecurring(ItemRequest.getRecurringsize()));
		item.setEnddate(addDate(ItemRequest.getEndrecurring()));
		itemRepository.save(item);
		return true;	
	}
	
	/**
	 * @param itemUpdateRequest payload object with item information to update
	 * @return  boolean if successful
	 */
	@Transactional
	public boolean editItem(ItemUpdateRequestObject itemUpdateRequest) {
		List<Item> theTaskList = itemRepository.findItemByUser(itemUpdateRequest.getOldName(), itemUpdateRequest.getUserName());
		Item theItem = theTaskList.get(0);
		ItemRequestObject updateItem = new ItemRequestObject(itemUpdateRequest);
		return addItem(updateItem, theItem);
	}
	
	/**
	 * @param userName of the current user
	 * @return returns list of all items in Payload form
	 */
	public List<ItemResponseObject> getItems(String userName){
		User theUser = loadUser(userName);
		boolean enddate;
		LocalDate endrecurring;
		List<ItemResponseObject> ItemConent = new ArrayList<ItemResponseObject>();
		System.out.println(theUser.getItems());
		for(Item item: theUser.getItems()) {
			if(item.getEnddate().getThedate() == null) {
				endrecurring = null;
				enddate=false;}
			else{
				enddate= true;
				endrecurring = item.getEnddate().getThedate();}
			ItemConent.add(new ItemResponseObject(item.getName(), item.getDescription(), item.getCost(), item.getDuedate().getThedate(), item.getIgroup().getThegroup() , item.getRecurring().isRecurring(),
					item.getRecurring().getRecurringsize(), enddate, endrecurring));
		}
		return ItemConent;
	}
	
	/**
	 * @param userName of the current user
	 * @param itemName of the a item
	 * @return boolean if Available
	 */
	public boolean checkItemNameAvailable(String userName, String itemName) {
		User theUser = loadUser(userName);	
		for(Item items: theUser.getItems()) {
			if(items.getName().equals(itemName)) 
				return false;
		}
		return true;
	}
	
	/**
	 * @param theUser The current user object
	 * @param ItemName the name of the item
	 */
	public void checkItem(User theUser, String ItemName) {
		for(Item items: theUser.getItems()) {
			if(items.getName().equals(ItemName)) 
				throw (new ApiError("Expense Name already Exists"));
		}
	}
	
	/**
	 * @param name of the item
	 * @param userName of the current user
	 * @return boolean if successful
	 */
	public boolean deleteItem(String name, String userName) {
    	List<Item> theTaskList = itemRepository.findItemByUser(name, userName);
    	Item theItem = theTaskList.get(0);
    	itemRepository.delete(theItem);
		return true;
	}
	
	/**
	 * @param UserName of the current user
	 * @return returns the user
	 */
	public User loadUser(String UserName) {
		Optional<User> userOption = userRepository.findByUsername(UserName);
		if(!userOption.isPresent())
			throw (new ApiError("Didn't find User"));
		return userOption.get();
	}
	
	/**
	 * @param recurring enum typed recurring
	 * @return the recurring model object type
	 */
	@Transactional
	public Recurring addRecurring(RecurringType recurring) {
		Optional<Recurring> recurringOption = recurringRepository.findByRecurringsize(recurring);
		if(!recurringOption.isPresent())
			throw (new ApiError("Didn't find recurring"));
		
		return recurringOption.get();
	}
	
	/**
	 * @param date in java date form
	 * @return Dates model object
	 */
	@Transactional
	public Dates addDate(LocalDate date) {
		Optional<Dates> dateOption = datesRepository.findByThedate(date);
		if(!dateOption.isPresent()) {
			Dates newDate = new Dates(date);
			datesRepository.save(newDate);
			return newDate;
		}
		else 
			return dateOption.get();
	}
	
	/**
	 * @param date in java date form
	 * @return Dates model object
	 */
	@Transactional
	public Groups addGroup(String group) {
		Optional<Groups> GroupOption = groupsRepository.findByThegroup(group);
		if(!GroupOption.isPresent()) {
			Groups newGroup = new Groups(group);
			groupsRepository.save(newGroup);
			return newGroup;
		}
		else 
			return GroupOption.get();
	}
}
