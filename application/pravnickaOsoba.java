package application;

public class pravnickaOsoba extends user {
	
	pravnickaOsoba(String meno, int vek, String pohlavie, String adresa, String mesto, String PSC, String ICO, String DIC, boolean platcaDPH){
		super(meno, vek, pohlavie, adresa, mesto, PSC, ICO, DIC, platcaDPH);
	}

	@Override
	String identity() {
		// TODO Auto-generated method stub
		return "pravnicka osoba";
	}

}
