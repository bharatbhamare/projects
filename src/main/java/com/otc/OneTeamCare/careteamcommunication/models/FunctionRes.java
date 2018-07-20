package com.otc.OneTeamCare.careteamcommunication.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FunctionRes {

		@Id
	private String careteam;

	private String users;

	private String careteamcommunication;

	

	public String getCareteam() {
		return careteam;
	}

	public void setCareteam(String careteam) {
		this.careteam = careteam;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getCareteamcommunication() {
		return careteamcommunication;
	}

	public void setCareteamcommunication(String careteamcommunication) {
		this.careteamcommunication = careteamcommunication;
	}

	public FunctionRes( String careteam, String users, String careteamcommunication) {
		super();
		
		this.careteam = careteam;
		this.users = users;
		this.careteamcommunication = careteamcommunication;
	}

	public FunctionRes() {
		
	}

		
}
