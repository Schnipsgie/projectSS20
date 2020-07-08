import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputForm {
	
	private JTextField rezName;
	private Vector<JTextField> zutaten = new Vector<JTextField>();
	
 public void openInputForm(int zutCount) {
	 
	 
	 InputHandler IH = new InputHandler(this);
	 JFrame InputFenster = new JFrame("Neues Rezept hinzuf�gen");
	 InputFenster.setSize(600, 250);
	 GridLayout gridlayout = new GridLayout(2, 1 , 40 , 0); //Layout festlegen
	 InputFenster.setLayout(gridlayout); //Grid zum Hauptfenster hinzuf�gen
	    
	 
	 
	 //submit Button
	 JButton submitRez = new JButton("Hinzuf�gen");
	 submitRez.addActionListener(IH);
	 
	 //Pannels
	 JPanel panelName = new JPanel(); 
	 JPanel panelZut = new JPanel(); 
	 
	 //Labels
	 JLabel labelRezName = new JLabel("Rezeptname");
	 JLabel labelZutaten = new JLabel("Zutaten");
	 labelZutaten.setHorizontalAlignment(JLabel.CENTER);
	 
	 //Input Felder
	 setRezName(new JTextField(32)); 
	
	 for (int j = 0; j <= zutCount; j++) {
	  setZutaten(new JTextField(32));	
	 }
	 //Layout f�r Zutatenpennel
	 int zc = zutCount;
	 GridLayout panellayout = new GridLayout(--zc, 1); //Layout festlegen
	 gridlayout.setVgap(20); // Abstand zwischen den Grids
	 panelZut.setLayout(panellayout); //Grid zum Hauptfenster hinzuf�gen
	 
	 //Alles zu den Pannels hinzuf�gen
	 panelName.add(labelRezName);
	 panelName.add(getRezName());
	 panelName.add(submitRez);
	 panelZut.add(labelZutaten);
	 
	 for (int j = 0; j <= zutCount; j++) {
		 panelZut.add(getZutaten().elementAt(j));	
	}
	 
	
	 //Pannels zum Fenster hinzuf�gen
	 InputFenster.add(panelName);
	 InputFenster.add(panelZut);
	 InputFenster.setVisible(true);
	 
	 
	 
 }
 
 
 
 public InputForm(int count) {
	 openInputForm (count); 
 }



JTextField getRezName() {
	return rezName;
}



void setRezName(JTextField rezName) {
	this.rezName = rezName;
}



Vector<JTextField> getZutaten() {
	return zutaten;
}



void setZutaten(JTextField zutat) {
	this.zutaten.addElement(zutat);;
}

}
