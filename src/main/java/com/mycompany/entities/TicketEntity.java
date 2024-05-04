/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import com.mycompany.models.Ticket;

/**
 *
 * @author Admin
 */
public class TicketEntity extends BaseEntity {
    public static void insert (Ticket newTicket) {
        open();
        
        String sql = "INSERT INTO Ticket (TicketName, CategoryId, Price, StartingPlace, EndingPlace, Distance, CreatedAt, UpdatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }
}
