package model;

public class Bus {

    private int id;
    private String placa;
    private int asiento;
    private int fk_conductor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public int getFk_conductor() {
        return fk_conductor;
    }

    public void setFk_conductor(int fk_conductor) {
        this.fk_conductor = fk_conductor;
    }
    
    
}
