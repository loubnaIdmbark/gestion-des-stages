package com.session;


import java.util.List;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import com.enteties.Stage;

@Stateless
@LocalBean
public class Stage_session implements StageLocal {

	@PersistenceContext
	EntityManager em;
	
	
    public Stage_session() {
        
    }
	public void addStage(Stage s) {
		em.persist(s);
		
	}
	@Override
	public void deleteStage(int id) {
		 Stage StageToRemove = em.find(Stage.class, id);
	        if (StageToRemove != null) {
	            em.remove(StageToRemove);
	        }
		
	}
	@Override
	public void updateStage(Stage s) {
		em.merge(s);
		
	}
	@Override
	public Stage getStage(int id) {
		 return em.find(Stage.class, id);

	}
	@Override
	public List<Stage> getAllStages() {
		TypedQuery<Stage> query = em.createQuery("SELECT s FROM Stage s", Stage.class);
        return query.getResultList();
	}

	@Override
	public List<Stage> getByType(String type) {
		TypedQuery<Stage> query = em.createQuery("SELECT s FROM Stage s WHERE s.type = :type", Stage.class);
		query.setParameter("type", type);
		return query.getResultList();
	}

	@Override
    public int getStageDuration(int id) {
        TypedQuery<Stage> query = em.createQuery("SELECT s FROM Stage s WHERE s.id = :id", Stage.class);
		query.setParameter("id", id);
		return query.getSingleResult().getDuration();
    }

	@Override
	public String getStageType(int id){
		TypedQuery<Stage> query = em.createQuery("SELECT s FROM Stage s WHERE s.id = :id", Stage.class);
		query.setParameter("id", id);
		return query.getSingleResult().getType();
	}

	@Override
	public String getStageDivision(int id){
		TypedQuery<Stage> query = em.createQuery("SELECT s FROM Stage s WHERE s.id = :id", Stage.class);
		query.setParameter("id", id);
		return query.getSingleResult().getDivision();
	}

	
	

}
