/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.PasajeDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Pasaje;

/**
 *
 * @author pabli
 */
public class MySQL_PasajeDAO implements PasajeDAO {
    
    MySQL_ConexionDAO c;
    private ResultSet rs;
    private String query;

    public MySQL_PasajeDAO() throws SQLException, ClassNotFoundException {
        //Conexion
        c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "");
    }

    @Override
    public void create(Pasaje p) throws SQLException {
        query = "insert into pasaje value(null,"+p.getAsiento()+",now(),"+p.getFk_vendedor()+","+p.getFk_horario()+")";
        c.ejecutar(query);
    }

    @Override
    public List<Pasaje> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pasaje p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
