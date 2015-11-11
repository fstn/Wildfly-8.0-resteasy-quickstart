package com.fstn.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fstn.model.User;

/**
 * The Class UserDTO.
 */
@XmlRootElement
public class UserDTO {

	/** The id. */
	private Long id;

	/** The first name. */
	private String firstName;

	/** The address. */
	private String address;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new user dto.
	 *
	 * @param user
	 *            the user
	 */
	public UserDTO(User user) {
		if (user != null) {
			this.id = user.getId();
			this.firstName = user.getFirstName();
			this.address = user.getAddress();
			this.name = user.getName();
		}
	}

	/**
	 * Gets the vo.
	 *
	 * @return the vo
	 */
	@XmlTransient
	public User getVo() {
		User user = new User();
		user.setId(id);
		user.setAddress(address);
		user.setFirstName(firstName);
		user.setName(name);
		return user;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
