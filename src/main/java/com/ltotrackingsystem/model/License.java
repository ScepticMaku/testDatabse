package main.java.com.ltotrackingsystem.model;

public class License {
    
    private Integer id;
    private Integer user_id;
    private String status;
    
    public int getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public int getUserId() {
        return user_id;
    }
    
    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
