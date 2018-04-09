package view;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Bibliotheque;
import model.Document;
import model.Roman;

public class SaisieLivre extends JFrame {
	
	private Bibliotheque bbth;
	private GridBagConstraints gbc;
	private Font font;
	private JLabel lbTitre, lbAuteur, lbNbPage, lbPrix;
	private JTextField tfTitre, tfAuteur, tfNbPage;
	private JButton jbValider;
	private JPanel jp;
	private JRadioButton prixChoix[];
	private ButtonGroup prixGroup;
	private Box box;
	private String prixTitle[] = {"Aucun","Goncourt","Medicis","Interallie"};
	
	public SaisieLivre(Bibliotheque bbth) throws HeadlessException {
		super();
		this.bbth = bbth;
		initComponents();
		setListeners();
		initSettings();
	}
	
	public void initComponents() {
		jp = new JPanel();
		font = new Font("Consolas", Font.BOLD, 18);
		lbTitre = new JLabel("Titre : ");
		lbAuteur = new JLabel("Auteur : ");
		lbNbPage = new JLabel("NB pages : ");
		lbPrix = new JLabel("Prix litteraire : ");
		tfTitre = new JTextField(5);
		tfAuteur = new JTextField(5);
		tfNbPage = new JTextField(5);
		jbValider = new JButton("Valider");
		
		box = Box.createHorizontalBox();
		prixChoix = new JRadioButton[4];
		prixGroup = new ButtonGroup();
		for (int i = 0; i < prixChoix.length; i++) {
			prixChoix[i] = new JRadioButton(prixTitle[i]);
			prixGroup.add(prixChoix[i]);
			box.add(prixChoix[i]);
		}
		prixChoix[0].setSelected(true);
		
		jp.setLayout(new GridBagLayout());
		lbTitre.setFont(font);
		lbAuteur.setFont(font);
		lbNbPage.setFont(font);
		lbPrix.setFont(font);
		
		addComponent(jp, lbTitre, 0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE);
		addComponent(jp, tfTitre, 1, 0, 3, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addComponent(jp, lbAuteur, 0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(jp, tfAuteur, 1, 1, 3, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addComponent(jp, lbNbPage, 0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(jp, tfNbPage, 1, 2, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(jp, lbPrix, 0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(jp, box, 1, 3, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
		addComponent(jp, jbValider, 1, 4, 10, 10, 0, 0, GridBagConstraints.LAST_LINE_END, GridBagConstraints.NONE);
		
		this.add(jp);
	}
	
	private void addComponent(Container con, JComponent comp, int xPos, int yPos,
			int compWidth, int compHeight, int ipadx, int ipady, int anchor, int fill) {
		gbc = new GridBagConstraints();
		gbc.gridx = xPos;
		gbc.gridy = yPos;
		gbc.gridwidth = compWidth;
		gbc.gridheight = compHeight;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.ipadx = ipadx;
		gbc.ipady = ipady;
		gbc.insets = new Insets(15, 12, 15, 12);
		gbc.anchor = anchor;
		gbc.fill = fill;
		con.add(comp, gbc);
	}
	
	public void initSettings() {
		this.setTitle("Saisie document");
		this.setLocation(400,250);
		this.setSize(550, 350);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
		
	public void setListeners() {
		jbValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!tfAuteur.getText().isEmpty() &&
						!tfTitre.getText().isEmpty() &&
						!tfNbPage.getText().isEmpty()){
					
					Document roman = null;
					String auteur = tfAuteur.getText();
					String titre = tfTitre.getText();
					int nbPage = 0;
					int prixLitt = 0;
					
					try {
						nbPage = Integer.parseInt(tfNbPage.getText());
						for (JRadioButton jbr : prixChoix) {
							if (jbr.isSelected()) {
								switch (jbr.getText().toUpperCase()) {
								case "AUCUN" :
									prixLitt = 0;
									break;
								case "GONCOURT" :
									prixLitt = 1;
									break;
								case "MEDICIS" :
									prixLitt = 2;
									break;
								case "INTERALLIE" :
									prixLitt = 3;
									break;
								}
							}
						}

						roman = new Roman(titre, auteur, nbPage, prixLitt);
						System.out.println(roman);
						if (bbth.addDocument(roman)) {
							new DialogNotif("Ajout avec success !");
							SaisieLivre.this.dispose();
						}
						
					} catch (Exception e) {
						new DialogNotif("Erreur ! Veuillez saisir un entier pour le nombre de page !");
					}
				}
				else {
					new DialogNotif("Erreur ! Veuillez saisir tous les champs necessaire !");
				}
			}
		});
	}
}
