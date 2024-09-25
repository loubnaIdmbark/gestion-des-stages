package com.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@Stateless
@LocalBean
public class Statistiques implements StatistiquesLocal {

	   @PersistenceContext
	    EntityManager em;
    public Statistiques() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int TotalEncadrant() {
		Query query = em.createQuery("SELECT Count(*) from Encadrant");
		Long result = (Long) query.getSingleResult();
		int total = result.intValue();
		System.out.println("Total Encadrant : " + total);
		return total;
	}

	@Override
	public int TotalStage() {
		Query query = em.createQuery("SELECT Count(*) from Stage");
		Long result = (Long) query.getSingleResult();
		int total = result.intValue();
		return total;
	}

	@Override
	public int TotalStagiaire() {
		Query query = em.createQuery("SELECT Count(*) from Stagiaire");
		Long result = (Long) query.getSingleResult();
		int total = result.intValue();
		return total;
	}

	public int StagiaireNouveaux() {
		Query query = em.createQuery("SELECT COUNT(*) FROM Stagiaire WHERE id_encadrant IS NULL AND id_stage IS NULL");
		Long result = (Long) query.getSingleResult();
		int total = result.intValue();
		return total;
	}

	public int StagiaireAffecete() {
		Query query = em.createQuery("SELECT COUNT(*) FROM Stagiaire WHERE id_encadrant IS NOT NULL AND id_stage IS NOT NULL");
		Long result = (Long) query.getSingleResult();
		int total = result.intValue();
		return total;
	}

	public int EncadrantAffecete() {
		Query query = em.createQuery("SELECT COUNT(*) FROM Stagiaire where id_Encadrant IS NOT NULL ");
		Long result = (Long) query.getSingleResult();
		int total = result.intValue();
		return total;
	}

	public int StageAffecete() {
		Query query = em.createQuery("SELECT COUNT(*) FROM Stagiaire where id_Stage IS NOT NULL ");
		Long result = (Long) query.getSingleResult();
		int total = result.intValue();
		return total;
	}

}