/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.HorarioBusDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HorarioBus;

/**
 *
 * @author pabli
 */
public class MySQL_HorarioBusDAO implements HorarioBusDAO {
    
    MySQL_ConexionDAO c;
    private ResultSet rs;
    private String query;
    private List<HorarioBus> listaHorarioBus;
    
    public MySQL_HorarioBusDAO() throws SQLException, ClassNotFoundException {
        //Conexion
        c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "123456");
    }

    @Override
    public void create(HorarioBus hb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HorarioBus> read() throws SQLException {
        query = "select * from horarioBus";
        
        HorarioBus hb;
        listaHorarioBus = new ArrayList<>();
        rs = c.ejecutarSelec(query);
        
        while(rs.next()){
            hb = new HorarioBus();
            
            hb.setId(rs.getInt(1));
            hb.setFk_bus(rs.getInt(2));
            hb.setHoraSalida(rs.getTime(3));
            hb.setFk_origen(rs.getInt(4));
            hb.setFk_destino(rs.getInt(5));
            hb.setPrecio(rs.getInt(6));
            
            listaHorarioBus.add(hb);
        }
        c.close();
        
        return listaHorarioBus;
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
