package DAO.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionOracle {
    //declaracion de variables de conexion con ORACLE
    private final String DRIVER="oracle.jdbc.driver.OracleDriver";
    private final String URL="jdbc:oracle:thin:@//localhost:1521/xepdb1";
    private final String USER="G##ACADEMICA";
    private final String PASSWORD="1234";
    
    //Cadena de conexion
    public Connection cadena;
    
    //Crear constructor de la clase
    public ConexionOracle(){
        this.cadena = null;
    }
    
    //Crear métodos conectar y desconectar
    public Connection conectar() throws SQLException{
        try{
            Class.forName(DRIVER);
            this.cadena = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Conexión incorrecta");
            System.exit(0);
        }
        return this.cadena;
    }
    
    //Desconectar
    public void desconectar(){
        try{
            this.cadena.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Fin");
        }
    }
}