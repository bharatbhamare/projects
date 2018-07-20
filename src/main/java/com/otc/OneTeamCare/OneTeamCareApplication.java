package com.otc.OneTeamCare;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
public class OneTeamCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneTeamCareApplication.class, args);
	}
	
}
