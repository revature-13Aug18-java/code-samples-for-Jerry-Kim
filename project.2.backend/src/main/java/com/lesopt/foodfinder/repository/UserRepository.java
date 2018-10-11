package com.lesopt.foodfinder.repository;
import com.lesopt.foodfinder.models.User;
import org.springframework.data.repository.CrudRepository;
import java.util.*;
public interface UserRepository extends CrudRepository<User, String> {
  List<User> findByIsChef(boolean isChef);
	List<User> findByUsernameAndIsChef(String username, boolean isChef);
}
