package com.mycompany.newbakovetsurgeryv2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * JavaFX App
 */
public class SurgeryInterface extends Application {

    private AnimalsWaiting animalsWaitingForVet;

    private final int WIDTH = 1500;
    private final int HEIGHT = 700;
    // visual components
    private final Label headingLabel = new Label("Book Animal into the Vet");
    private final Label vehicleLabel = new Label("Animal Details");
    private final Label regLabel = new Label("Species");
    private final TextField idField = new TextField();
    private final Label makeLabel = new Label("Breed");
    private final TextField speciesField = new TextField();
    private final Label modelLabel = new Label("Name of the Animal");
    private final TextField animalNameField = new TextField();
    private final Separator sectSeparator = new Separator();
    private final Separator sectSeparator2 = new Separator();
    private final Separator sectSeparator3 = new Separator();
    private final Separator sectSeparator4 = new Separator();
    private final Separator sectSeparator5 = new Separator();
    private final Label ownerLabel = new Label("Owner Details");
    private final Label nameLabel = new Label("Given Name");
    private final TextField nameField = new TextField();
    private final Label surnameLabel = new Label("Last Name ");
    private final TextField surnameField = new TextField();
    private final Label emailLabel = new Label("Email ");
    private final TextField emailField = new TextField();
     private final Label phoneLabel = new Label("phone ");
    private final TextField phoneField = new TextField();
    private final TextArea displayAnimals = new TextArea();
    private final Button addButton = new Button("Book in Animal");
    private final Button clearButton = new Button("Clear");

    @Override
    public void start(Stage stage) {
        //this is the class to contain the bikes. The parameter represents the maximum number of bikes

        animalsWaitingForVet = new AnimalsWaiting(20);
        //create horizontal boxes for the bike and owner details
        HBox animalDetails = new HBox(10);
        HBox ownerDetails = new HBox(10);
        // add components to HBoxes
        animalDetails.getChildren().addAll(regLabel, idField, makeLabel, speciesField, modelLabel, animalNameField);

        ownerDetails.getChildren().addAll(nameLabel, nameField, surnameLabel, surnameField, emailLabel, emailField, phoneLabel,phoneField );

        // create VBox
        VBox root = new VBox(10);
        // add all components to VBox
        root.getChildren().addAll(headingLabel, sectSeparator, vehicleLabel, animalDetails, sectSeparator2,
                ownerLabel, ownerDetails, sectSeparator3, displayAnimals, sectSeparator4, addButton, sectSeparator5, clearButton );
        // create the scene

        // set font of heading
        Font font = new Font("Courier", 40);
        headingLabel.setFont(font);
        font = new Font("Times", 20);
        vehicleLabel.setFont(font);
        ownerLabel.setFont(font);

        // set alignment of HBoxes
        animalDetails.setAlignment(Pos.BASELINE_CENTER);
        ownerDetails.setAlignment(Pos.TOP_CENTER);
        addButton.setAlignment(Pos.CENTER);

        // set alignment and Colour of  VBox 
        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.EMPTY);
        // set minimum and maximum width of components

        displayAnimals.setMaxSize(800, 900);

        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

        //addButton.setOnAction(e -> addHandler());
        // call private methods for button event handlers
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        //var scene = new Scene(new StackPane(label), 640, 480);
        Scene scene = new Scene(root);
        scene.setFill(Color.web("#c6f4b1"));
        stage.setScene(scene);
        stage.setTitle("Bako's Vet Surgery");
        // call private methods for button event handlers
        addButton.setOnAction(e -> addHandler());
        clearButton.setOnAction(e -> clearForm());
        stage.show();
    }
    
    private void clearForm() {
        idField.clear();
        speciesField.clear();
        animalNameField.clear();
        nameField.clear();
        surnameField.clear();  
        displayAnimals.clear();
        emailField.clear();
        phoneField.clear();
    }
    

    private void addHandler() {

        String animalID = idField.getText();
        String Species = speciesField.getText();
        String animalName = animalNameField.getText();
        String givenName = nameField.getText();
        String surname = surnameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        // check for errors
        if (animalID.length() == 0 || Species.length() == 0 || animalName.length() == 0) {
            displayAnimals.setText("You must enter the registration, maake and model of the animal");
        } else if (givenName.length() == 0 || surname.length() == 0) {
            displayAnimals.setText("You must enter both your given name and surname");
        } else // ok to add a Tenant
        {
            Animal animalToAdd = new Animal(animalID, Species, animalName, givenName, surname,email, phone);
            animalsWaitingForVet.addAnimal(animalToAdd);
            //clear the fields
            idField.setText("");
            speciesField.setText("");
            animalNameField.setText("");
            nameField.setText("");
            surnameField.setText("");
            displayAnimals.setText("");
            displayAnimals.appendText(animalID + " successfully added");
            displayAnimals.appendText("\n\nThe animal awaiting to see the Vet ");
            displayAnimals.appendText(animalsWaitingForVet.displayTheAnimals());
        }

    }

    public static void main(String[] args) {
        launch();
    }

}
