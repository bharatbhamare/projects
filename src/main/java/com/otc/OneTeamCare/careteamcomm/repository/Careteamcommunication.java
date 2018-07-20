package com.otc.OneTeamCare.careteamcomm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Careteamcommunication  extends CrudRepository<com.otc.OneTeamCare.careteamcommunication.models.Careteamcommunication, String>{

	
	public com.otc.OneTeamCare.careteamcommunication.models.Careteamcommunication findBylogicalId(String identifier);
}
