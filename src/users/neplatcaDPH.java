package users;

import java.io.Serializable;

public class neplatcaDPH implements platenieDPH, Serializable {

	/**
	 *Vypocet celkovej vysky sumy, ktoru ma dany subjekt zaplatit.
	 */
	@Override
	public float zaplatDPH(user u) {
		return neplatca(u);
	}
}
