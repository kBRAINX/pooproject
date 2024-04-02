/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author brayanne
 */
public class Connexion {
     private Connection conn;
    
    

    public Connection GetConnection(){
        try{ //toujours dans un block try pour gerer les erreurs connection a la base de données 
        Class.forName("com.mysql.cj.jdbc.Driver") ;//importation de notre driver  
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3300/projetpoo?useSSL=true","root",""); 
       
        return conn;        
        } 
    catch(Exception e){ 
            System.err.print(e); //nous affichons l'erreur s’il y en as 
    }   
       return null;
    }
}