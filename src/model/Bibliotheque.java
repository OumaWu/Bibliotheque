package model;
import java.util.List;

public class Bibliotheque {

	// Liste des documents de la bibliotheque
	private List<Document> documents;

	/**
	 * Constructeur d'une bibliotheque dont la liste de documents est vide.
	 */
	public Bibliotheque() {
		// TO DO ... ( "vide" ne veut pas dire null ! )
		throw new RuntimeException("Bibliotheque() not yet implemented"); 
	}
	
	/**
	 * Renvoie la liste des documents de la bibliotheque.
	 */
	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * Renvoie le i �me document de la liste des documents, s�il existe, 
	 * ou null sinon.
	 */
	public Document getDocument(int i) {
		// TO DO ...
		throw new RuntimeException("getDocument() not yet implemented"); 
	}
	
	/**
	 * Si doc est non null et n'appartient pas d�j� � la liste des documents,
	 * alors ajoute doc � cette liste et renvoie true ;
	 * sinon renvoie faux.
	 */
	public boolean addDocument(Document doc) {
		// TO DO ...
		throw new RuntimeException("addDocument() not yet implemented"); 
	}
	
	/**
	 * Si doc est dans la liste des documents, alors l'y supprime et renvoie true;
	 * sinon renvoie false.
	 */
	public boolean removeDocument(Document doc) {
		// TO DO ...
		throw new RuntimeException("removeDocument() not yet implemented"); 
	}

	@Override
	public String toString() {
		return "Bibliotheque de " + documents.size() + " documents";
	}	
}
