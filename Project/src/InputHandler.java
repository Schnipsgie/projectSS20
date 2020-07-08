import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;


public class InputHandler implements ActionListener{
	
	InputForm inputFormElement;
	TableMainForm mainForm;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand() == "Add") {
			System.out.println("Add Button wurde gedrückt");
			InputForm InpForm = new InputForm(4);
		}
		else if(event.getActionCommand() == "Hinzufügen") {
			
			Vector<String> zutaten = new Vector<String>();
	
			for (JTextField zutatenTextField : this.inputFormElement.getZutaten()) {
				zutaten.add(zutatenTextField.getText());		
			}
						
			Rezept newRezept = new Rezept(this.inputFormElement.getRezName().getText(), zutaten);
	
		}
		else if (event.getActionCommand() == "Tabelle neu Laden") {
			System.out.println("Reloading Main Frame");
			mainForm.reload();
		}
		else if (event.getActionCommand() == "Remove") {
			//System.out.println(mainForm.getTable().getValueAt(mainForm.getTable().getSelectedRow(), 0));
			
			System.out.println(mainForm.getRezeptListe().get(mainForm.getTable().getSelectedRow()));
			
		}
		
	
	}

	
	public InputHandler(InputForm inp) {
	
		this.inputFormElement = inp;
	
	}
	
	public InputHandler(TableMainForm mainForm) {
		
		 this.mainForm = mainForm;
		
	}
	
	public InputHandler() {}	
	
}

