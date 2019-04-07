package application;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class Controller implements Initializable {
	
	
	
//----------------------------------------login
	@FXML
	private TextField username;
	
	@FXML
	private TextField passwd;
	
	@FXML
	private Text wrong;
	
	
//----------------------------------------main
	
	@FXML
	private TextField key;
	
	@FXML
	private TextArea vypis;
	
	@FXML
	private TilePane found;
	
	@FXML
	private Text llog;
	
	private static Text llogi;
	
//----------------------------------------profile

	@FXML
	private Text nameprof;
	
	@FXML
	private Text yoprof;

	@FXML
	private Text genderprof;

	@FXML
	private Text adressprof;

	@FXML
	private Text pscprof;

	@FXML
	private Text icoprof;

	@FXML
	private Text dicprof;

	@FXML
	private CheckBox platcadphprof; 
	
	private static Text namei;
	private static Text yoi;
	private static Text genderi;
	private static Text adressi;
	private static Text psci;
	private static Text icoi;
	private static Text dici;
	private static CheckBox platcadphi;
	static Alert delete = new Alert(AlertType.CONFIRMATION);
	
//----------------------------------------addUser
	
	@FXML
	private TextField menoadd;
	
	@FXML
	private TextField vekadd;
	
	@FXML
	private TextField adressaadd;
	
	@FXML
	private TextField pscadd;
	
	@FXML
	private TextField mestoadd;
	
	@FXML
	private TextField icoadd;
	
	@FXML
	private TextField dicadd;
	
	@FXML
	private CheckBox platcaadd;
	
	@FXML
	private CheckBox pravnickaadd;
	
	private static TextField menoaddi;
	private static TextField vekaddi;
	private static TextField adressaaddi;
	private static TextField pscaddi;
	private static TextField mestoaddi;
	private static TextField icoaddi;
	private static TextField dicaddi;
	private static CheckBox platcaaddi;
	private static CheckBox pravnickaaddi;
	static Alert add = new Alert(AlertType.CONFIRMATION);
	
	
//----------------------------------------other
	
	
	
	
	
	
	
	
	@FXML
	public void login(ActionEvent event) throws IOException {
		
		String u = username.getText();
		String p = passwd.getText();
		
		if(u.equals(View.u.getUsername()) && p.equals(View.u.getPasswd())) {
			View.LOGGED = View.u;
			changeScene("main.fxml", event);
			llogi.setText(View.LOGGED.getMeno());
			
			System.out.println("Uspesne prihlaseny");
		}
		else {
			System.out.println("Zle prihlasovacie udaje");
			wrong.setOpacity(1);
		}
		
	}
	
	@FXML
	public void logout(ActionEvent event) throws IOException {
		View.LOGGED = null;
		changeScene("login.fxml", event);
		
		System.out.println("Uspesne odhlaseny");
	}
	
	@FXML
	public void search(ActionEvent event) throws IOException {
		
		ArrayList<Button> buttons = new ArrayList<Button>();
		ArrayList<user> result = Database.search(key.getText());
		
		vypis.clear();
		found.getChildren().clear();
		
		for(int i = 0; i<result.size();i++) {
			final Integer innerI = new Integer(i);
			
			
			
			buttons.add(new Button(result.get(innerI).getMeno()+ "\n" +result.get(innerI).getICO()));
			
			
			found.getChildren().add(buttons.get(innerI));
			
			
			buttons.get(innerI).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					try {
						changeScene("profile.fxml",e);
						profileData(result.get(innerI));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			vypis.appendText(result.get(innerI).toString()+"\n");
		}
	}
	
	@FXML
	public void back(ActionEvent event) throws IOException {
		changeScene("main.fxml", event);
	}
	
	
	public void all(ActionEvent event) throws IOException {
		ArrayList<Button> buttons = new ArrayList<Button>();
		ArrayList<user> result = Database.getSubjekti();
		
		vypis.clear();
		found.getChildren().clear();
		
		for(int i = 0; i<result.size();i++) {
			final Integer innerI = new Integer(i);
			
			
			
			buttons.add(new Button(result.get(innerI).getMeno()+ "\n" +result.get(innerI).getICO()));
			
			
			found.getChildren().add(buttons.get(innerI));
			
			
			buttons.get(innerI).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					try {
						changeScene("profile.fxml",e);
						profileData(result.get(innerI));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			vypis.appendText(result.get(innerI).toString()+"\n");
		}
		
	}
	
	@FXML
	public void add(ActionEvent event) throws IOException {
		try {
			changeScene("addUser.fxml", event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void addUser(ActionEvent event) throws IOException {
		/*System.out.println(menoaddi.getText());
		System.out.println(Integer.parseInt(vekaddi.getText()));
		System.out.println(adressaaddi.getText());
		System.out.println(mestoaddi.getText());
		System.out.println(pscaddi.getText());
		System.out.println(icoaddi.getText());
		System.out.println(dicaddi.getText());
		System.out.println(platcaaddi.isSelected());*/
		
		add.setContentText("Chcete pridať: \"" + menoaddi.getText() + "\" ?");
		
		Optional<ButtonType> result = add.showAndWait();
		
		if(result.get() == ButtonType.OK) {
			if(pravnickaaddi.isSelected()) {
				Database.add(new pravnickaOsoba(menoaddi.getText(),Integer.parseInt(vekaddi.getText()),"muz",adressaaddi.getText(),mestoaddi.getText(),pscaddi.getText(),icoaddi.getText(),dicaddi.getText(),platcaaddi.isSelected()));
			}
		
			else {
				Database.add(new fyzickaOsoba(menoaddi.getText(),Integer.parseInt(vekaddi.getText()),"muz",adressaaddi.getText(),mestoaddi.getText(),pscaddi.getText(),icoaddi.getText(),dicaddi.getText(),platcaaddi.isSelected()));
			}
			
			changeScene("main.fxml", event);
		}
		
		else {
			
		}
	}
	
	@FXML
	public void deleteUser(ActionEvent event) throws IOException {
		
		delete.setContentText("Chcete vymazať: \"" + namei.getText() + "\" ?");
		
		Optional<ButtonType> result = delete.showAndWait();
		
		System.out.println(icoi.getText());
		
		if(result.get() == ButtonType.OK) {
			Database.remove(icoi.getText());
			changeScene("main.fxml",event);
		}
		
		else {
			
		}
	}
	
	
	public void changeScene(String s,ActionEvent event) throws IOException {
			
		Parent homepage = FXMLLoader.load(getClass().getResource(s));
		Scene homeScene = new Scene(homepage);
		
		homeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(homeScene);
		stage.show();
		
		if(s.equals("main.fxml")) {
			llogi.setText(View.LOGGED.getMeno());
		}
	}
	
	public static void profileData(user u) {
		namei.setText(u.getMeno());
		yoi.setText(Integer.toString(u.getVek()));
		genderi.setText(u.getPohlavie());
		adressi.setText(u.getAdresa());
		psci.setText(u.getPSC() + ", " + u.getMesto());
		icoi.setText(u.getICO());
		dici.setText(u.getDIC());
		platcadphi.setSelected(u.isPlatcaDPH());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.llogi = llog;
		
		this.namei = nameprof;
		this.yoi = yoprof;
		this.genderi = genderprof;
		this.adressi = adressprof;
		this.psci = pscprof;
		this.icoi = icoprof;
		this.dici = dicprof;
		this.platcadphi = platcadphprof;
		
		this.menoaddi = menoadd;
		this.vekaddi = vekadd;
		this.adressaaddi = adressaadd;
		this.pscaddi = pscadd;
		this.mestoaddi = mestoadd;
		this.icoaddi = icoadd;
		this.dicaddi = dicadd;
		this.platcaaddi = platcaadd;
		this.pravnickaaddi = pravnickaadd;
		
		
	}
}
