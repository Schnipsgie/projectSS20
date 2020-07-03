import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class main {

	public static void main(String[] args) {

		Vector<Rezept> rezeptListe = new Vector<Rezept>();
		
//		Vector<String> zuVec = new Vector<String>();
//		zuVec.addElement("Eier");
//		zuVec.addElement("Salat");
//		Rezept r = new Rezept("Eiersalat", zuVec);
		
		//initial Loading
		FileHandler FH = new FileHandler();

		Vector<String> rezeptDataList = FH.readFile();
		for (String rezeptData : rezeptDataList) {
			//System.out.println(rezeptLine);
			Rezept currentRezept =  new Rezept(rezeptData);
			rezeptListe.add(currentRezept);
		}
			
		
//Sollte in eine extra Klasse
		//Hauptfester erstellen
		JFrame fenster = new JFrame("Rezepte");
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programm wird beendet wenn es geschlossen wird
		fenster.setSize(600, 250);
		GridLayout gridlayout = new GridLayout(2, 1); //Layout festlegen
	    gridlayout.setVgap(10); // Abstand zwischen den Grids
	    fenster.setLayout(gridlayout); //Grid zum Hauptfenster hinzufügen
      
        
        //Basisliste an rezepten
 
        Vector<Vector> tableData = new Vector<Vector>();
        
        //einzelne Spalte
        for (Rezept currentRezept : rezeptListe) {
        	Vector<String> baseList = new Vector<>(); 
        	baseList.add(currentRezept.getRezeptName());
        	baseList.addAll(currentRezept.getZutaten());
        	tableData.addElement(baseList);
        }
        
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Rezeptname");
        columnNames.addElement("Column 2");
        columnNames.addElement("Column 3");
        columnNames.addElement("Column 4");
        columnNames.addElement("Column 5");
        columnNames.addElement("Column 6");
       
        JPanel controlPanel = new JPanel();
        
        
        JButton addButton = new JButton("Add");
        addButton.setSize(30, 30);
        controlPanel.add(addButton);
        
        JTable table = new JTable (tableData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        fenster.add(scrollPane);
        fenster.add(controlPanel);
    
     
        fenster.setVisible(true);
        
	}

}
