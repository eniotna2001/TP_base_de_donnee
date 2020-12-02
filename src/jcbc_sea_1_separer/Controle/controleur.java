package jcbc_sea_1_separer.Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import jcbc_sea_1_separer.Model.*;
import jcbc_sea_1_separer.View.*;

public class controleur {
    
    void start() throws SQLException{        
        Connection conn=null;
            Properties props = new Properties();
            props.setProperty("user","root");
            props.setProperty("password","");      
            String url = "jdbc:mysql://localhost:3306/stock";
            conn = connexion.getConnexion(url, props);
            
            
           // EXERCICE A        
           ResultSet result_menage = null, result_electro = null;
           String req_menage ="SELECT nom_prod FROM produit WHERE n_cat=1";
           String req_electro ="SELECT nom_prod FROM produit WHERE n_cat=2";
           result_menage = repository.demande_simple(conn, req_menage);
           result_electro = repository.demande_simple(conn, req_electro);
           view1.exo_A_aff(result_menage,result_electro);
         
          //EXERCICE B
          ResultSet result_lim = null;
          String req_lim = "SELECT nom_prod,qte_stock,st_sec FROM `produit` WHERE qte_stock<=st_sec";
          result_lim = repository.demande_simple(conn, req_lim);
          view1.exo_B_aff(result_lim);
          
          //EXERCICE C
          ResultSet result_all_cat=null;         
          String req_categorie = "SELECT * FROM categorie";
          result_all_cat = repository.demande_simple(conn, req_categorie);         
          while (result_all_cat.next()){
              String nb_categorie = result_all_cat.getString("n_cat");
              String nom_categorie = result_all_cat.getString("nom_cat");
              ResultSet result_produit = null;
                       
              String req_produit = ("SELECT nom_prod FROM produit WHERE n_cat=?");           
              result_produit = repository.demande_var(conn,req_produit, nb_categorie);
              
              view1.exo_C_aff(nom_categorie,result_produit);
          }
          
          //EXERCICE D    
          ResultSet result_produit_D = null;
          
          String req_produit_D = ("SELECT * FROM produit WHERE (n_entrp=10 OR n_entrp=25) AND pu_prod>=55 ");
          result_produit_D = repository.demande_simple(conn,req_produit_D);
          
          view1.exo_D_aff(result_produit_D);           
    }
}
