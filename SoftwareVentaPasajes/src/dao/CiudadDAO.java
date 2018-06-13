package dao;

import java.sql.SQLException;
import java.util.List;
import model.Ciudad;

public interface CiudadDAO {
    
    void create(Ciudad c)throws SQLException, ClassNotFoundException;
    List<Ciudad> read()throws SQLException, ClassNotFoundException;
    void update(Ciudad c)throws SQLException, ClassNotFoundException;
    void delete(String id)throws SQLException, ClassNotFoundException;
}
