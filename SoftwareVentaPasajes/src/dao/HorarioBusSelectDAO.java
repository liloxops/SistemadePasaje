package dao;

import java.sql.SQLException;
import java.util.List;
import model.HorarioBusSelect;

public interface HorarioBusSelectDAO {
    
    void create(HorarioBusSelect hbs)throws SQLException, ClassNotFoundException;
    List<HorarioBusSelect> read()throws SQLException, ClassNotFoundException;
    void update(HorarioBusSelect hbs)throws SQLException, ClassNotFoundException;
    void delete(String id)throws SQLException, ClassNotFoundException;
    
    
}
