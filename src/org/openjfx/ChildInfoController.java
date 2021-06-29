package org.openjfx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ChildInfoController implements Initializable{
	
	public static String loggeduser = "" ;
	public static String selectedchild = "" ;
	
	public void setCurrentUser(String string) {
		loggeduser = string;
		System.out.println(loggeduser);
    }
	public void setCurrentKid(String string) {
		selectedchild = string;
		System.out.println(selectedchild);
    }
	
	ModelMyChildren mychildobj;
	public void init(ModelMyChildren ob2)
	{
		mychildobj = ob2;
		selectedchild = ob2.getKidname();
		System.out.println(selectedchild);
		System.out.println(loggeduser);
	}
	
	
	@FXML
    private TableView<ModelChildInfo> tableview;

    @FXML
    private TableColumn<ModelChildInfo, String> DoBCol;

    @FXML
    private TableColumn<ModelChildInfo, String> bgroupCol;
    
    @FXML
    private TableColumn<ModelChildInfo, String> hepbCol;

    @FXML
    private TableColumn<ModelChildInfo, String> rvCol;

    @FXML
    private TableColumn<ModelChildInfo, String> dtapCol;

    @FXML
    private TableColumn<ModelChildInfo, String> ipvCol;

    @FXML
    private TableColumn<ModelChildInfo, String> mmrCol;

    @FXML
    private TableColumn<ModelChildInfo, String> varCol;

    @FXML
    private TableColumn<ModelChildInfo, String> hepaCol;

    @FXML
    private TableColumn<ModelChildInfo, String>  bcgCol;

    @FXML
    private TableColumn<ModelChildInfo, String> hpvCol;

    @FXML
    private Label kidnamelabel;

    @FXML
    private JFXButton homebutton;

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
    
    
    
    
    ObservableList<ModelChildInfo> oblist = FXCollections.observableArrayList();
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		kidnamelabel.setText(selectedchild);
		
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null ;
		
		try
		{
			String sql = "SELECT * FROM kids where username = ? and kidname = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, loggeduser);
			ps.setString(2, selectedchild);
			rs = ps.executeQuery();
			
//			System.out.println("Complete Table:\n\n");
			while (rs.next())
			{
				oblist.add(new ModelChildInfo(rs.getString("dateofbirth"), rs.getString("bloodgroup"), 
						rs.getString("hepb"), rs.getString("rv"), rs.getString("dtap"), 
						rs.getString("ipv"), rs.getString("mmr"), rs.getString("var"), rs.getString("hepa"), 
						rs.getString("bcg"), rs.getString("hpv")));
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
		
		DoBCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
		bgroupCol.setCellValueFactory(new PropertyValueFactory<>("bloodgroup"));
		hepbCol.setCellValueFactory(new PropertyValueFactory<>("hepb"));
		rvCol.setCellValueFactory(new PropertyValueFactory<>("rv"));
		dtapCol.setCellValueFactory(new PropertyValueFactory<>("dtap"));
		ipvCol.setCellValueFactory(new PropertyValueFactory<>("ipv"));
		mmrCol.setCellValueFactory(new PropertyValueFactory<>("mmr"));
		varCol.setCellValueFactory(new PropertyValueFactory<>("var"));
		hepaCol.setCellValueFactory(new PropertyValueFactory<>("hepa"));
		bcgCol.setCellValueFactory(new PropertyValueFactory<>("bcg"));
		hpvCol.setCellValueFactory(new PropertyValueFactory<>("hpv"));
		
		
		tableview.setItems(oblist);
		
	}
}
