package model;

// TO DO ...
public class Roman extends Livre implements InterfaceAuteur {

	public static final int GONCOURT = 0;
	public static final int MEDICIS = 1;
	public static final int INTERALLIE = 2;
	public static final int PULITZER = 3;
	private int prixLitteraire;
	
	public Roman(String titre, String auteur, int nbPages, int prixLitt) {
		super(titre, auteur, nbPages);
		this.prixLitteraire = prixLitt;
	}

	/**
	 * @return the prixLitteraire
	 */
	public int getPrixLitteraire() {
		return prixLitteraire;
	}

	/**
	 * @param prixLitteraire the prixLitteraire to set
	 */
	public void setPrixLitteraire(int prixLitteraire) {
		this.prixLitteraire = prixLitteraire;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + ", prix " + this.prixLitteraire;
	}
}
