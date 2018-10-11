package com.lesopt.foodfinder.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
  public static final boolean IS_NOT_CHEF = false; 
  public static final boolean IS_CHEF = true;
  
	@Id
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String passw;
	private boolean isChef; 

	public User() {
	}
  
  public User(String firstname, String lastname, String username, String passw, String email, boolean isChef) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.passw = passw;
    this.email = email;
    this.isChef = isChef;
  }


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public boolean getIsChef() {
		return isChef;
	}

	public void setIsChef(boolean isChef) {
		this.isChef = isChef;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((passw == null) ? 0 : passw.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (isChef != other.isChef) {
			return false;
		}
		if (firstname == null) {
			if (other.firstname != null) {
				return false;
			}
		if (lastname == null) {
			if (other.lastname != null) {
				return false;
			}
		} else if (!firstname.equals(other.firstname)) {
			return false;
		}
		} else if (!lastname.equals(other.lastname)) {
			return false;
		}
		if (passw == null) {
			if (other.passw != null) {
				return false;
			}
		} else if (!passw.equals(other.passw)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [" + (username != null ? "username=" + username + ", " : "")
				 + "isChef=" + isChef + "]";
	}


	
	/**
	 * Get firstname.
	 *
	 * @return firstname as String.
	 */
	public String getFirstname()
	{
	    return firstname;
	}
	
	/**
	 * Set firstname.
	 *
	 * @param firstname the value to set.
	 */
	public void setFirstname(String firstname)
	{
	    this.firstname = firstname;
	}
	
	/**
	 * Get lastname.
	 *
	 * @return lastname as String.
	 */
	public String getLastname()
	{
	    return lastname;
	}
	
	/**
	 * Set lastname.
	 *
	 * @param lastname the value to set.
	 */
	public void setLastname(String lastname)
	{
	    this.lastname = lastname;
	}
}
