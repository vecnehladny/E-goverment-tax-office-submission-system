package users;

import java.io.Serializable;
import java.util.ArrayList;

import Controller.Controller;
import application.dp;
import application.dpfoA;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

abstract public class user implements Serializable {
	private platenieDPH platcaDPH;
	public static odovzdaneDP odovzdaneDanove;
	private String meno;
	private int vek;
	private String pohlavie;
	private String adresa;
	private String mesto;
	private String PSC;
	private String ICO;
	private String DIC;
	protected boolean admin = false;
	private boolean platcaDane;
	
	
	
	
	/**
	 * @return meno
	 */
	public String getMeno() {
		return meno;
	}




	/**
	 * @param meno
	 */
	public void setMeno(String meno) {
		this.meno = meno;
	}




	/**
	 * @return vek
	 */
	public int getVek() {
		return vek;
	}




	/**
	 * @param vek
	 */
	public void setVek(int vek) {
		this.vek = vek;
	}




	/**
	 * @return pohlavie
	 */
	public String getPohlavie() {
		return pohlavie;
	}




	/**
	 * @param pohlavie
	 */
	public void setPohlavie(String pohlavie) {
		this.pohlavie = pohlavie;
	}




	/**
	 * @return adresa
	 */
	public String getAdresa() {
		return adresa;
	}




	/**
	 * @param adresa
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}




	/**
	 * @return mesto
	 */
	public String getMesto() {
		return mesto;
	}




	/**
	 * @param mesto
	 */
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}




	/**
	 * @return psc
	 */
	public String getPSC() {
		return PSC;
	}




	/**
	 * @param pSC
	 */
	public void setPSC(String pSC) {
		PSC = pSC;
	}




	/**
	 * @return ICO
	 */
	public String getICO() {
		return ICO;
	}




	/**
	 * @param iCO
	 */
	public void setICO(String iCO) {
		ICO = iCO;
	}




	/**
	 * @return DIC
	 */
	public String getDIC() {
		return DIC;
	}




	/**
	 * @param dIC
	 */
	public void setDIC(String dIC) {
		DIC = dIC;
	}




	/**
	 * @return platcaDane
	 */
	public boolean isPlatcaDPH() {
		return platcaDane;
	}




	/**
	 * @param platcaDPH
	 */
	public void setPlatcaDPH(boolean platcaDPH) {
		if(platcaDPH) {
			this.platcaDPH = new platcaDPH();
			this.platcaDane = platcaDPH;
		}
		else {
			this.platcaDPH = new neplatcaDPH();
			this.platcaDane = platcaDPH;
		}
	}
	
	user(){
	}


	user(String meno, int vek, String pohlavie, String adresa, String mesto, String PSC, String ICO, String DIC, boolean platcaDPH){
	}
	
	/**
	 * Metoda, ktora sa stara o zobrazenie udajov subjekta v jeho profile.
	 */
	public void show() {
		if(this != null) {
			Controller.profileData(this);
			System.out.println(this.getMeno() + " " + this.getICO() );
		}
		
	}
	
	/**
	 * Metoda, ktora prida danove priznanie do zoznamu odovzdanych daneho subjekta.
	 * @param d
	 */
	public void pridajDp(dp d) {
		this.odovzdaneDanove.pridaj(d);
	}
	
	public float DPH() {
		return this.platcaDPH.zaplatDPH(this);
		
	}
	
	/**
	 * @return typ objektu
	 */
	abstract String identity();

	public String toString() {
		return "\nmeno: " + this.meno 
				+ "\nvek: " + this.vek
				+ "\npohlavie: " + this.pohlavie
				+ "\nadresa: " + this.adresa
				+ "\npsc: " + this.PSC
				+ " mesto: " + this.mesto
				+ "\nICO: " + this.ICO
				+ "\nDIC: " + this.DIC
				+ "\nplatcaDPH: " + this.platcaDPH
				+ "\n\n"
				+ this.odovzdaneDanove.getOdovzdane();
	}
}
