package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.enteties.Cadre;



@Stateless
@LocalBean
public class Cadre_session implements CadreLocal {
	@PersistenceContext
	   EntityManager em;
    public Cadre_session() {
       
    }

	@Override
	public void addCadre(Cadre c) {
		em.persist(c);
	}

	@Override
	public void deleteCadre(int id) {
		em.remove(em.find(Cadre.class, id));
	    }

	@Override
	public void updateCadre(Cadre c) {
		em.merge(c);
		
	}

	@Override
	public Cadre getCadre(int id) {
		return em.find(Cadre.class,id);
	}

	@Override
	public List<Cadre> getAllCadre() {
		TypedQuery<Cadre> query = em.createQuery("SELECT c FROM Cadre c", Cadre.class);
        return query.getResultList();
	}

	@Override
	public List<Cadre> getAllCadreByRole(String role) {
		TypedQuery<Cadre> query = em.createQuery("SELECT c FROM Cadre c WHERE c.role = :role", Cadre.class);
		query.setParameter("role", role);
		for(Cadre c : query.getResultList()) {
			System.out.println(c.getNom());
		}
		return query.getResultList();
	}

	@Override
	public Cadre getAllCadreByPrenomAndNom(String prenom, String nom) {
		TypedQuery<Cadre> query = em.createQuery("SELECT c FROM Cadre c WHERE c.prenom = :prenom AND c.nom = :nom", Cadre.class);
		query.setParameter("prenom", prenom);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}

	@Override
	public List<Cadre> getAllCadreByNom(String nom) {
		TypedQuery<Cadre> query = em.createQuery("SELECT c FROM Cadre c WHERE c.nom = :nom", Cadre.class);
		query.setParameter("nom", nom);
		return query.getResultList();
	}

}
