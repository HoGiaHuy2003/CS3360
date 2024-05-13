/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import static com.mycompany.entities.BaseEntity.close;
import static com.mycompany.entities.BaseEntity.conn;
import static com.mycompany.entities.BaseEntity.open;
import static com.mycompany.entities.BaseEntity.statement;
import com.mycompany.models.Category;
import com.mycompany.models.Order;
import com.mycompany.models.Status;
import com.mycompany.models.Ticket;
import com.mycompany.models.Users;
import java.sql.Date;
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
public class OrderEntity extends BaseEntity {
    public static void insert(Order order) {
        open();
        
        try {
            String sql = "INSERT INTO Order_(UserId, StatusId, OrderDate)VALUES(?, ?, ?)";
            
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, order.getUser().getUserId());
            statement.setInt(2, order.getStatus().getStatusId());
            statement.setDate(3, new Date(order.getOrderDate().getTime()));
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(OrderEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static List<Order> findOrderListByUser(Integer UserId) {
        List<Order> orderList = new Vector<>();
        open();
        try {
            String sql = "SELECT * FROM Order_ WHERE UserId = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);

            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Order order = new Order();
                
                order.setOrderId(resultSet.getInt("OrderId"));
                
                orderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return orderList;
    }
    
    public static void insert(Integer OrderId, Integer TicketId, Float Price) {
        open();
        
        try {
            String sql = "INSERT INTO OrderDetail(OrderId, TicketId, Price) VALUES (?, ?, ?)";
            
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, OrderId);
            statement.setInt(2, TicketId);
            statement.setFloat(3, Price);
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public static ObservableList<Order> printOrderListOfUser(Integer UserId) {
        open();
        
        List<Order> orderList = new Vector<>();
        
        try {
            String sql = "SELECT Users.UserName, Users.Email, Users.PhoneNumber, Order_.OrderId, Order_.OrderDate, Order_.CancelDate, Status.StatusId ,Status.StatusName, Ticket.TicketId ,Ticket.TicketName, Category.CategoryId ,Category.CategoryName, Ticket.StartingPlace, Ticket.EndingPlace, Ticket.DepartmentTime, OrderDetail.Price FROM OrderDetail INNER JOIN Order_ ON OrderDetail.OrderId = Order_.OrderId INNER JOIN Status ON Order_.StatusId = Status.StatusId INNER JOIN Ticket ON OrderDetail.OrderId = Ticket.TicketId INNER JOIN Category ON Ticket.CategoryId = Category.CategoryId INNER JOIN Users ON Order_.UserId = Users.UserId WHERE Users.UserId = ? ORDER BY OrderId ASC;";
        
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, UserId);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {

                
                Users user = new Users();
                user.setUsername(resultSet.getString("UserName"));
                user.setEmail(resultSet.getString("Email"));
                user.setPhoneNumber(resultSet.getString("PhoneNumber"));
                

                
                Status status = new Status();
                status.setStatusId(resultSet.getInt("StatusId"));
                status.setStatusName(resultSet.getString("StatusName"));
                

                
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
//                ticket.setCreatedAt(resultSet.getDate("CreatedAt"));
//                ticket.setUpdatedAt(resultSet.getDate("UpdatedAt"));
                
                Order order = new Order();
                
                order.setOrderId(resultSet.getInt("OrderId"));
                
                order.setUser(user);
                order.setOrderDate(resultSet.getDate("OrderDate"));
                order.setCancelDate(resultSet.getDate("CancelDate"));
                
                order.setStatus(status);
                
                order.getTicketList().add(ticket);
                
                orderList.add(order);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObservableList<Order> dataList = FXCollections.observableList(orderList);

        
        return dataList;
    }
    
    public static void updateCancelDate(Order order) {
        open();
        
        try {
            String sql = "UPDATE Order_ SET CancelDate = ?, StatusId = ? WHERE OrderId = ?";
            
            statement = conn.prepareStatement(sql);
            
            statement.setDate(1, new Date(order.getCancelDate().getTime()));
            statement.setInt(2, order.getStatus().getStatusId());
            statement.setInt(3, order.getOrderId());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
}

