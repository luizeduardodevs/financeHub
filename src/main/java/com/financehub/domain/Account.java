package com.financehub.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account implements Serializable {
	
	private static final long serialVersionUID = 0L;
	
	@Id
	private String id;
	private Integer numberAccount;
	private String type;
	private Integer value;
	private String status;
	private User user;
	private LocalDate createdAt;
	
	public Account() {}
	public Account(String id, Integer numberAccount, String type, Integer value, String status,User user,LocalDate createdAt) {
		this.id=id;
		this.numberAccount=numberAccount;
		this.type=type;
		this.value=value;
		this.status=status;
		this.user=user;
		this.createdAt=createdAt;
	}

	
}
