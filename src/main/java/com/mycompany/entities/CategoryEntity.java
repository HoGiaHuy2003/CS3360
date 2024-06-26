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
import com.mycompany.models.Ticket;
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
public class CategoryEntity {
    public static List<Category> getCategoryList() {
        List<Category> categoryList = new Vector<>();

        open();

        try {
            String sql = "SELECT * FROM category";
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Category category = new Category(resultSet.getInt("CategoryId"), resultSet.getString("CategoryName"));
                categoryList.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        
        ObservableList<Category> dataList = FXCollections.observableList(categoryList);
        
        return dataList;
    }
    
    public static void insert(Category newCategory) {
        open();
        
        try {
            String sql = "INSERT INTO Category (CategoryName) VALUES (?);";
            
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, newCategory.getCategoryName());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryEntity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
}
