import java.util.Arrays;
import java.util.Vector;
import java.util.regex.Pattern;
/**
 * Rezept Object
 * 
 * @author John Doe
 *
 */
public class Rezept {
	
	private String rezeptName;
	private Vector<String> zutaten;
	
	public String getRezeptName() {
		return rezeptName;
	}

	public void setRezeptName(String rezeptName) {
		this.rezeptName = rezeptName;
	}

	public Vector<String> getZutaten() {
		return zutaten;
	}

	public void setZutaten(Vector<String> zutaten) {
		this.zutaten = zutaten;
	}

	
	protected Rezept(String line) {
		String[] s = line.split(Pattern.quote( ";" ));
		
		Vector<String> ve = new Vector<String>(Arrays.asList(s));
		
		setRezeptName(ve.get(0));
		ve.remove(0);
	    setZutaten(ve);
		System.out.println(getRezeptName());
		for (String z : zutaten) {
			System.out.print(z);
		}
		System.out.println("\n");
	}
	
	public Rezept(String rname , Vector<String> zutaten) {
		setRezeptName(rname);
		setZutaten(zutaten);
		
		FileHandler FH = new FileHandler();
		
		StringBuilder stringBuilder = new StringBuilder();
		for (String zutat : zutaten) {
			stringBuilder.append(zutat + " ; ");
		}
		String content = rname + " ; " + stringBuilder.toString();		
		FH.writeFile(content);
	}
	
}
