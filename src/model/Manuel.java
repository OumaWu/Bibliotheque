package model;

// TO DO ...
public class Manuel extends Livre implements InterfaceAuteur {

	private int niveau;

	public Manuel(String titre, String auteur, int nbPages, int niveau) {
		super(titre, auteur, nbPages);
		this.niveau = niveau;
	}

	/**
	 * @return the niveau
	 */
	public int getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + ", niveau " + this.niveau;
	}
}
