public class ListeChainee implements Liste{
    MaillonEntier[] tab;

    int tete;

    public ListeChainee(int taille) {
        if (taille > 0) {
			this.tab = new MaillonEntier[taille];
			for (int i = 0; i < taille; i++) {
				this.tab[i] = new MaillonEntier(null, -2);
			}
			this.tete = -1;
        }
    }

    /**
	 * permet de supprimer un element d'une liste
	 * @param p place de l'element a supprimer 
	 */
    public void suplis(int p) {
		if (p >= 0 && p < this.tab.length) {
			if (p == tete()) {
				this.tete = suc(p);
			} else {
				int t = tete();
				while (suc(t) != p) {
					t = suc(t);
				}
				if (finliste(suc(p))) {
					this.tab[t].setSuc(-1);
				} else {
					this.tab[t].setSuc(suc(p));
				}
			}
			libererPlace(p);
		}
    }
	
	/**
	 * ajoute un element en tete de Liste
	 * @param s Element a ajouter en tete
	 */
	public void adjtlis(String s) {
		int place = retournerPlaceLibre();
        this.tab[place].setVal(s);
		if (tete() < 0) {
			this.tab[place].setSuc(-1);
		} else {
			this.tab[place].setSuc(tete());
		}
		this.tete = place;
    }
	
	/**
	 * ajoute un element a un endroit quelconque dans la liste
	 * @param p place apres laquelle inserer
	 * @param s element a inserer
	 */
	public void adjlis(int p, String s) {
		if (p >= 0 && p < this.tab.length-1) {
			int place = retournerPlaceLibre();
			if (finliste(suc(p))) { // la place p est le dernier element
				this.tab[place].setSuc(-1);
			} else {
				this.tab[place].setSuc(suc(p));
			}
			this.tab[p].setSuc(place);
			this.tab[place].setVal(s);
		}
    }
	
	/**
	 * permet de savoir si on se trouve en fin de liste
	 * @param p place ou on se trouve
	 * @return true si et seuelement si p est fin de liste
	 */
	public boolean finliste(int p) {
		if (p < 0) {
			return true;
		}
        return false;
    }

    /**
	 * retourne la premiere place de la liste
	 * @return tete de liste
	 */
	public int tete() {
        return this.tete;
    }
	
	/**
	 * permet de connaitre la place suivante dans la liste
	 * @param p place en cours
	 * @return place derriere p dans la liste
	 */
	public int suc(int p) {
		int suc = -1;
		if (p >= 0 && p < this.tab.length) {
        	suc = this.tab[p].getSuc();
		}
		return suc;
    }
	
	/**
	 * retourne la valeur associee a la place p
	 * @param p place de la liste
	 * @return la valeur associee a p
	 */
	public String val(int p) {
		String val = null;
		if (p >= 0 && p < this.tab.length) {
			val = this.tab[p].getVal();
		}
		return val;
    }

    public int retournerPlaceLibre() {
		int placeLibre = -1;
        for (int i = 0; i < this.tab.length; i++) {
			if (this.tab[i].getSuc() == -2) {
				placeLibre = i;
				break;
			}
		}
		return placeLibre;
    }

    public void libererPlace(int p) {
		if (p >= 0 && p < this.tab.length) {
			this.tab[p].setVal(null);
			this.tab[p].setSuc(-2);
		}
    }
}
