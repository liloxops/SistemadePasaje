package dao;

import java.util.List;
import model.Bus;

public interface BusDAO {
    
    void create(Bus b);
    List<Bus> read();
    void update(Bus b);
    void delete(String id);
}
