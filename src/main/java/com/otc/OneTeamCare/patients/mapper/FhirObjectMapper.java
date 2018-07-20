package com.otc.OneTeamCare.patients.mapper;

import java.io.IOException;

import org.hl7.fhir.instance.model.Address.AddressUse;
import org.hl7.fhir.instance.model.CodeableConcept;
import org.hl7.fhir.instance.model.Coding;
import org.hl7.fhir.instance.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.instance.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.instance.model.HumanName;
import org.hl7.fhir.instance.model.Patient.ContactComponent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.otc.OneTeamCare.patients.models.PatientData;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.client.api.IGenericClient;

@Component
public class FhirObjectMapper {

	
	public String  LeftMap(String resource, PatientData content) throws Exception
	{
		
		if(resource==null||content==null)
		{
			throw new NullPointerException("can't map object using null contents");
	
		}
			if(resource.toUpperCase().equals("PATIENT"))
			{
		
		if(content.getCity().equals("")||content.getFname().equals("")|| content.getId().equals("")||content.getLastname().equals("")||content.getMobile().equals("")||content.getPostalcode().equals("")||content.getState().equals("")||content.getStreet().equals(""))
		{
			throw new NullPointerException("object contains null filds");
		}else{
		
		FhirContext ctx = FhirContext.forDstu2Hl7Org();
		String serverBase = "http://fhirtest.uhn.ca/baseDstu2";

		IGenericClient client = ctx.newRestfulGenericClient(serverBase);

		org.hl7.fhir.instance.model.Patient patient = new org.hl7.fhir.instance.model.Patient();

		// FIRST AND LAST NAME
		
		
		patient.addName()
		.addFamily(content.getLastname())
		.addGiven(content.getFname());

		// SOCIAL SECURITY NUMBER
		// https://www.hl7.org/FHIR/datatypes.html#Identifier
		// https://www.hl7.org/FHIR/identifier-registry.html

		patient.addIdentifier()
		.setType(new CodeableConcept().addCoding(
		 new Coding().setCode("SB").setSystem("http://hl7.org/fhir/v2/0203")
		))
		.setSystem("http://hl7.org/fhir/sid/us-ssn")
		.setValue("123456789");

		// GENDER
		patient.setGender(AdministrativeGender.FEMALE);

		// ADDRESS INFORMATION
		patient.addAddress()
		.setUse(AddressUse.HOME)
		.addLine(content.getStreet())
		.setCity(content.getCity())
		.setState(content.getState())
		.setPostalCode(content.getPostalcode());

		// CONTACT https://www.hl7.org/fhir/datatypes-examples.html#ContactPoint
		patient.addTelecom()
		.setSystem(ContactPointSystem.PHONE)
		.setValue(content.getMobile());

		patient.addTelecom()
		.setSystem(ContactPointSystem.PHONE)
		.setValue("(415) 675 5745");

		patient.addTelecom()
		.setSystem(ContactPointSystem.EMAIL)
		.setValue("test@test.com");

		// EMERGENCY CONTACT https://www.hl7.org/FHIR/patient-definitions.html#Patient.contact
		ContactComponent emergencyContact = new ContactComponent();

		emergencyContact.addTelecom().setSystem(ContactPointSystem.PHONE)
		.setValue("(111) 675 5745");

		// Relationship to patient
		emergencyContact
		.addRelationship()
		.addCoding()
		 .setSystem("http://hl7.org/fhir/ValueSet/v2-0131")
		 .setCode("C");

		emergencyContact.setName(
		new HumanName().addFamily(content.getLastname()).addGiven(content.getFname())
		);

		patient.addContact(emergencyContact);

		// Encode to JSON
		IParser jsonParser = ctx.newJsonParser();
		jsonParser.setPrettyPrint(true);
		String encoded = jsonParser.encodeResourceToString(patient);
			
		return encoded;
		}
		
			}
			
			
			
		
		return null;
	}
	
	public String RightMap(String type, String data, String id) throws JsonParseException, JsonMappingException, IOException, JSONException
	{
		
		if(type.toUpperCase().equals("PATIENT")&& data!=null)
		{

			ObjectMapper mapper = new ObjectMapper();
			JSONObject jObject  = new JSONObject(data);
			
			PatientData pd= new PatientData();
			if(jObject.isNull("address"))
			{
				return null;
					
			}
			JSONArray array= jObject.getJSONArray("address");
			
			JSONObject address= array.getJSONObject(0);
			pd.setCity(address.getString("city"));
			pd.setPostalcode(address.getString("postalCode"));
			pd.setState(address.getString("state"));
			pd.setStreet(address.getString("use"));
			
			
			JSONArray nameArray= (JSONArray)jObject.get("name");
			JSONObject nameobj= nameArray.getJSONObject(0);
			
			pd.setFname(nameobj.get("given").toString());
			pd.setLastname(nameobj.get("family").toString());
			
			
			pd.setId(id);
			
			
			JSONArray telcomeAray= jObject.getJSONArray("telecom");
			JSONObject telcomObj= telcomeAray.getJSONObject(0);
			pd.setMobile(telcomObj.getString("value"));
			
			
			return  mapper.writeValueAsString(pd);
			
		}
		return null;
	}
	
}
