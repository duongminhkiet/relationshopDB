package com.cpc.permission.pr.object;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class PParent implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date created = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date modified = new Date();



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public java.util.Date getModified() {
		return modified;
	}


	public void setModified(java.util.Date modified) {
		this.modified = modified;
	}


	public java.util.Date getCreated() {
		return created;
	}
	
}