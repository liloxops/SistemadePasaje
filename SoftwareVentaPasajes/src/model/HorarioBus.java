package model;

import java.util.Date;

public class HorarioBus {

    private int id;
    private Date horario;
    private int fk_bus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public int getFk_bus() {
        return fk_bus;
    }

    public void setFk_bus(int fk_bus) {
        this.fk_bus = fk_bus;
    }
    
    
}
