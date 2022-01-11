

public class ListeContigue implements Liste {

    private String[] tab;
    private int nbElements;
 
    public ListeContigue( int tailleTab){
        this.tab=new String[tailleTab];
        this.nbElements=0;
    }
    

    /**
	 * permet de supprimer un element d'une liste
	 * @param p place de l'element  supprimer 
	 */
    public void suplis(int p){
        for (int i = p; i < tab.length-1; i++) {
            this.tab[i]=this.tab[i+1];
        }
        nbElements--;
    }
	
	/**
	 * ajoute un element en tete de Liste
	 * @param s Element a ajouter en tete
	 */
	public void adjtlis(String s){
        for (int i = this.tab.length-1; i >0; i--) {
            this.tab[i]=this.tab[i-1];
        }
        this.tab[0]=s;
        nbElements++;
    }
	
	/**
	 * ajoute un element a un endroit quelconque dans la liste
	 * @param p place apres laquelle inserer
	 * @param s element a inserer
	 */
	public void adjlis(int p, String s){
        for (int i = this.tab.length-1; i >p+1; i--) {
            this.tab[i]=this.tab[i-1];
        }
        this.tab[p+1]=s;
        nbElements++;
    }
	
	/**
	 * permet de savoir si on se trouve en fin de liste
	 * @param p place ou on se trouve
	 * @return true si et seuelement si p est fin de liste
	 */
	public boolean finliste(int p){
        boolean fin=(nbElements==p);
        return fin;
        
    }
	
	/**
	 * retourne la premiere place de la liste
	 * @return tete de liste
	 */
	public int tete(){
        return 0;

    }
	
	/**
	 * permet de connaitre la place suivante dans la liste
	 * @param p place en cours
	 * @return place derriere p dans la liste
	 */
	public int suc(int p){
        int suc=p+1;
        if( finliste(p)){
            suc=-1;
        }
        return suc;

    }
	
	/**
	 * retourne la valeur associee a la place p
	 * @param p place de la liste
	 * @return la valeur associee a p
	 */
	public String val(int p){
        return this.tab[p];

    }
    public String toString(){
        String s="";
        for (int i = 0; i < nbElements-1; i++) {
            s+=this.tab[i]+"\n"; 
            
        }
        return s;
    }

}