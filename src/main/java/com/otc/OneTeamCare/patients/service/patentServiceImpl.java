package com.otc.OneTeamCare.patients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otc.OneTeamCare.patients.models.Patient;
import com.otc.OneTeamCare.patients.repository.PatientRepo;
@Service
public class patentServiceImpl implements patientService {

	@Autowired
	PatientRepo patentRepo;
	
	@Override
	public String addPatient(Patient p) {
		patentRepo.save(p);
		return p.getLogicalId();
	}

	@Override
	public Patient getPatent(String logicalId) {
		
		return patentRepo.findBylogicalId(logicalId);
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return (List<Patient>)patentRepo.findAll();
	}

}
