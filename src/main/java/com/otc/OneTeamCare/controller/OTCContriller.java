package com.otc.OneTeamCare.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONException;
import org.omg.stub.java.rmi._Remote_Stub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.otc.OneTeamCare.careteamcomm.repository.Single;
import com.otc.OneTeamCare.careteamcomm.service.CareteamcommunicationService;
import com.otc.OneTeamCare.careteamcommunication.mappers.CareteamCommunicationUiData;
import com.otc.OneTeamCare.careteamcommunication.mappers.FhirObjectMapper_Careteamcomm;
import com.otc.OneTeamCare.careteamcommunication.models.Careteamcommunication;
import com.otc.OneTeamCare.careteamcommunication.models.FunctionRes;
import com.otc.OneTeamCare.patients.mapper.FhirObjectMapper;

import com.otc.OneTeamCare.patients.models.Patient;
import com.otc.OneTeamCare.patients.models.PatientData;
import com.otc.OneTeamCare.patients.service.patientService;

@RestController
public class OTCContriller {

	// private SessionFactory sessionFactory;

	@Autowired
	CareteamcommunicationService careteamcommunicationService;
	@Autowired
	patientService patentsSrvice;
	@Autowired
	FhirObjectMapper mapper;
	@Autowired
	FhirObjectMapper_Careteamcomm fhir_careteamComm;

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory().getSessionFactory();
	Session session = sessionFactory.openSession();

	@GetMapping("/careteamcommunication/all")
	public ResponseEntity<String> getCAreteam()
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		
			String sql = "SELECT * FROM qotc.get_careteamcommunication()";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(FunctionRes.class);

			List<FunctionRes> results = (List<FunctionRes>) query.list();
			List<String> careteamCommunication = new ArrayList<String>();
			for(int i=0 ; i<results.size(); i++)
			{
				System.out.println("getting chat");
				careteamCommunication.add(fhir_careteamComm.RightMap("CARETEAMCOMMUNICATION", results.get(i).getCareteamcommunication()));}
			
			return new ResponseEntity<String>(careteamCommunication.toString(), HttpStatus.OK);
	}

	@GetMapping("/careteamcommunication/{param}/{id}")
	public ResponseEntity<String> getCommByCareteam(@PathVariable("param") String param,
			@PathVariable("id") String identifier)
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		
		if (param.toLowerCase().equals("careteam")&&identifier!=null) {
			String sql = "SELECT * FROM qotc.get_careteamcommunication_by_careteam(?)";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Single.class);
			query.setString(0, identifier);
			Single results = (Single) query.uniqueResult();
			List<String> careteamCommunication = new ArrayList<String>();
			
			JSONArray arr = new JSONArray(results.getGet_careteamcommunication_by_careteam());

			for (int i = 0; i < arr.length(); i++) {

				if (arr.get(i) != null) {

					String jsonContent = fhir_careteamComm.RightMap("CARETEAMCOMMUNICATION", arr.get(1).toString());
					if (jsonContent != null) {
						careteamCommunication.add(jsonContent);
					}
				}
			}

			return new ResponseEntity<String>(careteamCommunication.toString(), HttpStatus.OK);
		}
		if (param.toLowerCase().equals("id")&&identifier!=null) {
			String sql = "SELECT * FROM qotc.get_careteamcommunication(?)";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(FunctionRes.class);
			query.setString(0, identifier);
			List<FunctionRes> results = (List<FunctionRes>) query.list();
			List<String> careteamCommunication = new ArrayList<String>();
			Iterator<FunctionRes> itr = results.iterator();
			while (itr.hasNext()) {
				FunctionRes communication = (FunctionRes) itr.next();
				if (communication != null) {
					String content = communication.getCareteamcommunication().toString();
					String jsonContent = fhir_careteamComm.RightMap("CARETEAMCOMMUNICATION", content);
					// System.out.println("json object: "+jsonContent);
					if (jsonContent != null) {
						careteamCommunication.add(jsonContent);
					}
				}
			}
				if(careteamCommunication.toString().length()<5)
				{
					return new ResponseEntity<>("content not founf",HttpStatus.NO_CONTENT);
				}
				
			return new ResponseEntity<String>(careteamCommunication.toString(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Sorry No Content Found", HttpStatus.NO_CONTENT);
	}

	@PostMapping("/careteamcommunication")
	public String addCareteamComunication(@RequestBody CareteamCommunicationUiData content) throws Exception {

		Careteamcommunication careteamcomm = new Careteamcommunication();
		careteamcomm.setContent(fhir_careteamComm.LeftMap("CARETEAMCOMMUNICATION", content));
		careteamcomm.setLogicalId(content.getId());
		careteamcomm.setPublished(new Timestamp(0));
		careteamcomm.setResourceType("careteamcommunication");
		careteamcomm.setUpdated(new Timestamp(0));
		careteamcomm.setVersionId("");

		careteamcommunicationService.addCommunication(careteamcomm);

		return content.getId();
	}

	@PutMapping("/careteamcommunication")
	public String updateCareteamcommunication(@RequestBody CareteamCommunicationUiData content) throws Exception {

		Careteamcommunication careteamcomm = new Careteamcommunication();
		careteamcomm.setContent(fhir_careteamComm.LeftMap("CARETEAMCOMMUNICATION", content));
		careteamcomm.setLogicalId(content.getId());
		careteamcomm.setPublished(new Timestamp(0));
		careteamcomm.setResourceType("careteamcommunication");
		careteamcomm.setUpdated(new Timestamp(0));
		careteamcomm.setVersionId("");

		careteamcommunicationService.addCommunication(careteamcomm);

		return content.getId();
	}

	@PostMapping("/patient")
	public String addPatients(@RequestBody PatientData content) throws Exception {
		System.out.println("id: " + content.getId());

		Patient p = new Patient();
		p.setContent(mapper.LeftMap("PATIENT", content));
		p.setLogicalId(content.getId());
		p.setPublished(new Timestamp(0));
		p.setResourceType(p.getResourceType());
		p.setUpdated(new Timestamp(0));
		p.setVersionId(p.getVersionId());

		patentsSrvice.addPatient(p);

		return content.getId();
	}

	@PutMapping("/patient")
	public String updatePAtient(@RequestBody PatientData content) throws Exception {
		System.out.println("id: " + content.getId());

		Patient p = new Patient();
		p.setContent(mapper.LeftMap("PATIENT", content));
		p.setLogicalId(content.getId());
		p.setPublished(new Timestamp(0));
		p.setResourceType(p.getResourceType());
		p.setUpdated(new Timestamp(0));
		p.setVersionId(p.getVersionId());

		patentsSrvice.addPatient(p);

		return content.getId();
	}

	@GetMapping("/patient")
	public ResponseEntity<List<String>> getAllpatient()
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		List<Patient> patients = patentsSrvice.getAllPatient();
		Iterator<Patient> itr = (Iterator<Patient>) patients.iterator();
		int count = 0;

		List<String> pc = new ArrayList<String>();
		while (itr.hasNext()) {
			System.out.println(++count);
			try {
				Patient p = (Patient) itr.next();
				if (p != null) {
					String str = mapper.RightMap("PATIENT", p.getContent().toString(), p.getLogicalId());
					if (str != null) {
						pc.add(str);
					}
				}
			} catch (JSONException j) {
				j.printStackTrace();
				itr.next();

			}
		}

		return new ResponseEntity<List<String>>(pc, HttpStatus.OK);

	}

	@GetMapping("/patient/{id}")
	public ResponseEntity<String> getPatient(@PathVariable("id") String id)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		// ObjectMapper mapper = new ObjectMapper();
		// PatientContent patient_content = mapper.readValue(mapper.toString(),
		// PatientContent.class);
		// org.hl7.fhir.instance.model.Patient pp =
		// mapper.readValue(patentsSrvice.getPatent(id).getContent().toString(),
		// org.hl7.fhir.instance.model.Patient.class);

		String data = mapper.RightMap("PATIENT", (patentsSrvice.getPatent(id).getContent().toString()), id);

		return new ResponseEntity<String>(data, HttpStatus.OK);
	}

}
