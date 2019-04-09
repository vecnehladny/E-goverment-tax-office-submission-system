package users;

public class uctovnik extends user {
	private String username;
	private String passwd;
	
	public void setLoginData(String username, String passwd) {
		this.username = username;
		this.passwd = passwd;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPasswd() {
		return this.passwd;
	}
	
	public void setAdmin() {
		this.admin = true;
	}
	
	public uctovnik(){
		setMeno("Viktor Klíma"); 
		setVek(20);
		setPohlavie("Muž");
		setAdresa("Budatinska 22");
		setMesto("Bratislava");
		setPSC("851 06");
		setICO("10795110");
		setDIC("3267418877");
		
		this.setAdmin();
		this.setLoginData("admin", "heslo");				
 		
	}

	@Override
	String identity() {
		return "Účtovník";
	}
}
