package model;

// TO DO ...
public class Revue extends Document {

	private int mois;
	private int annee;
	
	public Revue(String titre, int mois, int annee) {
		super(titre);
		this.mois = mois;
		this.annee = annee;
	}

	/**
	 * @return the mois
	 */
	public int getMois() {
		return mois;
	}

	/**
	 * @param mois the mois to set
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}

	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getNumEnreg() + "\"" + this.getTitre() + "\""
				+ ", " + mois + ", " + annee + ".";
	}

	@Override
	public Document clone() {
		return new Revue(getTitre(), mois, annee);
	}
}
