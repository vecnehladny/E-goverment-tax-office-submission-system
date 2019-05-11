package users;

public interface platenieDPH {

	public float zaplatDPH(user u);
	
	/**
	 * Defaulta metoda pre neplatcu, ktory vzdy zaplati 0.
	 * @param u
	 * @return
	 */
	default float neplatca(user u) {
		return 0;
	}
}
