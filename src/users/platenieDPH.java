package users;

public interface platenieDPH {

	public float zaplatDPH(user u);
	
	default float neplatca(user u) {
		return 0;
	}
}
