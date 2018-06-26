package factories;

import dao.HorarioBusSelectDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HorarioBusSelect;

public class MySQL_HorarioBusSelectDAO implements HorarioBusSelectDAO {

    MySQL_ConexionDAO c;
    private ResultSet rs;
    private String query;
    private List<HorarioBusSelect> listaBusesSelect;
    private List<HorarioBusSelect> listaHorario;

    public MySQL_HorarioBusSelectDAO() throws SQLException, ClassNotFoundException {
        c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "");
    }

    @Override
    public void create(HorarioBusSelect hbs) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HorarioBusSelect> read() throws SQLException, ClassNotFoundException {
        query = "select horarioBus.id, bus.placa, horarioBus.hora_salida, ciudad.nombre, horarioBus.precio from horarioBus,bus,ciudad where bus.id = horarioBus.fk_bus and horarioBus.fk_destino = ciudad.id;";

        HorarioBusSelect hbs;
        listaBusesSelect = new ArrayList<>();
        rs = c.ejecutarSelec(query);

        while (rs.next()) {
            hbs = new HorarioBusSelect();

            hbs.setId(rs.getInt(1));
            hbs.setFk_bus(rs.getString(2));
            hbs.setHoraSalida(rs.getTime(3));
            hbs.setFk_destino(rs.getString(4));
            hbs.setPrecio(rs.getInt(5));

            listaBusesSelect.add(hbs);
        }
        c.close();

        return listaBusesSelect;
    }

    @Override
    public void update(HorarioBusSelect hbs) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
