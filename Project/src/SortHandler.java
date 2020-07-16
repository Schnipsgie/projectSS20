import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;


public class SortHandler implements ActionListener{
	private TableMainForm tmf;
	private Vector<String> selections;
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JComboBox comboBox = (JComboBox) event.getSource();
		String selected = comboBox.getSelectedItem().toString();
		getTmf().filter(selected);
		
	}
	
	
		
	public SortHandler(Vector<String> selection , TableMainForm tmf) {
		setSelections(selection);
		setTmf(tmf);
	
	
	}

	
	//getter & setter
	private Vector<String> getSelections() {
		return selections;
	}



	private void setSelections(Vector<String> selections) {
		this.selections = selections;
	}



	private TableMainForm getTmf() {
		return tmf;
	}



	private void setTmf(TableMainForm tmf) {
		this.tmf = tmf;
	}
		
}
