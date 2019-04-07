package application;

public abstract class dp {
	private String typ;
	private int rok;
	private int prilohy;
	private boolean potvrdenie;

	dp(int rok, String typ, int prilohy, boolean potvrdenie){
		this.rok = rok;
		this.typ = typ;
		this.prilohy = prilohy;
		this.potvrdenie = potvrdenie;
	}
}
