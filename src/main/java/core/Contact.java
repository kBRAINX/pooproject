/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author brayanne
 */

abstract class Contact {
    
    private int code;
    private String nom;
    private Date dateNaissance;
    private String address;
    private String email;
    private int telNumber;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }

    public Contact(int code,String nom, Date dateNaissance, String address, String email, int telNumber) {
        this.code = code;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.address = address;
        this.email = email;
        this.telNumber = telNumber;
    }
    public abstract void insertbd() throws SQLException;
     
}