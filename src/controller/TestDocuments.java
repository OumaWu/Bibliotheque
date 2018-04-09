package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Bibliotheque;
import model.Document;
import model.Livre;
import model.Manuel;
import model.Revue;
import model.Roman;
import view.Affichage;
import view.Afficheur;
import view.SaisieLivre;

public class TestDocuments {

	/**
	 * Programme de test.
	 */
	public static void main(String[] args) {

		Document[] documents = {
			new Livre("L'archipel du Goulag", "Soljenitsyne", 250),
			new Roman("Rouge Brésil", "Rufin", 120, Roman.GONCOURT),
			new Revue("Le point", 03, 2014),
			new Roman("Le mendiant", "Wiesel", 150, Roman.MEDICIS),
			new Livre("La condition humaine", "Malraux", 130),
			new Manuel("Manuel qualité ISO 9001", "AFNOR", 50, 3)
		};
	
//		Affichage affichage = new Affichage();
//		affichage.afficherDocuments(Arrays.asList(documents));
//		affichage.afficherAuteurs(Arrays.asList(documents));
		
		/*for ( Document doc : documents ) {
			System.out.println(doc);
		}*/
		
		List<Document> docs = new ArrayList<Document>(Arrays.asList(documents));
		Bibliotheque b = new Bibliotheque(docs);
		
//		Afficheur aff = new Afficheur(b);
		new SaisieLivre(b);
//		b.addDocument(new Roman("asdf", "awer", 34, Roman.GONCOURT));
//		System.out.println(b);
	}

}
