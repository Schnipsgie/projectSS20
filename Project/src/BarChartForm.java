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
	
	private Vector<Rezept> rezeptListe;

       

	private int yVers=0;				   // y - Verschiebung
	int v = 0;
	
	
	
	private class MyPanel extends JPanel {
		public MyPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension (600, 500));
		
			
		}
		
	private void paintBar(Graphics g , String rezName , int value) {
		super.paintComponents(g);
		
		//setyVers(getyVers());
		g.setColor(Color.DARK_GRAY);
		g.fill3DRect(0, v , value, 30 , true);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", Font.BOLD, 13));
		g.drawString(rezName, 10 , 20+v);
		v = 35+v;
		
	}	
		
		
	
	protected void paintComponent (Graphics g) {
		v = 0;
		HashMap<String, Integer> availZutaten = new HashMap<String, Integer>();
		Vector<Rezept> rezVect  = getRezeptListe();
		
		for (Rezept reZ :  rezVect) {
			for (Zutat zut :  reZ.getZutaten()) {
				
				if (!availZutaten.containsKey(zut.getZutatenName())) {
					availZutaten.put(zut.getZutatenName(), 1);
					System.out.println(zut.getZutatenName());
				}
				else {
					int i = availZutaten.get(zut.getZutatenName());
					availZutaten.replace(zut.getZutatenName(), ++i);
					
				}
			}
			
		}
		
		for (String zut : availZutaten.keySet()) {
			
			paintBar(g, zut + " ( " + availZutaten.get(zut) + " ) ", availZutaten.get(zut)*100);
			
			
		}
		
	}	
		
		
//		
//		if(anzahl > 1) {
//		super.paintComponents(g);
//		g.setColor(Color.red);
//		g.fillRoundRect(x1+k, y1, breite, y2, 30,30);
//		g.setColor(Color.black);
//		g.setFont(new Font("Monospaced", Font.BOLD, 20));
//		g.drawString("Zutat Nr. 2!",2*v, 475);	
//		
//		}
//		
//		if(anzahl > 2) {
//		super.paintComponents(g);
//		g.setColor(Color.red);
//		g.fillRoundRect(x1+2*k, y1, breite, y2, 30,30);
//		g.setColor(Color.black);
//		g.setFont(new Font("Monospaced", Font.BOLD, 20));
//		g.drawString("Zutat Nr. 3!",4*v, 475);	
//		}	
//	
//	
//		if(anzahl > 3) {
//		super.paintComponents(g);
//		g.setColor(Color.red);
//		g.fillRoundRect(x1+3*k, y1, breite, y2, 30,30);
//		g.setColor(Color.black);
//		g.setFont(new Font("Monospaced", Font.BOLD, 20));
//		g.drawString("Zutat Nr. 4!", 6*v, 475);	
//		}	
//		
//		if(anzahl > 4) {
//		super.paintComponents(g);
//		g.setColor(Color.red);
//		g.fillRoundRect(x1+4*k, y1, breite, y2, 30,30);
//		g.setColor(Color.black);
//		g.setFont(new Font("Monospaced", Font.BOLD, 20));
//		g.drawString("Zutat Nr. 5!", 8*v, 475);	
//		}	
//	
//		}
	
	 	
	}
	
	public BarChartForm(Vector<Rezept> rezListe) {
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
		

	public Vector<Rezept> getRezeptListe() {
		return rezeptListe;
	}


	private void setRezeptListe(Vector<Rezept> rezeptListe) {
		this.rezeptListe = rezeptListe;
	}


	private int getyVers() {
		return yVers;
	}


	private void setyVers(int yVers) {
		this.yVers = yVers;
	}

		
}
	
    
