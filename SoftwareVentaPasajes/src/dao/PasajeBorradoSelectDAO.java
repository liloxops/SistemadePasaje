package dao;

import java.sql.SQLException;
import java.util.List;
import model.PasajeBorradoSelect;

public interface PasajeBorradoSelectDAO {
    
    void create(PasajeBorradoSelect pbs)throws SQLException, ClassNotFoundException;
    List<PasajeBorradoSelect> read(int id_Horario)throws SQLException, ClassNotFoundException;
    void update(PasajeBorradoSelect pbs)throws SQLException, ClassNotFoundException;
    void delete(String id)throws SQLException, ClassNotFoundException;
    
}
