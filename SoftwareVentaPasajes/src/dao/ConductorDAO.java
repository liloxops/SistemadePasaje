package dao;

import java.util.List;
import model.Conductor;

public interface ConductorDAO {
    
    void create(Conductor c);
    List<Conductor> read();
    void update(Conductor c);
    void delete(String id);
}
