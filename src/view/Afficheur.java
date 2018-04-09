package view;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Bibliotheque;
import model.Document;

public class Afficheur extends JFrame {
	
	private JTextArea jta;
	private JScrollPane sjp;
	private Bibliotheque bibliotheque;
	
	public Afficheur(Bibliotheque bibliotheque) throws HeadlessException {
		super();
		setBibliotheque(bibliotheque);
		initComponents();
		addLivres();
		initSettings();
	}
	
	public void initComponents() {
		this.jta = new JTextArea();
		this.sjp = new JScrollPane(jta);
		this.add(sjp);
	}
	
	public void initSettings() {
		this.setTitle("Afficheur bibliotheque");
		this.setLocation(400,250);
		this.setSize(600, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}
	
	public void addLivres() {
		for (Document doc : this.bibliotheque.getDocuments()) {
			jta.append(doc.toString() + "\n");
		}
	}
}
