package org.openjfx;

import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VaccinesController {

    @FXML
    private JFXButton hepbbutton;

    @FXML
    private JFXButton rvbutton;

    @FXML
    private JFXButton dtapbutton;

    @FXML
    private JFXButton ipvbutton;

    @FXML
    private JFXButton mmrbutton;

    @FXML
    private JFXButton varbutton;

    @FXML
    private JFXButton hepabutton;

    @FXML
    private JFXButton bcgbutton;

    @FXML
    private JFXButton hpvbutton;
    
    @FXML
    private JFXButton homebutton; 
    
    
    String loggeduser = "";
	public void setCurrentUser(String string) {
		loggeduser= string;
    }
    
    @FXML
    void homebuttonpushed(ActionEvent event) throws IOException
    {
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
    void bcgpushed(ActionEvent event) 
    {
    	 load("BCG.fxml", "BCG");
    }

    @FXML
    void dtappushed(ActionEvent event)
    {
    	load("DTap.fxml", "DTap");
    }

    @FXML
    void hepapushed(ActionEvent event) 
    {
    	load("HepA.fxml", "HepA");
    }

    @FXML
    void hepbpushed(ActionEvent event) 
    {
    	load("HepB.fxml", "HepB");
    }

    @FXML
    void hpvpushed(ActionEvent event)
    {
    	load("HPV.fxml", "HPV");
    }

    @FXML
    void ipvpushed(ActionEvent event)
    {
    	load("IPV.fxml", "IPV");
    }

    @FXML
    void mmrpushed(ActionEvent event) 
    {
    	load("MMR.fxml", "MMR");
    }

    @FXML
    void rvpushed(ActionEvent event) 
    {
    	load("RV.fxml", "RV");
    }

    @FXML
    void varpushed(ActionEvent event) 
    {
    	load("VAR.fxml", "VAR");
    }

    
    void load(String location, String title)
    {
    	URL url = getClass().getResource(location);
        if (url == null)
        {
            System.out.println("Can't load location file");
            Platform.exit();
        }
        Parent root = null;
		try {
			root = FXMLLoader.load(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Scene scene = new Scene(root);
		Stage secondarystage = new Stage();
		
//        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        secondarystage.setTitle(title);
        secondarystage.setScene(scene);
        secondarystage.show();
    }
}
