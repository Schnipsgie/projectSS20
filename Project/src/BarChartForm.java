import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class BarChartForm extends JFrame {
	
	private HashMap<String, Integer> rezeptListe;

	int v = 0;
	

	private class MyPanel extends JPanel {
		public MyPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension (600, 500));
		
			
		}
		
	private void paintBar(Graphics g , String rezName , int value) {
		super.paintComponents(g);
	
		g.setColor(Color.DARK_GRAY);
		g.fill3DRect(0, v , value, 30 , true);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", Font.BOLD, 13));
		g.drawString(rezName, 10 , 20+v);
		v = 35+v;
		
	}		
	
	protected void paintComponent (Graphics g) {
		v = 0;
		
		for (String zut : getRezeptListe().keySet()) {
			
			paintBar(g, zut + " ( " + getRezeptListe().get(zut) + " ) ", getRezeptListe().get(zut)*100);
			
		}
		
	}	

	}
	
	public BarChartForm(HashMap<String, Integer> rezListe) {
		super("BarChart");
		setRezeptListe(rezListe);
		
		
		JProgressBar meinLadebalken = new JProgressBar(0, 100);
		meinLadebalken.setValue(30);
		this.add(meinLadebalken);
		
		add(new MyPanel());
		pack();
		setVisible(true);
		setLocation(500, 500);
	}
		

	public HashMap<String, Integer> getRezeptListe() {
		return rezeptListe;
	}


	private void setRezeptListe(HashMap<String, Integer> rezeptListe) {
		this.rezeptListe = rezeptListe;
	}

		
}
	
    
