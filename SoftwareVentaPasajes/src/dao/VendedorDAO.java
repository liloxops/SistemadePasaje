package dao;

import java.util.List;
import model.Vendedor;

public interface VendedorDAO {
    
    void create(Vendedor v);
    List<Vendedor> read();
    void update(Vendedor p);
    void delete(String id);
}
