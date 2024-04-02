/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author brayanne
 */
public class Enseignant extends Contact {
 
    private String statut;
    Connexion conn = new Connexion();
    Connection connect;
    PreparedStatement pstmt;

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    public Enseignant(int code, String nom, Date dateNaissance, String address, String email, int telNumber, String statut) {
        super(code, nom, dateNaissance, address, email, telNumber);
        this.statut = statut;
    }
    
    public Enseignant(int code, String nom, Date dateNaissance, String address, String email, int telNumber) {
        super(code, nom, dateNaissance, address, email, telNumber); 
    }
    
    @Override
    public void insertbd() throws SQLException {
        String query = "INSERT INTO Enseignant (Code ,Nom, Date_naissance, Address, Email,TelNumber, Statut) VALUES ( ?,?, ?, ?, ?, ?, ?)";
        try  {
            
             connect=conn.GetConnection();
             pstmt = connect.prepareStatement(query);
            
            pstmt.setInt(1, this.getCode());
            pstmt.setString(2, this.getNom());
            pstmt.setDate(3, (java.sql.Date) this.getDateNaissance());
            pstmt.setString(4, this.getAddress());
            pstmt.setString(5, this.getEmail());
            // Set other parameters...
            pstmt.setInt(6, this.getTelNumber());
            pstmt.setString(7, this.getStatut());
            
            pstmt.executeUpdate();
            System.out.println(" ");
            JOptionPane.showMessageDialog(null,"operation effectuer avec succes");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"erreur d'execution");
        }

    }

}
