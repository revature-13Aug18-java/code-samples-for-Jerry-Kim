package com.lesopt.foodfinder.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.lesopt.foodfinder.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
