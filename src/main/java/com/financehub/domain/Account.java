package com.financehub.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Account implements Serializable {
	
	private static final long serialVersionUID = 0L;
	
	@Id
	private String id;
	private Integer numberAccount;
	private String type;
	private Integer value;
	private String status;
	@ManyToOne
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getNumberAccount() {
		return numberAccount;
	}
	public void setNumberAccount(Integer numberAccount) {
		this.numberAccount = numberAccount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", numberAccount=" + numberAccount + ", type=" + type + ", value=" + value
				+ ", status=" + status + ", user=" + user + ", createdAt=" + createdAt + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}

	
}
