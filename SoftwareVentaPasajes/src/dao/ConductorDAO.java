package dao;

import java.sql.SQLException;
import java.util.List;
import model.Conductor;

public interface ConductorDAO {
    
    void create(Conductor c)throws SQLException, ClassNotFoundException;
    List<Conductor> read()throws SQLException, ClassNotFoundException;
    void update(Conductor c)throws SQLException, ClassNotFoundException;
    void delete(String id)throws SQLException, ClassNotFoundException;
}
