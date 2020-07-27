import java.util.Vector;

import javax.swing.text.TabExpander;

//Requirements:
//
//DONE	1)Der Benutzer soll neue Objekte anlegen k�nnen.
//		2)Objekte sollen anhand des Namens eindeutig identifizierbar sein.
//		3)Objekte sollen folgende Bestandteile besitzen: eindeutiger Name,Freitext und eine beliebige Anzahl an Elementen mit Mengenangabe, Einheit und Bezeichnung.
//DONE?	4)Der Benutzer soll Objekte anhand der Bestandteile suchen k�nnen.
//DONE	5)Der Benutzer soll Objekte l�schen k�nnen.
//		6)Der Benutzer soll Objekte bearbeiten k�nnen.
//		7)Der Benutzer soll ein Objekt ausw�hlen k�nnen,um diesesanzuzeigen.
//DONE	8)Die Anwendung soll eine �bersichtsliste aller Objekte anzeigen.
//DONE	9)Die Anwendung soll beim Start automatisch alle gespeicherten Daten laden.
//		10)Die Anwendung soll eine grafische �bersicht �ber die nach Menge absteigend sortierten Elementen ausgeben k�nnen.
//			Bei gro�er Anzahl unterschiedlicherElemente sollen nur die h�ufigstenangezeigt werden. 
//			Dies soll in Form eines Balkendiagramms geschehen.

public class main {

	public static void main(String[] args) {
		
	initialLoading();
        
	}

	
	public static void initialLoading(){
		Vector<Rezept> rezeptListe = new Vector<Rezept>();

		//initial Loading
		FileHandler FH = new FileHandler();
		

		Vector<String> rezeptDataList = FH.readFile();
		for (String rezeptData : rezeptDataList) {
			
			Rezept currentRezept =  new Rezept(rezeptData);
			rezeptListe.add(currentRezept);
		}
			
		
		TableMainForm tableMainForm = new TableMainForm(rezeptListe);
		}
	
	
	

}
