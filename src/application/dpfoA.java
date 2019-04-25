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
		
		//System.out.println(this.zarok + " " + this.typ + " " + this.dic01 + " " + this.prilohy + " " + this.potvrdenie);
	}

}
