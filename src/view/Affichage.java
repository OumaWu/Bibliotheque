package view;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import model.*;

/**
 * Utilitaires d'affichage
 */
public class Affichage {

	// TO DO ...
	public void afficherDocuments(Collection<Document> docs) {
		System.out.println(docs);
	}
	
	public void afficherAuteurs(Collection<Document> docs) {
		List<Livre> avecAuteurs = new ArrayList<Livre>();
		for (Document doc : docs) {
			if (doc instanceof Livre) {
				avecAuteurs.add((Livre) doc);
			}
		}
		Collections.sort(avecAuteurs, Livre.TRI_AUTEUR);
		System.out.println(avecAuteurs);
	}
}
