/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.VendedorDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Vendedor;

/**
 *
 * @author pabli
 */
public class MySQL_VendedorDAO implements VendedorDAO {
    
    MySQL_ConexionDAO c;
    private ResultSet rs;
    private String query;

    public MySQL_VendedorDAO() throws SQLException, ClassNotFoundException {
         //Conexion
        c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "");
    }

    @Override
    public void create(Vendedor v) throws SQLException {
        query = "insert into vendedor value(null,'"+v.getNombre()+"','"+v.getRut()+"','"+v.getPass()+"')";
        c.ejecutar(query);
    }

    @Override
    public List<Vendedor> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Vendedor p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
