/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.VendedorDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vendedor;

/**
 *
 * @author pabli
 */
public class MySQL_VendedorDAO implements VendedorDAO {

    MySQL_ConexionDAO c;
    private ResultSet rs;
    private String query;
    private List<Vendedor> listVendedor;

    public MySQL_VendedorDAO() throws SQLException, ClassNotFoundException {
        //Conexion
        c = new MySQL_ConexionDAO("localhost", "bd_Pasaje", "root", "123456");
    }

    @Override
    public void create(Vendedor v) throws SQLException {
        query = "insert into vendedor value(null,'" + v.getNombre() + "','" + v.getRut() + "','" + v.getPass() + "')";
        c.ejecutar(query);
    }

    @Override
    public List<Vendedor> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Vendedor p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vendedor> search(String exp) throws SQLException {
        String query = "Select * from vendedor where rut LIKE '%" + exp + "%'";
        Vendedor v;
        listVendedor = new ArrayList<>();
        rs = c.ejecutarSelec(query);

        while (rs.next()) {
            v = new Vendedor();

            v.setId(rs.getInt(1));
            v.setNombre(rs.getString(2));
            v.setRut(rs.getString(3));
            v.setPass(rs.getString(4));
            listVendedor.add(v);
        }

        c.close();
        return listVendedor;
    }

    @Override
    public String getByRut(String rut) throws SQLException {

        String query = "Select * from vendedor where rut = '" + rut + "'";
        Vendedor v;
        String rutExp = "";
        rs = c.ejecutarSelec(query);

        if (rs.next()) {
            v = new Vendedor();

            v.setId(rs.getInt(1));
            v.setNombre(rs.getString(2));
            v.setRut(rs.getString(3));
            v.setPass(rs.getString(4));

            rutExp = v.getRut();
        }

        c.close();
        return rutExp;
    }

    @Override
    public Vendedor getObjectByRut(String rut
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getByPass(String pass
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre(String rut) throws SQLException {
        
        String query = "select vendedor.nombre from vendedor where rut = '" + rut + "'";
        Vendedor v;
        String nombre = "";
        rs = c.ejecutarSelec(query);

        if (rs.next()) {
            v = new Vendedor();

           
            v.setNombre(rs.getString(1));
            
            nombre = v.getNombre();
        }

        c.close();
        return nombre;


    }

}
