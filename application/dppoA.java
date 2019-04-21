package application;

import java.io.Serializable;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class dppoA extends dp implements Serializable {

	dppoA(int rok, String typ, int prilohy, boolean potvrdenie) {
		super();
		this.rok = rok;
		this.typ = typ;
		this.prilohy = prilohy;
		this.potvrdenie = potvrdenie;
	}
}
