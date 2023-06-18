
package DAO.Interfaz;

public class Lista {
    
    private String[] C_alumno = {"Código","Grado","Nombre","Apellido Paterno","Apellido Materno","DNI","Asistencias","Fecha de nacimiento"};
    private String[] C_docente = {"ID","Nombre","Apellido Paterno","Apellido Materno","DNI","Teléfono","Fecha de contrato"};
    
    public String[] getC_alumno() {
        return C_alumno;
    }

    public String[] getC_docente() {
        return C_docente;
    }
    
}
