/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Users {
    private Integer userId;
    private String username;
    private Integer age;
    private String email;
    private String phoneNumber;
    private String password;
    
    private List<Roles> roleList;
    
    private static Integer loginUserId;
    
    private static Integer selectedUserId;

    public static Integer getLoginUserId() {
        return loginUserId;
    }

    public static void setLoginUserId(Integer loginUserId) {
        Users.loginUserId = loginUserId;
    }

    public static Integer getSelectedUserId() {
        return selectedUserId;
    }

    public static void setSelectedUserId(Integer selectedUserId) {
        Users.selectedUserId = selectedUserId;
    }

    public Users() {
    }

    public Users(String username, Integer age, String email, String phoneNumber, String password) {
        this.username = username;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Users(Integer userId, String username, Integer age, String email, String phoneNumber, String password) {
        this.userId = userId;
        this.username = username;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Roles> roleList) {
        this.roleList = roleList;
    }
    
    public static Boolean validateAge(Integer age) {
        Pattern pattern = Pattern.compile("^(0?[1-9]|[1-9][0-9]|100|200)$");
        Matcher matcher = pattern.matcher(age.toString());
        if (matcher.find() && matcher.group().equals(age.toString())) {
            return true;
        }
        return false;
    }
    
    public static Boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("(0|91)?[7-9][0-9]{9}");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find() && matcher.group().equals(phoneNumber)) {
            return true;
        }
        return false;
    }
    
    public static Boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find() && matcher.group().equals(email)) {
            return true;
        }
        return false;
    }
    
    public static Boolean validatePasswordHash(String passwordHash) {
        Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{6,15})");
        Matcher matcher = pattern.matcher(passwordHash);
        if (matcher.find() && matcher.group().equals(passwordHash)) {
            return true;
        }
        return false;
    }
    
//    public static String generateString(int length) {
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        
//        StringBuilder randomString = new StringBuilder();
//        
//        Random random = new Random();
//        
//        for (int i = 0; i < length; i++) {
//            int index = random.nextInt(alphabet.length());
//            
//            char randomChar = alphabet.charAt(index);
//            
//            randomString.append(randomChar);
//        }
//        
//        return randomString.toString();
//    } // Random string 
}
