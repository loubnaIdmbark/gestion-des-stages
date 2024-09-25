package com.enteties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Encadrant")
public class Encadrant implements Serializable{

    
	private static final long serialVersionUID = 374510404670394651L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
    String prenom;
    String nom;
    String CIN;
    String role;
    String email;
    Long telephone;
    Date dateNaissance;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="Cadre_Encadrant",
	joinColumns=@JoinColumn(name="id_Encadrant"),
	inverseJoinColumns=@JoinColumn(name="id_Cadre"))
    List<Cadre> cadres;

    @OneToOne(mappedBy="encadrant")
    Stagiaire stagiaire;
    
    public Encadrant() {
    }

    public Encadrant(int int1) {
		this.id = int1;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/*public List<Cadre> getCadres() {
		return cadres;
	}

	public void setCadres(List<Cadre> cadres) {
		this.cadres = cadres;
	}*/

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	
    
}
