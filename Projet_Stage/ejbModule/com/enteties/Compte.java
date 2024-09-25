package com.enteties;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Compte")
public class Compte implements Serializable{
	

	private static final long serialVersionUID = -2920600728848806617L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	String usernam;
	String password;
	String type;
	
	@OneToOne
	@JoinColumn(name="id_cadre",unique = true)
	Cadre cadre;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser() {
		return usernam;
	}


	public void setUser(String user) {
		this.usernam = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Compte() {
		super();
	}


	public String getUsernam() {
		return usernam;
	}


	public void setUsernam(String usernam) {
		this.usernam = usernam;
	}


	public Cadre getCadre() {
		return cadre;
	}


	public void setCadre(Cadre cadre) {
		this.cadre = cadre;
	}
	
	
	
}
