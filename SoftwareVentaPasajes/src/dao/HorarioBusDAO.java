package dao;

import java.sql.SQLException;
import java.util.List;
import model.HorarioBus;

public interface HorarioBusDAO {
    
    void create(HorarioBus hb)throws SQLException, ClassNotFoundException;
    List<HorarioBus> read()throws SQLException, ClassNotFoundException;
    void update(HorarioBus hb)throws SQLException, ClassNotFoundException;
    void delete(String id)throws SQLException, ClassNotFoundException;
}
