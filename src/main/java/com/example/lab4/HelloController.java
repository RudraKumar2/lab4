package com.example.lab4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField inputField;

    @FXML
    private ListView<String> listView;

    private ObservableList<String> userList;

    @FXML
    public void initialize() {
        userList = FXCollections.observableArrayList();
        listView.setItems(userList);
    }

    @FXML
    private void handleAddButtonAction() {
        String name = inputField.getText();
        if (isValidName(name)) {
            userList.add(name);
            inputField.clear();
        } else {
            showAlert("Invalid Input", "Name must be at least 5 characters long, start with an uppercase letter, and not be empty.");
        }
    }

    @FXML
    private void handleDeleteButtonAction() {
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            userList.remove(selectedItem);
        } else {
            showAlert("No Selection", "Please select an item to delete.");
        }
    }

    private boolean isValidName(String name) {
        return name.matches("[A-Z][a-zA-Z]{4,}");
    }

    private void showAlert(String title, String message) {
        new Alert(Alert.AlertType.ERROR, message).showAndWait();
    }
}