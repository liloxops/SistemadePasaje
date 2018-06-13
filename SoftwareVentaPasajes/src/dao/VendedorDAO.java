package dao;

import java.sql.SQLException;
import java.util.List;
import model.Vendedor;

public interface VendedorDAO {
    
    void create(Vendedor v)throws SQLException, ClassNotFoundException;
    List<Vendedor> read()throws SQLException, ClassNotFoundException;
    void update(Vendedor p)throws SQLException, ClassNotFoundException;
    void delete(String id)throws SQLException, ClassNotFoundException;
}
