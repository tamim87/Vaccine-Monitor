package org.openjfx;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class alertBox
{
	public static void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
//        alert.initOwner(owner);
        alert.setTitle(title);
        alert.showAndWait();
    }
}