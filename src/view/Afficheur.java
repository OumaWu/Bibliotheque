package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import model.Bibliotheque;
import model.Document;
import model.Livre;

public class Afficheur extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6737888159021371280L;
	private Bibliotheque bibliotheque;
	private JTextArea jta;
	private JScrollPane sjp;
	private JPanel bottom;
	private JButton affDoc, affAut, addDoc, triLexico;
	
	public Afficheur(Bibliotheque bibliotheque) throws HeadlessException {
		super();
		this.bibliotheque = bibliotheque;
		initComponents();
		setListeners();
		initSettings();
	}
	
	public void initComponents() {
		this.jta = new JTextArea();
		this.sjp = new JScrollPane(jta);
		this.bottom = new JPanel();
		this.affDoc = new JButton("Afficher Livres");
		this.affAut = new JButton("Afficher Auteurs");
		this.triLexico = new JButton("Tri Lexicographique");
		this.addDoc = new JButton("Ajouter");
		
		this.bottom.setLayout(new FlowLayout(SwingConstants.CENTER,25,5));
		this.bottom.add(affDoc);
		this.bottom.add(affAut);
		this.bottom.add(triLexico);
		this.bottom.add(addDoc);
		this.add(sjp, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
	}
	
	public void initSettings() {
		this.setTitle("Afficheur bibliotheque");
		this.setLocation(400,250);
		this.setSize(600, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void setListeners() {
		//Action pour le bouton afficherDocument
		affDoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Afficheur.this.afficherDocuments(bibliotheque.getDocuments());
			}
		});
		
		//Action pour le bouton afficherAuteur
		affAut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Afficheur.this.afficherAuteurs(bibliotheque.getDocuments());
			}
		});
		
		//Action pour le bouton triLexicographique
		triLexico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Afficheur.this.bibliotheque.triLexico();
				Afficheur.this.afficherDocuments(bibliotheque.getDocuments());
			}
		});
		
		//Action pour le bouton addDocument
		addDoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SaisieLivre(bibliotheque);
			}
		});
	}
	
	public void afficherDocuments(Collection<Document> docs) {
		jta.append("LIVRES:\n\n");
		for (Document doc : docs) {
			jta.append(doc.toString());
		}
		jta.append("\n");
		this.setVisible(true);
	}
	
	public void afficherAuteurs(Collection<Document> docs) {
		jta.append("AUTEURS:\n\n");
		List<Livre> avecAuteurs = new ArrayList<Livre>();
		for (Document doc : docs) {
			if (doc instanceof Livre) {
				avecAuteurs.add((Livre) doc);
			}
		}
		
		Collections.sort(avecAuteurs, Livre.TRI_AUTEUR);
		List<String> auteurs = new ArrayList<String>();
		
		for (Document doc : avecAuteurs) {
			if (!auteurs.contains(((Livre) doc).getAuteur())) {
				auteurs.add(((Livre) doc).getAuteur());
			}
		}
		
		for (String auteur : auteurs) {
			jta.append(auteur + "\n");
		}
		jta.append("\n");
		this.setVisible(true);
	}
}
