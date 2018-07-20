package com.otc.OneTeamCare.patients.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.otc.OneTeamCare.patients.models.Patient;

@Repository
public interface PatientRepo extends CrudRepository<Patient, String> {

	public Patient findBylogicalId(String identifier);

}
