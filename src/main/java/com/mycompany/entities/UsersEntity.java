/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import static com.mycompany.entities.BaseEntity.close;
import static com.mycompany.entities.BaseEntity.conn;
import static com.mycompany.entities.BaseEntity.open;
import static com.mycompany.entities.BaseEntity.statement;
import com.mycompany.models.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public class UsersEntity extends BaseEntity {
    public static void insert(Users newUser) {
        open();
        
        try {
            String sql = "INSERT INTO Users(UserName, NormalizedUserName, Age, Email, NormalizedEmail, PhoneNumber, Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, newUser.getUsername());
            statement.setString(2, newUser.getUsername().toUpperCase());
            statement.setInt(3, newUser.getAge());
            statement.setString(4, newUser.getEmail());
            statement.setString(5, newUser.getEmail().toUpperCase());
            statement.setString(6, newUser.getPhoneNumber());
            statement.setString(7, newUser.getPassword());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static void update(Users updateUser) {
        open();
        
        
        try {
            String sql = "UPDATE Users SET UserName = ?, NormalizedUserName = ?, Age = ?, Email = ?, NormalizedEmail = ?, PhoneNumber = ?, Password = ? WHERE UserId = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, updateUser.getUsername());
            statement.setString(2, updateUser.getUsername().toUpperCase());
            statement.setInt(3, updateUser.getAge());
            statement.setString(4, updateUser.getEmail());
            statement.setString(5, updateUser.getEmail().toUpperCase());
            statement.setString(6, updateUser.getPhoneNumber());
            statement.setString(7, updateUser.getPassword());
            statement.setInt(8, updateUser.getUserId());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static void delete(Integer UserId) {
        open();
        
        String sql = "DELETE FROM Users WHERE UserId = ?";
        
        try {
            statement = conn.prepareStatement(sql);
        
            statement.setInt(1, UserId);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static ObservableList<Users> index () {
        List<Users> userList = new Vector<>();

        open();

        try {
            String sql = "SELECT * FROM Users";
            statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Users user = new Users(resultSet.getInt("UserId"), resultSet.getString("UserName"), resultSet.getInt("Age"), resultSet.getString("Email"), resultSet.getString("PhoneNumber"), resultSet.getString("Password"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }

        ObservableList<Users> dataList = FXCollections.observableList(userList);

        return dataList;
    }
    
    public static Users details(Integer UserId) {
        Users user = null;
        open();

        try {
            String sql = "SELECT * FROM Users WHERE UserId = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new Users(resultSet.getInt("UserId"), resultSet.getString("UserName"), resultSet.getInt("Age"), resultSet.getString("Email"), resultSet.getString("PhoneNumber"), resultSet.getString("Password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        
        return user;
    }
    
    public static Users login(Users userLogin) {
        Users user = null;
        open();

        try {
            String sql = "SELECT * FROM Users WHERE NormalizedUserName = ? AND Password = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, userLogin.getUsername().toUpperCase());
            statement.setString(2, userLogin.getPassword());
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new Users(resultSet.getInt("UserId"), resultSet.getString("UserName"), resultSet.getInt("Age"), resultSet.getString("Email"), resultSet.getString("PhoneNumber"), resultSet.getString("Password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        
        return user;
    }
    
    public static Users checkExisted(String checkedUser) {
        Users user = null;
        open();

        try {
            String sql = "SELECT * FROM Users WHERE NormalizedUserName = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, checkedUser.toUpperCase());
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new Users(resultSet.getInt("UserId"), resultSet.getString("UserName"), resultSet.getInt("Age"), resultSet.getString("Email"), resultSet.getString("PhoneNumber"), resultSet.getString("Password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        
        return user;
    }
}
