package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import users.fyzickaOsoba;
import users.pravnickaOsoba;
import users.user;

public class Database implements Serializable {
	private static ArrayList<user> subjekti = new ArrayList<user>();

	
	public static ArrayList<user> search(String key) {
		ArrayList<user> found = new ArrayList<user>();
		
		for(user user : subjekti) {
			if(user.getMeno().equalsIgnoreCase(key)) {
				found.add(user);
			}
			
			if(user.getDIC().equalsIgnoreCase(key)) {
				found.add(user);
			}
			
			if(user.getICO().equalsIgnoreCase(key)) {
				found.add(user);
			}
		}
		
		System.out.println(found);
		return found;
	}
	
	public static ArrayList<user> getSubjekti() {
		return subjekti;
	}
	
	public static void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream("databaza.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(subjekti);
			
			out.close();
			fileOut.close();
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		subjekti.clear();
		
		try{
			FileInputStream fileIn = new FileInputStream("databaza.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
			subjekti = (ArrayList<user>)in.readObject();
				
			for(user u : subjekti) {
				System.out.println("Recovered " + u.getMeno() + " " + u.getICO());
			}
			
			in.close();
            fileIn.close();
            
		}
		
		catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
		
		catch(FileNotFoundException e) {
            e.printStackTrace();
        }
		
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public static void update() {
		save();
		load();
	}
	
	public static void add(user u) {
		subjekti.add(u);
		update();
	}
	
	public static void vymaz(user current) {
		subjekti.remove(current);
		update();
	}
	
	public void test() {
		for(user u : subjekti) {
			if(u instanceof fyzickaOsoba) {
				System.out.println("----ja som fyzicka osoba: " + u.getMeno() + " " + u.getICO());
			}
			
			else {
				System.out.println("----" + u.getMeno() + " " + u.getICO());
			}
		}
	}
	
	public void create() {
		fyzickaOsoba a = new fyzickaOsoba("Janko", 30, "Muž", "Budatinska 22", "Bratislava", "97901", "13957971", "7096487980", true);
		fyzickaOsoba b = new fyzickaOsoba("Jozef", 30, "Muž", "Budatinska 23", "Bratislava", "97901", "88662143", "7116725051", true);
		fyzickaOsoba c = new fyzickaOsoba("Peter", 30, "Muž", "Budatinska 24", "Bratislava", "97901", "24962304", "8935605926", false);
		fyzickaOsoba d = new fyzickaOsoba("Mariana", 30, "Žena", "Budatinska 25", "Bratislava", "97901", "90112069", "6823592351", true);
		fyzickaOsoba e = new fyzickaOsoba("Jaroslav", 30, "Muž", "Budatinska 26", "Bratislava", "97901", "10458637", "6608787861", true);
		fyzickaOsoba f = new fyzickaOsoba("Rasto", 30, "Muž", "Budatinska 27", "Bratislava", "97901", "19608847", "1412213214", true);
		fyzickaOsoba g = new fyzickaOsoba("Mikulas", 30, "Muž", "Budatinska 28", "Bratislava", "97901", "66455841", "6133345446", false);
		fyzickaOsoba h = new fyzickaOsoba("Demeter", 30, "Muž", "Budatinska 29", "Bratislava", "97901", "73655436", "4970341139", false);
		fyzickaOsoba i = new fyzickaOsoba("Stefania", 30, "Žena", "Budatinska 30", "Bratislava", "97901", "23579430", "6410762553", false);
		fyzickaOsoba j = new fyzickaOsoba("Pavlina", 30, "Žena", "Budatinska 31", "Bratislava", "97901", "45148532", "4259677712", true);
		
		pravnickaOsoba k = new pravnickaOsoba("Janko", 30, "Muž", "Budatinska 32", "Bratislava", "97901", "37182592", "2876954278", true);
		pravnickaOsoba l = new pravnickaOsoba("Jozef", 30, "Muž", "Budatinska 33", "Bratislava", "97901", "71022110", "8057768850", true);
		pravnickaOsoba m = new pravnickaOsoba("Peter", 30, "Muž", "Budatinska 34", "Bratislava", "97901", "58669440", "6953943740", false);
		pravnickaOsoba n = new pravnickaOsoba("Mariana", 30, "Žena", "Budatinska 35", "Bratislava", "97901", "36131386", "8482091457", true);
		pravnickaOsoba o = new pravnickaOsoba("Jaroslav", 30, "Muž", "Budatinska 36", "Bratislava", "97901", "18540186", "6175742984", true);
		pravnickaOsoba p = new pravnickaOsoba("Rasto", 30, "Muž", "Budatinska 37", "Bratislava", "97901", "45313930", "5855533601", true);
		pravnickaOsoba q = new pravnickaOsoba("Mikulas", 30, "Muž", "Budatinska 38", "Bratislava", "97901", "47380567", "5361955783", false);
		pravnickaOsoba r = new pravnickaOsoba("Demeter", 30, "Muž", "Budatinska 39", "Bratislava", "97901", "30921635", "4729612918", false);
		pravnickaOsoba s = new pravnickaOsoba("Stefania", 30, "Žena", "Budatinska 40", "Bratislava", "97901", "95730474", "2298889872", false);
		pravnickaOsoba t = new pravnickaOsoba("Pavlina", 30, "Žena", "Budatinska 41", "Bratislava", "97901", "54106635", "6297867825", true);
		
		subjekti.add(a);
		subjekti.add(b);
		subjekti.add(c);
		subjekti.add(d);
		subjekti.add(e);
		subjekti.add(f);
		subjekti.add(g);
		subjekti.add(h);
		subjekti.add(i);
		subjekti.add(j);
		subjekti.add(k);
		subjekti.add(l);
		subjekti.add(m);
		subjekti.add(n);
		subjekti.add(o);
		subjekti.add(p);
		subjekti.add(q);
		subjekti.add(r);
		subjekti.add(s);
		subjekti.add(t);
		System.out.println("databaza vytvore");
	}
	
	public Database() {
		//create();
		//save();
		load();
		//test();
	}
}
