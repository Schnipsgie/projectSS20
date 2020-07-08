import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TableMainForm {
	private JFrame fenster;
	private JTable table;
	private Vector<Rezept> rezeptListe;
	
	public void saveChanges() {
		
		FileHandler FH =  new FileHandler();
		FH.createNewFile(getRezeptListe());
		
		
	}
	
	
	public void generateTable(Vector<Rezept> rezeptListe) {
		
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
	        table.setSelectionMode( ListSelectionModel.SINGLE_SELECTION  );
	        table.setRowSelectionAllowed(true);
	        table.setColumnSelectionAllowed(false);
	        
	        setTable(table);
		
	}
	
	public TableMainForm(Vector<Rezept> rezeptListe) {
				InputHandler IH = new InputHandler(this);
				setRezeptListe(rezeptListe);
	
		//Hauptfester erstellen
				fenster = new JFrame("Rezepte");
				fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programm wird beendet wenn es geschlossen wird
				fenster.setSize(600, 250);
				//Menü
				JMenuBar menuLeiste = new JMenuBar();
				JMenu menuOptionBearbeiten = new JMenu("Bearbeiten");
				JMenu menuOptionStatistik = new JMenu("Statistik");
				JMenuItem menuItemAdd = new JMenuItem("Add");
				JMenuItem menuItemRemove = new JMenuItem("Remove");
				JMenuItem menuItemReload = new JMenuItem("Tabelle neu Laden");
				menuItemAdd.addActionListener(IH);
				menuItemRemove.addActionListener(IH);
				menuItemReload.addActionListener(IH);
				
				menuOptionBearbeiten.add(menuItemAdd);
				menuOptionBearbeiten.add(menuItemRemove);
				menuOptionBearbeiten.add(menuItemReload);
			    menuLeiste.add(menuOptionBearbeiten);
			    menuLeiste.add(menuOptionStatistik);
		        fenster.setJMenuBar(menuLeiste);

		        generateTable(rezeptListe);
		        
		        JScrollPane scrollPane = new JScrollPane(getTable());
		        fenster.add(scrollPane);
		       
		        fenster.setVisible(true);
	
	
	}
	

	
	
	public void reload() {
	
		getFenster().invalidate();
		getFenster().validate();
		getFenster().repaint();
		getFenster().setVisible(true);
	}

	private JFrame getFenster() {
		return fenster;
	}

	private void setFenster(JFrame fenster) {
		this.fenster = fenster;
	}

	private void setTable(JTable table) {
		this.table = table;
	}

	protected JTable getTable() {
		return table;
	}

	Vector<Rezept> getRezeptListe() {
		return rezeptListe;
	}

	void setRezeptListe(Vector<Rezept> rezeptListe) {
		this.rezeptListe = rezeptListe;
	}
}
