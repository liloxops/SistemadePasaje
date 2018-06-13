/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.BusDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Bus;

/**
 *
 * @author pabli
 */
public class MySQL_BusDAO implements BusDAO {
    
    MySQL_ConexionDAO c;
    private ResultSet rs;
    private String query; 
    private List<Bus> listaBuses;

    public MySQL_BusDAO() throws SQLException, ClassNotFoundException {
        //Conexion
        c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "");
    }

   

    @Override
    public void create(Bus b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bus> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Bus b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bus getById(int id) throws SQLException  {
        query = "select * from bus where id = "+id;
        
        Bus b;
        listaBuses = new ArrayList<>();
        rs = c.ejecutarSelec(query);
        
        if(rs.next()){
            b = new Bus();
            
            b.setId(rs.getInt(1));
            b.setPlaca(rs.getString(2));
            
            listaBuses.add(b);
        }
        c.close();
        
        return listaBuses.get(0);
    }
    
    
    
}
