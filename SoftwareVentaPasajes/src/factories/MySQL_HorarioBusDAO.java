/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.HorarioBusDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.HorarioBus;

/**
 *
 * @author pabli
 */
class MySQL_HorarioBusDAO implements HorarioBusDAO {
    
    MySQL_ConexionDAO c;
    private ResultSet rs;

    public MySQL_HorarioBusDAO() throws SQLException, ClassNotFoundException {
        //Conexion
        c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "");
    }

    @Override
    public void create(HorarioBus hb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HorarioBus> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(HorarioBus hb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
