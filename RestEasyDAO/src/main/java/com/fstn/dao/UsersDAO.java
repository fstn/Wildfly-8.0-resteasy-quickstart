/**
 * 
 */
package com.fstn.dao;

import javax.persistence.EntityManager;

import com.fstn.model.User;

/**
 * The Class UsersDAO.
 *
 * @author stephen
 */
public class UsersDAO extends AbstractDAO<User> {

	
	/**
	 * Instantiates a new users dao.
	 *
	 * @param entityManager the entity manager
	 */
	public UsersDAO (EntityManager entityManager){
		super(User.class, entityManager);
	}
}
