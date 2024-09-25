package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.enteties.Stagiaire;


@Stateless
@LocalBean
public class Stagiaire_session implements StagiaireLocal {

	@PersistenceContext
	EntityManager em;
	
    public Stagiaire_session() {
      
    }

	@Override
	public void addStagiaire(Stagiaire st) {
		  em.persist(st);
		
	}

	@Override
	public void deleteStagiaire(int id) {
		  Stagiaire StagiaireToRemove = em.find(Stagiaire.class, id);
	        if (StagiaireToRemove != null) {
	            em.remove(StagiaireToRemove);
	        }
		
	}

	@Override
	public void updateStagiaire(Stagiaire st) {
		em.merge(st);
		
	}

	@Override
	public Stagiaire getStagiaire(int id) {
		
		return  em.find(Stagiaire.class,id) ;
	}

	@Override
	public List<Stagiaire> getAllStagiaire() {
		TypedQuery<Stagiaire> query = em.createQuery("SELECT st FROM Stagiaire st WHERE st.stage.id IS NOT NULL", Stagiaire.class);
		return query.getResultList();
	}

	@Override
	public List<Stagiaire> getAllStagiaireSansStage() {
		TypedQuery<Stagiaire> query = em.createQuery("SELECT st FROM Stagiaire st WHERE st.stage.id IS NULL", Stagiaire.class);
		return query.getResultList();
	}

	
	public List<Stagiaire> getStagiairebyNom(String nom) {
		TypedQuery<Stagiaire> query = em.createQuery("SELECT st FROM Stagiaire st WHERE st.nom=:nom AND st.stage.id IS NOT NULL", Stagiaire.class);
		query.setParameter("nom", nom);
		return query.getResultList();
	}

	@Override
	public Stagiaire getStagiairebyNomAndPrenom(String nom, String prenom) {
		TypedQuery<Stagiaire> query = em.createQuery("SELECT st FROM Stagiaire st WHERE st.nom=:nom AND st.prenom=:prenom", Stagiaire.class);
		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);
		return query.getSingleResult();
	}

	@Override
	public void Inscrire(Stagiaire st) {
		em.persist(st);	
	}

}
