package com.lesopt.foodfinder.models;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recipeId;
	private String recipeJSON;
  @Autowired
  @ManyToOne
	private User user;
	public Recipe() {
	}

  @Autowired
	public Recipe(String recipeJSON, User user) {
		this.recipeJSON = recipeJSON;
    this.user=user;
	}

	public Integer getRecipeId() {
		return recipeId;
	}


	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}


	public String getrecipeJSON() {
		return recipeJSON;
	}


	public void setrecipeJSON(String recipeJSON) {
		this.recipeJSON = recipeJSON;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recipeId;
		result = prime * result + ((recipeJSON == null) ? 0 : recipeJSON.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (!(obj instanceof Recipe)) {
			return false;
		}
		Recipe other = (Recipe) obj;
		if (recipeId != other.recipeId) {
			return false;
		}
		if (recipeJSON == null) {
			if (other.recipeJSON != null) {
				return false;
			}
		} else if (!recipeJSON.equals(other.recipeJSON)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeJSON=" + recipeJSON + ", user=" + user + "]";
	}



	
}
