package org.openjfx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class Signupcontroller implements Initializable 
{
	@FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField repeatpassword;

    @FXML
    private TextField phone;

    @FXML
    private JFXButton signupbutton;

    @FXML
    private JFXButton loginbutton;
    
//    DatabaseHandler handler ;

    @FXML
    void loadloginpage(ActionEvent event) throws IOException
    {
    	URL url = getClass().getResource("Login.fxml");
        if (url == null)
        {
            System.out.println("Can't load Login.fxml file");
            Platform.exit();
        }
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setTitle("Login");
        window.setScene(scene);
        window.show();

//      scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//        window.setMinHeight(560);
//  		window.setMinWidth(780);
    }

    @FXML
    public void signupbuttonpushed(ActionEvent event) throws IOException
    {
        if(checkValues())
        {
        	String uusr = (username.getText());
            String uemail = (email.getText());
            String uphone = (phone.getText());
            String upass =  (password.getText());
            String urepeatpass =  (repeatpassword.getText());
            
            if(!upass.equals(urepeatpass.strip() ) )
            {
            	Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Passwords do not match");
                alert.showAndWait();
                return;
            }
            if( usrExist(uusr, uemail, uphone))
            {
            	//usrexist returns true if username, email and phone are unique
            	//continues if username, email and phone are unique
            }
            else
            {
            	return;
            }
            
            Connection con = DbConnection.connect();
            PreparedStatement ps = null ;
            try {
				String sql = "INSERT INTO users(username, email, phone, password) VALUES(?,?,?,?) ";
				ps = con.prepareStatement(sql);
				ps.setString(1, uusr);
				ps.setString(2,uemail);
				ps.setString(3, uphone);
				ps.setString(4, upass);
				ps.execute();
				System.out.println("Data has been inserted");
				
				URL url = getClass().getResource("Dashboard.fxml");
                if (url == null)
                {
                    System.out.println("Can't load Dashboard.fxml file");
                    Platform.exit();
                }
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                Parent root = loader.load();
                
                DashboardController dashboardcontroller = loader.getController();
                
                
//                final FXMLLoader loader = new FXMLLoader();
////                loader.setStaticLoad(true);
//                Parent root = loader.load(url);
//                DashboardController dashboardcontroller = (DashboardController)loader.getController();
                dashboardcontroller.setCurrentUser(username.getText());
                
                
                
                Scene scene = new Scene(root);
                Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Home");
                window.setScene(scene);
                dashboardcontroller.welcome();;
                
                window.sizeToScene();
                window.setResizable(true);
                window.show();
				
			} catch (SQLException e) {
				System.out.println(e.toString());
//				e.printStackTrace();
			}
            
            try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
//            try{
//                
//                }
////                employee.getContact().add(this.contact.getText());
//                String[] contArray = this.contact.getText().split(";");
////                employee.getContact().addAll(Arrays.asList(contArray));
//                for (String s : contArray) {
//                    employee.setContact(s);
//                    System.out.println(s);
//                }
//                employee.setEmp_role(this.combobox.getEditor().getText().strip());
////                Date date = new Date("");
//                String date = this.datePicker.getEditor().getText().strip();
//                
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
        if(username.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty() || password.getText().isEmpty() || repeatpassword.getText().isEmpty() )
        {
            flag = false;
        }
        return flag;
    }
    
    public boolean usrExist(String uname, String email, String phone)
    {
    	Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null ;
		
		try
		{
//			String sql = "Select * from users where username = ? and email = ? and phone = ? ";
//			ps = con.prepareStatement(sql);
//			ps.setString(1, uname);
//			ps.setString(2, email);
//			ps.setString(3, phone);
//			
//			rs = ps.executeQuery();
			
			boolean flag = true;
			
			
			String sql = "Select username from users where username = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			rs = ps.executeQuery();
			if(rs.next())
			{
//				String dbuname = rs.getString(1);
				Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Error");
	            alert.setHeaderText(null);
	            alert.setContentText("Username already taken");
	            alert.showAndWait();
	            return false;
			}
			
			
			String sql2 = "Select email from users where email = ? ";
			ps = con.prepareStatement(sql2);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next())
			{
				Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Error");
	            alert.setHeaderText(null);
	            alert.setContentText("Use another email");
	            alert.showAndWait();
	            return false;
			}
			
			String sql3 = "Select phone from users where phone = ? ";
			ps = con.prepareStatement(sql3);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if(rs.next())
			{
				Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Error");
	            alert.setHeaderText(null);
	            alert.setContentText("Use another phone number");
	            alert.showAndWait();
	            return false;
			}
			
			return flag;
			
//			if(rs.next())
//			{
//				String dbuname = rs.getString("username");
//				String dbuemail = rs.getString("email");
//				String dbuphone = rs.getString("phone");
//				if(dbuname.equals(uname))
//				{
//					Alert alert = new Alert(Alert.AlertType.WARNING);
//		            alert.setTitle("Error");
//		            alert.setHeaderText(null);
//		            alert.setContentText("Username already taken");
//		            alert.showAndWait();
//				}
//				if(dbuemail.equals(email))
//				{
//					Alert alert = new Alert(Alert.AlertType.WARNING);
//		            alert.setTitle("Error");
//		            alert.setHeaderText(null);
//		            alert.setContentText("Use another email");
//		            alert.showAndWait();
//				}
//				if(dbuphone.equals(phone))
//				{
//					Alert alert = new Alert(Alert.AlertType.WARNING);
//		            alert.setTitle("Error");
//		            alert.setHeaderText(null);
//		            alert.setContentText("Use another phone number");
//		            alert.showAndWait();
//				}
//				return false;
//			}
//			else
//			{
//				return true;
//			}
			
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

//    public boolean checkValues()
//    {
//        boolean flag = true;
//        if(username.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty() || password.getText().isEmpty() || repeatpassword.getText().isEmpty() )
//        {
//            flag = false;
//        }
//        return flag;
//        if(combobox.getEditor().getText().isEmpty()){
//            jobLabel.setText("*Required");
//            jobLabel.setTextFill(Color.RED);
//            flag = false;
//        }
//        else
//        {
//            jobLabel.setText("");
//        }
//        if(datePicker.getEditor().getText().isEmpty()) 
//        {
//            userLabel.setText("*Required");
//            userLabel.setTextFill(Color.RED);
//            flag = false;
//        }
//    }
    
//    public void toLoginPage(ActionEvent e) {
//        try{
//            Stage primaryStage = (Stage) (((Node) e.getSource()).getScene().getWindow());
//            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
////            primaryStage.setTitle("Hello ");
//            primaryStage.setScene(new Scene(root, 750, 600));
//            primaryStage.show();
//        }catch (IOException exception){
//            System.out.println("Exception: (toLoginPage)" + exception);
//        }
//    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
//		handler = DatabaseHandler.getInstance();
		
	}
}
