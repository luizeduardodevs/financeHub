package com.financehub.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	@Column(unique=true)
	private String cpf;
	private String email;
	private String password;
	@OneToOne(mappedBy = "user")//ELE ENTRA DENTRO DO PARAMENTRO DA CONTRA ACCOUNT E PROCURA PELO O USER. é usada como espelho, pois as ações serao executadas atraves do account
	private Account accounts;
	
	public User() {}
	public User(String name,String cpf,String email,String password) {
		this.name=name;
		this.cpf=cpf;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
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
	public Account getAccounts() {
		return accounts;
	}
	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", cpf=" + cpf + ", email=" + email + ", password=" + password
				+ ", accounts=" + accounts + "]";
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
