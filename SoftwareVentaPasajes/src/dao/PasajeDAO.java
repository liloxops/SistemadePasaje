package dao;

import java.util.List;
import model.HorarioBus;
import model.Pasaje;

public interface PasajeDAO {
    
    void create(Pasaje p);
    List<Pasaje> read();
    void update(Pasaje p);
    void delete(String id);
}
