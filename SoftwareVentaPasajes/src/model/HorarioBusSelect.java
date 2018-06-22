package model;

import java.sql.Time;

public class HorarioBusSelect {
    
    private int id;
    private String fk_bus;
    private Time horaSalida;
    private String fk_origen;
    private String fk_destino;
    private int precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFk_bus() {
        return fk_bus;
    }

    public void setFk_bus(String fk_bus) {
        this.fk_bus = fk_bus;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFk_origen() {
        return fk_origen;
    }

    public void setFk_origen(String fk_origen) {
        this.fk_origen = fk_origen;
    }

    public String getFk_destino() {
        return fk_destino;
    }

    public void setFk_destino(String fk_destino) {
        this.fk_destino = fk_destino;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
    
}
