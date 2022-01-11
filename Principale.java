/**
 * Classe principale de la SAE 1.02
 * @author Etienne Andre
 * @since 2021-11-04
 *
 */


public class Principale{
	
	/**
	 * Exemple d'utilisation de LectureFichier et remplissage d'une liste
	 * @author Etienne Andre
	 */
	public static void remplir_liste(ListeTriee liste, String nom_fichier){
		LectureFichier lf = new LectureFichier(nom_fichier);
// 		
		String[] liste_noms = lf.lireFichier();
		for (String s : liste_noms) {
			liste.adjlisT(s);
		}
	}
	
	public static void main(String [] args){
		System.out.println("Bienvenue !");

		// TODO!
		
		

	}
}
