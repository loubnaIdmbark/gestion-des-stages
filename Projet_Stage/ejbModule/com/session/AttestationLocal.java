package com.session;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.enteties.Attestation;
@Local
public interface AttestationLocal {
	public void addAttestation(Attestation at);
	public void deleteAttestation(int id);
	public void updateAttestation(Attestation at);
	public Attestation getAttestation(int id);
	public List<Attestation> getAllAttestation();
	public Map<String, Object> getAttestationbyNomAndPrenom(String nom,String prenom);
}
