package users;

import java.io.Serializable;
import java.util.ArrayList;

import application.dp;

public class odovzdaneDP implements Serializable {
	private ArrayList<dp> odovzdane = new ArrayList<dp>();
	
	odovzdaneDP(){
	}

	/**
	 * Pridanie danoveho priznania do zoznamu odovzdanych
	 * @param d
	 */
	public void pridaj(dp d) {
		this.odovzdane.add(d);
	}
	
	/**
	 * Uprava daneho danoveho priznania
	 * @param d
	 * @return danove priznanie
	 */
	public dp edit(dp d) {
		return odovzdane.get(odovzdane.indexOf(d));
	}
	
	/**
	 * vymazanie daneho danoveho priznania
	 * @param d
	 */
	public void remove(dp d) {
		odovzdane.remove(d);
	}
	
	/**
	 * @return zoznam odovzdanych danovych priznani
	 */
	public ArrayList<dp> getOdovzdane(){
		return this.odovzdane;
	}
	
	/**
	 * @return prve danove priznanie zo zoznamu odovzdanych
	 */
	public dp getFirst() {
		return odovzdane.get(0);
	}
}
