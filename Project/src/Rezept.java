import java.util.Arrays;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
/**
 * Rezept Object
 * 
 * @author John Doe
 *
 */
public class Rezept {
	
	private String rezeptName;
	private String text;
	private Vector<Zutat> zutaten;
	
	public String getRezeptName() {
		return rezeptName;
	}

	public void setRezeptName(String rezeptName) {
		this.rezeptName = rezeptName;
	}

	public Vector<Zutat> getZutaten() {
		return zutaten;
	}

	public void setZutaten(Vector<Zutat> zutaten) {
		this.zutaten = zutaten;
	}

	
	public Vector<String> getAllZuatatenAsString() {
		
		Vector<String> s =  new Vector<String>();
		for (Zutat z : getZutaten()) {
			s.add(z.getAsString());
		}
		
		return s;
		
	}
	
	public int getAnzZutaten() {
		return zutaten.size();
	}
	
	protected Rezept(String line) {
		try {
			String[] s = line.split(Pattern.quote( ";" ));
			
			Vector<String> ve = new Vector<String>(Arrays.asList(s));
			//name setzen
			if (ve.get(0) != null) {
				setRezeptName(ve.get(0));
				ve.remove(0);
			}
			// beschreibung setzen
			if (ve.get(0) != null) {
				setText(ve.get(0));
				ve.remove(0);	
			}
			Vector<Zutat> zutatenVector = new Vector<Zutat>();
			for (String cont : ve) {
					String[] zua = cont.split(Pattern.quote( "," ));
					Vector<String> splitZutat = new Vector<String>(Arrays.asList(zua));
					
					if (splitZutat.size() == 3) {
						Zutat zu = new Zutat(Integer.parseInt(splitZutat.get(0)), splitZutat.get(1), splitZutat.get(2));
						zutatenVector.add(zu);
					}
				
			}
			setZutaten(zutatenVector);
		} catch (Exception e) {
			System.out.println();
			
		}
	}
	
	public Rezept(String rname, String betext  , Vector<Zutat> zutaten) {
		setRezeptName(rname);
		setText(betext);
		setZutaten(zutaten);
		
		FileHandler FH = new FileHandler();
		
		StringBuilder stringBuilder = new StringBuilder();
		for (Zutat zutat : zutaten) {
			stringBuilder.append(zutat.getAsString() + ";");
		}
		String content = rname + ";" + betext + ";" + stringBuilder.toString();		
		FH.writeFile(content);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
