package com.otc.OneTeamCare.patients.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.otc.OneTeamCare.patients.models.Patient;

@Service
public interface patientService  {

	public String addPatient(Patient p);
	public Patient getPatent(String logicalId);
	public List<Patient> getAllPatient();
	
	
}
