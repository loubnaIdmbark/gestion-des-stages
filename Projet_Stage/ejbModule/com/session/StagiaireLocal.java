package com.session;

import java.util.List;

import javax.ejb.Local;

import com.enteties.Stagiaire;

@Local
	public interface StagiaireLocal {
	public void addStagiaire(Stagiaire st);
	public void deleteStagiaire(int id);
	public void updateStagiaire(Stagiaire st);
	public Stagiaire getStagiaire(int id);
	public List<Stagiaire> getAllStagiaire();
	public List<Stagiaire> getAllStagiaireSansStage();
	public List<Stagiaire> getStagiairebyNom(String nom);
	public Stagiaire getStagiairebyNomAndPrenom(String nom,String prenom);
    public void Inscrire(Stagiaire st);
	
}
