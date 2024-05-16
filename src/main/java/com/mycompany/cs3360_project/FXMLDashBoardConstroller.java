/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.cs3360_project;

import com.mycompany.entities.CategoryEntity;
import com.mycompany.entities.OrderEntity;
import com.mycompany.entities.ReservationEntity;
import com.mycompany.entities.RolesEntity;
import com.mycompany.entities.StatusEntity;
import com.mycompany.entities.TicketEntity;
import com.mycompany.entities.UserRolesEntity;
import com.mycompany.entities.UsersEntity;
import com.mycompany.models.Category;
import com.mycompany.models.Order;
import com.mycompany.models.Reservation;
import com.mycompany.models.Roles;
import com.mycompany.models.Status;
import com.mycompany.models.Ticket;
import com.mycompany.models.Users;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Legion
 */
public class FXMLDashBoardConstroller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button bill_Btn;
    @FXML
    private Button selectTicket_Btn;

    @FXML
    private DatePicker selectTicket_Date;

    @FXML
    private Button selectTicket_addBtn;

    @FXML
    private Button selectTicket_addToCartBtn;

    @FXML
    private TextField selectTicket_ticketName;

    @FXML
    private TableColumn<Ticket, String> selectTicket_ticketNameTable;

    @FXML
    private ComboBox selectTicket_category;

    @FXML
    private TableColumn<Ticket, Category> selectTicket_categoryTable;

    @FXML
    private Button selectTicket_deleteBtn;

    @FXML
    private TableColumn<Ticket, Date> selectTicket_departmentTimeTable;

    @FXML
    private TextField selectTicket_endingPlace;

    @FXML
    private TableColumn<Ticket, String> selectTicket_endingPlaceBtn;

    @FXML
    private AnchorPane selectTicket_form;

    @FXML
    private TextField selectTicket_price;

    @FXML
    private TableColumn<Ticket, Float> selectTicket_priceTable;

    @FXML
    private Button selectTicket_resetBtn;

    @FXML
    private ComboBox<String> selectTicket_searchCategory;

    @FXML
    private Button selectTicket_selectTicketBtn;

    @FXML
    private TextField selectTicket_startingPlace;

    @FXML
    private TableColumn<Ticket, Float> selectTicket_startingPlaceTable;

    @FXML
    private TableView<Ticket> selectTicket_tableView;

    @FXML
    private Button selectTicket_updateBtn;

     @FXML
    private Button bookingTicket_Btn;

    @FXML
    private Label bookingTicket_age;

    @FXML
    private TableColumn<Ticket, String> bookingTicket_categoryTable;

    @FXML
    private TableColumn<Ticket, String> bookingTicket_departmentTimeTable;

    @FXML
    private Label bookingTicket_email;

    @FXML
    private TableColumn<Ticket, String> bookingTicket_endingPlaceTable;

    @FXML
    private AnchorPane bookingTicket_form;

    @FXML
    private Button bookingTicket_payBtn;

    @FXML
    private Label bookingTicket_phoneNumber;

    @FXML
    private TableColumn<Ticket, String> bookingTicket_priceTable;

    @FXML
    private Button bookingTicket_receiptBtn;

    @FXML
    private Button bookingTicket_resetBtn;

    @FXML
    private Button bookingTicket_selectBtn;

    @FXML
    private TableColumn<Ticket, String> bookingTicket_startingPlaceTable;

    @FXML
    private TableView<Ticket> bookingTicket_tableView;

    @FXML
    private TableColumn<Ticket, String> bookingTicket_ticketNameTable;

    @FXML
    private Label bookingTicket_toalBill;

    @FXML
    private DatePicker bookingTicket_userDate;

    @FXML
    private TextField bookingTicket_userFirstName;

    @FXML
    private ComboBox<?> bookingTicket_userGender;

    @FXML
    private TextField bookingTicket_userLastName;

    @FXML
    private TextField bookingTicket_userPhoneNum;

    @FXML
    private Label bookingTicket_username;
    
    @FXML
    private Button selectTicket_deleteFromReservationBtn;
    
    @FXML
    private Label login_username;
    
    @FXML
    private Label login_role_of_user;

    @FXML
    private Button close_btn;

    @FXML
    private Button role_addBtn;
    
    @FXML
    private TextField role_name;

    @FXML
    private TableColumn<Users, String> user_username;

    @FXML
    private TableColumn<Users, Integer> user_age;
    
    @FXML
    private TableColumn<Users, String> user_email;
    
    @FXML
    private TableColumn<Users, String> user_PhoneNum;

    @FXML
    private Button role_deleteBtn;
    
    @FXML
    private ListView<String> role_list;

    @FXML
    private TextField user_search;

    @FXML
    private TableView<Users> user_tableView;

    @FXML
    private Button roleAuthorize_btn;

    @FXML
    private Button users_Btn;

    @FXML
    private AnchorPane users_form;

    @FXML
    private Button dashBoard_Btn;
    
    @FXML 
    private Button edit_users_btn;
    
    @FXML
    private Button delete_user_btn;

    @FXML
    private AnchorPane dashBoard_form;

    @FXML
    private AnchorPane dashboard_availableAirplanes;

    @FXML
    private Label dashboard_availableAirplanesNum;

    @FXML
    private AreaChart<?, ?> dashboard_incomChart;

    @FXML
    private AnchorPane dashboard_todayIncome;

    @FXML
    private Label dashboard_todayIncomeNum;

    @FXML
    private AnchorPane dashboard_totalIncome;

    @FXML
    private Label dashboard_totalIncomeNum;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize_btn;

    @FXML
    private Button signout_btn;
    
    @FXML
    private TableView<Ticket> bill_TableView;

    @FXML
    private Button bill_cancelBtn;

    @FXML
    private Label bill_cancelDate;

    @FXML
    private TableColumn<Ticket, String> bill_categoryTable;

    @FXML
    private TableColumn<Ticket, String> bill_departureTable;

    @FXML
    private Label bill_email;

    @FXML
    private TableColumn<Ticket, String> bill_endingPlaceTable;

    @FXML
    private AnchorPane bill_form;

    @FXML
    private ComboBox<Integer> bill_history;

    @FXML
    private Label bill_orderDate;

    @FXML
    private Label bill_phoneNumber;

    @FXML
    private TableColumn<Ticket, Float> bill_priceTable;

    @FXML
    private TableColumn<Ticket, String> bill_startingPlaceTable;

    @FXML
    private Label bill_status;

    @FXML
    private Label bill_thankYou;

    @FXML
    private TableColumn<Ticket, String> bill_ticketNameTable;

    @FXML
    private Label bill_totalPayment;

    @FXML
    private Label bill_username;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        getUserNameAndRole();
        
        setValueForUsersTableView();
        
        setValueForRolesListView();
        
        authorization();
        
        setValueForTicketTableView();
        
        disableUpdateAndDelete();
        
        comboxCategory();
        
        setTicketForUpdatedForm();
        
        setUpReservationForm();
        
        setUpHistoryComboBox();
        
        setUpOrderOfUser();
    }    
    
    @FXML
    private void close() {
        System.exit(0);
    }
    
    @FXML
    private void minimize() {
        Stage stage = (Stage)main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    
    @FXML
    private void switchForm(ActionEvent event) {
        if(event.getSource() == dashBoard_Btn){
            dashBoard_form.setVisible(true);
            selectTicket_form.setVisible(false);
            bookingTicket_form.setVisible(false);
            users_form.setVisible(false);
            bill_form.setVisible(false);
        } else if(event.getSource() == selectTicket_Btn) {
            dashBoard_form.setVisible(false);
            selectTicket_form.setVisible(true);
            bookingTicket_form.setVisible(false);
            users_form.setVisible(false);
            bill_form.setVisible(false);
        } else if(event.getSource() == bookingTicket_Btn) {
            dashBoard_form.setVisible(false);
            selectTicket_form.setVisible(false);
            bookingTicket_form.setVisible(true);
            users_form.setVisible(false);
            bill_form.setVisible(false);
        } else if(event.getSource() == users_Btn) {
            dashBoard_form.setVisible(false);
            selectTicket_form.setVisible(false);
            bookingTicket_form.setVisible(false);
            users_form.setVisible(true);
            bill_form.setVisible(false);
        } else if(event.getSource() == bill_Btn) {
            dashBoard_form.setVisible(false);
            selectTicket_form.setVisible(false);
            bookingTicket_form.setVisible(false);
            users_form.setVisible(false);
            bill_form.setVisible(true);
        }
    }
    
    private void setValueForUsersTableView() {
        ObservableList<Users> userList = UsersEntity.index();
        user_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        user_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        user_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        user_PhoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        
        user_tableView.setItems(userList);
    }
    
    private void setValueForRolesListView() {
        ObservableList<Roles> roleList = RolesEntity.index();
        
        if (roleList == null) {
            return;
        }
 
        Integer sizeOfRoleList = roleList.size();
        
        role_list.getItems().clear();
        
        for (int i = 0; i < sizeOfRoleList; i++) {
            role_list.getItems().add(roleList.get(i).getRoleName());
        }
        role_list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    @FXML
    private void chooseUser() {
        if (user_tableView.getSelectionModel().getSelectedItem() != null) {
            ObservableList<Users> userList = UsersEntity.index();
            Integer sizeOfUserList = userList.size();
            for (int i = 0; i < sizeOfUserList; i++) {
                if (user_tableView.getSelectionModel().getSelectedItem().getUserId() == userList.get(i).getUserId()) {
                    Users.setSelectedUserId(userList.get(i).getUserId());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success!!!");
                    alert.setHeaderText("Selected User successfully!!!");
                    alert.setContentText("User are selected: " + userList.get(i).getUsername());
                    alert.showAndWait();
                    setUpReservationForm();
                    return;
                }
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!!!");
        alert.setHeaderText("No user choosen!");
        alert.setContentText("Please choose a user to authorize or support for booking ticket!!!");
        alert.showAndWait();
    }
    
    @FXML 
    private void authorizedUser() {
        if (Users.getSelectedUserId() == null) {
            // Do Some Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!!");
            alert.setHeaderText("No user choosen!");
            alert.setContentText("Please choose a user to authorize!");
            alert.showAndWait();
            return;
        }
        
        if (UserRolesEntity.findUserListByRoleName("Admin").size() == 1 && UserRolesEntity.isAuthorized(Users.getSelectedUserId(), "Admin")) {
            // This user is the only one who has role: admin and cannot be authorized 
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!!");
            alert.setHeaderText("Account is the only one which has role: Admin!!!");
            alert.setContentText("Your account is the only one having role: Admin and cannot be authorized!!!");
            alert.showAndWait();
            return;
        }
        
        UserRolesEntity.deleteByUserId(Users.getSelectedUserId());
        
        if (role_list.getSelectionModel().getSelectedItems() != null) {
            ObservableList<Roles> roleList = RolesEntity.index();
            Integer sizeOfRoleList = roleList.size();
            Integer roleSelectedSize = role_list.getSelectionModel().getSelectedItems().size();
            for (int i = 0; i < sizeOfRoleList; i++) {
                for (int j = 0; j < roleSelectedSize; j++) {
                    if (role_list.getSelectionModel().getSelectedItems().get(j).equalsIgnoreCase(roleList.get(i).getRoleName())) {
//                        roleList.get(i).setUserId(Users.getSelectedUserId());
                        UserRolesEntity.insert(Users.getSelectedUserId(), roleList.get(i).getRoleId());
                    }    
                }
            }
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!!!");
        alert.setHeaderText("Authorized User successfully!!!");
        alert.setContentText("User choosen is authorized as: " + role_list.getSelectionModel().getSelectedItems());
        alert.showAndWait();
        
        if (Users.getSelectedUserId() == Users.getLoginUserId()) {
            getUserNameAndRole();
        }
        
        authorization();
    }
    
    @FXML
    private void addRole() {
        String roleName = role_name.getText().toString();
        
        Roles newRole = new Roles();
        newRole.setRoleName(roleName);
        
        RolesEntity.insert(newRole);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!!!");
        alert.setHeaderText("Role added successfully!!!");
        alert.setContentText("Role added is: " + roleName);
        alert.showAndWait();
        
        role_list.getItems().add(roleName);
    }
    
    @FXML
    private void deleteRole() {
        if (role_list.getSelectionModel().getSelectedItems() != null) {
            ObservableList<Roles> roleList = RolesEntity.index();
            System.out.println(role_list.getSelectionModel().getSelectedItems().get(0));
            Integer roleSelectedSize = role_list.getSelectionModel().getSelectedItems().size();
            Integer sizeOfRoleList = roleList.size();
            
            role_list.getSelectionModel().getSelectedItems();
            
            for (int i = 0; i < sizeOfRoleList; i++) {
                for (int j = 0; j < roleSelectedSize; j++) {
                    if (role_list.getSelectionModel().getSelectedItems().get(j).equalsIgnoreCase(roleList.get(i).getRoleName())) {
                        
                        if (RolesEntity.findRoleByName("Admin").getRoleName().equalsIgnoreCase(role_list.getSelectionModel().getSelectedItems().get(j))) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error!!!");
                            alert.setHeaderText("Cannot delete role admin!!!");
                            alert.setContentText("Role admin cannot be deleted!!!");
                            alert.showAndWait();
                            continue;
                        }
                        
                        Integer deletedRoleId = roleList.get(i).getRoleId();
                        if (UserRolesEntity.findUserListByRoleId(deletedRoleId) != null) {
                            UserRolesEntity.deleteByRoleId(deletedRoleId); 
                        }
                        RolesEntity.delete(deletedRoleId);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success!!!");
                        alert.setHeaderText("Deleted role successfully!!!");
                        alert.setContentText("Role are deleted: " + roleList.get(i).getRoleName());
                        alert.showAndWait();
//                        role_list.getItems().remove(roleList.get(i).getRoleName());
                    }
                }
            }
            
            getUserNameAndRole();
            
            setValueForRolesListView();
            

            
//            Integer sizeOfRoleList = roleList.size();
//
//            for (int i = 0; i < sizeOfRoleList; i++) {
//                if (RolesEntity.findRoleByName(roleList.get(i)).getRoleName() != null) {
//                    Users deletedRole = RolesEntity.findRoleByName(roleList.get(i));
//                    Integer deletedRoleId = deletedRole.getRoleId();
//                    if (UserRolesEntity.findByRoleId(deletedRoleId) != null) {
//                        UserRolesEntity.deleteByRoleId(deletedRoleId); 
//                    }
//                    RolesEntity.delete(deletedRoleId);
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Success!!!");
//                    alert.setHeaderText("Deleted role successfully!!!");
//                    alert.setContentText("Role are deleted: " + deletedRole.getRoleName());
//                    alert.showAndWait();
//                    role_list.getItems().remove(roleList.get(i));
//                }
//            }
//            if (Users.getSelectedUserId() == Users.getLoginUserId()) {
//                getUserNameAndRole();
//            }
//            if (role_list.getSelectionModel().getSelectedItems() != null) {
//                ObservableList<Users> roleList = RolesEntity.index();
//                Integer sizeOfRoleList = roleList.size();
//                Integer roleSelectedSize = role_list.getSelectionModel().getSelectedItems().size();
//                for (int i = 0; i < sizeOfRoleList; i++) {
//                    for (int j = 0; j < roleSelectedSize; j++) {
//                        if (role_list.getSelectionModel().getSelectedItems().get(j).equalsIgnoreCase(roleList.get(i).getRoleName())) {
//                            roleList.get(i).setUserId(Users.getSelectedUserId());
//                            UserRolesEntity.insert(roleList.get(i));
//                        }    
//                    }
//                }
//            }
        }
    }
    
    private void getUserNameAndRole() {
        Integer loginId = Users.getLoginUserId();
        
//        System.out.println(loginId);
        
        Users users = UsersEntity.details(loginId);
        
        login_username.setText(users.getUsername());
        
        List<Roles> userRoleList = UserRolesEntity.findRoleListByUserId(loginId);
        
        if (userRoleList.size() == 0) {
            return;
        }
        
        String roleList = userRoleList.get(0).getRoleName();
        
        for (int i = 1; i < userRoleList.size(); i++) {
            roleList += ", " + userRoleList.get(i).getRoleName();
        }
        login_role_of_user.setText("Your role: " + roleList);
    }
    
    @FXML 
    private void signOut() throws IOException {
        main_form.getScene().getWindow().hide();
        Users.setLoginUserId(null);
        Users.setSelectedUserId(null);
        Ticket.setSelectedTicketId(null);
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void editAccount () throws IOException {
        main_form.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void deleteAccount() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete this account: ");
        alert.setHeaderText("Are you sure want to delete your account?");

        Optional<ButtonType> option = alert.showAndWait();
        
        if (option.get() == null) {
            
        } else if (option.get() == ButtonType.OK) {
            
        if (UserRolesEntity.findUserListByRoleName("Admin").size() == 1 && UserRolesEntity.isAuthorized(Users.getLoginUserId(), "Admin")) {
            // This user is the only one who has role: admin and cannot be deleted 
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!!");
            alert.setHeaderText("Account is the only one which has role: Admin!!!");
            alert.setContentText("Your account is the only one having role: Admin and cannot be authorized!!!");
            alert.showAndWait();
            return;
            }
            
            UserRolesEntity.deleteByUserId(Users.getLoginUserId());
            UsersEntity.delete(Users.getLoginUserId());
            Users.setLoginUserId(null);
            signOut();
        }
        
    } 
    
    private void authorization() {
        dashBoard_Btn.setDisable(false);
        roleAuthorize_btn.setDisable(false);
        role_addBtn.setDisable(false);
        role_deleteBtn.setDisable(false);
        selectTicket_addBtn.setDisable(false);
        if (!UserRolesEntity.isAuthorized(Users.getLoginUserId(), "Admin")) {
            dashBoard_Btn.setDisable(true);
            roleAuthorize_btn.setDisable(true);
            role_addBtn.setDisable(true);
            role_deleteBtn.setDisable(true);
            selectTicket_addBtn.setDisable(true);
        }
        users_Btn.setDisable(false);
        if (!UserRolesEntity.isAuthorized(Users.getLoginUserId(), "Admin") && !UserRolesEntity.isAuthorized(Users.getLoginUserId(), "Employee")) {
            users_Btn.setDisable(true);
        }
    }
    
    
//    private String[] catagoryList = {"VIP Ticket", "Normal Ticket"};
    private void comboxCategory() {
//        List<String> listC = new ArrayList();
//        for(String data: catagoryList) {
//            listC.add(data);
//        }
//        ObservableList listCategory = FXCollections.observableArrayList(listC);
//        selectTicket_category.setItems(listCategory);
        selectTicket_category.getItems().clear();
        selectTicket_searchCategory.getItems().clear();
        List<Category> categoryList = CategoryEntity.getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            selectTicket_category.getItems().addAll(categoryList.get(i).getCategoryName());
            selectTicket_category.getSelectionModel().select(null);
            selectTicket_searchCategory.getItems().addAll(categoryList.get(i).getCategoryName());
            selectTicket_searchCategory.getSelectionModel().select(null);
        }
    }
    
    @FXML
    private void setValueForTicketTableView() {
        ObservableList<Ticket> ticketList = TicketEntity.index();
        List<Category> categoryList = CategoryEntity.getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getCategoryName().equals(selectTicket_searchCategory.getValue())) {
                Integer categoryId = categoryList.get(i).getCategoryId();
                ticketList = TicketEntity.findByCategory(categoryId);
                break;
            }
        }
        
        selectTicket_ticketNameTable.setCellValueFactory(new PropertyValueFactory<>("ticketName"));
        selectTicket_categoryTable.setCellValueFactory(new PropertyValueFactory<>("category"));
        selectTicket_priceTable.setCellValueFactory(new PropertyValueFactory<>("price"));
        selectTicket_startingPlaceTable.setCellValueFactory(new PropertyValueFactory<>("startingPlace"));
        selectTicket_endingPlaceBtn.setCellValueFactory(new PropertyValueFactory<>("endingPlace"));
        selectTicket_departmentTimeTable.setCellValueFactory(new PropertyValueFactory<>("departmentTime"));
        
        selectTicket_tableView.setItems(ticketList);
    }
    
    private void disableUpdateAndDelete() {
        if (!UserRolesEntity.isAuthorized(Users.getLoginUserId(), "Admin")) {//UserRole is not Admin you cannot delete or update Ticket
            selectTicket_updateBtn.setDisable(true); // update is disabled
            selectTicket_deleteBtn.setDisable(true); // delete is disabled
            selectTicket_resetBtn.setDisable(false); // reset is unabled
            if (Ticket.getSelectedTicketId() == null) { // If you haven't selected ticket you cannot using resetBtn
                selectTicket_resetBtn.setDisable(true); // reset is disable
            }
            return;
        }
        // else if you is admin you can delete and update Ticket
        selectTicket_updateBtn.setDisable(false);
        selectTicket_deleteBtn.setDisable(false);
        selectTicket_resetBtn.setDisable(false);
        if (Ticket.getSelectedTicketId() == null) {
            selectTicket_updateBtn.setDisable(true);
            selectTicket_deleteBtn.setDisable(true);
            selectTicket_resetBtn.setDisable(true);
        }
    }
    
    @FXML
    private void addTicket() throws Exception {
        //TicketName, CategoryId, Price, StartingPlace, EndingPlace, Distance, DepartmentTime ,CreatedAt, UpdatedAt
        //TicketName, CategoryId, Price, StartingPlace, EndingPlace, Distance, DepartmentTime ,CreatedAt, UpdatedAt
        String ticketName = selectTicket_ticketName.getText();
        String startingPlace = selectTicket_startingPlace.getText();
        String endingPlace = selectTicket_endingPlace.getText();
        Float price = Float.valueOf(selectTicket_price.getText());
        String categoryName = (String)selectTicket_category.getSelectionModel().getSelectedItem();
        Integer categoryId = null;
        List<Category> categoryList = CategoryEntity.getCategoryList();
        // Find category ID
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getCategoryName().equals(categoryName)) {
                categoryId = categoryList.get(i).getCategoryId();
                break;
            }
        }
//        if(categoryName.equals("VIP Ticket")) {
//            categoryId = 1;
//        }
//        else {
//            categoryId = 2;
//        }
        //get DepartureDate
        LocalDate selectedDate = selectTicket_Date.getValue();
        Date departmentDate = java.sql.Date.valueOf(selectedDate);
        //Get creat and update Time
        Date creatAt = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date updateAt = creatAt;
        //Integer distance = null;
        Category category = new Category(categoryId, categoryName);
        Ticket newTicket = new Ticket(ticketName, category, price, startingPlace, endingPlace, departmentDate, creatAt, updateAt);
        // Attempt to insert the new ticket into the database
        TicketEntity.insert(newTicket);
        System.out.println("Ticket inserted successfully!");
        setValueForTicketTableView();
        
        // Announce to add successfully
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!!!");
        alert.setHeaderText("Ticket is added successfully!!!");
        alert.setContentText("Ticket added is: " + newTicket.getTicketName());
        alert.showAndWait();
    }
    
    @FXML
    private void selectTicket() {
        ObservableList<Ticket> ticketList = TicketEntity.index();// getTicketEntityList
        Integer sizeOfTicketList = ticketList.size();
        for (int i = 0; i < sizeOfTicketList; i++) {
            if (selectTicket_tableView.getSelectionModel().getSelectedItem().getTicketId() == ticketList.get(i).getTicketId()) {
                Ticket.setSelectedTicketId(ticketList.get(i).getTicketId());//Only when selectTicket I have selectedTicketId selectedTicketId equal TicketId
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success!!!");
                alert.setHeaderText("Selected ticket successfully!!!");
                alert.setContentText("Ticket is selected: " + ticketList.get(i).getTicketName());
                alert.showAndWait();
                break;
            }
        }
        
        System.out.println(Ticket.getSelectedTicketId());
        setTicketForUpdatedForm(); // then in the form you set value for textLabel for update
        
        disableUpdateAndDelete();// disableUpdateAnd Del
    }
    
    private void setTicketForUpdatedForm() {
        if (Ticket.getSelectedTicketId() != null) {
            Ticket ticketSelected = TicketEntity.details(Ticket.getSelectedTicketId());
            selectTicket_ticketName.setText(ticketSelected.getTicketName());
            selectTicket_startingPlace.setText(ticketSelected.getStartingPlace());
            selectTicket_endingPlace.setText(ticketSelected.getEndingPlace());
            selectTicket_price.setText(ticketSelected.getPrice().toString());
            selectTicket_category.setValue(ticketSelected.getCategory().getCategoryName());

            Instant instant = Instant.ofEpochMilli(ticketSelected.getDepartmentTime().getTime());
            selectTicket_Date.setValue(instant.atZone(ZoneId.systemDefault()).toLocalDate());
        } 
        else {
            selectTicket_ticketName.setText(null);
            selectTicket_startingPlace.setText(null);
            selectTicket_endingPlace.setText(null);
            selectTicket_price.setText(null);
            selectTicket_category.setValue(null);
            selectTicket_Date.setValue(null);
        }
    }
    
    @FXML
    private void updateTicket() {
        String ticketName = selectTicket_ticketName.getText();
        String startingPlace = selectTicket_startingPlace.getText();
        String endingPlace = selectTicket_endingPlace.getText();
        Float price = Float.valueOf(selectTicket_price.getText());
        String categoryName = (String)selectTicket_category.getSelectionModel().getSelectedItem();
        Integer categoryId = null;
        List<Category> categoryList = CategoryEntity.getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getCategoryName().equals(categoryName)) {
                categoryId = categoryList.get(i).getCategoryId();
                break;
            }
        }
//        if(categoryName.equals("VIP Ticket")) {
//            categoryId = 1;
//        }
//        else {
//            categoryId = 2;
//        }
        LocalDate selectedDate = selectTicket_Date.getValue();
        Date departmentDate = java.sql.Date.valueOf(selectedDate);
        Date creatAt = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date updateAt = creatAt;
        Integer distance = null;
        Category category = new Category(categoryId, categoryName);
        Ticket updateTicket = new Ticket(ticketName, category, price, startingPlace, endingPlace, departmentDate, creatAt, updateAt);
        if (Ticket.getSelectedTicketId() == null) {
            // ERROR CANNOT EDITED BECAUSE NO TICKET IS SELECTED TO DELETE
            return;
        }
        updateTicket.setTicketId(Ticket.getSelectedTicketId());
        // Attempt to insert the new ticket into the database
        TicketEntity.update(updateTicket);
        System.out.println("Ticket updated successfully!");
        setValueForTicketTableView();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!!!");
        alert.setHeaderText("Ticket is updated successfully!!!");
        alert.setContentText("Ticket updated is: " + updateTicket.getTicketName());
        alert.showAndWait();
    }
    
    @FXML
    private void resetTicket() {
        Ticket.setSelectedTicketId(null);
        disableUpdateAndDelete();
        setTicketForUpdatedForm();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!!!");
        alert.setHeaderText("Ticket is unselected successfully!!!");
        alert.setContentText("Ticket is unselected!");
        alert.showAndWait();
    }
    
    @FXML 
    private void deleteTicket() {
        
    }
    
    @FXML
    private void addToReservation() {
        if (Ticket.getSelectedTicketId() != null) {
            Integer UserId = Users.getLoginUserId();
            if (Users.getSelectedUserId() != null) {
                UserId = Users.getSelectedUserId();
            } 
            
            ReservationEntity.insert(UserId, Ticket.getSelectedTicketId());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!!!");
            alert.setHeaderText("Add ticket successfully!!!");
            alert.setContentText("Ticket which you choosed is added to reservation!");
            alert.showAndWait();
            setUpReservationForm();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!!!");
        alert.setHeaderText("Error add ticket to reservation");
        alert.setContentText("Please choose ticket you want to add to reservation!");
        alert.showAndWait();
    }
    
    private void setUpReservationForm() {
        Integer UserId = Users.getLoginUserId();
        if (Users.getSelectedUserId() != null) {
            UserId = Users.getSelectedUserId();
        }
        
        Reservation userReservation = ReservationEntity.ticketListOfUserId(UserId);
        
        if (userReservation == null) {
            bookingTicket_Btn.setDisable(true);
            bookingTicket_form.setVisible(false);
            selectTicket_form.setVisible(true);
            return;
        }
        bookingTicket_username.setText(userReservation.getUser().getUsername());
        bookingTicket_age.setText(userReservation.getUser().getAge().toString());
        bookingTicket_phoneNumber.setText(userReservation.getUser().getPhoneNumber());
        bookingTicket_email.setText(userReservation.getUser().getEmail());

        ObservableList<Ticket> ticketList = FXCollections.observableList(ReservationEntity.ticketListOfUserId(UserId).getTicketList());
        bookingTicket_ticketNameTable.setCellValueFactory(new PropertyValueFactory<>("ticketName"));
        bookingTicket_categoryTable.setCellValueFactory(new PropertyValueFactory<>("category"));
        bookingTicket_priceTable.setCellValueFactory(new PropertyValueFactory<>("price"));
        bookingTicket_startingPlaceTable.setCellValueFactory(new PropertyValueFactory<>("startingPlace"));
        bookingTicket_endingPlaceTable.setCellValueFactory(new PropertyValueFactory<>("endingPlace"));
        bookingTicket_departmentTimeTable.setCellValueFactory(new PropertyValueFactory<>("departmentTime"));

        bookingTicket_tableView.setItems(ticketList); 
        
        bookingTicket_Btn.setDisable(false);
        
        bookingTicket_toalBill.setText(ReservationEntity.totalBill(UserId).toString());
    }
    
    @FXML
    private void deleteFromReservation () {
        if (bookingTicket_tableView.getSelectionModel().getSelectedItem() != null) {
            Ticket.setSelectedTicketId(bookingTicket_tableView.getSelectionModel().getSelectedItem().getTicketId());
            
            Integer UserId = Users.getLoginUserId();
            if (Users.getSelectedUserId() != null) {
                UserId = Users.getSelectedUserId();
            } 
            
            ReservationEntity.deleteTicketByUserId(UserId, Ticket.getSelectedTicketId());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!!!");
            alert.setHeaderText("Delete ticket successfully!!!");
            alert.setContentText("Ticket which you choosed is delete from reservation!");
            alert.showAndWait();
            Ticket.setSelectedTicketId(null);
            setUpReservationForm();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!!!");
        alert.setHeaderText("Error delete ticket from reservation");
        alert.setContentText("Please choose ticket you want to delete from reservation!");
        alert.showAndWait();
    }
    
    @FXML
    private void order() {
        Integer UserId = Users.getLoginUserId();
        if (Users.getSelectedUserId() != null) {
            UserId = Users.getSelectedUserId();
        }
        
        Users orderUser = UsersEntity.details(UserId);
        
        Order order = new Order();
        
        order.setUser(orderUser);
        
        List<Status> statusList = StatusEntity.getStatusList();
        
        order.setStatus(statusList.get(0));
        
        order.setOrderDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        OrderEntity.insert(order);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!!!");
        alert.setHeaderText("Order Successfully!!!");
        alert.setContentText("Your order is successfully!");
        alert.showAndWait();
        
        List<Order> orderList = OrderEntity.findOrderListByUser(UserId);
        
        Integer size = orderList.size() - 1;
        
        order.setOrderId(orderList.get(size).getOrderId());
        
        bill_form.setVisible(true);
        
        bookingTicket_form.setVisible(false);
        
        Reservation getTicketListFromReservation = ReservationEntity.ticketListOfUserId(UserId);
        
        for (int i = 0; i < getTicketListFromReservation.getTicketList().size(); i++) {
            OrderEntity.insert(order.getOrderId(), getTicketListFromReservation.getTicketList().get(i).getTicketId(), getTicketListFromReservation.getTicketList().get(i).getPrice());
        }
        
        ReservationEntity.clearReservation(UserId);
        
        setUpOrderOfUser();
        
    }
    
    private void setUpHistoryComboBox() {
        Integer UserId = Users.getLoginUserId();
        if (Users.getSelectedUserId() != null) {
            UserId = Users.getSelectedUserId();
        }
        
        ObservableList<Order> orderList = OrderEntity.printOrderListOfUser(UserId);
        
        if (orderList.size() == 0) {
            bill_Btn.setDisable(true);
            
            bill_form.setVisible(false);
            
            selectTicket_form.setVisible(true);
            
            return;
        }
        
        for (int i = 0; i < orderList.size(); i++) {
            bill_history.getItems().addAll(i+1);
        }
        
        bill_history.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void setUpOrderOfUser() {
        Integer UserId = Users.getLoginUserId();
        if (Users.getSelectedUserId() != null) {
            UserId = Users.getSelectedUserId();
        }
        
        ObservableList<Order> orderList = OrderEntity.printOrderListOfUser(UserId);
        
        if (orderList.size() == 0) {
            return;
        }
       
        for (int i = 0; i < orderList.size(); i++) {
            if (bill_history.getSelectionModel().getSelectedItem() == i+1) {
                bill_username.setText(orderList.get(i).getUser().getUsername());
                bill_email.setText(orderList.get(i).getUser().getEmail());
                bill_phoneNumber.setText(orderList.get(i).getUser().getPhoneNumber());
                bill_orderDate.setText(orderList.get(i).getOrderDate().toString());
                bill_status.setText(orderList.get(i).getStatus().toString());
                bill_cancelDate.setText("No Cancel");
                
                if (orderList.get(i).getCancelDate() != null) {
                    bill_cancelDate.setText(orderList.get(i).getCancelDate().toString());
                }
                
                bill_ticketNameTable.setCellValueFactory(new PropertyValueFactory<>("ticketName"));
                bill_categoryTable.setCellValueFactory(new PropertyValueFactory<>("category"));
                bill_priceTable.setCellValueFactory(new PropertyValueFactory<>("price"));
                bill_startingPlaceTable.setCellValueFactory(new PropertyValueFactory<>("startingPlace"));
                bill_endingPlaceTable.setCellValueFactory(new PropertyValueFactory<>("endingPlace"));
                bill_departureTable.setCellValueFactory(new PropertyValueFactory<>("departmentTime"));
                
                ObservableList<Ticket> ticketList = FXCollections.observableList(orderList.get(i).getTicketList());
                
                bill_TableView.setItems(ticketList);
                
                return;
            }
        }
    }
    
    @FXML
    private void cancelOrder() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete this account: ");
        alert.setHeaderText("Are you sure want to cancel your order?");

        Optional<ButtonType> option = alert.showAndWait();
        
        if (option.get() == null) {
            
        } else if (option.get() == ButtonType.OK) {
            Integer UserId = Users.getLoginUserId();
            if (Users.getSelectedUserId() != null) {
                UserId = Users.getSelectedUserId();
            }
            
            ObservableList<Order> orderList = OrderEntity.printOrderListOfUser(UserId);
            
            Order order = new Order();
            
            order.setCancelDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            
            for (int i = 0; i < orderList.size(); i++) {
                if (bill_history.getSelectionModel().getSelectedItem() == i+1) {
                    order.setOrderId(orderList.get(i).getOrderId());
                    
                    Status status = new Status();
                    
                    status.setStatusId(orderList.get(i).getStatus().getStatusId() + 1);
                    
                    order.setStatus(status);
                    
                    OrderEntity.updateCancelDate(order);
                    
                    setUpOrderOfUser();
                    
                    return;
                }
            }
        }
    }
} 
