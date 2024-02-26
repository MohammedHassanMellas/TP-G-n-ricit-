import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

       MetierProduitImpl metierProduit = new MetierProduitImpl(new ArrayList<>());

        metierProduit.add(new Produit(1, "Mac", "Bock", 2000, "new", 20));
        metierProduit.add(new Produit(2, "Asus", "I9", 3000, "new", 3));
        metierProduit.add(new Produit(3, "HP", "5200", 1000, "new", 2));
        metierProduit.add(new Produit(4, "Dell", "1LD", 1500, "new", 9));

        Scanner input = new Scanner(System.in);

        int userChoice;

        double num;

        do {
            System.out.println("Entre number");
            num = input.nextInt();

            userChoice = displayMenu(input);

            switch (userChoice) {
                case 1:
                    System.out.println("la liste des produits est : " );
                    List<Produit> ListProduits = metierProduit.getAll();
                    for (Produit produit: ListProduits){
                        System.out.println(produit);
                    }
                    break;
                case 2:
                    System.out.println("Entre son id :) ");
                    input.nextLine();
                    System.out.println(metierProduit.findById(input.nextLong()));
                    break;
                case 3:
                    System.out.println("Veuillez saisir le nouveau produit : ");
                    metierProduit.add(new Produit(input.nextLong(),input.next(),input.next(),input.nextInt(),input.next(),input.nextInt()));
                    System.out.println("le produit a été ajouter");
                    List<Produit> Produits = metierProduit.getAll();
                    for (Produit produit:Produits){
                        System.out.println(produit);
                    }
                    break;
                case 4:
                    System.out.println("Supprimer un produit par id !");
                    metierProduit.delete(input.nextLong());
                    System.out.println("le produit à été supprimé!");
                    List<Produit> Produit = metierProduit.getAll();
                    for (Produit p:Produit)
                        System.out.println(p);
                    break;
                case 5:
                    System.out.println(" Quitter ce programme.!");
                    break;
                default:
                    System.out.println("Wrong entry: Enter a value between 1-6");
                    break;
            }
        } while (userChoice != 6) ;
    }
    public static int displayMenu(Scanner input)
    {
        System.out.println("Make a selection ");
        System.out.println("-----------------");
        System.out.println("| 1) Afficher la liste des produits.");
        System.out.println("| 2) Rechercher un produit dans la liste.");
        System.out.println("| 3) Ajouter un nouveau produit dans la liste.");
        System.out.println("| 4) Supprimer un produit par id.");
        System.out.println("| 5) Quitter ce programme.");
        System.out.println("----------------");

        return input.nextInt();
    }
}
