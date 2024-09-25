package com.session;

import java.util.List;

import javax.ejb.Local;

import com.enteties.Cadre;

@Local
public interface CadreLocal {
	public void addCadre(Cadre c);
	public void deleteCadre(int id);
	public void updateCadre(Cadre c);
	public Cadre getCadre(int id);
	public List<Cadre> getAllCadre();
	public List<Cadre> getAllCadreByRole(String role);
	public Cadre getAllCadreByPrenomAndNom(String prenom,String nom);
	public List<Cadre> getAllCadreByNom(String nom);
}
