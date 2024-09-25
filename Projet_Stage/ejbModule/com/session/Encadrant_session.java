package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.enteties.Encadrant;


@Stateless
@LocalBean
public class Encadrant_session implements EncadrantLocal {

    @PersistenceContext
    EntityManager em;
    public Encadrant_session() {
     
    }
	@Override
	public void addEncadrant(Encadrant ec) {
		em.persist(ec);
	}
	@Override
	public void deleteEncadrant(int id) {
		Encadrant encadrant = em.find(Encadrant.class, id);
		em.remove(encadrant);
	}
	@Override
	public void updateEncadrant(Encadrant ec) {
		em.merge(ec);
		
	}
	@Override
	public Encadrant getEncadrant(int id) {
		return em.find(Encadrant.class,id);
	}
	@Override
	public List<Encadrant> getAllEncadrant() {
		TypedQuery<Encadrant> query = em.createQuery("SELECT ec FROM Encadrant ec", Encadrant.class);
        return query.getResultList();
	}

	@Override
	public List<Encadrant> getByNom(String nom) {
		TypedQuery<Encadrant> query = em.createQuery("SELECT ec FROM Encadrant ec WHERE ec.nom = :nom", Encadrant.class);
		query.setParameter("nom", nom);
		return query.getResultList();
	}

}
