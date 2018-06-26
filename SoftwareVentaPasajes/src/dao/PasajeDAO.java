package dao;

import java.sql.SQLException;
import java.util.List;
import model.HorarioBus;
import model.Pasaje;

public interface PasajeDAO {
    
    void create(Pasaje p)throws SQLException, ClassNotFoundException;
    List<Pasaje> read()throws SQLException, ClassNotFoundException;
    void update(Pasaje p)throws SQLException, ClassNotFoundException;
    void delete(int id)throws SQLException, ClassNotFoundException;
    List<Pasaje> numAsiento(int id_horario)throws SQLException, ClassNotFoundException;
}
