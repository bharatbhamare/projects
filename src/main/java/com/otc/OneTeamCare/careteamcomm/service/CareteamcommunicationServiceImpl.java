package com.otc.OneTeamCare.careteamcomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otc.OneTeamCare.careteamcommunication.models.Careteamcommunication;

@Service
 class CareteamcommunicationServiceImpl implements CareteamcommunicationService
 {

	 @Autowired
	 com.otc.OneTeamCare.careteamcomm.repository.Careteamcommunication careteamrepo;
	 
	@Override
	public String addCommunication(Careteamcommunication comm) {
		careteamrepo.save(comm);
		return "succesess";
	}

	@Override
	public List<Careteamcommunication> getAllCareteamcommunications() {
		
		return (List<Careteamcommunication>)careteamrepo.findAll();
	}

	@Override
	public Careteamcommunication getCateteamCommunication(String identifier) {
		// TODO Auto-generated method stub
		return (Careteamcommunication)careteamrepo.findBylogicalId(identifier);
	}
}
