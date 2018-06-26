package factories;

import dao.PasajeBorradoSelectDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PasajeBorradoSelect;

public class MySQL_PasajeBorradoSelectDAO implements PasajeBorradoSelectDAO{
    MySQL_ConexionDAO c;
    private ResultSet rs;
    private String query;
    private List<PasajeBorradoSelect> pasajesBorrados;

    public MySQL_PasajeBorradoSelectDAO() throws SQLException, ClassNotFoundException {
         c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "");
    }

    @Override
    public void create(PasajeBorradoSelect pbs) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PasajeBorradoSelect pbs) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PasajeBorradoSelect> read(int id_Horario) throws SQLException, ClassNotFoundException {
        query = "select pasajeBorrado.asiento,pasajeBorrado.fecha,horarioBus.precio from pasajeBorrado,horarioBus where horarioBus.id = pasajeBorrado.fk_horario and pasajeBorrado.fk_horario = "+id_Horario;
        
        PasajeBorradoSelect pbs;
        pasajesBorrados = new ArrayList<>();
        rs = c.ejecutarSelec(query);

        while (rs.next()) {
            pbs = new PasajeBorradoSelect();
            
            pbs.setAsiento(rs.getInt(1));
            pbs.setFecha(rs.getString(2));
            pbs.setFk_Horario(rs.getInt(3));

            pasajesBorrados.add(pbs);
        }
        c.close();

        return pasajesBorrados;
        
    }
    
}
