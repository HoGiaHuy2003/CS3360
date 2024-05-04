/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import com.mycompany.models.Ticket;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class TicketEntity extends BaseEntity {
    public static void insert (Ticket newTicket) {
        open();

        try {
            String sql = "INSERT INTO Ticket (TicketName, CategoryId, Price, StartingPlace, EndingPlace, Distance, DepartmentTime ,CreatedAt, UpdatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, newTicket.getTicketName());
            statement.setInt(2, newTicket.getCategoryId());
            statement.setFloat(3, newTicket.getPrice());
            statement.setString(4, newTicket.getStartingPlace());
            statement.setString(5, newTicket.getEndingPlace());
            statement.setInt(6, newTicket.getDistance());
            statement.setDate(7, (Date) newTicket.getDepartmentTime());
            statement.setDate(8, (Date) newTicket.getCreatedAt());
            statement.setDate(9, (Date) newTicket.getUpdatedAt());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static void update (Ticket updateTicket) {
        open();

        try {
            String sql = "UPDATE Ticket  SET TicketName = ?, CategoryId = ?, Price = ?, StartingPlace = ?, EndingPlace = ?, Distance = ?, DepartmentTime = ?, UpdatedAt = ?) WHERE TicketId = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, updateTicket.getTicketName());
            statement.setInt(2, updateTicket.getCategoryId());
            statement.setFloat(3, updateTicket.getPrice());
            statement.setString(4, updateTicket.getStartingPlace());
            statement.setString(5, updateTicket.getEndingPlace());
            statement.setInt(6, updateTicket.getDistance());
            statement.setDate(7, (Date) updateTicket.getDepartmentTime());
            statement.setDate(8, (Date) updateTicket.getUpdatedAt());
            statement.setInt(9, updateTicket.getTicketId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static void delete (Integer TicketId) {
        open();
        
        String sql = "DELETE FROM Ticket WHERE TicketId = ?";
        
        try {
            statement = conn.prepareStatement(sql);
        
            statement.setInt(1, TicketId);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static ObservableList<Ticket> findByCategory(Integer CategoryId) {
        List<Ticket> ticketList = new Vector<>();
        
        open();
        
        String sql = "SELECT Ticket.*, Category.CategoryName FROM Ticket LEFT JOIN Category ON Ticket.CategoryId = Category.CategoryId WHERE Category.CategoryId = ?";
        try {
            statement = conn.prepareStatement(sql);
        
            statement.setInt(1, CategoryId);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setTicketName(resultSet.getString("TicketName"));
                ticket.setCategoryName(resultSet.getString("CategoryName"));
                ticket.setPrice(resultSet.getFloat("Price"));
                ticket.setStartingPlace(resultSet.getString("StartingPlace"));
                ticket.setEndingPlace(resultSet.getString("EndingPlace"));
                ticket.setDistance(resultSet.getInt("Distance"));
                ticket.setDepartmentTime(resultSet.getDate("DepartmentTime"));
                ticket.setCreatedAt(resultSet.getDate("CreatedAt"));
                ticket.setUpdatedAt(resultSet.getDate("UpdatedAt"));
                
                ticketList.add(ticket);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        
        ObservableList<Ticket> dataList = FXCollections.observableList(ticketList);

        return dataList;
    } 
}
