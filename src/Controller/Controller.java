package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import View.*;
import application.Database;
import application.dp;
import application.dpfoA;
import javafx.stage.*;
import users.fyzickaOsoba;
import users.pravnickaOsoba;
import users.user;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private TilePane found;
	
	@FXML
	private Text llog;
	
	private static Text llogi;
	private Alert dph = new Alert(AlertType.INFORMATION);
	private TextArea dphVypis = new TextArea();
	
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
	
	@FXML
	private TableView<dp> odovzdaneTable;
	
	@FXML
	private TableColumn<dp, Integer> obdobie;
	
	@FXML
	private TableColumn<dp, String> typ;
	
	@FXML
	private TableColumn<dp, Integer> prilohy;
	
	@FXML
	private TableColumn<dp, Boolean> potvrdenie;
	
	@FXML
	private HBox tlacidlaprof;
	
	@FXML
	private TextField zarok;
	
	@FXML
	private TextField dic01;
	
	@FXML
	private TextField t36;
	
	@FXML
	private TextField t361;
	@FXML
	private TextField t37;
	@FXML
	private TextField t371;
	@FXML
	private TextField t372;
	@FXML
	private TextField t38;
	@FXML
	private TextField t39;
	@FXML
	private TextField t40;
	@FXML
	private TextField t43;
	@FXML
	private TextField t70;
	@FXML
	private TextField t72;	
	
	private static HBox tlacidlaprofi;
	private static Text namei;
	private static Text yoi;
	private static Text genderi;
	private static Text adressi;
	private static Text psci;
	private static Text icoi;
	private static Text dici;
	private static TextField zaroki;
	private static TextField dic01i;
	private static TextField t36i;
	private static TextField t361i;
	private static TextField t37i;
	private static TextField t371i;
	private static TextField t372i;
	private static TextField t38i;
	private static TextField t39i;
	private static TextField t40i;
	private static TextField t43i;
	private static TextField t70i;
	private static TextField t72i;
	private static CheckBox platcadphi;
	
	
	static TableView<dp> odovzdaneTablei;
	static TableColumn<dp, Integer> obdobiei;
	static TableColumn<dp, String> typi;
	static TableColumn<dp, Integer> prilohyi;
	static TableColumn<dp, Boolean> potvrdeniei;
	static Alert delete = new Alert(AlertType.CONFIRMATION);
	static Alert addDP = new Alert(AlertType.CONFIRMATION);
	
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
	
	
	
	
	
	
	
	
	/**
	 * Metoda pre prihlasovanie, metoda spracovava udaje z formulara a porovnava s prihlasovacimi udajmi pouzivatela.
	 * Ak neexistuje zhoda, vypise chybovu hlasku.
	 * Ak je prihlasenie uspesne, ulozi aktualneho uzivatela do globalnej premennej a aplikacia sa dostane do hlavnej casti.
	 * @param event
	 * @throws IOException
	 */
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
	
	/**
	 * Metoda sluziaca na odhlasovanie. Vynuluje globalnu premennu prihlaseneho pouzivatela a prepne aplikaciu do sceny prihlasenia.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void logout(ActionEvent event) throws IOException {
		View.LOGGED = null;
		changeScene("login.fxml", event);
		
		System.out.println("Uspesne odhlaseny");
	}
	
	/**
	 * Metoda sa stara o vyhladavanie, na zaklade vysledku vyhladavnia vytvori tlacitka, ktore sa preklikavaju najdene profily pouzivatelov
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void search(ActionEvent event) throws IOException {
		
		ArrayList<Button> buttons = new ArrayList<Button>();
		ArrayList<user> result = Database.search(key.getText());
		
		
		found.getChildren().clear();
		
		for(int i = 0; i<result.size();i++) {
			final Integer innerI = new Integer(i);
			
			
			
			buttons.add(new Button(result.get(innerI).getMeno()+ "\n" +result.get(innerI).getICO()));
			
			
			found.getChildren().add(buttons.get(innerI));
			
			
			buttons.get(innerI).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					try {
						changeScene("profile.fxml",e);
						result.get(innerI).show();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
		}
	}
	
	/**
	 * Navrat do hlavnej casti aplikacie
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void back(ActionEvent event) throws IOException {
		changeScene("main.fxml", event);
	}
	
	
	/**
	 * Metoda ktora vypise vsetkych subjektov v databaze v podobe tlacidiel preklikavatelnych na ich profily.
	 * @param event
	 * @throws IOException
	 */
	public void all(ActionEvent event) throws IOException {
		ArrayList<Button> buttons = new ArrayList<Button>();
		ArrayList<user> result = Database.getSubjekti();
		
		
		found.getChildren().clear();
		
		for(int i = 0; i<result.size();i++) {
			final Integer innerI = new Integer(i);
			
			buttons.add(new Button(result.get(innerI).getMeno()+ "\n" +result.get(innerI).getICO()));
			
			found.getChildren().add(buttons.get(innerI));
			
			buttons.get(innerI).setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					try {
						changeScene("profile.fxml",e);
						result.get(innerI).show();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			
		}
		
	}
	
	/**
	 * Metoda pre prepnutie sceny na formular pridania noveho subjektu.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void add(ActionEvent event) throws IOException {
		try {
			changeScene("addUser.fxml", event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ulozenie (Serializovanie) doterajsie vykonanych zmien v databaze.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void save(ActionEvent event) throws IOException {
		try {
			Database.update();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//polymorfizmus
	/**
	 * Metoda ktora vypocita kazdej osobe, kolko by mala zaplatit dph za dane obdobie a vypise informacie (meno + ico + ciastku)
	 * Pri neplaticovi vypise 0.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void vypocitajDPH(ActionEvent event) throws IOException {
		try {
			ArrayList<user> subjekti = Database.getSubjekti();
			
			for (user u : subjekti) {
				if(u instanceof fyzickaOsoba) {
					System.out.println("\n+-----------------------------------");
					System.out.println("| "+u.getMeno() + " ("+u.getICO()+")");
					System.out.println("| "+((fyzickaOsoba) u).DPH());
					System.out.println("+-----------------------------------");
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	
	/**
	 * Metoda na handlovanie dat z formulara pre pridanie subjektu
	 * @param event
	 * @throws IOException
	 */
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
	
	/**
	 * Metoda na vymazanie subjektu z databazy s nutnym potvrdenim.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void deleteUser(ActionEvent event) throws IOException {
		
		delete.setContentText("Chcete vymazať: \"" + namei.getText() + "\" ?");
		
		Optional<ButtonType> result = delete.showAndWait();
		
		System.out.println(icoi.getText());
		
		if(result.get() == ButtonType.OK) {
			Database.vymaz(View.current);
			changeScene("main.fxml",event);
		}
		
		else {
			
		}
	}
	
	
	/**
	 * Hlavna metoda starajuca sa o vymenu scen v okne podla nazvu sceny.
	 * @param s
	 * @param event
	 * @throws IOException
	 */
	public void changeScene(String s,ActionEvent event) throws IOException {
			
		Parent homepage = FXMLLoader.load(getClass().getResource("/Resources/"+ s));
		Scene homeScene = new Scene(homepage);
		
		homeScene.getStylesheets().add(getClass().getResource("/Resources/application.css").toExternalForm());
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(homeScene);
		stage.show();
		
		if(s.equals("main.fxml")) {
			llogi.setText(View.LOGGED.getMeno());
		}
	}
	
	/**
	 * Metoda na zatvorenie aktualneho otvoreneho okna.
	 * @param event
	 * @throws IOException
	 */
	public void CloseWindow(ActionEvent event) throws IOException {
		
		 Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 stage.close();
	}
	
	/**
	 * Metoda na vytvorenie noveho okna pri vyplneni alebo upravovani danoveho priznania.
	 * @param s
	 * @param event
	 * @throws IOException
	 */
	public void changeWindow(String s,ActionEvent event) throws IOException {
		try {
			
			Parent homepage = FXMLLoader.load(getClass().getResource("/Resources/" + s));
			Scene homeScene = new Scene(homepage);
			
			homeScene.getStylesheets().add(getClass().getResource("/Resources/application.css").toExternalForm());
			
	        Stage stage = new Stage();
	        stage.setScene(homeScene);  
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Metoda, ktora sa stara o spracovanie dat subjektu do podoby profilu. Vypis informacii + vypis odovzdanych danovych priznani do tabulky.
	 * @param u
	 */
	public static void profileData(user u) {
		View.current = u;
		
		namei.setText(u.getMeno());
		yoi.setText(Integer.toString(u.getVek()));
		genderi.setText(u.getPohlavie());
		adressi.setText(u.getAdresa());
		psci.setText(u.getPSC() + ", " + u.getMesto());
		icoi.setText(u.getICO());
		dici.setText(u.getDIC());
		platcadphi.setSelected(u.isPlatcaDPH());
		
		
		ObservableList<dp> dotabulky = FXCollections.observableArrayList(u.odovzdaneDanove.getOdovzdane());
		System.out.println(dotabulky);
		
		obdobiei.setCellValueFactory(new PropertyValueFactory<dp, Integer>("rok"));
		typi.setCellValueFactory(new PropertyValueFactory<dp, String>("typ"));
		prilohyi.setCellValueFactory(new PropertyValueFactory<dp, Integer>("prilohy"));
		potvrdeniei.setCellValueFactory(new PropertyValueFactory<dp, Boolean>("potvrdenie"));
	
		odovzdaneTablei.setItems(dotabulky);
		
		odovzdaneTablei.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
			
			@Override
			public void handle(MouseEvent e) {
				if(e.getClickCount() > 1) {
					if(odovzdaneTablei.getSelectionModel().getSelectedIndex() >= 0) {
						try {
							showDP(odovzdaneTablei.getSelectionModel().getSelectedItem());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}

			/**
			 * Metoda pre otvorenie vybraneho danoveho priznania v novom okne so vsetkymi udajmi.
			 * @param selectedItem
			 * @throws IOException
			 */
			private void showDP(dp selectedItem) throws IOException {
				new Controller().changeWindow("dpfoA.fxml", new ActionEvent());
				dic01i.setText(selectedItem.dic01);
				zaroki.setText(selectedItem.zarok);
				t36i.setText(selectedItem.t36);
				t361i.setText(selectedItem.t361);
				t37i.setText(selectedItem.t37);
				t371i.setText(selectedItem.t371);
				t372i.setText(selectedItem.t372);
				t38i.setText(selectedItem.t38);
				t39i.setText(selectedItem.t39);
				t40i.setText(selectedItem.t40);
				t43i.setText(selectedItem.t43);
				t70i.setText(selectedItem.t70);
				t72i.setText(selectedItem.t72);
			}
		});
		
		
		Button pridatDP = new Button("Add DP");
		tlacidlaprofi.getChildren().add(pridatDP);
		
		pridatDP.setOnAction(e -> {
			try {
				new Controller().changeWindow("dpfoA.fxml", e);
			}
			
			catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
	}
	
	/**
	 * Metoda, ktora poda danove priznanie a ulozi ho ku danovim priznaniam daneho subjektu.
	 * @param event
	 * @throws IOException
	 */
	public void odovzdat(ActionEvent event) throws IOException {
		addDP.setContentText("Chcete podať toto Daňové priznanie?");
		
		Optional<ButtonType> result = addDP.showAndWait();
		
		if(result.get() == ButtonType.OK) {
			View.current.odovzdaneDanove.pridaj(new dpfoA(Integer.parseInt(this.zaroki.getText()),"A",this.dic01i.getText(),0,false));
			CloseWindow(event);
		}
		
		else {
			
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//System.out.println(odovzdaneTable + "\n" + obdobie + "\n" + typ + "\n" + prilohy + "\n" + potvrdenie);
		
		this.llogi = llog;
		
		this.tlacidlaprofi = tlacidlaprof;
		this.namei = nameprof;
		this.yoi = yoprof;
		this.genderi = genderprof;
		this.adressi = adressprof;
		this.psci = pscprof;
		this.icoi = icoprof;
		this.dici = dicprof;
		this.zaroki = zarok;
		this.dic01i = dic01;
		this.t36i = t36;
		this.t361i = t361;
		this.t37i = t37;
		this.t371i = t371;
		this.t372i = t372;
		this.t38i = t38;
		this.t39i = t39;
		this.t40i = t40;
		this.t43i = t43;
		this.t70i = t70;
		this.t72i = t72;
		
		this.platcadphi = platcadphprof;
		this.odovzdaneTablei = odovzdaneTable;
		this.obdobiei = obdobie;
		this.typi = typ;
		this.prilohyi = prilohy;
		this.potvrdeniei = potvrdenie;
		
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
