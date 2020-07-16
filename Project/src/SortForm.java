import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SortForm extends JFrame {

	private TableMainForm tmf;

	public SortForm() {
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public SortForm(TableMainForm tmf) {
		setTmf(tmf);

		this.setSize(300, 100);
		
		JPanel sortPannel = new JPanel();
		JLabel sortText = new JLabel("Sortieren nach : ");
		Vector<String> availZutaten = new Vector<String>();
		Vector<Rezept> rezVect  = getTmf().getRezeptListe();
		
		for (Rezept reZ :  rezVect) {
			for (String zut :  reZ.getZutaten()) {
				if (availZutaten.indexOf(zut) == -1) {
					availZutaten.add(zut); 
				}
			}
			
		}
		SortHandler sh = new SortHandler(availZutaten, tmf);
		
		JComboBox sortComboBox = new JComboBox(availZutaten);
		sortComboBox.addActionListener(sh);
		sortPannel.add(sortText);
		sortPannel.add(sortComboBox);

		sortPannel.setVisible(true);
		this.add(sortPannel);
		this.setVisible(true);
	}

	private TableMainForm getTmf() {
		return tmf;
	}

	private void setTmf(TableMainForm tmf) {
		this.tmf = tmf;
	}

	
}
