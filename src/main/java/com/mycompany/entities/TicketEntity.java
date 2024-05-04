/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import com.mycompany.models.Ticket;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            statement.setString(7, newTicket.getDepartmentTime());
            statement.setDate(8, (Date) newTicket.getCreatedAt());
            statement.setDate(9, (Date) newTicket.getUpdatedAt());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
}
