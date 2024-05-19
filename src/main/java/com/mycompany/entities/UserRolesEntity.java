/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import static com.mycompany.entities.BaseEntity.close;
import static com.mycompany.entities.BaseEntity.conn;
import static com.mycompany.entities.BaseEntity.open;
import static com.mycompany.entities.BaseEntity.statement;
import com.mycompany.models.Roles;
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
public class UserRolesEntity extends BaseEntity {
    public static void insert(Integer UserId, Integer RoleId) {
        open();
        
        try {
            String sql = "INSERT INTO UserRole(UserId, RoleId) VALUES(?, ?)";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);
            statement.setInt(2, RoleId);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static void deleteByUserId(Integer UserId) {
        open();
        
        String sql = "DELETE FROM UserRole WHERE UserId = ?";
        
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
    
    public static void deleteByRoleId(Integer RoleId) {
        open();
        
        String sql = "DELETE FROM UserRole WHERE RoleId = ?";
        
        try {
            statement = conn.prepareStatement(sql);
        
            statement.setInt(1, RoleId);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static List<Users> findUserListByRoleId(Integer RoleId) {
        List<Users> userList = new Vector<>();
        open();

        try {
            String sql = "SELECT Roles.RoleId, Roles.RoleName, Users.UserId, Users.UserName FROM userrole LEFT JOIN users ON users.UserId = userrole.UserId LEFT JOIN roles ON roles.RoleId = userrole.RoleId WHERE roles.RoleId = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, RoleId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Users user = new Users();
                user.setUserId(resultSet.getInt("UserId"));
                user.setUsername(resultSet.getString("UserName"));
                
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
    
    public static ObservableList<Roles> findRoleListByUserId(Integer UserId) {
        List<Roles> roleList = new Vector<>();
        open();
        
        try {
            String sql = "SELECT Roles.RoleId, Roles.RoleName, Users.UserId, Users.UserName FROM userrole LEFT JOIN users ON users.UserId = userrole.UserId LEFT JOIN roles ON roles.RoleId = userrole.RoleId WHERE users.UserId = ?;";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
//                Users user = new Users();
//                user.setUsername(resultSet.getString("UserName"));
//                user.setRoleName(resultSet.getString("RoleName"));
                Roles role = new Roles();
                role.setRoleId(resultSet.getInt("RoleId"));
                role.setRoleName(resultSet.getString("RoleName"));

                roleList.add(role);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        
        ObservableList<Roles> dataList = FXCollections.observableList(roleList);
        
        return dataList;
    }
    
    public static List<Users> findUserListByRoleName(String RoleName) {
        List<Users> userList = new Vector<>();
        open();

        try {
            String sql = "SELECT Roles.RoleId, Roles.RoleName, Users.UserId, Users.UserName FROM userrole LEFT JOIN users ON users.UserId = userrole.UserId LEFT JOIN roles ON roles.RoleId = userrole.RoleId WHERE roles.RoleName = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, RoleName);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Users user = new Users();
                user.setUserId(resultSet.getInt("UserId"));
                user.setUsername(resultSet.getString("UserName"));
                
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return userList;
    }
    
    public static Boolean isAuthorized(Integer UserId, String RoleName) {
        open();
        
        try {
            String sql = "SELECT Roles.RoleName, Users.UserId, Users.UserName FROM userrole LEFT JOIN users ON users.UserId = userrole.UserId LEFT JOIN roles ON roles.RoleId = userrole.RoleId WHERE users.UserId = ? AND roles.RoleName = ?;";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);
            statement.setString(2, RoleName);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        
        return false;
    }
}
