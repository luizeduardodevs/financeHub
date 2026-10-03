package com.financehub.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pix_key")
public class PixKey implements Serializable {
	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "pix_key")
	private String key;
	private String type;
	@ManyToOne
	private Account account;
	
	public PixKey() {}

	public PixKey(String key, String type, Account account) {
		super();
		this.key = key;
		this.type = type;
		this.account = account;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
		PixKey other = (PixKey) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PixKey [id=" + id + ", key=" + key + ", type=" + type + ", account=" + account + "]";
	}
	
	
	
	
	

}
