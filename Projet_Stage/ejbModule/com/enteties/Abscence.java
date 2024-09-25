package com.enteties;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Abscence")
public class Abscence implements Serializable {
    
	
	private static final long serialVersionUID = -6663644602249795362L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String date_abs;
    int justified;
    String justification;
    
    @ManyToOne
    @JoinColumn(name="id_Cadre")
    Cadre cadre;

    @ManyToOne
    @JoinColumn(name="id_Stagiaire")
    Stagiaire stagiaire;


    
    public Abscence() {
    	super();
    }



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDate_abs() {
		return date_abs;
	}



	public void setDate_abs(String date) {
		this.date_abs = date;
	}



	public int getJustified() {
		return justified;
	}



	public void setJustified(int justifie) {
		this.justified = justifie;
	}



	public String getJustification() {
		return justification;
	}



	public void setJustification(String justification) {
		this.justification = justification;
	}



	public Cadre getCadre() {
		return cadre;
	}



	public void setCadre(Cadre cadre) {
		this.cadre = cadre;
	}



	public Stagiaire getStagiaire() {
		return stagiaire;
	}



	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
    
    
}
