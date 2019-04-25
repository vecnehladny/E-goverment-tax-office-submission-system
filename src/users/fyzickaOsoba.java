package users;

import java.util.ArrayList;

import Controller.Controller;
import application.dp;
import application.dpfoA;

public class fyzickaOsoba extends user {
	
	public fyzickaOsoba(String meno, int vek, String pohlavie, String adresa, String mesto, String PSC, String ICO, String DIC, boolean platcaDPH){
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
		this.pridajDp(new dpfoA(2018,"A",this.getDIC(),4,true));
	}

	@Override
	String identity() {
		// TODO Auto-generated method stub
		return "fyzicka osoba";
	}
	
	@Override
	public void show() {
			Controller.profileData(this);
	}

	@Override
	public float zaplatDPH() {
		if(this.isPlatcaDPH()) {
			ArrayList<dp> odovzdane = this.odovzdaneDanove.getOdovzdane();
			
			for(dp d : odovzdane) {
				if(d instanceof dpfoA) {
					return (float) ((Float.parseFloat(d.t40) - Float.parseFloat(d.t43) + Float.parseFloat(d.t37)) * 0.47);
				}
				else {
					continue;
				}
			}
			
			
		}
		
		else {
			return 0;
		}
		
		return 0;
		
	}
		
}

