package model;

import java.util.Date;

public class Pasaje {

    private int id;
    private int asiento;
    private Date fecha;
    private int fk_horario;

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getFk_horario() {
        return fk_horario;
    }

    public void setFk_horario(int fk_horario) {
        this.fk_horario = fk_horario;
    }

    @Override
    public String toString() {
        return String.valueOf(asiento);
    }

    

}
