import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.JTextField;




public class InputHandler implements ActionListener{
	
	InputForm inputFormElement;
	private TableMainForm mainForm;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "Add") {
			InputForm InpForm = new InputForm(4, getMainForm());
		}
		else if(event.getActionCommand() == "Hinzufügen") {
			
			Vector<Zutat> zutaten = new Vector<Zutat>();
	
			for (Vector<JTextField> zutatenTextField : this.inputFormElement.getZutaten()) {
	
				int i = 0;
				try {
					i = Integer.parseInt(zutatenTextField.get(0).getText());
					Zutat zu = new Zutat(i , zutatenTextField.get(1).getText(), zutatenTextField.get(2).getText());
					zutaten.add(zu);
				} catch (NumberFormatException e) {}
		
			}
						
			Rezept newRezept = new Rezept(this.inputFormElement.getRezName().getText(), this.inputFormElement.getRezText().getText(), zutaten);
		
			getMainForm().generateRezeptliste();
			getMainForm().reload();
			
			
			
			
		}
		else if (event.getActionCommand() == "Diagramm") {
			
			HashMap<String, Integer> unsortetMap = new HashMap<String, Integer>();
			Vector<Rezept> rezVect  = getMainForm().getRezeptListe();
			
			for (Rezept reZ :  rezVect) {
				for (Zutat zut :  reZ.getZutaten()) {
					
					if (!unsortetMap.containsKey(zut.getZutatenName())) {
						unsortetMap.put(zut.getZutatenName(), 1);
						System.out.println(zut.getZutatenName());
					}
					else {
						int i = unsortetMap.get(zut.getZutatenName());
						unsortetMap.replace(zut.getZutatenName(), ++i);
						
					}
				}
				
			}
			HashMap<String, Integer> result = unsortetMap.entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))// reverse order fï¿½r desc.
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
							LinkedHashMap::new));
			
			BarChartForm barChart =  new BarChartForm(result);
			
			
		}
		else if (event.getActionCommand() == "Tabelle neu Laden") {
			int row = getMainForm().getTable().getSelectedRow();
			int column = getMainForm().getTable().getSelectedColumn();
			
			//System.out.println(getMainForm().getTable().getValueAt(row, column));
			
			getMainForm().save();
			getMainForm().reload();
		}
		else if (event.getActionCommand() == "Remove") {
			
			FileHandler FH = new FileHandler();

			getMainForm().getRezeptListe().remove(getMainForm().getRezeptListe().get(getMainForm().getTable().getSelectedRow()));
			
			System.out.println(getMainForm().getRezeptListe().toString());
			getMainForm().saveChanges();
			getMainForm().reload();
			
		}
		else if (event.getActionCommand() == "Sortieren") {
			
			SortForm SF = new SortForm(getMainForm());
			
		}
		
	}

	
	public InputHandler(InputForm inp , TableMainForm mainForm) {
		this.setMainForm(mainForm);
		this.inputFormElement = inp;
		
	
	}
	
	public InputHandler(TableMainForm mainForm) {
		
		 this.setMainForm(mainForm);
		
	}
	
	public InputHandler() {}


	public TableMainForm getMainForm() {
		return mainForm;
	}


	private void setMainForm(TableMainForm mainForm) {
		this.mainForm = mainForm;
	}	
	
}

