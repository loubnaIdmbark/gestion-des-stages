package com.session;

import java.util.List;

import javax.ejb.Local;

import com.enteties.Abscence;

@Local
	public interface AbscenceLocal {
		
		public void addAbscence(Abscence ab);
		public void deleteAbscence(int id);
		public void updateAbscence(Abscence ab);
		public Abscence getAbscence(int id);
		public List<Abscence> getAllAbscence();
		public List<Abscence> getByStagiaire(int id);
}
