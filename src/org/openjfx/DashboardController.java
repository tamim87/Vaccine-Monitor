package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class DashboardController implements Initializable {
	
//	@FXML
//	Label curUsr;
	
	public static String loggeduser = "" ;
	public void setCurrentUser(String string) {
		loggeduser = string;
    }
    
    public void welcome()
    {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Welcome");
        alert.setHeaderText(null);
        alert.setContentText("Welcome " + loggeduser);
        alert.showAndWait();
    }
    
    

    @FXML
    private JFXButton mykidsbutton;

    @FXML
    private JFXButton vaccinesbutton;

    @FXML
    private JFXButton addchildbutton;

    @FXML
    private JFXButton schedulesbutton;

    @FXML
    private JFXButton logoutbutton;
    
	@FXML
	public void mykidsbuttonpushed(ActionEvent event) throws IOException {
		//passes parent username to fetch child number and info from users table
		
		URL url = getClass().getResource("MyChildren.fxml");
        if (url == null)
        {
            System.out.println("Can't load MyChildren.fxml file");
            Platform.exit();
        }
        FXMLLoader loader = new FXMLLoader();
        
        MyChildrenController McController = new MyChildrenController();
        McController.setCurrentUser(loggeduser);
        loader.setLocation(url);
//        loader.setController(McController);
        System.out.println("see");
        Parent root = loader.load();
//      
//        loader.setStaticLoad(true);
        
        
        
//        Pane root = loader.load(url);
//        MyChildrenController McController = (MyChildrenController)loader.getController();
//        McController.setCurrentUser(loggeduser);
//        System.out.println(curUsr);
        
        Scene scene = new Scene(root);
        
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setTitle("My Children");
        window.setScene(scene);
        
        window.sizeToScene();
        window.setResizable(true);
        window.show();
		
		
	}

	@FXML
	public void vaccinesbuttonpushed(ActionEvent event) throws IOException {
		URL url = getClass().getResource("Vaccines.fxml");
        if (url == null)
        {
            System.out.println("Can't load Vaccines.fxml file");
            Platform.exit();
        }
        final FXMLLoader loader = new FXMLLoader();
//        loader.setStaticLoad(true);
        Pane root = loader.load(url);
//        VaccinesController vaccinescontroller = (VaccinesController)loader.getController();
//        vaccinescontroller.setCurrentUser(curUsr);
//        System.out.println(curUsr);
        
        Scene scene = new Scene(root);
        
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setTitle("Available Vaccines");
        window.setScene(scene);
        
        window.sizeToScene();
        window.setResizable(true);
        window.show();

//      scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//        window.setMinHeight(560);
//  		window.setMinWidth(780);
        System.out.println(loggeduser);
	}
	

	@FXML
	public void addchildbuttonpushed(ActionEvent event) throws IOException 
	{
		URL url = getClass().getResource("AddKid.fxml");
        if (url == null)
        {
            System.out.println("Can't load AddKid.fxml file");
            Platform.exit();
        }
        FXMLLoader loader = new FXMLLoader();
        
        AddKidController acController = new AddKidController();
        acController.setCurrentUser(loggeduser);
        loader.setLocation(url);
//        loader.setController(McController);
        System.out.println("see");
        Parent root = loader.load();
//      
//        loader.setStaticLoad(true);
        
        
        
//        Pane root = loader.load(url);
//        MyChildrenController McController = (MyChildrenController)loader.getController();
//        McController.setCurrentUser(loggeduser);
//        System.out.println(curUsr);
        
        Scene scene = new Scene(root);
        
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setTitle("Add Kid");
        window.setScene(scene);
        
        window.sizeToScene();
        window.setResizable(true);
        window.show();
	}
	

	@FXML
	public void schedulesbuttonpushed(ActionEvent event) throws IOException {
		
		URL url = getClass().getResource("Schedules.fxml");
        if (url == null)
        {
            System.out.println("Can't load Schedules.fxml file");
            Platform.exit();
        }
    	Stage primarystage = new Stage();
        final FXMLLoader loader = new FXMLLoader();
//        loader.setStaticLoad(true);
        Parent root = loader.load(url);
        Logincontroller dashboardcontroller = (Logincontroller)loader.getController();
        
        Scene scene = new Scene(root);
        
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setTitle("Schedules");
        window.setScene(scene);
        
        window.sizeToScene();
        window.setResizable(true);
        window.show();
		
		
	}
	

	@FXML
	public void logoutbuttonpushed(ActionEvent event) throws IOException {
		URL url = getClass().getResource("Login.fxml");
        if (url == null)
        {
            System.out.println("Can't load Login.fxml file");
            Platform.exit();
        }
    	Stage primarystage = new Stage();
        final FXMLLoader loader = new FXMLLoader();
//        loader.setStaticLoad(true);
        Parent root = loader.load(url);
        Logincontroller dashboardcontroller = (Logincontroller)loader.getController();
        
        Scene scene = new Scene(root);
        
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setTitle("Login");
        window.setScene(scene);
        
        window.sizeToScene();
        window.setResizable(true);
        window.show();

//      scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//        window.setMinHeight(560);
//  		window.setMinWidth(780);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
