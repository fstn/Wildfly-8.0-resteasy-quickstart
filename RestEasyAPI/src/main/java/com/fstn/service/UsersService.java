package com.fstn.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fstn.dto.UserDTO;
import com.fstn.facade.UsersFacade;

/**
 * The Class UsersService.
 */
@Path("/users")
public class UsersService {

    /** The users facade. */
    @Inject
    UsersFacade usersFacade;
    
     /** Find all.
	 *
	 * @return the list
	 */
    @GET
    @Path("/")
    @Produces({ "application/json" })
    public List<UserDTO> findAll() {
    	return usersFacade.findAll();
    }

     /** Find all.
	 *
	 * @param id
	 *            the id
	 * @return the user dto
	 */
    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    public UserDTO findAll(@PathParam("id") Long id) {
    	return usersFacade.find(id);
    }
    
}
