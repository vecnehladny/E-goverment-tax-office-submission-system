package users;

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
		pridajDp(new dpfoA(2018,"A",getDIC(),4,true));
	}

	@Override
	String identity() {
		// TODO Auto-generated method stub
		return "fyzicka osoba";
	}

	@Override
	public float zaplatDPH() {
		
		if(this.isPlatcaDPH()) {
			//....
		}
		
		else {
			return 0;
		}
		
		return 0;
		
	}
		
}

