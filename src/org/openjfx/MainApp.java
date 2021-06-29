package org.openjfx;

import java.net.URL;
import javafx.scene.Parent;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
//        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
//        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        URL url = getClass().getResource("Login.fxml");
        if (url == null)
        {
            System.out.println("Can't load Login.FXML file");
            Platform.exit();
        }
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
//        Scene scene = new Scene(root,800,600);
        

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(true);
//        stage.setMaximized(false);
        stage.show();
//        DatabaseHandler db ;
        

//      stage.setMinHeight(560);
//      stage.setMinWidth(780);
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}