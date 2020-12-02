package jcbc_sea_1_separer.Model;

import java.util.Properties;
import java.sql.*;
import java.util.*;

public class connexion {
    
    public static Connection getConnexion(String url, Properties props){
        try {
		Class.forName("com.mysql.jdbc.Driver") ;
            }
             catch (ClassNotFoundException e){
		System.out.println("Erreur lors du chargement "+e.getMessage()) ;
            }            
        Connection connexion = null;
        try{
            connexion = DriverManager.getConnection(url,props) ;
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
	}
        return connexion;
    }
}
