/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.connection.ConnectionConfig;
import com.mycompany.mavenproject1.model.RegistroVisita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author leafa
 */
public class DataBaseOperations {
    
    public static void createTable() throws SQLException {
    String sqlCreateTable = "CREATE TABLE IF NOT EXISTS Visitas ("
                            + "id INT PRIMARY KEY, "
                            + "nomePaciente VARCHAR(255), "
                            + "nomeVisita VARCHAR(255), "
                            + "telefone VARCHAR(25), "
                            + "periodo VARCHAR(255));";  

    try (Connection conn = ConnectionConfig.getConnection();
         Statement stmt = conn.createStatement()) {

        stmt.executeUpdate(sqlCreateTable);
        System.out.println("Tabela 'Visitas' criada com sucesso.");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao criar a tabela");
    }
}
    
    public static void insertData(Integer id, String nomePaciente, String nomeVisita, String telefone, String periodo) {
        String sqlInsertData = "INSERT INTO Visitas (id, nomePaciente, nomeVisita, telefone, periodo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionConfig.getConnection();  
             PreparedStatement stmt = conn.prepareStatement(sqlInsertData)) {
            stmt.setInt(1, id);
            stmt.setString(2, nomePaciente); 
            stmt.setString(3, nomeVisita);   
            stmt.setString(4, telefone);     
            stmt.setString(5, periodo);      

            stmt.executeUpdate();  
            System.out.println("Dados inseridos com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir dados.");
        }
    }
    
     public static void showData() {
        String sqlSelectData = "SELECT * FROM Visitas";  

        try (Connection conn = ConnectionConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlSelectData);
             ResultSet rs = stmt.executeQuery()) {

            // Exibe os dados
            while (rs.next()) {               
                int id = rs.getInt("id");
                String nomePaciente = rs.getString("nomePaciente");
                String nomeVisita = rs.getString("nomeVisita");
                String telefone = rs.getString("telefone");
                String periodo = rs.getString("periodo");
                
                System.out.println("ID: " + id + ", Nome do Paciente: " + nomePaciente
                        + ", Nome da Visita: " + nomeVisita
                        + ", Telefone: " + telefone
                        + ", Período: " + periodo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao recuperar dados.");
        }
    }

    public static RegistroVisita getListaVisitas(String busca) {
        String sqlSelectData = "SELECT * FROM Visitas where ID = ?";  
        RegistroVisita rv = null;
        try 
        {Connection conn = ConnectionConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlSelectData);
            stmt.setInt(1, Integer.parseInt(busca));
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
            rv = new RegistroVisita(
                rs.getInt("ID"),
                rs.getString("nomePaciente"),
                rs.getString("nomeVisita"),
                rs.getString("telefone"),
                rs.getString("periodo"));
                System.out.println(rs.getString("periodo"));
                }
                
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao recuperar dados.");
            return null;
        }
        return rv;
    }
    public static void updateData(Integer id, String telefone) {
    // A SQL de UPDATE, que vai atualizar o telefone com base no ID
    String sqlUpdateData = "UPDATE Visitas SET telefone = ? WHERE id = ?";

    try (Connection conn = ConnectionConfig.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sqlUpdateData)) {

        // Definindo os parâmetros para a atualização
        stmt.setString(1, telefone);  // Atualiza o telefone
        stmt.setInt(2, id);  // Onde o ID é igual ao fornecido

        // Executa a atualização
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Dados atualizados com sucesso.");
        } else {
            System.out.println("Nenhum dado foi encontrado para o ID fornecido.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao atualizar dados.");
    }
}
    
    public static void deleteData(Integer id) {
    String sqlDeleteData = "DELETE FROM Visitas WHERE id = ?";

    try (Connection conn = ConnectionConfig.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sqlDeleteData)) {
        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Dados deletados com sucesso.");
        } else {
            System.out.println("Nenhum dado foi encontrado para o ID fornecido.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao deletar os dados.");
    }
}
    
}
