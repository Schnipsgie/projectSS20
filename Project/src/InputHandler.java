import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

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
			
			Vector<String> zutaten = new Vector<String>();
	
			for (JTextField zutatenTextField : this.inputFormElement.getZutaten()) {
				zutaten.add(zutatenTextField.getText());		
			}
						
			Rezept newRezept = new Rezept(this.inputFormElement.getRezName().getText(), zutaten);
			
			getMainForm().generateRezeptliste();
			getMainForm().reload();
			
			
			
	
		}
		else if (event.getActionCommand() == "Tabelle neu Laden") {
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

