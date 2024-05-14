/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import com.mycompany.models.Status;
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
public class StatusEntity extends BaseEntity {
    public static List<Status> getStatusList() {
        List<Status> statusList = new Vector<>();

        open();

        try {
            String sql = "SELECT * FROM Status";
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Status Status = new Status(resultSet.getInt("StatusId"), resultSet.getString("StatusName"));
                statusList.add(Status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        
        ObservableList<Status> dataList = FXCollections.observableList(statusList);
        
        return dataList;
    }
}
