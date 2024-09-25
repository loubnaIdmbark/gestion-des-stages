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
@Table(name="Attestation")
public class Attestation implements Serializable {
    
    
	private static final long serialVersionUID = -8922247292885230455L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @OneToOne
    @JoinColumn(name="id_Stagiaire" , unique = true)
    Stagiaire stagiaire;

	public Attestation() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
    
    

}
