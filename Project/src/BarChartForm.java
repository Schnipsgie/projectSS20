import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BarChartForm extends JFrame {
	


	private int x1 = 50;            	// x - Startwert
	private int y1 = 300;           	// y - Startpunkt
	private int breite = 30;        	// Säulenbreite
	private int y2 = 150;          		// y - Wert
	int anzahl = 3;				        // Anzahl Zutaten
	int v = 100;                        // x - Verschiebung
	int k = 200;					   // x - Verschiebung Zutaten
	
	
	
	
	private class MyPanel extends JPanel {
		public MyPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension (1000, 500));
		
			
		}
	
	protected void paintComponent (Graphics g) {
		
		if (anzahl >= 1) {
		super.paintComponents(g);
		g.setColor(Color.red);
		g.fillRoundRect(x1, y1, breite, y2, 30,30);
		g.setColor(Color.black);
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		g.drawString("Zutat Nr. 1!", 0, 475);
		}
		
		
		if(anzahl > 1) {
		super.paintComponents(g);
		g.setColor(Color.red);
		g.fillRoundRect(x1+k, y1, breite, y2, 30,30);
		g.setColor(Color.black);
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		g.drawString("Zutat Nr. 2!",2*v, 475);	
		
		}
		
		if(anzahl > 2) {
		super.paintComponents(g);
		g.setColor(Color.red);
		g.fillRoundRect(x1+2*k, y1, breite, y2, 30,30);
		g.setColor(Color.black);
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		g.drawString("Zutat Nr. 3!",4*v, 475);	
		}	
	
	
		if(anzahl > 3) {
		super.paintComponents(g);
		g.setColor(Color.red);
		g.fillRoundRect(x1+3*k, y1, breite, y2, 30,30);
		g.setColor(Color.black);
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		g.drawString("Zutat Nr. 4!", 6*v, 475);	
		}	
		
		if(anzahl > 4) {
		super.paintComponents(g);
		g.setColor(Color.red);
		g.fillRoundRect(x1+4*k, y1, breite, y2, 30,30);
		g.setColor(Color.black);
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		g.drawString("Zutat Nr. 5!", 8*v, 475);	
		}	
	
		}
	
	 	}
	
	
	public BarChartForm() {
		super("BarChart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		pack();
		setVisible(true);
		setLocation(500, 500);
		
		
		
		
	 }
	
	public static void main(String[] args) {
		new BarChartForm();
	 }
		
	
    }
