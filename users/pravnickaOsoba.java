package users;

public class pravnickaOsoba extends user implements platcaDPH {
	
	public pravnickaOsoba(String meno, int vek, String pohlavie, String adresa, String mesto, String PSC, String ICO, String DIC, boolean platcaDPH){
		super(meno, vek, pohlavie, adresa, mesto, PSC, ICO, DIC, platcaDPH);
	}

	@Override
	String identity() {
		// TODO Auto-generated method stub
		return "pravnicka osoba";
	}

	@Override
	public void zaplatDPH() {
		// TODO Auto-generated method stub
		
	}

}
