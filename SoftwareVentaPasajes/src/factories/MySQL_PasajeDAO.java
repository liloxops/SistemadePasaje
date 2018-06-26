/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.PasajeDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private List<Pasaje> listaNumAsientos;

    public MySQL_PasajeDAO() throws SQLException, ClassNotFoundException {
        //Conexion
        c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "");
    }

    @Override
    public void create(Pasaje p) throws SQLException {
        query = "insert into pasaje value(null,"+p.getAsiento()+",now(),"+p.getFk_horario()+")";
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
    public void delete(int id) throws SQLException {
        query = "delete from pasaje where fk_horario = "+id;
        
        c.ejecutar(query);
    }

    @Override
    public List<Pasaje> numAsiento(int id_horario) throws SQLException {
        query = "select asiento from pasaje where fk_horario = "+id_horario;
        
        Pasaje p;
        
        listaNumAsientos = new ArrayList<>();
        rs = c.ejecutarSelec(query);
        
        while(rs.next()){
            p = new Pasaje();
            
            p.setAsiento(rs.getInt(1));
            
            listaNumAsientos.add(p);
        }
        c.close();
        
        return listaNumAsientos;
    }

   
    
}
