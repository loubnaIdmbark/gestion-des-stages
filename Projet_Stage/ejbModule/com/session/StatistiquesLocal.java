package com.session;

import javax.ejb.Local;

@Local
public interface StatistiquesLocal {
	public int TotalEncadrant();
	public int TotalStage();
	public int TotalStagiaire();
	public int StagiaireAffecete();
	public int StageAffecete() ;
	public int EncadrantAffecete();
	public int StagiaireNouveaux();
}
