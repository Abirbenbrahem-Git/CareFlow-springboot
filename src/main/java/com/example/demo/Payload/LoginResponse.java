package com.example.demo.Payload;

public class LoginResponse {
    private String message;
    private String role;
    private int userId;

    public LoginResponse(String message, String role, int userId) {
        this.message = message;
        this.role = role;
        this.userId = userId;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

}
