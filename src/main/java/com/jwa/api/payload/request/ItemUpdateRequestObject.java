package com.jwa.api.payload.request;


import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jwa.model.RecurringType;

/**
 * 
 * @author John Anderson
 * 
 * The request object of item to update
 */
public class ItemUpdateRequestObject {	
    @NotBlank
    @Size(max = 40)
	private String name;
    
    @NotBlank
    @Size(max = 40)
	private String oldName;   

    @Size(max = 225)
	private String description;
    
    @NotNull
	private int cost;
    
    @NotBlank
    private String userName;

    @NotNull
    private LocalDate duedate;
    
    @NotBlank
    private String group;
    
    @NotNull
    private boolean recurring;
    
    @Enumerated(EnumType.STRING)
    private RecurringType recurringsize;
    private boolean enddate;
    private LocalDate endrecurring;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}
	
	public boolean isRecurring() {
		return recurring;
	}

	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	public RecurringType getRecurringsize() {
		return recurringsize;
	}

	public void setRecurringsize(RecurringType recurringsize) {
		this.recurringsize = recurringsize;
	}

	public boolean isEnddate() {
		return enddate;
	}

	public void setEnddate(boolean enddate) {
		this.enddate = enddate;
	}

	public LocalDate getEndrecurring() {
		return endrecurring;
	}

	public void setEndrecurring(LocalDate endrecurring) {
		this.endrecurring = endrecurring;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "ItemUpdateRequestObject [name=" + name + ", oldName=" + oldName + ", description=" + description
				+ ", cost=" + cost + ", userName=" + userName + ", duedate=" + duedate + ", group=" + group
				+ ", recurring=" + recurring + ", recurringsize=" + recurringsize + ", enddate=" + enddate
				+ ", endrecurring=" + endrecurring + "]";
	}

	
}
