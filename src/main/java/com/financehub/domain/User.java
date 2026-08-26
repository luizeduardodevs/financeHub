package com.financehub.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private Integer cpf;
	private String email;
	private String password;
	
	public User() {}
	public User(String id,String name,Integer cpf,String email,String password) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.password=password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf=cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " "+cpf +" "+ email +" "+ password;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
