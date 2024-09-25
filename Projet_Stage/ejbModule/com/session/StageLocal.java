package com.session;

import java.util.List;

import javax.ejb.Local;

import com.enteties.Stage;

@Local
public interface StageLocal {
	public void addStage(Stage s);
	public void deleteStage(int id);
	public void updateStage(Stage s);
	public Stage getStage(int id);
	public List<Stage> getAllStages();
	public List<Stage> getByType(String type);
	public int getStageDuration(int id);
	public String getStageType(int id);
	public String getStageDivision(int id);
}
