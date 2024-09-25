package com.enteties;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cadre")
public class Cadre implements Serializable{
    
    
	private static final long serialVersionUID = 4628103424107337887L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
    String prenom;
    String nom;
    String role;
    String email;
    Long telephone;
    
    @OneToOne(mappedBy="cadre")
    Compte compte;

    @ManyToMany(mappedBy="cadres",fetch = FetchType.LAZY)
    List<Encadrant> encadrants;

    @ManyToMany(mappedBy="cadres",fetch = FetchType.LAZY)
    List<Stagiaire> stagiaires;

    @OneToMany(mappedBy="cadre",fetch = FetchType.EAGER)
    List<Abscence> abscences;

    public Cadre() {
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

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/*public List<Encadrant> getEncadrants() {
		return encadrants;
	}

	public void setEncadrants(List<Encadrant> encadrants) {
		this.encadrants = encadrants;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}*/

	public List<Abscence> getAbscences() {
		return abscences;
	}

	public void setAbscences(List<Abscence> abscences) {
		this.abscences = abscences;
	}

	public List<Encadrant> getEncadrants() {
		return encadrants;
	}

	public void setEncadrants(List<Encadrant> encadrants) {
		this.encadrants = encadrants;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	
	
	
	
    
    

}
