/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooproject;

import java.sql.Connection;
import view.MainFrmApplication;

/**
 *
 * @author brayanne
 */
public class MainApplication {
    public static void main(String[] agrs){
        Connection connection = null;

        MainFrmApplication vue = new MainFrmApplication();
        vue.setVisible(true);  
    }
}
