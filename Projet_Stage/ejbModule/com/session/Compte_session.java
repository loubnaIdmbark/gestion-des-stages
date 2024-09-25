package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.enteties.Compte;



@Stateless
@LocalBean
public class Compte_session implements CompteLocal {


	@PersistenceContext
	   EntityManager em;
    public Compte_session() {
    }
	@Override
	public void addCompte(Compte co) {
		em.persist(co);
	}
	@Override
	public void deleteCompte(int id) {
		Compte compte = em.find(Compte.class, id); // Find the entity by its ID
    if (compte != null) {
        em.remove(compte); // Remove the entity
    }
	}
	@Override
	public void updateCompte(Compte co) {
		em.merge(co);
	}
	@Override
	public Compte getCompte(int id) {
	return em.find(Compte.class,id);
	}
	@Override
	public List<Compte> getAllCompte() {
		TypedQuery<Compte> query = em.createQuery("SELECT co FROM Compte co ", Compte.class);
        return query.getResultList();
	}

	@Override
	public String getCompteType(String login) {
		TypedQuery<String> query = em.createQuery("SELECT co.type FROM Compte co WHERE co.usernam = :login", String.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

	@Override
	public Boolean getCompteByLoginAndPass(String login, String pass) {
		TypedQuery<Compte> query = em.createQuery("SELECT co FROM Compte co WHERE co.usernam = :login AND co.password = :pass", Compte.class);
		query.setParameter("login", login);
		query.setParameter("pass", pass);
		if (query.getResultList().size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public List<Compte> getCompteByLogin(String login) {
		TypedQuery<Compte> query = em.createQuery("SELECT co FROM Compte co WHERE co.usernam = :login", Compte.class);
		query.setParameter("login", login);
		return query.getResultList();
	}
	
}
