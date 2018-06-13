package model;

import factories.MySQL_BusDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TMBus implements TableModel {

    private List<HorarioBus> listaBuses;
    private MySQL_BusDAO bus;

    public TMBus(List<HorarioBus> listaBuses) throws SQLException, ClassNotFoundException {
        this.listaBuses = listaBuses;
        bus = new MySQL_BusDAO();
    }

    public HorarioBus getHorarioBuses(int index) {
        return listaBuses.get(index);
    }

    @Override
    public int getRowCount() {
        return listaBuses.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            default:
                return "Hora";
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
        
        HorarioBus hb = listaBuses.get(rowIndex);
        
        switch(columnIndex){
            default:
                return hb.getHoraSalida();
        
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
