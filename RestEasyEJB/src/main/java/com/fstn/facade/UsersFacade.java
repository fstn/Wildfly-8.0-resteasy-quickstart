/**
 * 
 */
package com.fstn.facade;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fstn.dao.UsersDAO;
import com.fstn.dto.UserDTO;
import com.fstn.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UsersFacade.
 *
 * @author stephen
 */
@Stateless
public class UsersFacade {

	/** The entity manager. */
	@PersistenceContext(unitName="primary")
	private EntityManager entityManager;
	
	/** The users dao. */
	private UsersDAO usersDAO;
	
	/**
	 * Post construct.
	 */
	@PostConstruct
	private void  postConstruct(){
		usersDAO = new UsersDAO(entityManager);
	}
		
	/**
	 * Find.
	 *
	 * @param id the id
	 * @return the user dto
	 */
	public UserDTO find(Long id){
		User user = usersDAO.find(id);
		return new UserDTO(user);
	}
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<UserDTO> findAll(){
		List<User> users = usersDAO.findAll();
		return users.stream().filter(Objects::nonNull).map(user -> new UserDTO(user)).collect(Collectors.toList());
	}
}
