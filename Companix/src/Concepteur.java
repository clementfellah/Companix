import java.util.Date;

public class Concepteur extends Salarie{

	int nbrAnneeDev;
	
	public Concepteur(int code, String nom, String prenom, Date dateEmbauche, int nbrAnneeDev) {
		super(code, nom, prenom, dateEmbauche);
		this.nbrAnneeDev = nbrAnneeDev;
	}	
	
	public int getNbrAnneeDev() {
		return nbrAnneeDev;
	}

	public void setNbrAnneeDev(int nbrAnneeDev) {
		this.nbrAnneeDev = nbrAnneeDev;
	}
	
	@Override public String toString() {
	
		return super.toString() + " | "
				+ "Nombre d'année de développement : " + nbrAnneeDev;
	}
	
	@Override public void afficherFonction() {
		System.out.println("Fonction : Concepteur");
	}


}

