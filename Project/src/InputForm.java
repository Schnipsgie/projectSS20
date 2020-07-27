import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class InputForm {
	
	private JTextField rezName;
	private JTextField rezText;
	private Vector<Vector<JTextField>> zutaten = new Vector<>();

	
 public void openInputForm(int zutCount, TableMainForm tmf) {
	 
	 
	 InputHandler IH = new InputHandler(this , tmf);
	 JFrame InputFenster = new JFrame("Neues Rezept hinzufügen");
	 InputFenster.setSize(600, 250);
	 GridLayout gridlayout = new GridLayout(2, 1 , 40 , 0); //Layout festlegen
	 InputFenster.setLayout(gridlayout); //Grid zum Hauptfenster hinzufügen
	    
	 
	 
	 //submit Button
	 JButton submitRez = new JButton("Hinzufügen");
	 submitRez.addActionListener(IH);
	 
	 //Pannels
	 JPanel header = new JPanel(); 
	 JPanel panelName = new JPanel(); 
	 JPanel panelText = new JPanel(); 
	 JPanel panelsub = new JPanel(); 
	 JPanel panelZut = new JPanel(); 
	 
	 //Labels
	 JLabel labelRezName = new JLabel("Rezeptname");
	 JLabel labelRezText = new JLabel("Beschreibung");
	 JLabel labelZutaten = new JLabel("Zutaten");
	 labelZutaten.setHorizontalAlignment(JLabel.CENTER);
	 
	 //Input Felder
	 setRezName(new JTextField(32)); 
	 setRezText(new JTextField(32));
	
	 for (int j = 0; j <= zutCount; j++) {
		 
		Vector<JTextField> inputZutat = new Vector<JTextField>();

		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false); //verhindert das als tausendermarkierung ein punkt gesetzt wird, sonst: Exeption beim Intparsen		
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setAllowsInvalid(false);//erlaubt nur Zahlen, ansonsten: Exeption beim Intparsen
		JFormattedTextField anzahlZutat = new JFormattedTextField(formatter); 
		anzahlZutat.setPreferredSize(new Dimension( 30, 20 ));

		
		JTextField zutatenName = new JTextField(32);
		JTextField einheitZutat = new JTextField(3);
		
		inputZutat.add(anzahlZutat);
		inputZutat.add(einheitZutat);
		inputZutat.add(zutatenName);
		setZutaten(inputZutat);	
	 }
	 //Layout für Zutatenpennel
	 int zc = zutCount;
	 GridLayout panellayout = new GridLayout(--zc, 1); //Layout festlegen
	 gridlayout.setVgap(20); // Abstand zwischen den Grids
	 panelZut.setLayout(panellayout); //Grid zum Hauptfenster hinzufügen
	 
	 //Alles zu den Pannels hinzufügen
	 
	 panelName.add(labelRezName);
	 panelName.add(getRezName());
	 panelText.add(labelRezText);
	 panelText.add(getRezText());
	 panelsub.add(submitRez);
	 header.add(panelName);
	 header.add(panelText);
	 header.add(panelsub);
	 
	 panelZut.add(labelZutaten);
	 
	 
	 for (Vector<JTextField> jtfVector : getZutaten()) {
		 JPanel jtfPannel = new JPanel();
		 
		 for (JTextField jtf : jtfVector) {
			 jtfPannel.add(jtf);
		 }
		 
		 panelZut.add(jtfPannel);
	 }
	
	 //Pannels zum Fenster hinzufügen
	 InputFenster.add(header);
	 InputFenster.add(panelZut);
	 InputFenster.setVisible(true);
	 
	 
	 
 }
 
 
 
 public InputForm(int count , TableMainForm tmf) {
	 openInputForm (count, tmf); 
 }


JTextField getRezName() {
	return rezName;
}



void setRezName(JTextField rezName) {
	this.rezName = rezName;
}



Vector<Vector<JTextField>> getZutaten() {
	return zutaten;
}



void setZutaten(Vector<JTextField> zutat) {
	this.zutaten.addElement(zutat);;
}



public JTextField getRezText() {
	return rezText;
}



public void setRezText(JTextField rezText) {
	this.rezText = rezText;
}


}
