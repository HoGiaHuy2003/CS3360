/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package com.mycompany.cs3360_project;

import com.mycompany.entities.CategoryEntity;
import com.mycompany.entities.RolesEntity;
import com.mycompany.entities.StatusEntity;
import com.mycompany.entities.UserRolesEntity;
import com.mycompany.entities.UsersEntity;
import com.mycompany.models.Category;
import com.mycompany.models.Roles;
import com.mycompany.models.Status;
import com.mycompany.models.Users;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Legion
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane signIn_form;
    @FXML
    private Button signin_close;

    @FXML
    private Hyperlink signin_hyperlink;

    @FXML
    private Button signin_minimize;

    @FXML
    private PasswordField signin_password;

    @FXML
    private TextField signin_username;

    @FXML
    private Button signinbtn;
    
    @FXML
    private TextField signup_age;

    @FXML
    private Button signup_btn;

    @FXML
    private Button signup_close;

    @FXML
    private TextField signup_email;
    
    @FXML
    private AnchorPane signup_form;
    
    @FXML
    private Hyperlink hyperlink;

    @FXML
    private Button signup_miniminze;

    @FXML
    private PasswordField signup_password;
    
    @FXML
    private TextField signup_phonenumber;

    @FXML
    private TextField signup_username;
    @FXML
    private Label title;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (Users.getLoginUserId() != null) {
            title.setText("Edit your information");
            hyperlink.setText("Back");
            Users editedUser = UsersEntity.details(Users.getLoginUserId());
            signup_age.setText(editedUser.getAge().toString());
            signup_phonenumber.setText(editedUser.getPhoneNumber());
            signup_email.setText(editedUser.getEmail());
            signup_username.setText(editedUser.getUsername());
            signup_password.setText(editedUser.getPassword());
            signup_btn.setText("Edit");
            signIn_form.setVisible(false);
            signup_form.setVisible(true);
        }
    }    
    
    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }

    private void switchForm(ActionEvent event) throws IOException {
        if (Users.getLoginUserId() != null) {
            switchToDashBoard();
        }
        
        if(event.getSource() == signin_hyperlink){
            signIn_form.setVisible(false);
            signup_form.setVisible(true);
        } else if(event.getSource() == hyperlink) {
            signIn_form.setVisible(true);
            signup_form.setVisible(false);
        }
    }
    @FXML
    private void signIn_close() {
        System.exit(0);
    }
    @FXML
    private void signIn_minimize() {
        Stage stage = (Stage)signIn_form.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    private void signUp_close() {
        System.exit(0);
    }
    @FXML
    private void signUp_minimize() {
        Stage stage = (Stage)signup_form.getScene().getWindow();
        stage.setIconified(true);       
    }
    
    @FXML
    private double x = 0;
    private double y = 0;
    private void switchToDashBoard() throws IOException {
//        App.setRoot("dashboard");
       signinbtn.getScene().getWindow().hide();
       Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
       Stage stage = new Stage();
       Scene scene = new Scene(root);
       root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
            
            stage.setOpacity(0.8);
        });
        
        root.setOnMouseReleased((MouseEvent event) -> {
            stage.setOpacity(1);
        });

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
    
    private void errorLogin() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!!!");
        alert.setHeaderText("Cannot login!!!");
        alert.setContentText("Username and password are incorrect, please check again!!!");
        alert.showAndWait();
    }
    
    @FXML
    private void signIn_and_signUp() throws Exception {
//       signinbtn.getScene().getWindow().hide();
//       Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
//       Stage stage = new Stage();
//       Scene scene = new Scene(root);
//       stage.setScene(scene);
//       stage.show();
        if (signIn_form.isVisible()) {
           Users user = new Users();
           user.setUsername(signin_username.getText().toString());
           user.setPassword(signin_password.getText().toString());

           Users userLogin = UsersEntity.login(user);
           
           

           if (userLogin != null) {
                
                Users.setLoginUserId(userLogin.getUserId());
               
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successfully!!!");
                alert.setHeaderText("Log in successfully!!!");
                alert.setContentText("Account " + user.getUsername() + " is logged in!!!");
                alert.showAndWait();
               

               switchToDashBoard();
           } else {
               
               Users.setCountFailureLoginNumber(Users.getCountFailureLoginNumber() + 1);
               
               if (Users.getCountFailureLoginNumber() == 3) {
                   
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!!!");
                    alert.setHeaderText("Log in fail 3 times consecutively!!!");
                    alert.setContentText("You failed to log in 3 times consecutively, the program will close currently.");
                    alert.showAndWait();
                   
                    System.exit(0);
               }
               
                errorLogin();
           }
           return;
        } // Sign In Method
       
        if (signup_form.isVisible()) {
            try {
                if (!Users.validateAge(Integer.parseInt(signup_age.getText().toString()))) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!!!");
                    alert.setHeaderText("Cannot register!!!");
                    alert.setContentText("Age must be a number from 1 to 200, please try again!!!");
                    alert.showAndWait();
                    return;
                }
                
                Integer age = Integer.parseInt(signup_age.getText().toString());
                
                if (!Users.validatePhoneNumber((signup_phonenumber.getText().toString()))) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!!!");
                    alert.setHeaderText("Cannot register!!!");
                    alert.setContentText("Phone number must be 10/11/12 digits, and the first digit must be 7, 8 or 9, please try again!!!");
                    alert.showAndWait();
                    return;
                } 
                String phoneNumber = (signup_phonenumber.getText().toString());
                
                if (!Users.validateEmail(signup_email.getText().toString())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!!!");
                    alert.setHeaderText("Cannot register!!!");
                    alert.setContentText("Invalid email, please try again!!!");
                    alert.showAndWait();
                    return; 
                }
                String email = signup_email.getText().toString();
                
                String username = signup_username.getText().toString();
                
                if (Users.getLoginUserId() == null) {
                    if (UsersEntity.checkExisted(username) != null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error!!!");
                        alert.setHeaderText("Cannot register!!!");
                        alert.setContentText("Username is already existed, please choose another username!!!");
                        alert.showAndWait();
                        return;
                    } 
                }
                
                if (!Users.validatePasswordHash(signup_password.getText().toString())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!!!");
                    alert.setHeaderText("Cannot register!!!");
                    alert.setContentText("Password must contains one digits, one lowercase, one uppercase, one special symbol in the list - '@#$%', from 6 to 15 characters, please try again!!!");
                    alert.showAndWait();
                    return;
                }
                
                String password = signup_password.getText().toString();
                
                Users user = new Users(username, age, email, phoneNumber, password);
                
                if (Users.getLoginUserId() == null) {
                    UsersEntity.insert(user); 
                    signIn_form.setVisible(true);
                    signup_form.setVisible(false);
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successfully!!!");
                    alert.setHeaderText("Register successfully!!!");
                    alert.setContentText("Your account is registered!!!");
                    alert.showAndWait();
                    
                    if (UsersEntity.index().size() == 1 && RolesEntity.index().size() == 0) {
                        Roles admin = new Roles(1, "Admin");
                        RolesEntity.insert(admin);
                        UserRolesEntity.insert(user.getUserId(), admin.getRoleId());
                        
                        Status status = new Status(1, "Waiting For Payment");
                        
                        StatusEntity.insert(status);
                        
                        status.setStatusId(2);
                        status.setStatusName("Cancelled");
                        
                        StatusEntity.insert(status);
                        
                        status.setStatusId(3);
                        status.setStatusName("Succeed");
                        
                        StatusEntity.insert(status);
                        
                        Category category = new Category(1, "Economy");
                        
                        CategoryEntity.insert(category);
                        
                        category.setCategoryId(2);
                        category.setCategoryName("Business");
                        
                        CategoryEntity.insert(category);
                        
                        category.setCategoryId(3);
                        category.setCategoryName("First Class");
                        
                        CategoryEntity.insert(category);
                    }
                    
                } // Register 
                else {
                    user.setUserId(Users.getLoginUserId());
                    UsersEntity.update(user);
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successfully!!!");
                    alert.setHeaderText("Update Information successfully!!!");
                    alert.setContentText("Your information is updated!!!");
                    alert.showAndWait();
                    
                    switchToDashBoard();
                } // Edit User Information
                
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!!!");
                alert.setHeaderText("Cannot register!!!");
                alert.setContentText("Age must be a number from 1 to 200, please try again!!!");
                alert.showAndWait();
            }
        } // Sign Up and Edit User Information

    }
    
}
