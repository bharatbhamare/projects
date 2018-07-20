package com.otc.OneTeamCare.careteamcommunication.mappers;


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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.otc.OneTeamCare.careteamcommunication.models.Content;
import com.otc.OneTeamCare.careteamcommunication.models.Identifier;
import com.otc.OneTeamCare.careteamcommunication.models.Msgdata;
import com.otc.OneTeamCare.careteamcommunication.models.RefrenceObject;
import com.otc.OneTeamCare.careteamcommunication.models.Sentby;
import com.otc.OneTeamCare.patients.models.PatientData;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.client.api.IGenericClient;

@Component
public class FhirObjectMapper_Careteamcomm {

	@Autowired
	CareteamCommunicationUiData careteamcomm;
	@Autowired
	MessageBy messegeBy;
	@Autowired
	Patient patient;
	@Autowired
	CareTeam careteam;
	public String  LeftMap(String resource, CareteamCommunicationUiData content) throws Exception
	{
		
		if(resource==null||content==null)
		{
			throw new NullPointerException("can't map object using null contents");
	
		}
			if(resource.toUpperCase().equals("CARETEAMCOMMUNICATION"))
			{
				ObjectMapper mapper = new ObjectMapper();
			Content cont= new Content();
			RefrenceObject refobj= new RefrenceObject();
			Msgdata msg= new Msgdata();
			com.otc.OneTeamCare.careteamcommunication.models.Sentby sendby= new Sentby();
			Identifier identifier=new Identifier();
			
			identifier.setValue(content.getPatient().getIdentifier());
			identifier.setSystem("patient");
			refobj.setIdentifier(identifier);
			refobj.setReference("patient/"+content.getPatient().getIdentifier());
			refobj.setDisplay(content.getPatient().getDisplay());
			
			
			identifier.setValue(content.getCareTeam().getIdentifier());
			identifier.setSystem("careteam");
			refobj.setIdentifier(identifier);
			refobj.setReference("careteam/"+content.getCareTeam().getIdentifier());
			refobj.setDisplay(content.getCareTeam().getDisplay());
			cont.setCareteam(refobj);
			
			
			Identifier identifier1= new Identifier();
			identifier1.setValue(content.getMessageBy().getIdentifier());
			identifier1.setSystem("user");
			sendby.setIdentifier(identifier1);
			sendby.setReference("user/"+content.getMessageBy().getIdentifier());
			sendby.setDisplay(content.messageBy.getDisplay());
			cont.setSentby(sendby);
			
			RefrenceObject refobj1= new RefrenceObject();
			Identifier identifier2= new Identifier();
			identifier2.setValue(content.getRelatesToId());
			identifier2.setSystem("user");
			refobj1.setIdentifier(identifier2);
			refobj1.setReference("user/"+content.getRelatesToId());
			refobj1.setDisplay("relatesto");
			cont.setRelatesto(refobj1);
			
			
			msg.setImgdata(content.getMessageType());
			msg.setMessage(content.getMessageData());
			
			cont.setMsgdata(msg);
			cont.setId(content.getId());
			cont.setSentdate(content.getMessageDate());
			cont.setIdentifier(content.getId());
			cont.setMessagetype(content.getMessageType());
			cont.setSentdate(content.getMessageDate());
			
				return mapper.writeValueAsString(cont);
			}
		
		return null;
	}
	
	public String RightMap(String resource, String content) throws JsonParseException, JsonMappingException, IOException, JSONException
	{
		if(resource==null||content==null)
		{
			throw new NullPointerException("can't map object using null contents");
	
		}
		if(resource.toUpperCase().equals("CARETEAMCOMMUNICATION")&& content!=null)
		{
			ObjectMapper mapper = new ObjectMapper();
					JSONObject jObject  = new JSONObject(content);
			careteamcomm.setId(jObject.getString("id"));
			careteamcomm.setMessageDate(jObject.getString("sentdate"));
			careteamcomm.setMessageData(jObject.getString("messagetype"));
			careteamcomm.setMessageType(jObject.getString("messagetype"));
			
			if(!jObject.isNull("sentby"))
			{
				JSONObject mesg=jObject.getJSONObject("sentby");
				JSONObject msgidentf= mesg.getJSONObject("identifier");
			messegeBy.setIdentifier(msgidentf.getString("value"));
			messegeBy.setReference(mesg.getString("reference"));
			messegeBy.setDisplay(mesg.getString("display"));
			messegeBy.setPhoto("dasdasd");
			}
			
			/*if(!jObject.isNull("relatesto"))
			{
				JSONObject relates=jObject.getJSONObject("relatesto");
				JSONObject reletsid= relates.getJSONObject("identifier");
			careteam.setIdentifier(reletsid.getString("value"));
			careteam.setDisplay(relates.getString("display"));
			}*/
			if(!jObject.isNull("careteam"))
			{
				JSONObject crt=jObject.getJSONObject("careteam");
				JSONObject crti= crt.getJSONObject("identifier");
				careteam.setDisplay(crt.getString("display"));
				careteam.setIdentifier(crti.getString("value"));
			}
			
			if(!jObject.isNull("msgdata"))
			{
				JSONObject msgd=jObject.getJSONObject("msgdata");
				
				careteamcomm.setMessage(msgd.getString("message"));
			}
			if(!jObject.isNull("relatesto"))
			{
				JSONObject relatesTo=jObject.getJSONObject("relatesto");
				JSONObject identifier_relates= relatesTo.getJSONObject("identifier");
				if((!identifier_relates.isNull("value"))||(identifier_relates.getString("value").length()>0))
				{
					careteamcomm.setRelatesToId(identifier_relates.getString("value"));	
				}
				}
			careteamcomm.setMessageBy(messegeBy);
			careteamcomm.setCareTeam(careteam);
			careteamcomm.setPatient(patient);
			if(!jObject.isNull("reply"))
			{
			JSONArray replyarray= jObject.getJSONArray("reply");
			int n=0;
			if(!replyarray.toString().equals("[null]")||replyarray.length()<0)
			{
				System.out.println("array: "+replyarray);
			while(n<replyarray.length())
			{
				JSONObject reply= replyarray.getJSONObject(n);
				String str_rep= RightMap("CARETEAMCOMMUNICATION", reply.toString());
				if(str_rep!=null)
				{
					careteamcomm.reply.add(str_rep.toString());				}
				
			}
			}
			}
			return mapper.writeValueAsString(careteamcomm);
			}
		
		return null;
	}
		
}
