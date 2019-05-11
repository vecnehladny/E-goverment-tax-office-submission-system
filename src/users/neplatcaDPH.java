package users;

import java.io.Serializable;

public class neplatcaDPH implements platenieDPH, Serializable {

	@Override
	public float zaplatDPH(user u) {
		return neplatca(u);
	}
}
