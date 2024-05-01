/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class UserManagement {
    List<Users> userList;
    Integer size;

    public UserManagement() {
        userList = new Vector<Users>();
        size = userList.size();
    }
    
    public void register(Users user) {
        userList.add(user);
        System.out.println("Registered successfully!!!");
    }
    
    public Users login(Users user) {
        for (int i = 0; i < size; i++) {
            if (userList.get(i).getUsername().equals(user.getUsername()) && userList.get(i).getPassword().equals(user.getPassword())) {
                return userList.get(i);
            }
        }
        return null;
    }
    
    public List<Users> selectUser() {
        return userList;
    }
    
    public void editUser(Users user) {
        for (int i = 0; i < size; i++) {
            if (userList.get(i).getUserId() == user.getUserId()) {
                userList.set(i, user);
            }
        }
    }
    
    public void deleteUser(int userId) {
        for (int i = 0; i < size; i++) {
            if (userList.get(i).getUserId() == userId) {
                userList.remove(i);
            }
        }
    }
} 
