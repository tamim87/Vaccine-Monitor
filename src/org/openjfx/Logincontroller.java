package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Logincontroller implements Initializable 
{
	@FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button signupbutton;

    @FXML
    private Button loginbutton;

//    @FXML
//    private ComboBox<String> combobox;
    
    Label curUser;

    public void setCurrentUser(String string) {
        curUser.setText(string);
    }
    
    @FXML
    void loadsignuppage(ActionEvent event) throws IOException
    {
    	URL url = getClass().getResource("Signup.fxml");
        if (url == null)
        {
            System.out.println("Can't load Signup.fxml file");
            Platform.exit();
        }
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setTitle("Signup");
        window.setScene(scene);
  		window.show();
//  		ReadDb.readtable();
//  		ReadDb.readspecificrow();
//  		ReadDb.getTotalNumberofUsers();
//        window.setMinHeight(560);
//        window.setMinWidth(780);
    }

    @FXML
    void loginbuttonpushed(ActionEvent event) throws IOException
    {
    	if(checkValues())
        {
        	String uusr = (username.getText());
            String upass = (password.getText());

            if( usrExist(uusr, upass))
            {
            	if(uusr.equals("admin"))
            	{
            		URL url = getClass().getResource("AdminPage.fxml");
                    if (url == null)
                    {
                        System.out.println("Can't load AdminPage.fxml file");
                        Platform.exit();
                    }
                    
                    FXMLLoader loader = new FXMLLoader(url);
                    Parent root = loader.load();
                    
                    AdminPageController adcontroller = loader.getController();
                    
                    
//                    final FXMLLoader loader = new FXMLLoader();
////                    loader.setStaticLoad(true);
//                    Parent root = loader.load(url);
//                    DashboardController dashboardcontroller = (DashboardController)loader.getController();
//                    adcontroller.setCurrentUser(username.getText());
                    
                    Scene scene = new Scene(root);
                    Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Home");
                    window.setScene(scene);
//                    adcontroller.welcome();
                    
                    window.sizeToScene();
                    window.setResizable(true);
                    window.show();
            	}
            	
            	else
            	{
            	
            	
                	URL url = getClass().getResource("Dashboard.fxml");
                    if (url == null)
                    {
                        System.out.println("Can't load Dashboard.fxml file");
                        Platform.exit();
                    }
                    
                    FXMLLoader loader = new FXMLLoader(url);
                    Parent root = loader.load();
                    
                    DashboardController dashboardcontroller = loader.getController();
                    
                    
//                    final FXMLLoader loader = new FXMLLoader();
////                    loader.setStaticLoad(true);
//                    Parent root = loader.load(url);
//                    DashboardController dashboardcontroller = (DashboardController)loader.getController();
                    dashboardcontroller.setCurrentUser(username.getText());
                    
                    Scene scene = new Scene(root);
                    Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Home");
                    window.setScene(scene);
                    dashboardcontroller.welcome();;
                    
                    window.sizeToScene();
                    window.setResizable(true);
                    window.show();
            	}
            }
            else
            {
            	Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Usename or Password");
                alert.showAndWait();
                return;
            }
        }
        else 
        {
        	Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please complete all the fields");
            alert.showAndWait();
        }
    }
    
    
    public boolean checkValues()
    {
        boolean flag = true;
        if(username.getText().isEmpty() || password.getText().isEmpty() )
        {
            flag = false;
        }
        return flag;
    }
    
    public boolean usrExist(String uname, String pass)
    {
    	Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null ;
		
		try
		{
			String sql = "Select * from users where username = ? and password = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch (SQLException e) 
		{
			System.out.println(e.toString());
//			e.printStackTrace();
			return false;
		}
		finally 
		{
			try 
			{
				rs.close();
				ps.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				System.out.println(e.toString());
//				e.printStackTrace();
			}
		}
    }
    
//    
//    @FXML
//    void comboboxpushed(ActionEvent event)
//    {
//    	String s = combobox.getSelectionModel().getSelectedItem().toString();
//    	
//    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
//		ObservableList<String> list = FXCollections.observableArrayList("Admin","User");
//		combobox.setItems(list);
//		combobox.setValue("User");	
		
	}
}
