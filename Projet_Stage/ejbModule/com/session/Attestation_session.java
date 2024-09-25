package com.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.enteties.Attestation;
import com.enteties.Stagiaire;



@Stateless
@LocalBean
public class Attestation_session implements AttestationLocal {


	@PersistenceContext
	EntityManager em;
	@EJB
    private StagiaireLocal stagiaireLocal;
	@EJB
	private StageLocal stageLocal;
	
    public Attestation_session() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void addAttestation(Attestation at) {
		em.persist(at);
		
	}
	@Override
	public void deleteAttestation(int id) {
		 em.remove(id);
	}
	@Override
	public void updateAttestation(Attestation at) {
		em.merge(at);
		
	}
	@Override
	public Attestation getAttestation(int id) {
		return em.find(Attestation.class,id);
	}
	@Override
	public List<Attestation> getAllAttestation() {
		TypedQuery<Attestation> query = em.createQuery("SELECT at FROM at ", Attestation.class);
		return query.getResultList();
	}

	@Override
	public Map<String, Object> getAttestationbyNomAndPrenom(String nom, String prenom) {
    	Map<String, Object> attestationMap = new HashMap<>();

    	Stagiaire s = stagiaireLocal.getStagiairebyNomAndPrenom(nom, prenom);

    	int duration = stageLocal.getStageDuration(s.getStage().getId());
		String type = stageLocal.getStageType(s.getStage().getId());

		attestationMap.put("nom", nom);
		attestationMap.put("prenom", prenom);
		attestationMap.put("duration", duration);
		attestationMap.put("division", s.getStage().getDivision()); // Assuming the division is available in Stagiaire entity
		attestationMap.put("type", type);

      return attestationMap;
}

}
