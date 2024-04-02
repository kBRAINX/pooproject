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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.CreateContact;

/**
 *
 * @author brayanne
 */
public class Repertoire {
    Connexion conn = new Connexion();
    Connection connect;
    Statement stat;
    ResultSet res;
    PreparedStatement pstmt;
    private List<Contact> contacts;

    public Repertoire() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public void deleteContact(int code ,String type) {
        if(type.equals("Etudiant")){

            try {
                // requete de suppression
                String sql = "DELETE FROM Etudiant WHERE Code = ?";
                connect = conn.GetConnection();
                pstmt = connect.prepareStatement(sql);
                pstmt.setInt(1, code);
                pstmt.executeUpdate();
                pstmt.close();

                System.out.println("suppression effectuer avec succes");
                JOptionPane.showMessageDialog(null, "suppression effectuer avec succes");
            } catch (SQLException e) {
                System.out.println("erreur lors de la suppression du contact : " + e.getMessage());
                JOptionPane.showMessageDialog(null, "erreur lors de la supression");
            }
        }else if(type.equals("Enseignant")){
            try {
                String sql = "DELETE FROM Enseignat WHERE Code = ?";
                connect = conn.GetConnection();
                pstmt = connect.prepareStatement(sql);
                pstmt.setInt(1, code);
                pstmt.executeUpdate();
                pstmt.close();

                System.out.println("suppression effectuer avec succes");
                    JOptionPane.showMessageDialog(null, "suppression effectuer avec succes");
            } catch (SQLException e) {
                System.out.println("erreur lors de la suppression du contact : " + e.getMessage());
                 JOptionPane.showMessageDialog(null, "erreur lors de la suppression");
            }
        }else if(type.equals("Agent")){
            try {
                String sql = "DELETE FROM Agent WHERE Code = ?";
                connect = conn.GetConnection();
                pstmt = connect.prepareStatement(sql);
                pstmt.setInt(1, code);
                pstmt.executeUpdate();
                pstmt.close();

                System.out.println("suppression effectuer avec succes");
                JOptionPane.showMessageDialog(null, "suppression effectuer avec succes");
            } catch (SQLException e) {
                System.out.println("erreur lors de la suppression du contact : " + e.getMessage());
                JOptionPane.showMessageDialog(null, "erreur lors de la suppression");
            }
        }
    }

    public void updateContact(String nom, String Adress,String Email , int code, int TEL, String Type){
        
        if(Type.equals("Etudiant")){
            String sql = "UPDATE Etudiant SET Nom=?,Address=?,email = ?,TelNumber = ? WHERE Code=?";
    
            try {
                connect=conn.GetConnection();
                pstmt=connect.prepareStatement(sql);
                pstmt.setString(1, nom);
                pstmt.setString(2, Adress);
                pstmt.setString(3, Email);
                pstmt.setInt(4, TEL);
                pstmt.setInt(5,code);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "modification effectuer avec succes");  
            } catch (Exception e) {
                e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "erreur lors de la modification");
            }
        }else if(Type.equals("Enseignant")){
            String sql2 = "UPDATE Enseignant SET Nom=?,Address=?,email = ?,TelNumber = ? WHERE Code=?";
    
            try {
                connect=conn.GetConnection();
                pstmt=connect.prepareStatement(sql2);
                pstmt.setString(1, nom);
                pstmt.setString(2, Adress);
                pstmt.setString(3, Email);
                pstmt.setInt(4, TEL);
                pstmt.setInt(5,code);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "modification effectuer avec succes");  
            } catch (Exception e) {
                e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "erreur lors de la modification");
            }
        }else if(Type.equals("Agent")){
            String sql3 = "UPDATE Agent SET Nom=?,Address=?,email = ?,TelNumber = ? WHERE Code=?";
    
            try {
                connect=conn.GetConnection();
                pstmt=connect.prepareStatement(sql3);
                pstmt.setString(1, nom);
                pstmt.setString(2, Adress);
                pstmt.setString(3, Email);
                pstmt.setInt(4, TEL);
                pstmt.setInt(5,code);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "modification effectuer avec succes");     
            } catch (Exception e) {
                e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "erreur lors de la modification");
            }
        }
    }
    
    public List<Contact> searchContact(String Nom,String Address,String Email) {
    
        List<Contact> list_recherche =new ArrayList<>();
        String sql = "SELECT Code, Nom, Date_Naissance, Address, Email, TelNumber FROM Etudiant WHERE (Nom LIKE ? OR Address LIKE ? OR Email LIKE ? )";
        try {
            connect=conn.GetConnection();
            pstmt=connect.prepareStatement(sql);
            pstmt.setString(1, Nom.isEmpty() ? Nom : Nom + "%");
            pstmt.setString(2, Address.isEmpty() ? Address : Address + "%");
            pstmt.setString(3, Email.isEmpty() ? Email : Email + "%");

            res = pstmt.executeQuery();

            while (res.next()) {
                int Code = res.getInt("Code");
                String nom = res.getString("Nom");
                String  dn = res.getString("Date_Naissance"); 
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Exemple de format AAAA-MM-JJ
                Date dateNaissance = null;
                try {
                   dateNaissance = format.parse(dn);
                } catch (ParseException ex) {
                   Logger.getLogger(CreateContact.class.getName()).log(Level.SEVERE, null, ex);
                }
                java.sql.Date sqlDateNaissance = new java.sql.Date(dateNaissance.getTime());

                Address= res.getString("Address");
                Email = res.getString("Email");
                int tel = res.getInt("TelNumber");
                Etudiant individu = new Etudiant(Code, nom, sqlDateNaissance, Address, Email, tel);
                list_recherche.add(individu);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "erreur lors de la recherche");
        }
    
        String sql2 = "SELECT Code, Nom, Date_Naissance, Address, Email, TelNumber FROM Agent WHERE (Nom LIKE ? OR Address LIKE ? OR Email LIKE ? )";
        try {
            
            connect=conn.GetConnection();
            pstmt=connect.prepareStatement(sql2);
            pstmt.setString(1, Nom.isEmpty() ? Nom : Nom + "%");
            pstmt.setString(2, Address.isEmpty() ? Address : Address + "%");
            pstmt.setString(3, Email.isEmpty() ? Email : Email + "%");

            res = pstmt.executeQuery();

            while (res.next()) {
                int Code = res.getInt("Code");
                String nom = res.getString("Nom");
                String  dn = res.getString("Date_Naissance"); SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Exemple de format AAAA-MM-JJ
                Date dateNaissance = null;
                try {
                   dateNaissance = format.parse(dn);
                } catch (ParseException ex) {
                   Logger.getLogger(CreateContact.class.getName()).log(Level.SEVERE, null, ex);
                }
                java.sql.Date sqlDateNaissance = new java.sql.Date(dateNaissance.getTime());

                Address= res.getString("Address");
                Email = res.getString("Email");
                int tel = res.getInt("TelNumber");
                Agent individu = new Agent(Code, nom, sqlDateNaissance, Address, Email, tel);
                list_recherche.add(individu);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "erreur lors de la recherche");
        }
    
        String sql3 = "SELECT Code, Nom, Date_Naissance, Address, Email, TelNumber FROM Enseignant WHERE (Nom LIKE ? OR Address LIKE ? OR Email LIKE ? )";
        try {
        
            connect=conn.GetConnection();
            pstmt=connect.prepareStatement(sql3);
            pstmt.setString(1, Nom.isEmpty() ? Nom : Nom + "%");
            pstmt.setString(2, Address.isEmpty() ? Address : Address + "%");
            pstmt.setString(3, Email.isEmpty() ? Email : Email + "%");

            res = pstmt.executeQuery();

            while (res.next()) {
                int Code = res.getInt("Code");
                String nom = res.getString("Nom");
                String  dn = res.getString("Date_Naissance"); SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Exemple de format AAAA-MM-JJ
                Date dateNaissance = null;
                try {
                   dateNaissance = format.parse(dn);
                } catch (ParseException ex) {
                   Logger.getLogger(CreateContact.class.getName()).log(Level.SEVERE, null, ex);
                }
                java.sql.Date sqlDateNaissance = new java.sql.Date(dateNaissance.getTime());

                Address= res.getString("Address");
                Email = res.getString("Email");
                int tel = res.getInt("TelNumber");
                Agent individu = new Agent(Code, nom, sqlDateNaissance, Address, Email, tel);
                list_recherche.add(individu);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "erreur lors de la recherche");
        }
        return  list_recherche;
    }
}
