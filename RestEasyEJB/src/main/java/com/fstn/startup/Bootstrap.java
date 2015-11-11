package com.fstn.startup;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fstn.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Startup.
 */
@Startup
@Singleton
public class Bootstrap {

	@PersistenceContext
	private EntityManager entityManager;
	/**
	 * Post construct.
	 */
	@PostConstruct
	public void postConstruct(){
		User user = new User();
		user.setFirstName("Paul");
		user.setName("DUPOND");
		user.setAddress("2 rue des Olivier 34000 Montpellier");
		entityManager.persist(user);
		
	}
}
