package com.financehub.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Transantion implements Serializable{
	 private static final long serialVersionUID = 0L;
	 
	 @Id
	 private String id;
	 private String type;
	 private Integer amount;
	 private LocalDateTime dateTime;
	 private String description;
	 private Account account;
	 
	 public Transantion(){}
	 
	 public String getId() {
		 return id;
	 }
	 public void setId(String id) {
		 this.id=id;
	 }
	 public String getType() {
		 return type;
	 }
	 public void setTyper(String type) {
		 this.type=type;
	 }
	 public Integer getAmount() {
		 return amount;
	 }
	 public void setAmount(Integer amount) {
		 this.amount=amount;
	 }
	 public LocalDateTime getDateTime() {
		 return dateTime;
	 }
	 public void setDateTime(LocalDateTime dateTime) {
		 this.dateTime=dateTime;
	 }
	 public String getDescription() {
		 return description;
	 }
	 public void setDescription(String description) {
		 this.description=description;
	 }
	 public Account getAccount() {
		 return account;
	 }
	 public void setAccount(Account account) {
		 this.account=account;
	 }

	 @Override
	 public String toString() {
		return "Transantion [id=" + id + ", type=" + type + ", amount=" + amount + ", dateTime=" + dateTime
				+ ", description=" + description + ", account=" + account + "]";
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
		Transantion other = (Transantion) obj;
		return Objects.equals(id, other.id);
	 }
	 
	

}
