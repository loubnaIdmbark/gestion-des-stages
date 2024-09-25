package com.session;

import java.util.List;

import javax.ejb.Local;

import com.enteties.Encadrant;


@Local
public interface EncadrantLocal {
	public void addEncadrant(Encadrant ec);
	public void deleteEncadrant(int id);
	public void updateEncadrant(Encadrant ec);
	public Encadrant getEncadrant(int id);
	public List<Encadrant> getAllEncadrant();
	public List<Encadrant> getByNom(String nom);
}
