import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		ArrayList<Salarie> listeConcepteur = new ArrayList<Salarie>();
		ArrayList<Salarie> listeAnalyste = new ArrayList<Salarie>();
		menu(listeConcepteur, listeAnalyste);
	}
	
	public static void menu(ArrayList<Salarie> listeConcepteur, ArrayList<Salarie> listeAnalyste) {
		
		Scanner sc = new Scanner(System.in);
		Print.printMenu();

		boolean existing = false;
		while (existing == false) {
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				createConcepteur(listeConcepteur, listeAnalyste, sc);
				existing = true;
				break;
			case 2:
				deleteConcepteur(listeConcepteur);
				existing = true;
				break;
			case 3:
				afficheConcepteur(listeConcepteur);
				existing = true;
				break;
			case 4:
				createAnalyste(listeAnalyste, listeConcepteur, sc);
				existing = true;
				break;
			case 5:
				deleteAnalyste(listeAnalyste);
				existing = true;
				break;
			case 6:
				afficheAnalyste(listeAnalyste);
				existing = true;
				break;
			case 7:
				afficherSalariesTries(listeConcepteur, listeAnalyste);
				existing = true;
				break;
			default:
				System.out.println("Choix incorrect");
			}
			menu(listeConcepteur, listeAnalyste);
		}
	}
	
	public static ArrayList<Salarie> createConcepteur (ArrayList<Salarie> listeConcepteur, ArrayList<Salarie> listeAnalyste, Scanner sc) {        
	    Map mapInfoConcepteur = Print.printConcepteur();
	    int code = (int) mapInfoConcepteur.get("code");
	    
	    ArrayList<Salarie> listeSalarie = new ArrayList<Salarie>(listeConcepteur);
	    listeSalarie.addAll(listeAnalyste);
	    
	    while(true) {
	        boolean codeExiste = false;
	        for(Salarie salarie : listeSalarie) {
	            if(salarie.getCode() == code) {
	                codeExiste = true;
	                System.out.println("Erreur : Le code saisi existe déjà pour un autre salarié !");
	                System.out.println("Veuillez saisir un nouveau code: ");
	                code = sc.nextInt();
	                break;
	            }
	        }
	        if(!codeExiste) {
	            String nom = (String) mapInfoConcepteur.get("nom");
	            String prenom = (String) mapInfoConcepteur.get("prenom");
	            Date dateEmbauche = (Date) mapInfoConcepteur.get("dateEmbauche");
	            int nbrAnneeDev = (int) mapInfoConcepteur.get("nbrAnneeDev");
	            Concepteur concepteur = new Concepteur(code, nom, prenom, dateEmbauche, nbrAnneeDev);
	            listeConcepteur.add(concepteur);
	            Print.back();
	            return listeSalarie;                
	        }       
	    }
	}

	
	public static void afficheConcepteur(ArrayList<Salarie> listeConcepteur) {
		Print.printListeConcepteur(listeConcepteur);
		Print.back();
	}
	
	
	public static ArrayList<Salarie> createAnalyste (ArrayList<Salarie> listeAnalyste, ArrayList<Salarie> listeConcepteur, Scanner sc) {		
		Map mapInfoAnalyste = Print.printAnalyste();
		int code = (int) mapInfoAnalyste.get("code");
		
		ArrayList<Salarie> listeSalarie = new ArrayList<Salarie>(listeAnalyste);
		listeSalarie.addAll(listeConcepteur);
		
		while(true) {
			boolean codeExiste = false;
			
			for(Salarie salarie : listeSalarie) {
				if(salarie.getCode() == code) {
					codeExiste = true;
					System.out.println("Erreur : Le code saisi existe déjà pour un autre salarié !");
					System.out.println("Veuillez saisir un nouveau code: ");
					code = sc.nextInt();
					break;
				}
			}
			if(!codeExiste) {
				String nom = (String) mapInfoAnalyste.get("nom");
				String prenom = (String) mapInfoAnalyste.get("prenom");
				Date dateEmbauche = (Date) mapInfoAnalyste.get("dateEmbauche");
				int nbrDeplacementClient = (int) mapInfoAnalyste.get("nbrDeplacementClient");
				Analyste analyste = new Analyste(code, nom, prenom, dateEmbauche, nbrDeplacementClient);
				listeAnalyste.add(analyste);
				Print.back();
				return listeAnalyste;				
			}
			
		}
	}
	
	public static void afficheAnalyste(ArrayList<Salarie> listeAnalyste) {
		Print.printListeAnalyste(listeAnalyste);
		Print.back();
	}
	
	public static void deleteConcepteur(ArrayList<Salarie> listeConcepteur) {
		int codeToRemove = Print.printChoiceConcepteurToRemove(listeConcepteur);
		for (int i = 0; i < listeConcepteur.size(); i++) {
			if (codeToRemove == listeConcepteur.get(i).getCode()){
				listeConcepteur.remove(listeConcepteur.get(i));
			} else {
				System.out.println("Il n'y a pas de concepteur possédant ce code !");
			}
		}
		Print.back();
	}
	
	public static void deleteAnalyste(ArrayList<Salarie> listeAnalyste) {
		int codeToRemove = Print.printChoiceAnalysteToRemove(listeAnalyste);
		for (int i = 0; i < listeAnalyste.size(); i++) {
			if (codeToRemove == listeAnalyste.get(i).getCode()){
				listeAnalyste.remove(listeAnalyste.get(i));
			} else {
				System.out.println("Il n'y a pas d'analyste possédant ce code !");
			}
		}
		Print.back();
	}
	
    public static void afficherSalariesTries(ArrayList<Salarie> listeConcepteur, ArrayList<Salarie> listeAnalyste) {
        ArrayList<Salarie> listeSalaries = new ArrayList<Salarie>(listeConcepteur);
        listeSalaries.addAll(listeAnalyste);

        Collections.sort(listeSalaries, new Comparator<Salarie>() {
          
            public int compare(Salarie s1, Salarie s2) {
                return Integer.compare(s1.getCode(), s2.getCode());
            }
        });

        Print.printAfficherSalariesTrier(listeSalaries);
        Print.back();
    }
	
    public static void compareSalarie(ArrayList<Salarie> listeConcepteur, ArrayList<Salarie> listeAnalyste) {
        ArrayList<Salarie> listeSalaries = new ArrayList<Salarie>(listeConcepteur);
        listeSalaries.addAll(listeAnalyste);
    }
}
