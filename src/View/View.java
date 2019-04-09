package View;


import application.Database;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import users.uctovnik;
import users.user;

public class View extends Application implements Runnable {
	public static uctovnik LOGGED = null;
	public static uctovnik u = new uctovnik();
	public static user current;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Database();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Resources/login.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("/Resources/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void run() {
		new Thread(new View(), "thread");
	}
}
