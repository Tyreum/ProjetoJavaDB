package projetojavadb;

import java.sql.*;

public class Conexao {

    public static Connection abrirConexao() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url = "";

            url += "jdbc:mysql//127.0.0.1:3307/estacionamento?";
            url += "user=root&password=etecia";

            con = DriverManager.getConnection(url);
            
            System.out.println("Conexão aberta mec");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }


        return con;
    }

    public static Connection fecharConexao() {
        Connection con = null;

        try {
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return con;
    }
}
