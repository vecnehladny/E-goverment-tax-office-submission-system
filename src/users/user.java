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
	public odovzdaneDP odovzdaneDanove = new odovzdaneDP();
	private String meno;
	private int vek;
	private String pohlavie;
	private String adresa;
	private String mesto;
	private String PSC;
	private String ICO;
	private String DIC;
	private boolean platcaDPH; //true = ano, false = nie
	protected boolean admin = false;
	
	
	
	
	public String getMeno() {
		return meno;
	}




	public void setMeno(String meno) {
		this.meno = meno;
	}




	public int getVek() {
		return vek;
	}




	public void setVek(int vek) {
		this.vek = vek;
	}




	public String getPohlavie() {
		return pohlavie;
	}




	public void setPohlavie(String pohlavie) {
		this.pohlavie = pohlavie;
	}




	public String getAdresa() {
		return adresa;
	}




	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}




	public String getMesto() {
		return mesto;
	}




	public void setMesto(String mesto) {
		this.mesto = mesto;
	}




	public String getPSC() {
		return PSC;
	}




	public void setPSC(String pSC) {
		PSC = pSC;
	}




	public String getICO() {
		return ICO;
	}




	public void setICO(String iCO) {
		ICO = iCO;
	}




	public String getDIC() {
		return DIC;
	}




	public void setDIC(String dIC) {
		DIC = dIC;
	}




	public boolean isPlatcaDPH() {
		return platcaDPH;
	}




	public void setPlatcaDPH(boolean platcaDPH) {
		this.platcaDPH = platcaDPH;
	}
	
	user(){
	}


	user(String meno, int vek, String pohlavie, String adresa, String mesto, String PSC, String ICO, String DIC, boolean platcaDPH){
		setMeno(meno); 
		setVek(vek);
		setPohlavie(pohlavie);
		setAdresa(adresa);
		setMesto(mesto);
		setPSC(PSC);
		setICO(ICO);
		setDIC(DIC);
		setPlatcaDPH(platcaDPH);
		pridajDp(new dpfoA(2018,"A",getDIC(),4,true));
	}
	
	public void show() {
		if(this != null) {
			Controller.profileData(this);
			System.out.println(this.getMeno() + " " + this.getICO() );
		}
		
	}
	
	public void pridajDp(dp d) {
		this.odovzdaneDanove.pridaj(d);
	}
	
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
