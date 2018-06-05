package dao;

import java.util.List;
import model.HorarioBus;

public interface HorarioBusDAO {
    
    void create(HorarioBus hb);
    List<HorarioBus> read();
    void update(HorarioBus hb);
    void delete(String id);
}
