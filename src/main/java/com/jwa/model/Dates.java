package com.jwa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dates")
public class Dates{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    
    private LocalDate thedate;
    
	public Dates() {
	}
    
	public Dates(LocalDate thedate) {
		this.thedate = thedate;
	}

	public Long getId() {
		return id;
	}
	
	public LocalDate getThedate() {
		return thedate;
	}

	public void setThedate(LocalDate thedate) {
		this.thedate = thedate;
	}

	@Override
	public String toString() {
		return "Dates [id=" + id + ", thedate=" + thedate + "]";
	}
}
