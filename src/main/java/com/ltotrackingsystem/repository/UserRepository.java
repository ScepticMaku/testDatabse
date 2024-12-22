package main.java.com.ltotrackingsystem.repository;

import main.java.com.ltotrackingsystem.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer>{
    List<User> searchByName(String name);
}
