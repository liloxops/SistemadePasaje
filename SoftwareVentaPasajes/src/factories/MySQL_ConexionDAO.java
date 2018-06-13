/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.ConexionDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pabli
 */
public class MySQL_ConexionDAO implements ConexionDAO {
    
    
    private Connection con; // Establecer la conexión
    private Statement sen;  // Ejecutar consultas
    private ResultSet rs;   // Recorrer los resultados (Tabla)

    // localhost --> ip --> mysql --> afuera
    public MySQL_ConexionDAO(String server, String bd, String user, String pass) throws SQLException, ClassNotFoundException {
        String protocolo = "jdbc:mysql://";
        String lineaUser = "user=" + user;
        String lineaPass = "password=" + pass;

        String url = protocolo
                + server + "/"
                + bd + "?"
                + lineaUser + "&"
                + lineaPass;

        System.out.println(url);

        Class.forName("com.mysql.jdbc.Driver"); // jar, INCLUIR!!!!!
        con = DriverManager.getConnection(url);
    }
    
   
    @Override
    public void conectar() throws SQLException {

        try {
            sen = con.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conectado");
    }

    @Override
    public void ejecutar(String query) throws SQLException {
        sen = con.createStatement();
        sen.executeUpdate(query);
        close();
    }

    @Override
    public ResultSet ejecutarSelec(String query) throws SQLException {
        sen = con.createStatement();
        rs = sen.executeQuery(query);
        return rs;
    }

    @Override
    public void close() throws SQLException {
        sen.close();
    }


}
