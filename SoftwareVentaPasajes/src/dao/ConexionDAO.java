package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ConexionDAO {
    
     public void conectar() throws SQLException;
    void ejecutar(String query) throws SQLException;
    ResultSet ejecutarSelec(String query) throws SQLException;
    void close() throws SQLException;
}
