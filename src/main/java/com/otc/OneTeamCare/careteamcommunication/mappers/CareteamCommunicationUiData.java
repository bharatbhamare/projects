package com.otc.OneTeamCare.careteamcommunication.mappers;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CareteamCommunicationUiData {
  private String id;
  private String relatesToId;
  private String channel;
  private String messageType;
  private String messageData;
  private String message;
  private String messageDate;
  MessageBy messageBy;
  Patient patient;
  CareTeam careTeam;
  ArrayList<String> reply = new ArrayList<String>();
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getRelatesToId() {
	return relatesToId;
}
public void setRelatesToId(String relatesToId) {
	this.relatesToId = relatesToId;
}
public String getChannel() {
	return channel;
}
public void setChannel(String channel) {
	this.channel = channel;
}
public String getMessageType() {
	return messageType;
}
public void setMessageType(String messageType) {
	this.messageType = messageType;
}
public String getMessageData() {
	return messageData;
}
public void setMessageData(String messageData) {
	this.messageData = messageData;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getMessageDate() {
	return messageDate;
}
public void setMessageDate(String messageDate) {
	this.messageDate = messageDate;
}
public MessageBy getMessageBy() {
	return messageBy;
}
public void setMessageBy(MessageBy messageBy) {
	this.messageBy = messageBy;
}
public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}
public CareTeam getCareTeam() {
	return careTeam;
}
public void setCareTeam(CareTeam careTeam) {
	this.careTeam = careTeam;
}
public ArrayList<String> getReply() {
	return reply;
}
public void setReply(ArrayList<String> reply) {
	this.reply = reply;
}



}