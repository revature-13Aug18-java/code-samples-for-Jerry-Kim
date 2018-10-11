package com.lesopt.foodfinder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Recipe does not exist.")
public class RecipeNotFoundException extends RuntimeException {

	public RecipeNotFoundException() {
		super();
	}

}
