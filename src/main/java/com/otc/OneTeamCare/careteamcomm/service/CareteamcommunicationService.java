package com.otc.OneTeamCare.careteamcomm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.otc.OneTeamCare.careteamcommunication.models.Careteamcommunication;


@Service
public interface CareteamcommunicationService {

	public String addCommunication(Careteamcommunication comm);
	public List<Careteamcommunication> getAllCareteamcommunications();
	public Careteamcommunication getCateteamCommunication(String identifier);

}
