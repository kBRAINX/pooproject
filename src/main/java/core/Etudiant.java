/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author brayanne
 */
public class Etudiant extends Contact {

    private int niveau;
    Connexion conn = new Connexion();
     Connection connect;
    PreparedStatement pstmt;
    
    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
    private String cycle;

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    public Etudiant(int code, String nom, Date dateNaissance, String address, String email, int telNumber, String cycle, int niveau) {
        super(code, nom, dateNaissance, address, email, telNumber);
        this.cycle = cycle;
        this.niveau = niveau;
    }
    
    public Etudiant(int code, String nom, Date dateNaissance, String address, String email, int telNumber) {
        super(code, nom, dateNaissance, address, email, telNumber);
        
    }

    @Override
    public void insertbd() throws SQLException {
         
      String query = "INSERT INTO Etudiant(Code,Nom, Date_naissance, Address, Email,TelNumber, Cycle, Niveau) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
            pstmt.setString(7, this.getCycle());
            pstmt.setInt(8, this.getNiveau());
           
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
