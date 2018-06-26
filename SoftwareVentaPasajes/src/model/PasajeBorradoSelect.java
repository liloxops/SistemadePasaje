package model;

import java.util.Date;

public class PasajeBorradoSelect {
    
    private int id;
    private int asiento;
    private String fecha;
    private int fk_Horario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    public int getFk_Horario() {
        return fk_Horario;
    }

    public void setFk_Horario(int fk_Horario) {
        this.fk_Horario = fk_Horario;
    }
    
    
}
