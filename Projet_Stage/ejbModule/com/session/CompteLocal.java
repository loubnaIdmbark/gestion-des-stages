package com.session;

import java.util.List;

import javax.ejb.Local;

import com.enteties.Compte;



@Local
public interface CompteLocal {
	public void addCompte(Compte co);
	public void deleteCompte(int id);
	public void updateCompte(Compte co);
	public Compte getCompte(int id);
	public List<Compte> getAllCompte();
	public Boolean getCompteByLoginAndPass(String login,String pass);
	public String getCompteType(String login);
	public List<Compte> getCompteByLogin(String login);

}
