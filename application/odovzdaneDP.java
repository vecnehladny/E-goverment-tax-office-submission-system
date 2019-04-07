package application;

import java.util.ArrayList;

public class odovzdaneDP {
	private ArrayList<dp> odovzdane = new ArrayList<dp>();
	
	odovzdaneDP(){
		this.odovzdane = null;
	}
	
	public void add(dp d) {
		this.odovzdane.add(d);
	}
	
	public dp edit(dp d) {
		return odovzdane.get(odovzdane.indexOf(d));
	}
	
	public void remove(dp d) {
		odovzdane.remove(d);
	}
}
