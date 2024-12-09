/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.connection.ConnectionConfig;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author leafa
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        Connection connection =  ConnectionConfig.getConnection();
    if (connection != null) { 
        try {
            connection.close();
            System.out.println("Conexão fechada com sucesso."); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    }
}
