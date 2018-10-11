package com.lesopt.foodfinder;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.lesopt.foodfinder.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.lesopt.foodfinder.models.User;
import com.lesopt.foodfinder.repository.UserRepository;
import com.lesopt.foodfinder.models.Recipe;

@SpringBootApplication
public class DemoApplication {
  private final static Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

  @Bean
  public CommandLineRunner demo(UserRepository userRepo, RecipeRepository recipeRepo) {
    return (args) -> {
      User user1 = userRepo.save(new User("firstname", "lastname", "username", "pass", "email@", User.IS_NOT_CHEF));
      User user2 = userRepo.save(new User("Jack", "Bauer", "jackbauer", "123", "jack@@", User.IS_CHEF));
      String recipeJson = "{\"title\": \"recipe title\", \"publisher\": \"some publisher\" }";
      recipeRepo.save(new Recipe(recipeJson, user1));
      recipeRepo.save(new Recipe(recipeJson, user2));
      for(User u : userRepo.findAll()) {
        log.info(u.toString());
      }
    };
  }
}
