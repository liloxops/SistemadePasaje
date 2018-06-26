package model;

import factories.MySQL_PasajeBorradoSelectDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TMHistorialPasajes implements TableModel{
    
    private List<PasajeBorradoSelect> listaHistorial;
    private MySQL_PasajeBorradoSelectDAO historial;

    public TMHistorialPasajes(List<PasajeBorradoSelect> listaHistorial) throws SQLException, ClassNotFoundException {
        this.listaHistorial = listaHistorial;
        historial = new MySQL_PasajeBorradoSelectDAO();
    }

    public PasajeBorradoSelect getHistorial(int index) {
        return listaHistorial.get(index);
    }
    

    @Override
    public int getRowCount() {
        return listaHistorial.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Asientos";
            case 1:
                return "Fecha";
            default:
                return "Tarifa";
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
        
        PasajeBorradoSelect pbs = listaHistorial.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return pbs.getAsiento();
            case 1:
                return pbs.getFecha();
            default:
                return pbs.getFk_Horario();
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
