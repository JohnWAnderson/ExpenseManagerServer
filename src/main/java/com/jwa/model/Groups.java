package com.jwa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;  
    
    @NotBlank
    private String thegroup;
    
	public Groups() {}

	public Groups(String thegroup) {
		this.thegroup = thegroup;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getThegroup() {
		return thegroup;
	}

	public void setThegroup(String thegroup) {
		this.thegroup = thegroup;
	}
    
}

