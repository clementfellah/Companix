import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Print {
	
	static void printMenu() {
		String menu =
				"1 - Ajouter un concepteur \r\n"
				+ "2- Supprimer un concepteur \r\n"
				+ "3- Lister les concepteurs existants \r\n"
				+ "4- Ajouter un analyste \r\n" 
				+ "5- Supprimer un analyste \r\n"
				+ "6- Lister les analystes existants \r\n"
				+ "7- Lister les salariés existants en mettant en évidence la fonction (Concepteur ou Analyste) \r\n" 
				+ "   Faites votre choix (1, 2, 3) :";
		System.out.println(menu);
	}
	
	
	static Map printConcepteur() {
		Scanner sc = new Scanner(System.in);
		
		int code = 0;
		boolean codeFormat = false;
		String nom = "";
		String prenom = "";
		Date dateEmbauche = null;
		boolean dateEmbaucheFormat = false;
		int nbrAnneeDev = 0;
		boolean nbrAnneeDevFormat = false;
		
		System.out.println("Saisir le code: ");
		while(!codeFormat) {
			try {			
				code = sc.nextInt();
				codeFormat = true;
			} catch (Exception e) {
				System.out.println("Format incorrect (nombre):");
				sc.next();
				
			}
		}
		System.out.println("Saisir le nom: ");
		nom = sc.next();			

		
		System.out.println("Saisir le prénom: ");
		prenom = sc.next();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		while (dateEmbaucheFormat == false) {
		    System.out.println("Saisir la date (JJ/MM/AAAA): ");
		    try {
		        String inputDate = sc.next();
		        dateEmbauche = dateFormat.parse(inputDate);
		        dateEmbaucheFormat = true;
		    } catch (Exception e) {
		        System.out.println("Format incorrect (JJ/MM/AAAA) :");
		        sc.next();
		    }
		}

		while(!nbrAnneeDevFormat) {			
		    System.out.println("Saisir le nombre d'année de développement: ");
		    try{
		    	nbrAnneeDev = sc.nextInt();
		    	nbrAnneeDevFormat = true;
		    }catch (Exception e) {
				System.out.println("Format incorrect (nombre):");
				sc.next();
			}
		}
		
		System.out.println("Le/la concepteur/rice "+nom+" "+prenom+" a été ajouté(e) !");
		
		Map mapInfoConcepteur = new HashMap();
		mapInfoConcepteur.put("code", code);
		mapInfoConcepteur.put("nom", nom);
		mapInfoConcepteur.put("prenom", prenom);
		mapInfoConcepteur.put("dateEmbauche", dateEmbauche);
		mapInfoConcepteur.put("nbrAnneeDev", nbrAnneeDev);
		
		return mapInfoConcepteur;
	}
	
	static Map printAnalyste() {
	    Scanner sc = new Scanner(System.in);
	    
		int code = 0;
		boolean codeFormat = false;
		String nom = "";
		String prenom = "";
		Date dateEmbauche = null;
		boolean dateEmbaucheFormat = false;
		int nbrDeplacementClient = 0;
		boolean nbrDeplacementClientFormat = false;
		
		System.out.println("Saisir le code: ");
		while(!codeFormat) {
			try {			
				code = sc.nextInt();
				codeFormat = true;
			} catch (Exception e) {
				System.out.println("Format incorrect (nombre):");
				sc.next();
				
			}
		}
		System.out.println("Saisir le nom: ");
		nom = sc.next();			

		
		System.out.println("Saisir le prénom: ");
		prenom = sc.next();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		while (dateEmbaucheFormat == false) {
		    System.out.println("Saisir la date (JJ/MM/AAAA): ");
		    try {
		        String inputDate = sc.next();
		        dateEmbauche = dateFormat.parse(inputDate);
		        dateEmbaucheFormat = true;
		    } catch (Exception e) {
		        System.out.println("Format incorrect (JJ/MM/AAAA) :");
		        sc.next();
		    }
		}

		while(!nbrDeplacementClientFormat) {			
		    System.out.println("Saisir le nombre de déplacement de client: ");
		    try{
		    	nbrDeplacementClient = sc.nextInt();
		    	nbrDeplacementClientFormat = true;
		    }catch (Exception e) {
				System.out.println("Format incorrect (nombre):");
				sc.next();
			}
		}

	    System.out.println("L'analyste " + nom + " " + prenom + " a été ajouté(e) !");

	    Map mapInfoAnalyste = new HashMap();
	    mapInfoAnalyste.put("code", code);
	    mapInfoAnalyste.put("nom", nom);
	    mapInfoAnalyste.put("prenom", prenom);
	    mapInfoAnalyste.put("dateEmbauche", dateEmbauche);
	    mapInfoAnalyste.put("nbrDeplacementClient", nbrDeplacementClient);

	    return mapInfoAnalyste;
	}

	
	static void back() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Appuyer sur n'importe quelle touche pour revenir au menu.");
		String back = sc.next();
	}
	
	static void printListeConcepteur(ArrayList<Salarie> listeConcepteur) {
		for (Salarie concepteur : listeConcepteur) {
			concepteur.afficherFonction();
			System.out.println(concepteur.toString());
		}
	}
	
	static void printListeAnalyste(ArrayList<Salarie> listeAnalyste) {
		for (Salarie analyste : listeAnalyste) {
			analyste.afficherFonction();
			System.out.println(analyste.toString());
		}
	}
	
	static int printChoiceConcepteurToRemove(ArrayList<Salarie> listeConcepteur) {
		Scanner sc = new Scanner(System.in);
		for (Salarie concepteur : listeConcepteur) {
			System.out.println(concepteur.toString());
		}
		System.out.println("Choisissez le code du salarié dont vous voulez vous séparer : ");
		int codeToRemove = sc.nextInt();
		return codeToRemove;
	}
	
	static int printChoiceAnalysteToRemove(ArrayList<Salarie> listeAnalyste) {
		Scanner sc = new Scanner(System.in);
		for (Salarie analyste : listeAnalyste) {
			System.out.println(analyste.toString());
		}
		System.out.println("Choisissez le code du salarié dont vous voulez vous séparer : ");
		int codeToRemove = sc.nextInt();
		return codeToRemove;
	}
	
	static void printAfficherSalariesTrier(ArrayList<Salarie> listeSalaries) {
		for (Salarie salarie : listeSalaries) {
            salarie.afficherFonction();
            System.out.println(salarie.toString());
        }
	}
	

	
	
}
