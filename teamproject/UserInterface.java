/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UserInterface extends Application {

    private Stage primaryStage;
    private StackPane root;
    private TextField userField;
    private PasswordField passField;
    private VBox mainButtonBox;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createMainInterface();
        
        Scene scene = new Scene(root, 635, 420);
        primaryStage.setTitle("Magic Shop Café");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void createMainInterface() {
        // Create buttons
        Button userBtn = createButton("User");
        Button adminBtn = createButton("Admin");
        Button staffBtn = createButton("Staff");

        // Layout for buttons
        mainButtonBox = new VBox();//for back button
        HBox buttonBox = new HBox(85, userBtn, adminBtn, staffBtn);
        buttonBox.setPadding(new Insets(20));
        buttonBox.setAlignment(Pos.CENTER);
        
        mainButtonBox = new VBox(buttonBox);
        mainButtonBox.setAlignment(Pos.CENTER);

        // Set button actions
        userBtn.setOnAction(e -> showLoginInterface("User"));
        adminBtn.setOnAction(e -> showLoginInterface("Admin"));
        staffBtn.setOnAction(e -> showLoginInterface("Staff"));

        // Background setup
        Image bgImage = new Image("file:/G://Summer 2025//CSE lab//TeamProject//src//gfx//openimage.png");
        BackgroundImage bg = new BackgroundImage(
                bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, false)
        );

        root = new StackPane();
        root.setBackground(new Background(bg));
        root.getChildren().add(mainButtonBox);
        StackPane.setAlignment(buttonBox, Pos.BOTTOM_CENTER);
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setPadding(new Insets(20));
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setBackground(new Background(new BackgroundFill(
                Color.ANTIQUEWHITE,
                new CornerRadii(10),
                Insets.EMPTY
        )));
        return button;
    }
    private Button createButton2(String text) {
        Button button = new Button(text);
        button.setPrefWidth(105);
        button.setPrefHeight(2);
        button.setPadding(new Insets(5));
        button.setAlignment(Pos.TOP_LEFT);
        button.setBackground(new Background(new BackgroundFill(
                Color.BURLYWOOD,
                new CornerRadii(2),
                Insets.EMPTY
        )));
        return button;
    }
    private Button createButton3(String text) {
        Button button = new Button(text);
        button.setPrefWidth(105);
        button.setPrefHeight(2);
        button.setPadding(new Insets(5));
        button.setAlignment(Pos.TOP_RIGHT);
        button.setBackground(new Background(new BackgroundFill(
                Color.BURLYWOOD,
                new CornerRadii(2),
                Insets.EMPTY
        )));
        return button;
    }
    public Button createBackButton() {
        Button backButton = createButton("Back");

        backButton.setOnAction(e -> {
            root.getChildren().clear();
            root.getChildren().add(mainButtonBox);
        });

        return backButton;
    }

    private void showLoginInterface(String userType) {
        // Clear existing UI elements
        root.getChildren().clear();

        // Create login form
        VBox loginFormation = new VBox(10);
        StackPane.setAlignment(loginFormation, Pos.CENTER);
        loginFormation.setAlignment(Pos.CENTER);

        Label title = new Label(userType + " Login");
        title.setTextFill(Color.WHITE);

        userField = new TextField();
        userField.setPromptText("Username");
        userField.setPrefWidth(200);
        userField.setMaxWidth(200);

        passField = new PasswordField();
        passField.setPromptText("Password");
        passField.setPrefWidth(200);
        passField.setMaxWidth(200);

        Button loginBtn = createButton("Login");
        Button backBtn1 = createBackButton();

        loginBtn.setOnAction(e -> handleLogin(userType));

        loginFormation.getChildren().addAll(title, userField, passField, loginBtn, backBtn1);
        root.getChildren().add(loginFormation);
    }

    private void handleLogin(String userType) {
        String username = userField.getText();
        String password = passField.getText();

        Customer customer = new Customer(username, password,this);
        customer.login();
        Staff admin = new Staff(username, password,this);
        admin.login();
        Staff staff = new Staff(username,password,this);
        staff.login();
    }
    protected void showUserMenu(){
        Button menuBtn = createButton("Menu");
        Button logoutBtn = createButton("Logout");
        Button backBtn2 = createBackButton();
        VBox showmenu = new VBox(10, menuBtn, logoutBtn,backBtn2);
        showmenu.setAlignment(Pos.CENTER);
        StackPane.setAlignment(showmenu, Pos.CENTER);
        logoutBtn.setOnAction(e -> System.exit(0));
        menuBtn.setOnAction(e -> showUserOrder());

        root.getChildren().clear();
        root.getChildren().add(showmenu);
        Image cImage = new Image("file:G://Summer 2025//CSE lab//TeamProject//src//gfx//bgimage.png");
        BackgroundImage cfi = new BackgroundImage(
                cImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true)
        );

        //new bg set
        root.setBackground(new Background(cfi));
        
    }
    
    protected void showUserOrder() {
        Cafe cafe = new Cafe();
        cafe.setUpMenu();
        TextField userInput = new TextField();
        userInput.setPromptText("Type your drink name");

        Button checkBtn = createButton2("Check Menu");
        Button OrderBtn = createButton2("Order");
        Button SnacksBtn = createButton3("Snacks");
        Button PayBtn = createButton3("Payment");

        Label resultLabel = new Label();

        checkBtn.setOnAction(e -> {
            String input = userInput.getText().trim();
            MenuItem item = cafe.findItemByName(input);
            if (item != null) {
                resultLabel.setText("✅ " + item.getName() + " is available for " + item.getPrice() + " BDT.");
            } else {
                resultLabel.setText("Sorry T-T, we don't have \"" + input + "\" on the menu.");
            }});
        
        root.getChildren().clear();
        VBox inputSection = new VBox(userInput);
        VBox menu1 = new VBox(5, checkBtn, resultLabel, OrderBtn);
        VBox menu2 = new VBox(5, SnacksBtn, PayBtn);
        VBox menu3 = new VBox(5,inputSection, menu1);
        VBox menucard = new VBox(250, menu3, menu2);
        menu2.setAlignment(Pos.BOTTOM_RIGHT);
        root.getChildren().add(menucard);
        
        Image mImage = new Image("file:G://Summer 2025//CSE lab//TeamProject//src//gfx//drinks.png");
        BackgroundImage menuImage = new BackgroundImage(
                mImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true)
        );

        //new bg set
        root.setBackground(new Background(menuImage));
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }
}