package dao;

import java.sql.SQLException;
import java.util.List;
import model.Bus;

public interface BusDAO {
    
    void create(Bus b)throws SQLException, ClassNotFoundException;
    List<Bus> read()throws SQLException, ClassNotFoundException;
    void update(Bus b)throws SQLException, ClassNotFoundException;
    void delete(String id)throws SQLException, ClassNotFoundException;
    Bus getById(int id) throws SQLException, ClassNotFoundException;
}
