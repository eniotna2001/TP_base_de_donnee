package jcbc_sea_1_separer.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class repository {
    public static ResultSet demande_simple(Connection conn, String req){
        ResultSet result = null;
        try{
           Statement cat = null;
           cat = (Statement) conn.createStatement() ;
           result = cat.executeQuery(req);
           return result;
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
	}
        return result;
    }
    
    public static ResultSet demande_var(Connection conn, String req, String var1){
        ResultSet result = null;
        try{
            PreparedStatement produit = conn.prepareStatement(req);
            produit.setString(1, var1);
            result = produit.executeQuery();
            return result;
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
	}
        return result;
    }
}
