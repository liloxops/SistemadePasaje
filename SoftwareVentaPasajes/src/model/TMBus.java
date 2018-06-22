package model;

import factories.MySQL_BusDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TMBus implements TableModel {

    private List<HorarioBusSelect> listaBuses;
    private MySQL_BusDAO bus;

    public TMBus(List<HorarioBusSelect> listaBuses) throws SQLException, ClassNotFoundException {
        this.listaBuses = listaBuses;
        bus = new MySQL_BusDAO();
    }

    public HorarioBusSelect getHorarioBuses(int index) {
        return listaBuses.get(index);
    }

    @Override
    public int getRowCount() {
        return listaBuses.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Hora Salida";
            case 2:
                return "Destino";
            default:
                return "Precio";
                
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        HorarioBusSelect hbs = listaBuses.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return hbs.getId();
            case 1:
                return hbs.getHoraSalida();
            case 2:
                return hbs.getFk_destino();
            default:
                return hbs.getPrecio();
        
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

}
