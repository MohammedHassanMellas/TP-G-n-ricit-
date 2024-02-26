import java.util.List;

public class MetierProduitImpl implements  IMetier<Produit, Long> {
   private List<Produit> produits;

    public MetierProduitImpl(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public void add(Produit o) {
     produits.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(Long id) {
        for (Produit p:produits){
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Produit produit= this.findById(id);
        if (produit != null)
            produits.remove(produit);
    }
}
