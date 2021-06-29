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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminPageController implements Initializable {
	
	static String name = "" ; 
	
	@FXML
    private TableView<ModelAdminPage> tableview;
	
    @FXML
    private TableColumn<ModelAdminPage, String> parentNameCol;

    @FXML
    private TableColumn<ModelAdminPage, String> kidNameCol;

    @FXML
    private TableColumn<ModelAdminPage, String> vaccineNameCol;

    @FXML
    private TableColumn<ModelAdminPage, String> doBCol;

    @FXML
    private JFXButton refreshbutton;

    @FXML
    private JFXButton confirmbutton;

    @FXML
    private JFXButton homebutton;

    @FXML
    void confirmbuttonpushed(ActionEvent event) {


//		Connection con = DbConnection.connect();
//		PreparedStatement ps = null;
//		ResultSet rs = null ;
//		
//		try
//		{
//			String sql = "SELECT * FROM kids ";
//			ps = con.prepareStatement(sql);
//			
//			rs = ps.executeQuery();
//			
////			System.out.println("Complete Table:\n\n");
//			
//			final ResultSetMetaData rsmd = rs.getMetaData();
//			final int columnCount = rsmd.getColumnCount();
//			while (rs.next())
//			{
//				
//				String uname = rs.getString("username");
//				String kname = rs.getString("kidname");
//				String dob = rs.getString("dateofbirth");
//
//				  System.out.print("uname "+uname);
//				  System.out.print(" kidname "+kname);
//				  System.out.print(" dateofbirth "+dob);
//				  System.out.println("\n\n\n");
//				
//				for (int i = 1; i <= columnCount; i++ )
//				{
//					  name = rsmd.getColumnName(i);
//					  System.out.print("colname "+name);
//					  String colval = rs.getString(name) ;
//
//					  System.out.println("\tcolval "+colval);
//					  String kk = "No";
//					  if(colval.equals(kk))
//					  {
//						  oblist.add(new ModelAdminPage( rs.getString("username"), rs.getString("kidname"), rs.getString(rsmd.getColumnName(i)), rs.getString("dateofbirth") ));
//						  System.out.println("Username: "+rs.getString("username")+"   Kidname: "+ rs.getString("kidname")+"    Vaccinename: "+ rs.getString(rsmd.getColumnName(i))+"     DOb: "+rs.getString("dateofbirth"));
//					  }
//					  System.out.println();
//					  // Do stuff with name
//				}
//			}
//		}
//		catch (SQLException e) 
//		{
//			System.out.println(e.toString());
////			e.printStackTrace();
//		}
//		finally 
//		{
//			try 
//			{
//				rs.close();
//				ps.close();
//				con.close();
//			} catch (SQLException e) 
//			{
//				System.out.println(e.toString());
////				e.printStackTrace();
//			}
//		}
//		parentNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
//		kidNameCol.setCellValueFactory(new PropertyValueFactory<>("kidname"));
//		vaccineNameCol.setCellValueFactory(new PropertyValueFactory<>("vaccinename"));
//		doBCol.setCellValueFactory(new PropertyValueFactory<>("dateofbirth"));
//		
//		tableview.setItems(oblist);
    	
    }

    @FXML
    void homebuttonpushed(ActionEvent event) throws IOException {

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

    @FXML
    void refreshbuttonpushed(ActionEvent event) {
    	

//		Connection con = DbConnection.connect();
//		PreparedStatement ps = null;
//		ResultSet rs = null ;
//		
//		try
//		{
//			String sql = "SELECT * FROM kids ";
//			ps = con.prepareStatement(sql);
//			
//			rs = ps.executeQuery();
//			
////			System.out.println("Complete Table:\n\n");
//			
//			final ResultSetMetaData rsmd = rs.getMetaData();
//			final int columnCount = rsmd.getColumnCount();
//			while (rs.next())
//			{
//				
//				String uname = rs.getString("username");
//				String kname = rs.getString("kidname");
//				String dob = rs.getString("dateofbirth");
//
//				  System.out.print("uname "+uname);
//				  System.out.print(" kidname "+kname);
//				  System.out.print(" dateofbirth "+dob);
//				  System.out.println("\n\n\n");
//				
//				for (int i = 1; i <= columnCount; i++ )
//				{
//					  name = rsmd.getColumnName(i);
//					  System.out.print("colname "+name);
//					  String colval = rs.getString(name) ;
//
//					  System.out.println("\tcolval "+colval);
//					  String kk = "No";
//					  if(colval.equals(kk))
//					  {
//						  oblist.add(new ModelAdminPage( rs.getString("username"), rs.getString("kidname"), rs.getString(rsmd.getColumnName(i)), rs.getString("dateofbirth") ));
//						  System.out.println("Username: "+rs.getString("username")+"   Kidname: "+ rs.getString("kidname")+"    Vaccinename: "+ rs.getString(rsmd.getColumnName(i))+"     DOb: "+rs.getString("dateofbirth"));
//					  }
//					  System.out.println();
//					  // Do stuff with name
//				}
//			}
//		}
//		catch (SQLException e) 
//		{
//			System.out.println(e.toString());
////			e.printStackTrace();
//		}
//		finally 
//		{
//			try 
//			{
//				rs.close();
//				ps.close();
//				con.close();
//			} catch (SQLException e) 
//			{
//				System.out.println(e.toString());
////				e.printStackTrace();
//			}
//		}
//		parentNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
//		kidNameCol.setCellValueFactory(new PropertyValueFactory<>("kidname"));
//		vaccineNameCol.setCellValueFactory(new PropertyValueFactory<>("vaccinename"));
//		doBCol.setCellValueFactory(new PropertyValueFactory<>("dateofbirth"));
//		
//		tableview.setItems(oblist);

    }

    ObservableList<ModelAdminPage> oblist = FXCollections.observableArrayList();

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
//		Connection con = DbConnection.connect();
//		PreparedStatement ps = null;
//		ResultSet rs = null ;
//		
//		try
//		{
//			String sql = "SELECT * FROM kids ";
//			ps = con.prepareStatement(sql);
//			
//			rs = ps.executeQuery();
//			
////			System.out.println("Complete Table:\n\n");
//			
//			final ResultSetMetaData rsmd = rs.getMetaData();
//			final int columnCount = rsmd.getColumnCount();
//			while (rs.next())
//			{
//				
//				String uname = rs.getString("username");
//				String kname = rs.getString("kidname");
//				String dob = rs.getString("dateofbirth");
//
//				  System.out.print("uname "+uname);
//				  System.out.print(" kidname "+kname);
//				  System.out.print(" dateofbirth "+dob);
//				  System.out.println("\n\n\n");
//				
//				for (int i = 1; i <= columnCount; i++ )
//				{
//					  name = rsmd.getColumnName(i);
//					  System.out.print("colname "+name);
//					  String colval = rs.getString(name) ;
//
//					  System.out.println("\tcolval "+colval);
//					  String kk = "No";
//					  if(colval.equals(kk))
//					  {
//						  oblist.add(new ModelAdminPage( rs.getString("username"), rs.getString("kidname"), rs.getString(rsmd.getColumnName(i)), rs.getString("dateofbirth") ));
//						  System.out.println("Username: "+rs.getString("username")+"   Kidname: "+ rs.getString("kidname")+"    Vaccinename: "+ rs.getString(rsmd.getColumnName(i))+"     DOb: "+rs.getString("dateofbirth"));
//					  }
//					  System.out.println();
//					  // Do stuff with name
//				}
//			}
//		}
//		catch (SQLException e) 
//		{
//			System.out.println(e.toString());
////			e.printStackTrace();
//		}
//		finally 
//		{
//			try 
//			{
//				rs.close();
//				ps.close();
//				con.close();
//			} catch (SQLException e) 
//			{
//				System.out.println(e.toString());
////				e.printStackTrace();
//			}
//		}
//		parentNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
//		kidNameCol.setCellValueFactory(new PropertyValueFactory<>("kidname"));
//		vaccineNameCol.setCellValueFactory(new PropertyValueFactory<>("vaccinename"));
//		doBCol.setCellValueFactory(new PropertyValueFactory<>("dateofbirth"));
//		
//		tableview.setItems(oblist);
	}
}
