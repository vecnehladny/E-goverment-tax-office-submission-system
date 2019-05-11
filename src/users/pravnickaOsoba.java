package users;

import Controller.Controller;
import application.dpfoA;

public class pravnickaOsoba extends user {
	
	public pravnickaOsoba(String meno, int vek, String pohlavie, String adresa, String mesto, String PSC, String ICO, String DIC, boolean platcaDPH){
		//super(meno, vek, pohlavie, adresa, mesto, PSC, ICO, DIC, platcaDPH);
		setMeno(meno); 
		setVek(vek);
		setPohlavie(pohlavie);
		setAdresa(adresa);
		setMesto(mesto);
		setPSC(PSC);
		setICO(ICO);
		setDIC(DIC);
		setPlatcaDPH(platcaDPH);
		this.odovzdaneDanove = new odovzdaneDP();
		pridajDp(new dpfoA(2018,"A",this.getDIC(),4,true));
	}
	
	@Override
	public void show() {
			Controller.profileData(this);
			System.out.println(this.getMeno() + " " + this.getICO() );
	}

	@Override
	String identity() {
		// TODO Auto-generated method stub
		return "pravnicka osoba";
	}
}
