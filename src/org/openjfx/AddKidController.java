package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import com.jfoenix.controls.JFXButton;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import com.jfoenix.controls.JFXCheckBox;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;

public class AddKidController {
	
	public static String loggeduser = "" ;
	public void setCurrentUser(String string) {
		loggeduser = string;
    }
	
	@FXML
	private JFXCheckBox hepb;
	@FXML
	private JFXCheckBox rv;
	@FXML
	private JFXCheckBox dtap;
	@FXML
	private JFXCheckBox iv;
	@FXML
	private JFXCheckBox mmr;
	@FXML
	private JFXCheckBox var;
	@FXML
	private JFXCheckBox hepa;
	@FXML
	private JFXCheckBox bcg;
	@FXML
	private JFXCheckBox hpv;
	@FXML
	private TextField kidname;
	@FXML
	private DatePicker dateofbirth;
	@FXML
	private TextField bloodgroup;
	@FXML
	private JFXButton submitbtn;
	
	@FXML
    void homebuttonpushed(ActionEvent event) throws IOException 
    {
    	URL url = getClass().getResource("Dashboard.fxml");
        if (url == null)
        {
            System.out.println("Can't load Dashboard.fxml file");
            Platform.exit();
        }
        FXMLLoader loader = new FXMLLoader();
        
        DashboardController dController = new DashboardController();
//        ModelMyChildren ob = tableview.getSelectionModel().getSelectedItem() ;
        
        dController.setCurrentUser(loggeduser);
        
        loader.setLocation(url);
        System.out.println("see");
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setTitle("Home");
        window.setScene(scene);
        
        window.sizeToScene();
        window.setResizable(true);
        window.show();
    }
	
	
	
	
	static String Hepb = "No";
	static String Rv   = "No";
	static String Dtap = "No";
	static String Ipv  = "No";
	static String Mmr  = "No";
	static String Var  = "No";
	static String Hepa = "No";
	static String Bcg  = "No";
	static String Hpv  = "No";
	
	
	@FXML
	public void hepbchecked(ActionEvent event) {
		// TODO Autogenerated
		boolean fl = hepb.isSelected();
//		String Hepb = "0" ;
		if(fl) Hepb = "Yes" ;
	}
	@FXML
	public void rvchecked(ActionEvent event) {
		// TODO Autogenerated
		boolean fl = rv.isSelected();
//		String Rv = "0" ;
		if(fl) Rv = "Yes" ;
	}
	@FXML
	public void dtapchecked(ActionEvent event) {
		// TODO Autogenerated
		boolean fl = dtap.isSelected();
//		String Dtap = "0" ;
		if(fl) Dtap = "Yes" ;
	}
	@FXML
	public void ivchecked(ActionEvent event) {
		// TODO Autogenerated
		boolean fl = iv.isSelected();
//		String Ipv = "0" ;
		if(fl) Ipv = "Yes" ;
	}
	@FXML
	public void mmrchecked(ActionEvent event) {
		// TODO Autogenerated
		boolean fl = mmr.isSelected();
//		String Mmr = "0" ;
		if(fl) Mmr = "Yes" ;
	}
	@FXML
	public void varchecked(ActionEvent event) {
		// TODO Autogenerated
		boolean fl = var.isSelected();
//		String Var = "0" ;
		if(fl) Var = "Yes" ;
	}
	@FXML
	public void hepachecked(ActionEvent event) {
		// TODO Autogenerated
		boolean fl = hepa.isSelected();
//		String Hepa = "0" ;
		if(fl) Hepa = "Yes" ;
	}
	@FXML
	public void bcgchecked(ActionEvent event) {
		// TODO Autogenerated
		boolean fl = bcg.isSelected();
//		String Bcg = "0" ;
		if(fl) Bcg = "Yes" ;
	}
	@FXML
	public void hpvchecked(ActionEvent event) {
		// TODO Autogenerated
		boolean fl = hpv.isSelected();
//		String Hpv = "0" ;
		if(fl) Hpv = "Yes" ;
	}
	
	
	@FXML
	public void submitbuttonpushed(ActionEvent event) throws IOException {
		//first push kid data into kids table along with parent username
		//then redirect user to homepage
		
		
		Connection con = DbConnection.connect();
        PreparedStatement ps = null ;
        try {
        	String sql = "INSERT INTO kids(username, kidname, dateofbirth, bloodgroup, hepb, rv, dtap, ipv, mmr, var, hepa, bcg, hpv) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, loggeduser);
			ps.setString(2, kidname.getText());
			ps.setString(3, ((TextField)dateofbirth.getEditor()).getText());
			ps.setString(4, bloodgroup.getText());
			
			ps.setString(5, Hepb);
			ps.setString(6, Rv);
			ps.setString(7, Dtap);
			ps.setString(8, Ipv);
			ps.setString(9, Mmr);
			ps.setString(10, Var);
			ps.setString(11, Hepa);
			ps.setString(12, Bcg);
			ps.setString(13, Hpv);
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
            
            
//            final FXMLLoader loader = new FXMLLoader();
////            loader.setStaticLoad(true);
//            Parent root = loader.load(url);
//            DashboardController dashboardcontroller = (DashboardController)loader.getController();
            dashboardcontroller.setCurrentUser(loggeduser);
            
            
            
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
//			e.printStackTrace();
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		URL url = getClass().getResource("Dashboard.fxml");
        if (url == null)
        {
            System.out.println("Can't load Dashboard.fxml file");
            Platform.exit();
        }
//    	Stage primarystage = new Stage();
        final FXMLLoader loader = new FXMLLoader();
//        loader.setStaticLoad(true);
        Parent root = loader.load(url);
        DashboardController dashboardcontroller = (DashboardController)loader.getController();
        
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Home");
        window.setScene(scene);
        
        window.sizeToScene();
        window.setResizable(true);
        window.show();
		
		
	}
}
