import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class main {

	public static void main(String[] args) {

		Vector<Rezept> rezeptListe = new Vector<Rezept>();
		
		Vector<String> zuVec = new Vector<String>();
		zuVec.addElement("Eier");
		zuVec.addElement("Salat");
		Rezept r = new Rezept("Eiersalat", zuVec);
		
		//initial Loading
		FileHandler FH = new FileHandler();
//		FH.writeFile("Kuchen ; Eier ; Mehl ; Zucker");
//		FH.writeFile("Pizza ; Mehl ; Salz ; Schinken ; Salami ");
//		FH.writeFile("Spiegelei ; Eier ; Öl ; Salz");
		Vector<String> rezeptDataList = FH.readFile();
		for (String rezeptData : rezeptDataList) {
			//System.out.println(rezeptLine);
			Rezept currentRezept =  new Rezept(rezeptData);
			rezeptListe.add(currentRezept);
		}
			
		
//Sollte in eine extra Klasse
		JFrame fenster = new JFrame("Rezepte");
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(600, 250);
       
      
        
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
       
        
        
        JTable table = new JTable (tableData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        fenster.add(scrollPane, BorderLayout.CENTER);
        fenster.setVisible(true);
        
	}

}
