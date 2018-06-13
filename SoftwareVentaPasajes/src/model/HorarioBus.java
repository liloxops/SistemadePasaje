package model;

import java.sql.Time;
import java.util.Date;

public class HorarioBus {

    private int id;
    private int fk_bus;
    private Time horaSalida;
    private int fk_origen;
    private int fk_destino;
    private int precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_bus() {
        return fk_bus;
    }

    public void setFk_bus(int fk_bus) {
        this.fk_bus = fk_bus;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getFk_origen() {
        return fk_origen;
    }

    public void setFk_origen(int fk_origen) {
        this.fk_origen = fk_origen;
    }

    public int getFk_destino() {
        return fk_destino;
    }

    public void setFk_destino(int fk_destino) {
        this.fk_destino = fk_destino;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
