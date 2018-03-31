package model;

// TO DO ...
public abstract class Document implements Comparable<Document>, Cloneable {
	
	private static int compteur = 1;
	private int numEnreg;
	private String titre;
	
	public Document(String titre) {
		this.titre = titre;
		setNumEnreg(compteur++);
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNumEnreg() {
		return numEnreg;
	}

	public void setNumEnreg(int numEnreg) {
		this.numEnreg = numEnreg;
	}
	
	@Override
	public int compareTo(Document doc) {
		return this.titre.compareTo(doc.titre);
	}
	
	@Override
	public Document clone() {
		return null;
	}
}