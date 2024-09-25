package com.enteties;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Stagiaire")
public class Stagiaire implements Serializable {
    
	
	private static final long serialVersionUID = 5469506597984588496L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String prenom;
    String nom;
    String CIN;
    String etablissemnt;
    String filiere;
    String adresse;
    String email;
    Long telephone;
    Date dateNaissance;

    @ManyToMany
    @JoinTable(name="Cadre_Stagiaire",
    joinColumns=@JoinColumn(name="id_Stagiaire"),
    inverseJoinColumns=@JoinColumn(name="id_Cadre"))
    List<Cadre> cadres;

    @OneToMany(mappedBy = "stagiaire")
    List<Abscence> abscences;

    @OneToOne(mappedBy="stagiaire")
    Attestation attestation;

    @ManyToOne
    @JoinColumn(name="id_Stage")
    Stage stage;
    
    @OneToOne
    @JoinColumn(name="id_Encadrant",unique = true)
    Encadrant encadrant;
    
    public Stagiaire() {
    }

	public int getId() {
		return id;
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

	public String getEtablissemnt() {
		return etablissemnt;
	}

	public void setEtablissemnt(String etablissemnt) {
		this.etablissemnt = etablissemnt;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
/* 
	public List<Cadre> getCadres() {
		return cadres;
	}

	public void setCadres(List<Cadre> cadres) {
		this.cadres = cadres;
	}

	public List<Abscence> getAbscences() {
		return abscences;
	}*/

	public void setAbscences(List<Abscence> abscences) {
		this.abscences = abscences;
	}

	public Attestation getAttestation() {
		return attestation;
	}

	public void setAttestation(Attestation attestation) {
		this.attestation = attestation;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}


	@XmlTransient
	public Encadrant getEncadrant() {
		return encadrant;
	}

	public void setEncadrant(Encadrant encadrant) {
		this.encadrant = encadrant;
	}
	
	
    
    
}
