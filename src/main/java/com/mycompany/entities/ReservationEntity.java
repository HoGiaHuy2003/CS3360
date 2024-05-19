/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import com.mycompany.models.Category;
import com.mycompany.models.Reservation;
import com.mycompany.models.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ReservationEntity extends BaseEntity {
    public static void insert(Integer UserId, Integer TicketId) {
        open();
        
        try {
            String sql = "INSERT INTO Reservation (UserId, TicketId) VALUES (?, ?)";
            
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);
            statement.setInt(2, TicketId);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static void deleteTicketFromReservation(Integer UserId, Integer TicketId) {
        open();
        
        try {
            String sql = "DELETE FROM Reservation WHERE UserId = ? AND TicketId = ?";
            
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);
            statement.setInt(2, TicketId);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static void deleteTicket(Integer TicketId) {
        open();
        
        try {
            String sql = "DELETE FROM Reservation WHERE TicketId = ?";
            
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, TicketId);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static void clearReservation (Integer UserId) {
        open();
        
        try {
            String sql = "DELETE FROM Reservation WHERE UserId = ?";
            
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static Reservation ticketListOfUserId (Integer UserId) {
        Reservation reservation = null;
        
        open();
        
        try {
            String sql = "SELECT Users.UserId, Users.UserName, Users.Age, Users.Email, Users.PhoneNumber, Ticket.*, Category.* FROM Ticket INNER JOIN Reservation ON Ticket.TicketId = Reservation.TicketId LEFT JOIN Category ON Ticket.CategoryId = Category.CategoryId INNER JOIN Users ON Reservation.UserId = Users.UserId WHERE users.UserId = ?;";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                if (reservation == null) {
                    reservation = new Reservation();
                }
                reservation.getUser().setUserId(resultSet.getInt("UserId"));
                reservation.getUser().setUsername(resultSet.getString("UserName"));
                reservation.getUser().setAge(resultSet.getInt("Age"));
                reservation.getUser().setEmail(resultSet.getString("Email"));
                reservation.getUser().setPhoneNumber(resultSet.getString("PhoneNumber"));
                
                Ticket ticket = new Ticket();
                ticket.setTicketId(resultSet.getInt("TicketId"));
                ticket.setTicketName(resultSet.getString("TicketName"));
                
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("CategoryId"));
                category.setCategoryName(resultSet.getString("CategoryName"));
                
                ticket.setCategory(category);
                ticket.setPrice(resultSet.getFloat("Price"));
                ticket.setStartingPlace(resultSet.getString("StartingPlace"));
                ticket.setEndingPlace(resultSet.getString("EndingPlace"));
                ticket.setDepartmentTime(resultSet.getDate("DepartmentTime"));
                ticket.setCreatedAt(resultSet.getDate("CreatedAt"));
                ticket.setUpdatedAt(resultSet.getDate("UpdatedAt"));
                
                reservation.getTicketList().add(ticket);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservationEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        
        return reservation;
    }
    
    public static Float totalBill(Integer UserId) {
        open();
        
        try {
            String sql = "SELECT SUM(Price) 'Total Price' FROM Ticket INNER JOIN Reservation ON Ticket.TicketId = Reservation.TicketId LEFT JOIN Category ON Ticket.CategoryId = Category.CategoryId INNER JOIN Users ON Reservation.UserId = Users.UserId WHERE Users.UserId = ?;";
            
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getFloat("Total Price");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservationEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally  {
            close();
        }
        
        return null;
    }
}
