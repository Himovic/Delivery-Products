package Models;

public class CommandeInfo {
	
        private int id;
	private String nomProduit;
	private String nomSupermarche;
	private int Quantite;
	private double prix;
	private double prixTot;
	
	public CommandeInfo() {
		
	}

	public CommandeInfo(String nomProduit, String nomSupermarche, int quantite, double prix, double prixTot) {
		super();
		this.nomProduit = nomProduit;
		this.nomSupermarche = nomSupermarche;
		Quantite = quantite;
		this.prix = prix;
		this.prixTot = prixTot;
	}
        
        public CommandeInfo(int id,String nomProduit, int quantite, double prix, double prixTot) {
		super();
                this.id = id;
		this.nomProduit = nomProduit;
		Quantite = quantite;
		this.prix = prix;
		this.prixTot = prixTot;
	}
        
	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getNomSupermarche() {
		return nomSupermarche;
	}

	public void setNomSupermarche(String nomSupermarche) {
		this.nomSupermarche = nomSupermarche;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getPrixTot() {
		return prixTot;
	}

	public void setPrixTot(double prixTot) {
		this.prixTot = prixTot;
	}
        
        
        
	@Override
	public String toString() {
		return "CommandeInfo [nomProduit=" + nomProduit + ", nomSupermarche=" + nomSupermarche + ", Quantite="
				+ Quantite + ", prix=" + prix + ", prixTot=" + prixTot + "]";
	}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
	
	
}
