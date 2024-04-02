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
public class Agent extends Contact{
    Connexion conn = new Connexion();
    Connection connect;
    PreparedStatement pstmt;
    
    
    private double salaire;
    private String statut;
    private String categorie;
    private int indiceSalaire;
    private String occupation;

    public Agent(int code, String nom, Date dateNaissance, String address, String email, int telNumber, double salaire, String statut, String categorie, int indiceSalaire, String occupation) {
        super(code, nom, dateNaissance, address, email, telNumber);
        this.salaire = salaire;
        this.statut = statut;
        this.categorie = categorie;
        this.indiceSalaire = indiceSalaire;
        this.occupation = occupation;
    }

    public Agent(int code, String nom, Date dateNaissance, String address, String email, int telNumber) {
        super(code, nom, dateNaissance, address, email, telNumber);
    }
    

    public double getSalaire(){
        return salaire;
    }
    
    public void setSalaire(double salaire){
        this.salaire=salaire;
    }
    
      public String getStatut(){
        return statut;
    }
    
    public void setStatut(String statut){
        this.statut=statut;
    }
    
      public String getCategorie(){
        return categorie;
    }
    
    public void setCategorie(String categorie){
        this.categorie=categorie;
    }
    
      public int getIndiceSalaire(){
        return indiceSalaire;
    }
    
    public void setIndiceSalaire(int indiceSalaire){
        this.indiceSalaire=indiceSalaire;
    }
    
      public String getOccupation(){
        return occupation;
    }
    
    public void setOccupation(String occupation){
        this.occupation=occupation;
    }

    @Override
    public void insertbd() throws SQLException {
             String query = "INSERT INTO Agent (Code, Nom, Date_naissance, Address, Email,TelNumber,Salaire,Statut,Categorie,IndiceSalaire,Occupation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
             
        try {

            connect=conn.GetConnection();
            pstmt = connect.prepareStatement(query);
             
           pstmt.setInt(1, this.getCode());
             pstmt.setString(2, this.getNom());
             pstmt.setDate(3, (java.sql.Date) this.getDateNaissance());
             pstmt.setString(4, this.getAddress());
             pstmt.setString(5, this.getEmail());
           
             pstmt.setInt(6, this.getTelNumber());
             pstmt.setDouble(7, this.getSalaire());
             pstmt.setString(8, this.getStatut());
             pstmt.setString(9, this.getCategorie());
             pstmt.setInt(10, this.getIndiceSalaire());
             pstmt.setString(11, this.getOccupation());
            
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

