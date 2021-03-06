import java.util.Vector;

import javax.swing.JOptionPane;

public class Zutat {

	
	private int anzahl;
	private String einheit;
	private String zutatenName;
	
	
	/**
	 * 
	 * @param anz die Anzahl der Zutat zb. 500
	 * @param einh die Einheit zb. gramm
	 * @param name der Name der Zutat zb. Mehl
	 */
	public Zutat(int anz,String einh, String name){
		setAnzahl(anz);
		setEinheit(einh);
		setZutatenName(name);
		
	}
	
	public Zutat(String content) throws Exception{
		try {
			String[] v = content.split(",");
			
			Integer.parseInt(v[0]);
			
			
			setAnzahl(Integer.parseInt(v[0]));
			setEinheit(v[1]);
			setZutatenName(v[2]);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			
			throw new Exception();
		}
		
	}

	public String getAsString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getAnzahl() + ",");
		sb.append(getEinheit() + ",");
		sb.append(getZutatenName());
		
		return sb.toString();
	}
	
	public int getAnzahl() {
		return anzahl;
	}
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	public String getEinheit() {
		return einheit;
	}
	public void setEinheit(String einheit) {
		this.einheit = einheit;
	}
	public String getZutatenName() {
		return zutatenName;
	}
	public void setZutatenName(String zutatenName) {
		this.zutatenName = zutatenName;
	}
	
}
