package main.java.com.ltotrackingsystem.model;

public class User {
    
    private Integer id;
    private String last_name;
    private String middle_name;
    private String first_name;
    private String email;
    private String phone_number;
    private String citizenship;
    private String birthdate;
    private String gender;
    private String address;
    private String civil_status;
    
    public int getId() {
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getLastName() {
        return last_name;
    }
    
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    
    public String getMiddleName() {
        return middle_name;
    }
    
    public void setMiddleName(String middle_name) {
        this.middle_name = middle_name;
    }
    
    public String getFirstName() {
        return first_name;
    }
    
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phone_number;
    }
    
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }
    
    public String getCitizenship() {
        return citizenship;
    }
    
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCivilStatus() {
        return civil_status;
    }
    
    public void setCivilStatus(String civil_status) {
        this.civil_status = civil_status;
    }
}
