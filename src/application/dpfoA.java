package application;

import java.io.Serializable;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class dpfoA extends dp implements Serializable {

	public dpfoA(int rok, String typ, String dic, int prilohy, boolean potvrdenie) {
		
		
		this.zarok = Integer.toString(rok);
		this.rok = rok;
		this.typ = typ;
		this.dic01 = dic;
		this.prilohy = prilohy;
		this.potvrdenie = potvrdenie;
		
		this.t36 = "1208";
		this.t361 = "1208";
		this.t37 = "45";
		this.t371 = "45";
		this.t372 = "0";
		this.t38 = "1162";
		this.t39 = "1162";
		this.t40 = "3803";
		this.t43 = "1162";
		this.t70 = "70";
		this.t72 = "70";		
		//System.out.println(this.zarok + " " + this.typ + " " + this.dic01 + " " + this.prilohy + " " + this.potvrdenie);
	}

}
