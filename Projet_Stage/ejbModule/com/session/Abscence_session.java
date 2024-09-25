package com.session;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.enteties.Abscence;


@Stateless
@LocalBean
public class Abscence_session implements AbscenceLocal {

	@PersistenceContext
	   EntityManager em;
    public Abscence_session() {
    }

	@Override
	public void addAbscence(Abscence ab) {
		em.persist(ab);
		
	}

	@Override
	public void deleteAbscence(int id) {
		em.remove(em.find(Abscence.class, id));
	}

	@Override
	public void updateAbscence(Abscence ab) {
		em.merge(ab);
		
	}

	@Override
	public Abscence getAbscence(int id) {
		return em.find(Abscence.class,id);
	}

	@Override
	public List<Abscence> getAllAbscence() {
		TypedQuery<Abscence> query = em.createQuery("SELECT ab FROM Abscence ab ", Abscence.class);
        return query.getResultList();
	}

	@Override
	public List<Abscence> getByStagiaire(int id) {
		TypedQuery<Abscence> query = em.createQuery("SELECT ab FROM ab WHERE ab.stagiaire.id = :id", Abscence.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
