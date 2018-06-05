/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.CiudadDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Ciudad;

/**
 *
 * @author pabli
 */
class MySQL_CiudadDAO implements CiudadDAO {
    
    MySQL_ConexionDAO c;
    private ResultSet rs;

    public MySQL_CiudadDAO() throws SQLException, ClassNotFoundException {
         c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "");
    }

    @Override
    public void create(Ciudad c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciudad> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Ciudad c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
