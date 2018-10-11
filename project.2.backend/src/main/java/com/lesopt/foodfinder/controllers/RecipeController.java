//package com.revature.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.*;
//
//import java.sql.Date;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.revature.dao.RecipeDao;
//import com.revature.dao.RecipeDaoImpl;
//import com.revature.dao.UserDAO;
//import com.revature.dao.UserDAOImpl;
//import com.revature.exceptions.RecipeNotFoundException;
//import com.revature.exceptions.UserNotFoundException;
//import com.revature.models.RUser;
//import com.revature.models.Recipe;
//import com.revature.services.RecipeService;
//
//@Controller
//@CrossOrigin
//public class RecipeController {
//	
//	private static Logger log = Logger.getRootLogger();
//	private static UserDAO ud = new UserDAOImpl();
//	
//	@Autowired
//	private static RecipeService rService = new RecipeService();
//	
//	@GetMapping("/recipes/{id}")
//	@ResponseBody
//	public Recipe printRecipeByRecipeId(@PathVariable("id") int recipeId) {
//		
//		Recipe recipe = rService.getRecipeByRecipeId(recipeId);
//		
//		if(recipe == null) {
//			throw new RecipeNotFoundException();
//		}
//		
//		return recipe;
//		
//	}
//	
//	@GetMapping("recipes/users")
//	public String getSearchPage() {
//		return "RecipesByUser";
//	}
//	
//	@GetMapping("/recipes/users/{id}")
//	@ResponseBody
//	public List<Recipe> printRecipesByUserId(@PathVariable("id") int userId) {
//		
//		List<Recipe> recipes = rService.getAllRecipesByUserId(userId);
//		
//		if(recipes.size() == 0) {
//			throw new UserNotFoundException();
//		}
//		
//		return recipes;
//	}
//	
//	@GetMapping("/recipes")
//	@ResponseBody
//	public List<Recipe> printAllRecipes() {
//		return rService.getAllRecipes();
//	}
//	
//	@RequestMapping(value="recipes/save", method=RequestMethod.POST)
//	public String saveRecipe(@RequestParam("userId") String userId, @RequestParam("JSON") String recipeJSON) {
//		
//		Recipe recipe = new Recipe();
//		recipe.setrecipeJSON(recipeJSON);
//		RUser user = ud.getUserByUserId(Integer.parseInt(userId));
//		
//		if(user == null) {
//			throw new UserNotFoundException();
//		}
//		
//		recipe.setUser(user);
//		rService.saveRecipe(recipe);
//		
//		return "redirect:/recipes";
//		
//	}
//	
//	@RequestMapping(value="recipes/delete", method=RequestMethod.POST)
//	public String deleteRecipe(@RequestParam("recipeId") String recipeId) {
//		
//		Recipe recipe = rService.getRecipeByRecipeId(Integer.parseInt(recipeId));
//		
//		if(recipe == null) {
//			throw new RecipeNotFoundException();
//		}
//		
//		rService.deleteRecipe(recipe);
//		
//		return "redirect:/recipes";
//		
//	}
//	
//	@RequestMapping(value="recipes/save", method=RequestMethod.GET)
//	public String getSaveRecipe() {
//		return "SaveRecipe";
//	}
//	
//	@RequestMapping(value="recipes/delete", method=RequestMethod.GET)
//	public String getDeleteRecipe() {
//		return "DeleteRecipe";
//	}
//	
////----------------------------------------------------------------------------------------------------------
//	public void printRecipesByUser(RUser user) {
//		ObjectMapper om = new ObjectMapper();
//		try {
//			RecipeDao rdi = new RecipeDaoImpl();
//			List<Recipe> recipes = rdi.getAllRecipesByUser(user);
//			
//			String recipesString = om.writeValueAsString(recipes);
//			recipesString = "{\"recipes\":"+recipesString+"}";
//			log.info(recipesString);
//			
//
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}	
//	}
//
//	public void printRecipe(Recipe recipe) {
//		ObjectMapper om = new ObjectMapper();
//		try {
//			
//			String recipeString = om.writeValueAsString(recipe);
//			recipeString = "{\"recipes\":"+recipeString+"}";
//			log.info(recipeString);
//			
//
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//	}
//}
