/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import com.mycompany.models.Roles;
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
public class RolesEntity extends BaseEntity {
    public static void insert(Roles newRole) {
        open();

        String sql = "INSERT INTO Roles (RoleName, NormalizedRoleName) VALUES (?, ?)";

        try {
            statement = conn.prepareStatement(sql);

            statement.setString(1, newRole.getRoleName());
            statement.setString(2, newRole.getRoleName().toUpperCase());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RolesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public static void update(Roles updatedRole) {
        open();

        String sql = "UPDATE Roles SET RoleName = ?, NormalizedRoleName = ? WHERE RoleId = ?";

        try {
            statement = conn.prepareStatement(sql);

            statement.setString(1, updatedRole.getRoleName());
            statement.setString(2, updatedRole.getRoleName().toUpperCase());

            statement.setInt(3, updatedRole.getRoleId());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RolesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public static void delete(Integer RoleId) {
        open();
        String sql = "DELETE FROM Roles WHERE RoleId = ?";

        try {
            statement = conn.prepareStatement(sql);

            statement.setInt(1, RoleId);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RolesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public static ObservableList<Roles> index() {
        List<Roles> roleList = new Vector<>();

        open();

        try {
            String sql = "SELECT * FROM Roles";
            statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Roles role = new Roles(resultSet.getInt("RoleId"), resultSet.getString("RoleName"));
                roleList.add(role);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }

        ObservableList<Roles> dataList = FXCollections.observableList(roleList);

        return dataList;
    }
    
    public static Roles findRoleByName(String RoleName) {
        Roles role = null;

        open();

        try {
            String sql = "SELECT * FROM Roles WHERE NormalizedRoleName = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, RoleName.toUpperCase());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                role = new Roles(resultSet.getInt("RoleId"), resultSet.getString("RoleName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }

        return role;
    }
}
