package main.java.com.ltotrackingsystem.repository;

import main.java.com.ltotrackingsystem.model.User;
import main.java.com.ltotrackingsystem.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class UserRepositoryImplementation implements UserRepository {
    DatabaseConnection connectDatabase = new DatabaseConnection();
    
    @Override
    public User create(User user){
        String sql = "INSERT INTO user "
                + "(last_name, middle_name, first_name, email, phone_number, citizenship, "
                + "birthdate, gender, address, civil_status) "
                + "VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            PreparedStatement state = connectDatabase.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            state.setString(1, user.getLastName());
            state.setString(2, user.getMiddleName());
            state.setString(3, user.getFirstName());
            state.setString(4, user.getEmail());
            state.setString(5, user.getPhoneNumber());
            state.setString(6, user.getCitizenship());
            state.setString(7, user.getBirthdate());
            state.setString(8, user.getGender());
            state.setString(9, user.getAddress());
            state.setString(10, user.getCivilStatus());
            state.executeUpdate();
            
            ResultSet generatedKeys = state.getGeneratedKeys();
            if(generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
        return user;
    }
    
    @Override
    public Optional<User> read(Integer id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            PreparedStatement state = connectDatabase.getConnection().prepareStatement(sql);
            
            state.setInt(1, id);
            ResultSet result = state.executeQuery();
            
            if(result.next()) {
                User user = new User();
                user.setId(result.getInt("id"));
                user.setLastName(result.getString("last_name"));
                user.setMiddleName(result.getString("middle_name"));
                user.setFirstName(result.getString("first_name"));
                user.setEmail(result.getString("email"));
                user.setPhoneNumber(result.getString("phone_number"));
                user.setCitizenship((result.getString("citizenship")));
                user.setBirthdate(result.getString("birthdate"));
                user.setGender(result.getString("gender"));
                user.setAddress(result.getString("address"));
                user.setCivilStatus(result.getString("civil_status"));
                return Optional.of(user);
            }
        } catch(SQLException e) {
            System.out.println("Error reading user: " + e.getMessage());
        }
        return Optional.empty();
    }
    
    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        
        try (
                PreparedStatement state = connectDatabase.getConnection().prepareStatement(sql);
                ResultSet result = state.executeQuery()) {
            
            while(result.next()) {
                User user = new User();
                user.setId(result.getInt("id"));
                user.setLastName(result.getString("last_name"));
                user.setMiddleName(result.getString("middle_name"));
                user.setFirstName(result.getString("first_name"));
                user.setEmail(result.getString("email"));
                user.setPhoneNumber(result.getString("phone_number"));
                user.setCitizenship((result.getString("citizenship")));
                user.setBirthdate(result.getString("birthdate"));
                user.setGender(result.getString("gender"));
                user.setAddress(result.getString("address"));
                user.setCivilStatus(result.getString("civil_status"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error reading all users: " + e.getMessage());
        }
        return users;
    }
    
    @Override
    public User update(User user) {
        String sql = "UPDATE user "
                + "SET last_name = ?, middle_name = ?, first_name = ?, email = ?, phone_number = ?, "
                + "citizenship = ?, birthdate = ?, gender = ?, address = ?, civil_status = ? WHERE id = ?";
        try (PreparedStatement state = connectDatabase.getConnection().prepareStatement(sql)) {
            
            state.setString(1, user.getLastName());
            state.setString(2, user.getMiddleName());
            state.setString(3, user.getFirstName());
            state.setString(4, user.getEmail());
            state.setString(5, user.getPhoneNumber());
            state.setString(6, user.getCitizenship());
            state.setString(7, user.getBirthdate());
            state.setString(8, user.getGender());
            state.setString(9, user.getAddress());
            state.setString(10, user.getCivilStatus());
            state.setInt(11, user.getId());
            state.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
        return user;
    }
    
    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM user WHERE id = ?";
        
        try(PreparedStatement state = connectDatabase.getConnection().prepareStatement(sql)) {
            
            state.setInt(1, id);
            return state.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Error deleteing user: " + e.getMessage());
        }
        
        return false;
    }
    
    @Override
    public List<User> searchByName(String name) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE name LIKE ?";
        
        try(PreparedStatement state = connectDatabase.getConnection().prepareStatement(sql)) {
            
            state.setString(1, "%" + name + "%");   
            ResultSet result = state.executeQuery();
            
            while (result.next()){
                User user = new User();
                user.setId(result.getInt("id"));
                user.setLastName(result.getString("last_name"));
                user.setMiddleName(result.getString("middle_name"));
                user.setFirstName(result.getString("first_name"));
                user.setEmail(result.getString("email"));
                user.setPhoneNumber(result.getString("phone_number"));
                user.setCitizenship((result.getString("citizenship")));
                user.setBirthdate(result.getString("birthdate"));
                user.setGender(result.getString("gender"));
                user.setAddress(result.getString("address"));
                user.setCivilStatus(result.getString("civil_status"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error finding a user: " + e.getMessage());
        }
        return users;
    }
}
