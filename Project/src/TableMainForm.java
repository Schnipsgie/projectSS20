import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class TableMainForm extends JFrame{
	private JFrame fenster;
	private JTable table;
	private JScrollPane scrollPane;
	private Vector<Rezept> rezeptListe;
	private TableRowSorter<TableModel> sorter;
	
	public void saveChanges() {
		
		FileHandler FH =  new FileHandler();
		FH.createNewFile(getRezeptListe());
		
		
	}
	
	
	public void filter(String filter) {
		
		 getSorter().setRowFilter(RowFilter.regexFilter(filter));

		
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
	       
	        TableModel model = new DefaultTableModel(tableData, columnNames);
	        JTable table = new JTable (model);
	        setSorter(new TableRowSorter<TableModel>(model));
	        table.setRowSorter(getSorter());
	       
	        
	        table.setSelectionMode( ListSelectionModel.SINGLE_SELECTION  );
	        table.setRowSelectionAllowed(true);
	        table.setColumnSelectionAllowed(false);
	        
	        setTable(table);
		
	}
	
	public TableMainForm(Vector<Rezept> rezeptListe) {
				InputHandler IH = new InputHandler(this);
				setRezeptListe(rezeptListe);
	
		//Hauptfester erstellen
				setFenster(new JFrame("Rezepte"));
				getFenster().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programm wird beendet wenn es geschlossen wird
				getFenster().setSize(600, 250);
				//Menü
				JMenuBar menuLeiste = new JMenuBar();
				JMenu menuOptionBearbeiten = new JMenu("Bearbeiten");
				
				JMenu menuOptionStatistik = new JMenu("Statistik");
				JMenuItem menuItemAdd = new JMenuItem("Add");
				JMenuItem menuItemRemove = new JMenuItem("Remove");
				JMenuItem menuItemReload = new JMenuItem("Tabelle neu Laden");
				JMenuItem menuItemSort = new JMenuItem("Sortieren");
				menuItemAdd.addActionListener(IH);
				menuItemRemove.addActionListener(IH);
				menuItemReload.addActionListener(IH);
				menuItemSort.addActionListener(IH);
				
				menuOptionBearbeiten.add(menuItemAdd);
				menuOptionBearbeiten.add(menuItemRemove);
				menuOptionBearbeiten.add(menuItemReload);
				menuOptionBearbeiten.add(menuItemSort);
			    menuLeiste.add(menuOptionBearbeiten);
			    menuLeiste.add(menuOptionStatistik);
			    getFenster().setJMenuBar(menuLeiste);

		        generateTable(rezeptListe);
		        
		        JScrollPane scrollPane = new JScrollPane(getTable());
		        getFenster().add(scrollPane);
		        setScrollPane(scrollPane);
		        getFenster().setVisible(true);
	
	
	}
	

	public void generateRezeptliste() {
		Vector<Rezept> rezeptListe = new Vector<Rezept>();

		//initial Loading
		FileHandler FH = new FileHandler();
		

		Vector<String> rezeptDataList = FH.readFile();
		for (String rezeptData : rezeptDataList) {
			System.out.println(rezeptData);
			Rezept currentRezept =  new Rezept(rezeptData);
			rezeptListe.add(currentRezept);
		}
		
		setRezeptListe(rezeptListe);
		
	}
	
	public void reload() {
		System.out.println("reload");
		generateTable(getRezeptListe());
		
		getFenster().remove(getScrollPane());
		
		JScrollPane scrollPane = new JScrollPane(getTable());
	    getFenster().add(scrollPane);
	    setScrollPane(scrollPane);
		
		getFenster().repaint();
        getFenster().revalidate();
        getFenster().validate();
	
		
	}

	private JFrame getFenster() {
		return fenster;
	}

	private void setFenster(JFrame fenster) {
		this.fenster = fenster;
	}

	private void setTable(JTable table) {
		this.table = table;
		System.out.println("tabelle gesetzt");
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


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	private TableRowSorter<TableModel> getSorter() {
		return sorter;
	}


	private void setSorter(TableRowSorter<TableModel> sorter) {
		this.sorter = sorter;
	}
}
