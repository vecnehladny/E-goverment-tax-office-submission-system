package users;

import java.io.Serializable;
import java.util.ArrayList;

import application.dp;

public class odovzdaneDP implements Serializable {
	private ArrayList<dp> odovzdane = new ArrayList<dp>();
	
	odovzdaneDP(){
	}

	public void pridaj(dp d) {
		this.odovzdane.add(d);
	}
	
	public dp edit(dp d) {
		return odovzdane.get(odovzdane.indexOf(d));
	}
	
	public void remove(dp d) {
		odovzdane.remove(d);
	}
	
	public ArrayList<dp> getOdovzdane(){
		return this.odovzdane;
	}
	
	public dp getFirst() {
		return odovzdane.get(0);
	}
}
