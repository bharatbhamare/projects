package com.otc.OneTeamCare.careteamcomm.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Single {
	@Id
	private String get_careteamcommunication_by_careteam;

	public String getGet_careteamcommunication_by_careteam() {
		return get_careteamcommunication_by_careteam;
	}

	public void setGet_careteamcommunication_by_careteam(String get_careteamcommunication_by_careteam) {
		this.get_careteamcommunication_by_careteam = get_careteamcommunication_by_careteam;
	}

	
	
}
