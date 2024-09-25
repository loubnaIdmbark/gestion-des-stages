package com.enteties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Stage")
public class Stage implements Serializable{
	
	
	private static final long serialVersionUID = 5111420631276848409L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String sujet;
    Date dateDebut;
    Date dateFin;
    String division;
    String type;

    @OneToMany(mappedBy = "stage")
    List<Stagiaire> stagiaires;


	public Stage(int int1) {
		this.id = int1;
    }

	public Stage() {
	}

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return (int) ((dateFin.getTime() - dateDebut.getTime()) / (1000 * 60 * 60 * 24));
	}

	/* 
	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	*/
}
