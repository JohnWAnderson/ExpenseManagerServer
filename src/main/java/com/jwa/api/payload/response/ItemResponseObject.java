package com.jwa.api.payload.response;

import java.time.LocalDate;

import com.jwa.model.RecurringType;

/**
 * 
 * @author John Anderson
 *
 * The response payload for item information redux in front end
 */
public class ItemResponseObject {
	private String name;
	private String description;
	private int cost;
    private LocalDate duedate;
    private String group;
    private boolean recurring;
    private RecurringType recurringsize;
    private boolean enddate;
    private LocalDate endrecurring;
    
    public ItemResponseObject() {}
    
	public ItemResponseObject(String name, String description, int cost, LocalDate duedate, String group, boolean recurring,
		RecurringType recurringsize, boolean enddate, LocalDate endrecurring) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.duedate = duedate;
		this.group = group;
		this.recurring = recurring;
		this.recurringsize = recurringsize;
		this.enddate = enddate;
		this.endrecurring = endrecurring;
	}

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

	public LocalDate getEndrecurring() {
		return endrecurring;
	}

	public void setEndrecurring(LocalDate endrecurring) {
		this.endrecurring = endrecurring;
	}

	public boolean isEnddate() {
		return enddate;
	}

	public void setEnddate(boolean enddate) {
		this.enddate = enddate;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "ItemResponseObject [name=" + name + ", description=" + description + ", cost=" + cost + ", duedate="
				+ duedate + ", group=" + group + ", recurring=" + recurring + ", recurringsize=" + recurringsize
				+ ", enddate=" + enddate + ", endrecurring=" + endrecurring + "]";
	}


}
