package com.otc.OneTeamCare.careteamcommunication.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Content {

	private RefrenceObject careteam;
	private String identifier;
	private Msgdata msgdata;
	private String sentdate;
	private String messagetype;
	private RefrenceObject episode;
	private String id;
	private List<Content>  reply;
	private RefrenceObject relatesto;
	private Sentby sentby;
	private String resourceType;
	
	
	public Content() {
	
	}


	public Content(RefrenceObject careteam, String identifier, Msgdata msgdata, String sentdate, String messagetype,
			RefrenceObject episode, String id, List<Content> reply, RefrenceObject relatesto, Sentby sentby,
			String resourceType) {
		super();
		this.careteam = careteam;
		this.identifier = identifier;
		this.msgdata = msgdata;
		this.sentdate = sentdate;
		this.messagetype = messagetype;
		this.episode = episode;
		this.id = id;
		this.reply = reply;
		this.relatesto = relatesto;
		this.sentby = sentby;
		this.resourceType = resourceType;
	}


	public RefrenceObject getCareteam() {
		return careteam;
	}


	public void setCareteam(RefrenceObject careteam) {
		this.careteam = careteam;
	}


	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	public Msgdata getMsgdata() {
		return msgdata;
	}


	public void setMsgdata(Msgdata msgdata) {
		this.msgdata = msgdata;
	}


	public String getSentdate() {
		return sentdate;
	}


	public void setSentdate(String sentdate) {
		this.sentdate = sentdate;
	}


	public String getMessagetype() {
		return messagetype;
	}


	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}


	public RefrenceObject getEpisode() {
		return episode;
	}


	public void setEpisode(RefrenceObject episode) {
		this.episode = episode;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public List<Content> getReply() {
		return reply;
	}


	public void setReply(List<Content> reply) {
		this.reply = reply;
	}


	public RefrenceObject getRelatesto() {
		return relatesto;
	}


	public void setRelatesto(RefrenceObject relatesto) {
		this.relatesto = relatesto;
	}


	public Sentby getSentby() {
		return sentby;
	}


	public void setSentby(Sentby sentby) {
		this.sentby = sentby;
	}


	public String getResourceType() {
		return resourceType;
	}


	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}


	
}
