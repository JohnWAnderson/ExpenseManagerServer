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
 * The request object for items to add
 */
public class ItemRequestObject {
	@NotBlank
    @Size(max = 40)
	private String name;

    @Size(max = 225)
	private String description;
    
    @NotNull
	private int cost;
    
    @NotBlank
    private String userName;
    
    @NotNull
    private LocalDate duedate;
    
    @NotNull
    private boolean recurring;
    
    @Enumerated(EnumType.STRING)
    private RecurringType recurringsize;
    
    private boolean enddate;
    
    private LocalDate endrecurring;
    
    public ItemRequestObject() {}
    
	public ItemRequestObject(String name, String description, int cost, LocalDate duedate, boolean recurring,
			RecurringType recurringsize, boolean enddate, LocalDate endrecurring) {
			this.name = name;
			this.description = description;
			this.cost = cost;
			this.duedate = duedate;
			this.recurring = recurring;
			this.recurringsize = recurringsize;
			this.enddate = enddate;
			this.endrecurring = endrecurring;
	}
	public ItemRequestObject(ItemUpdateRequestObject changeRequest) {
		this.name = changeRequest.getName();
		this.userName = changeRequest.getUserName();
		this.description = changeRequest.getDescription();
		this.cost = changeRequest.getCost();
		this.duedate = changeRequest.getDuedate();
		this.recurring = changeRequest.isRecurring();
		this.recurringsize = changeRequest.getRecurringsize();
		this.enddate = changeRequest.isEnddate();
		this.endrecurring = changeRequest.getEndrecurring();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
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

	@Override
	public String toString() {
		return "ItemRequestObject [name=" + name + ", description=" + description + ", cost=" + cost + ", userName="
				+ userName + ", duedate=" + duedate + ", recurring=" + recurring + ", recurringsize=" + recurringsize
				+ ", enddate=" + enddate + ", endrecurring=" + endrecurring + "]";
	}

}
