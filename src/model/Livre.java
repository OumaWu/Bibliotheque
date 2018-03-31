package model;

import java.util.Comparator;

// TO DO ...
public class Livre extends Document implements InterfaceAuteur {

	private String auteur;
	private int nbPages;
	public static final Comparator<Livre> TRI_AUTEUR = new Comparator<Livre>() {

		@Override
		public int compare(Livre l1, Livre l2) {
			return l1.getAuteur().compareTo(l2.getAuteur());
		}
		
	};

	public Livre(String titre, String auteur, int nbPages) {
		super(titre);
		this.auteur = auteur;
		this.nbPages = nbPages;
	}

	@Override
	public String getAuteur() {
		return auteur;
	}
	
	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	/**
	 * @return the nbPages
	 */
	public int getNbPages() {
		return nbPages;
	}

	/**
	 * @param nbPages the nbPages to set
	 */
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getNumEnreg() + "\"" + this.getTitre() + "\""
				+ ", \"" + auteur + "\", " + nbPages + " p";
	}
	
	@Override
	public int compareTo(Document doc) {
		if (!this.getTitre().equals(doc.getTitre()))
			return this.getTitre().compareTo(doc.getTitre());
		return this.getAuteur().compareTo(((Livre)doc).getAuteur());
	}
	
	@Override
	public Document clone() {
		return new Livre(getTitre(), auteur, nbPages);
	}	
}
