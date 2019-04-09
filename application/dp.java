package application;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class dp {
	String dic01;
	String datum02;
	boolean typ1;
	boolean typ2;
	boolean typ3;
	String zarok;
	String priezvisko03;
	String meno04;
	String titul05;
	String ulica06;
	String cislo07;
	String psc08;
	String obec09;
	String stat10;
	boolean nerezident;
	String ulica12;
	String cislo13;
	String psc14;
	String obec15;
	String priezvisko16;
	String meno17;
	String titul18;
	String rodnecislo19;
	String ulica20;
	String cislo21;
	String psc22;
	String obec23;
	String stat24;
	String telefon25;
	String email26;
	String rodnecislo2;
	boolean ano27;
	String dochodok28;
	String menopriezvisko29;
	String rodnecislo291;
	boolean uplatnenienezdanitelenj30;
	String vlastnyprijem311;
	String mesiace312;
	String menopriezvisko321;
	String menopriezvisko322;
	String menopriezvisko323;
	String menopriezvisko324;
	String rodnecislo321;
	String rodnecislo322;
	String rodnecislo323;
	String rodnecislo324;
	String kupele321;
	String kupele322;
	String kupele323;
	String kupele324;
	boolean vsetky321;
	boolean vsetky322;
	boolean vsetky323;
	boolean vsetky324;
	int mesiacov321;
	int mesiacov322;
	int mesiacov323;
	int mesiacov324;
	boolean dalsiedeti33;
	String zakupele34;
	boolean danovybonus35;
	String uroky351;
	String t36;
	String t361;
	String rodnecislo3;
	String t37;
	String t371;
	String t372;
	String t38;
	String t39;
	String t40;
	String t41;
	String t42;
	String t421;
	String t422;
	String t43;
	String t44;
	String t45;
	String t46;
	String t47;
	String t48;
	String t49;
	String t50;
	String t51;
	String t52;
	String t53;
	String t54;
	String t55;
	String t56;
	String rodnecislo4;
	String t57;
	String t58;
	String t59;
	String t60;
	String t61;
	String t62;
	String t63;
	String t64;
	String t65;
	String t66;
	String t67;
	String t68;
	String t69;
	String t70;
	String t71;
	String t72;
	String t73;
	String t74;
	String rodnecislo5;
	String t75;
	String t76;
	String t77;
	String t78;
	String t79;
	String t80;
	String t81;
	String t82;
	boolean neuplatnujem821;
	boolean splnam822;
	String t83;
	String podpis831;
	String ico841;
	String pravnaforma842;
	String nazov843;
	String nazov844;
	String ulicas;
	String cislos;
	String pscs;
	String obecs;
	boolean zaslanieudajov841;
	String rodnecislo6;
	boolean osobitnezaz842;
	String kodstatu1;
	String kodstatu2;
	String kodstatu3;
	String prijmy1;
	String prijmy2;
	String prijmy3;
	String vydavky1;
	String vydavky2;
	String vydavky3;
	String t86;
	String t87;
	String datum871;
	String podpis872;
	boolean c873;
	boolean c874;
	boolean c875;
	boolean c876;
	boolean posta881;
	boolean ucet882;
	boolean zahranicie883;
	String iban884;
	String datum885;
	String podpis886;
	
	
	int rok;
	String typ;
	int prilohy;
	boolean potvrdenie;
	

	dp(int rok, String typ, String dic, int prilohy, boolean potvrdenie){
		this.rok = rok;
		this.typ = typ;
		this.dic01 = dic;
		this.prilohy = prilohy;
		this.potvrdenie = potvrdenie;
	}
	
	public dp() {
		// TODO Auto-generated constructor stub
	}
	
	public int getRok() {
		return this.rok;
	}
	
	public String getTyp() {
		return this.typ;
	}
	
	public int getPrilohy(){
		return this.prilohy;
	}
	
	public boolean getPotvrdenie() {
		return this.potvrdenie;
		
	}
	

	public String toString() {
		return "\nrok: " + this.rok 
				+ "\ntyp: " + this.typ
				+ "\nprilohy: " + this.prilohy
				+ "\npotvrdenie: " + this.potvrdenie
				+ "\n";
	}
}
