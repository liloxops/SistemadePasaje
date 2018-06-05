package factories;

import dao.BusDAO;
import dao.CiudadDAO;
import dao.ConductorDAO;
import dao.HorarioBusDAO;
import dao.PasajeDAO;
import dao.VendedorDAO;
import exception.MotorNoSoportadoException;
import java.sql.SQLException;
import model.HorarioBus;

public class DAOFactory {
    
    private static DAOFactory daoFactory;
    
    private DAOFactory(){
    
    }
    
    
    public static DAOFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        
        return daoFactory;
    }
    
    public enum Motor{
        MY_SQL, ORACLE, MS_SQL
    }
    
    public BusDAO getBusDAO(Motor motor) throws MotorNoSoportadoException, SQLException, ClassNotFoundException{
        switch(motor){
            case MY_SQL:
                return new MySQL_BusDAO();
//            case MS_SQL:
//                return new SQLDB_MarcaDAO();
            default:
                throw new MotorNoSoportadoException(motor+" no soportado");
        }
    }
    
    public CiudadDAO getCiudadDAO(Motor motor) throws MotorNoSoportadoException, SQLException, ClassNotFoundException {
        switch (motor) {
            case MY_SQL:
                return new MySQL_CiudadDAO();
//            case MS_SQL:
//                return new SQLDB_MarcaDAO();
            default:
                throw new MotorNoSoportadoException(motor + " no soportado");
        }
    }

    public ConductorDAO getConductorDAO(Motor motor) throws MotorNoSoportadoException, SQLException, ClassNotFoundException {
        switch (motor) {
            case MY_SQL:
                return new MySQL_ConductorDAO();
//            case MS_SQL:
//                return new SQLDB_MarcaDAO();
            default:
                throw new MotorNoSoportadoException(motor + " no soportado");
        }
    }

    public HorarioBusDAO getHorarioBus(Motor motor) throws MotorNoSoportadoException, SQLException, ClassNotFoundException {
        switch (motor) {
            case MY_SQL:
                return new MySQL_HorarioBusDAO();
//            case MS_SQL:
//                return new SQLDB_MarcaDAO();
            default:
                throw new MotorNoSoportadoException(motor + " no soportado");
        }
    }

    public PasajeDAO getPasajeDAO(Motor motor) throws MotorNoSoportadoException, SQLException, ClassNotFoundException {
        switch (motor) {
            case MY_SQL:
                return new MySQL_PasajeDAO();
//            case MS_SQL:
//                return new SQLDB_MarcaDAO();
            default:
                throw new MotorNoSoportadoException(motor + " no soportado");
        }
    }

    public VendedorDAO getVendedorDAO(Motor motor) throws MotorNoSoportadoException, SQLException, ClassNotFoundException {
        switch (motor) {
            case MY_SQL:
                return new MySQL_VendedorDAO();
//            case MS_SQL:
//                return new SQLDB_MarcaDAO();
            default:
                throw new MotorNoSoportadoException(motor + " no soportado");
        }
    }
}
