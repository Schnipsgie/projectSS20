import java.util.Vector;

import javax.swing.text.TabExpander;

//Requirements:
//
//DONE	1)Der Benutzer soll neue Objekte anlegen können.
//		2)Objekte sollen anhand des Namens eindeutig identifizierbar sein.
//		3)Objekte sollen folgende Bestandteile besitzen: eindeutiger Name,Freitext und eine beliebige Anzahl an Elementen mit Mengenangabe, Einheit und Bezeichnung.
//DONE?	4)Der Benutzer soll Objekte anhand der Bestandteile suchen können.
//DONE	5)Der Benutzer soll Objekte löschen können.
//		6)Der Benutzer soll Objekte bearbeiten können.
//		7)Der Benutzer soll ein Objekt auswählen können,um diesesanzuzeigen.
//DONE	8)Die Anwendung soll eine Übersichtsliste aller Objekte anzeigen.
//DONE	9)Die Anwendung soll beim Start automatisch alle gespeicherten Daten laden.
//		10)Die Anwendung soll eine grafische Übersicht über die nach Menge absteigend sortierten Elementen ausgeben können.
//			Bei großer Anzahl unterschiedlicherElemente sollen nur die häufigstenangezeigt werden. 
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
