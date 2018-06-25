/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.CiudadDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ciudad;

/**
 *
 * @author pabli
 */
public class MySQL_CiudadDAO implements CiudadDAO {
    
    MySQL_ConexionDAO c;
    private ResultSet rs;
    private String query;
    private List<Ciudad> ciudades;

    public MySQL_CiudadDAO() throws SQLException, ClassNotFoundException {
         c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "123456");
    }

    @Override
    public void create(Ciudad c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciudad> read() throws SQLException {
        query = "select * from ciudad";
        
        ciudades = new ArrayList<>();
        
        Ciudad ci;
        
        rs = c.ejecutarSelec(query);
        
        while(rs.next()){
            ci = new Ciudad();
            
            ci.setId(rs.getInt(1));
            ci.setNombre(rs.getString(2));
            
            ciudades.add(ci);
        }
        c.close();
        
        return ciudades;
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
