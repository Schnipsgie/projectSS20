import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
	
	
	/**
	 * Saves the "Vector<Rezept> rezeptListe"
	 * 
	 */
	
	public void saveChanges() {
		
		FileHandler FH =  new FileHandler();
		FH.createNewFile(getRezeptListe());
		
		
	}
	
	/**
	 * 
	 * 
	 * converts the Jtable with the current (and / or modified data) to "Vector<Rezept> rezeptListe"
	 * 
	 * 
	 */
	public void save() {
		
		int columnCount = table.getModel().getColumnCount();
		int rowCount = table.getModel().getRowCount();
		
		
		Vector<Rezept> newRezList = new Vector<Rezept>();
		
		for (int i = 0; i < rowCount; i++) {
			Vector<Zutat> neuZutaten = new Vector<Zutat>();
			for (int j = 2; j < columnCount; ++j) {
				
				if (table.getModel().getValueAt(i, j) != null) {
					if(!table.getModel().getValueAt(i, j).equals("")) {
						
						Zutat z;
						try {
							z = new Zutat(table.getModel().getValueAt(i, j).toString());
							neuZutaten.add(z);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Error : " + table.getModel().getValueAt(i, j).toString() + " hat nicht das Richtige Format");
						}
						
					}
				}
			}
			Rezept re = new Rezept(table.getValueAt(i, 0).toString() ,table.getValueAt(i, 1).toString(), neuZutaten);
			System.out.println(table.getValueAt(i, 0).toString());
			newRezList.add(re);
			
		}
		setRezeptListe(newRezList);
		saveChanges();
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
	        	baseList.add(currentRezept.getText());
	        	baseList.addAll(currentRezept.getAllZuatatenAsString());
	        	tableData.addElement(baseList);
	        }
	        
	        Vector<String> columnNames = new Vector<String>();
	        columnNames.addElement("Rezeptname");
	        columnNames.addElement("Beschreibung");
	        columnNames.addElement("Zutat 1");
	        columnNames.addElement("Zutat 2");
	        columnNames.addElement("Zutat 3");
	        columnNames.addElement("Zutat 4");
	        columnNames.addElement("Zutat 5");
	       
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
				
				JMenuItem menuItemDiagramm = new JMenuItem("Diagramm");
				
				JMenuItem menuItemAdd = new JMenuItem("Add");
				JMenuItem menuItemRemove = new JMenuItem("Remove");
				JMenuItem menuItemReload = new JMenuItem("Tabelle neu Laden");
				JMenuItem menuItemSort = new JMenuItem("Sortieren");
				
				menuItemAdd.addActionListener(IH);
				menuItemRemove.addActionListener(IH);
				menuItemReload.addActionListener(IH);
				menuItemSort.addActionListener(IH);
				
				menuItemDiagramm.addActionListener(IH);
				
				menuOptionStatistik.add(menuItemDiagramm);
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
