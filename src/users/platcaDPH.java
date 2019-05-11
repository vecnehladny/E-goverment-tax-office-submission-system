package users;

import java.io.Serializable;
import java.util.ArrayList;

import application.dp;
import application.dpfoA;
import application.dppoA;

public class platcaDPH implements platenieDPH, Serializable {

	@Override
	public float zaplatDPH(user u) {
		
	ArrayList<dp> odovzdane = u.odovzdaneDanove.getOdovzdane();
			
	for(dp d : odovzdane) {
		if(d instanceof dpfoA) {
			System.out.println(u.getMeno());
			return (float) ((Float.parseFloat(d.t40) - Float.parseFloat(d.t43) + Float.parseFloat(d.t37)) * 0.47);
		}
		else {
			continue;
		}
	}
		
	return 0;
		
	}

}
