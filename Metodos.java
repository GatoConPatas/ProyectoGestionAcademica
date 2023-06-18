
package DAO.Interfaz;

import DAO.Conexion.ConexionOracle;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Metodos {
    //CREAR UN MÉTODO PARA LLENAR EL JTABLE = JREPORTE
    public void rellenarTabla(String tabla, JTable visor) throws SQLException{
        
        String sql = " select * from "+tabla;
        String sql2 = " select count(*) from user_tab_columns where table_name='"+tabla+"'";
        Statement st;
        Lista nombre_columna = new Lista();
        ConexionOracle con = new ConexionOracle();
        Connection conexion = con.conectar();
        st = conexion.createStatement();
        
        ResultSet coso = st.executeQuery(sql2);
        coso.next();
        int nose = coso.getInt(1);
        
        DefaultTableModel modelo = new DefaultTableModel();
        String[] aux = null;
        
        switch(tabla){
            case "ALUMNO":
                aux = nombre_columna.getC_alumno();
                break;
            case "DOCENTE":
                aux = nombre_columna.getC_docente();
                break;
        }
        
        int i = 0;
        while(i<nose){
            modelo.addColumn(aux[i]);
            i++;
        }

        visor.setModel(modelo);
        
        //COLECCIÓN DE STRINGS PARA LLENAR LA TABLA
        String[] datos = new String[i+1];
        
        ResultSet rs = st.executeQuery(sql);
        
        //Llamo a los items de la tabla y los igualo a la estructura del formulario
        while(rs.next()){
            for(int x=0;x<nose;x++){
                datos[x] = rs.getString(x+1);
            }
            modelo.addRow(datos);
        }
    }
}