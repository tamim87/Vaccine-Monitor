module vaccineMONITOR {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.base;
	requires com.jfoenix;
	requires java.sql;
	
//requires javafx.media;
//requires javafx.swing;
//requires javafx.web;

	opens org.openjfx to javafx.fxml;
	exports org.openjfx;
}