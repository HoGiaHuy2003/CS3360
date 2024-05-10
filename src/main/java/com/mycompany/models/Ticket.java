/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Ticket {
    private Integer ticketId;
    
    private String ticketName;
    
    private Float price;
    
    private String startingPlace;
    
    private String endingPlace;
    
    private Date departmentTime;
    
    private Category category;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private static Integer selectedTicketId;

    public static Integer getSelectedTicketId() {
        return selectedTicketId;
    }

    public static void setSelectedTicketId(Integer selectedTicketId) {
        Ticket.selectedTicketId = selectedTicketId;
    }

    public Ticket() {
        category = new Category();
    }

    //TicketName, CategoryId, Price, StartingPlace, EndingPlace, Distance, DepartmentTime ,CreatedAt, UpdatedAt
    public Ticket(String ticketName, Category category ,Float price, String startingPlace, String endingPlace, Date departmentTime, Date creatAt, Date updateAt) {
        this.ticketName = ticketName;
        this.category = category;
        this.price = price;
        this.startingPlace = startingPlace;
        this.endingPlace = endingPlace;
        this.departmentTime = departmentTime;
        this.createdAt = creatAt;
        this.updatedAt = updateAt;
        
    }
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStartingPlace() {
        return startingPlace;
    }

    public void setStartingPlace(String startingPlace) {
        this.startingPlace = startingPlace;
    }

    public String getEndingPlace() {
        return endingPlace;
    }

    public void setEndingPlace(String endingPlace) {
        this.endingPlace = endingPlace;
    }

    public Date getDepartmentTime() {
        return departmentTime;
    }

    public void setDepartmentTime(Date departmentTime) {
        this.departmentTime = departmentTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketId=" + ticketId + ", ticketName=" + ticketName + ", price=" + price + ", startingPlace=" + startingPlace + ", endingPlace=" + endingPlace + ", departmentTime=" + departmentTime + ", category=" + category + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
