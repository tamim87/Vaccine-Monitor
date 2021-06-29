package org.openjfx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyChildrenController implements Initializable{
	
	
	public static String loggeduser = "" ;
	public void setCurrentUser(String string) {
		loggeduser= string;
		System.out.println(loggeduser);
    }
	
    @FXML
    private JFXButton checkinfobutton;

    @FXML
    private TableView<ModelMyChildren> tableview;
    
    @FXML
    private TableColumn<ModelMyChildren, String> kidNameCol;

    @FXML
    private TableColumn<ModelMyChildren, String> dobCol;

    @FXML
    private TableColumn<ModelMyChildren, String> bloodGroupCol;

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
    
    
    @FXML
    void checkinfopushed(ActionEvent event) throws IOException {
    	
    	URL url = getClass().getResource("ChildInfo.fxml");
        if (url == null)
        {
            System.out.println("Can't load ChildInfo.fxml file");
            Platform.exit();
        }
        FXMLLoader loader = new FXMLLoader();
        
        ChildInfoController cController = new ChildInfoController();
        ModelMyChildren ob = tableview.getSelectionModel().getSelectedItem() ;
        
        cController.setCurrentUser(loggeduser);
//        cController.setCurrentKid(ob.getKidname());
        cController.init(ob);
        
        loader.setLocation(url);
//        loader.setController(McController);
        System.out.println("see");
        Parent root = loader.load();
//      
//        loader.setStaticLoad(true);
        
        Scene scene = new Scene(root);
        
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setTitle("Child Info");
        window.setScene(scene);
        
        window.sizeToScene();
        window.setResizable(true);
        window.show();
    }
    
    ObservableList<ModelMyChildren> oblist = FXCollections.observableArrayList();
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
//		System.out.println(loggeduser + " danke ");
		
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null ;
		
		try
		{
			String sql = "SELECT * FROM kids where username = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, loggeduser);
			rs = ps.executeQuery();
			
//			System.out.println("Complete Table:\n\n");
			while (rs.next())
			{
				oblist.add(new ModelMyChildren(rs.getString("kidname"), rs.getString("dateofbirth"), rs.getString("bloodgroup")));
			}
		}
		catch (SQLException e) 
		{
			System.out.println(e.toString());
//			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) 
			{
				System.out.println(e.toString());
//				e.printStackTrace();
			}
		}
		
		
		kidNameCol.setCellValueFactory(new PropertyValueFactory<>("kidname"));
		dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
		bloodGroupCol.setCellValueFactory(new PropertyValueFactory<>("bloodgroup"));
		
		tableview.setItems(oblist);
	}

}
