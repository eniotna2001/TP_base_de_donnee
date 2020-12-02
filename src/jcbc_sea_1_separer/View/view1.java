package jcbc_sea_1_separer.View;

import java.sql.ResultSet;
import java.sql.SQLException;

public class view1 {
    public static void exo_A_aff (ResultSet result_menage, ResultSet result_electro){
        try{
        System.out.println("Les produits Electroménagers sont : ");
           while (result_menage.next()){
               String nom_menage = result_menage.getString("nom_prod");
               System.out.println("nom : "+nom_menage);
           }
           
           System.out.println("\n\nLes produits Electroniques sont : ");
           while (result_electro.next()){
               String nom_electro = result_electro.getString("nom_prod");
               System.out.println("nom : "+nom_electro);
           }
           
           System.out.println("\n\n");
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
	}
    }
    
    public static void exo_B_aff (ResultSet result_lim){
        try{
        System.out.println("Les produits ayant atteind leur limite sont : \nnom\t\t\tquantite\t\t\tlimite");
          while (result_lim.next()){
              String nom_lim = result_lim.getString("nom_prod");
              String quantite = result_lim.getString("qte_stock");
              String limite = result_lim.getString("st_sec");
              System.out.println(nom_lim+"\t\t\t"+quantite+"\t\t\t"+limite);
          }
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
	}
    }
    
    public static void exo_C_aff (String nom_categorie, ResultSet result_produit){
        try{
            int verif=0;
            System.out.println("\n\nArticle présent dans la catégorie " + nom_categorie);
              while (result_produit.next()){
                  System.out.println(result_produit.getString("nom_prod"));
                  verif++;
              }
              if (verif==0){
                  System.out.println("Il n'y a aucun produit dans cette catégorie");
              }
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
	}
    }
    
    public static void exo_D_aff (ResultSet result_produit_D){
        try{
        System.out.println("\n\nLes articles présent dans les entrepot 10 ou 25 ayant leur prix untaire supérieur à 55 sont : \nnom\t\t\tprix unitaire\t\tentrepot");
          while (result_produit_D.next()){
              String nom = result_produit_D.getString("nom_prod");
              String prix_uni = result_produit_D.getString("pu_prod");
              String entrepot = result_produit_D.getString("n_entrp");
              System.out.println(nom+"\t\t\t"+prix_uni+"\t\t\t"+entrepot);
          }
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
	}
    }
}
