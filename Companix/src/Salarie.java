import java.text.SimpleDateFormat;
import java.util.Date;

public class Salarie {
	
	private int code;
	private String nom;
	private String prenom;
	private Date dateEmbauche;
	
	public Salarie(int code, String nom, String prenom, Date dateEmbauche) {
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getnom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    String dateEmbaucheFormatted = sdf.format(dateEmbauche);
		String toString = "Code : " + code + " | "
				+ "Nom : " + nom + " | "
				+ "Prénom : " + prenom + " | "
				+ "Date d'embauche : " + dateEmbaucheFormatted;
		return toString;
	}
	
	public void afficherFonction() {
		System.out.println("Fonction : Salarié");
	}
}
