package com.otc.OneTeamCare;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.cfg.Configuration;

import com.otc.OneTeamCare.careteamcomm.repository.Single;
import com.otc.OneTeamCare.careteamcommunication.models.FunctionRes;

@NamedNativeQuery(
	    name = "getcomm",
	    query = "{ get_careteamcommunication()}",
	    callable = true,
	    resultClass = Object.class
	)

public class aaaaaaa {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory().getSessionFactory();
		if(sessionFactory==null)
		{
			System.out.println("null obj");
		}else{
			System.out.println("niot bnull");
		}

		Session session= sessionFactory.openSession();
		if(session==null)
		{
			System.out.println("session is null");
		}else{
			
			String sql = "SELECT * FROM qotc.get_careteamcommunication(?)";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(FunctionRes.class);
			query.setString(0, "qqqq");
			FunctionRes results =  (FunctionRes) query.uniqueResult();
			
			System.out.println("res: "+results.getCareteamcommunication());
			
			
		}
		
	}
	

}
