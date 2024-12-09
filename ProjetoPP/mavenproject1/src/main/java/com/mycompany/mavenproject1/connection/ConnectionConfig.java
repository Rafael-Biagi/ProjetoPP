/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leafa
 */
public class ConnectionConfig {
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa"; 
    private static final String PASSWORD = "";
    
public static Connection getConnection() { 
        Connection connection = null; 
    try {
        // Carregando o driver JDBC para SQL Server 
        Class.forName("org.h2.Driver");        // Estabelecendo a conexão 
        connection = DriverManager.getConnection(URL, USER, PASSWORD); 
        System.out.println("Conexão estabelecida com sucesso."); 
    }
    catch (ClassNotFoundException e) { 
        System.out.println("Driver JDBC não encontrado.");
        e.printStackTrace();
    }  catch (SQLException e) { 
        System.out.println("Erro ao conectar ao banco de dados."); 
        e.printStackTrace(); 
    } 
    return connection; 
    }

}

