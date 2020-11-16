/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomaraton;

/**
 *
 * @author carri
 */
public class Participante {
    private int id; 
    private String cedula,nombre,apellido,auspiciantes; 
    private int edad, horaLlegada; 
    private char sexo,categoria; 
    
    public Participante(String cedula,String nombre, String apellido, int edad, char sexo,String auspiciantes){ 
        this.cedula = cedula; 
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.edad = edad; 
        this.sexo = sexo; 
        this.auspiciantes = auspiciantes; 
    }
    
    public void setHoraLLegada(int horaLlegada){ 
        this.horaLlegada = horaLlegada; 
    }
    
    public void setCategoria(char categoria){ 
        this.categoria = categoria; 
    }
    
    public String getCedula(){ 
        return this.cedula; 
    }
    
    @Override
    public String toString(){ 
        return this.cedula; 
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    public void setApellido(String apellido) {
        this.apellido = apellido; 
    }

    public void setAuspiciantes(String auspiciantes) {
        this.auspiciantes = auspiciantes; 
    }

    public void setEdad(int edad) {
        this.edad = edad; 
    }

    public void setSexo(char sexo) {
        this.sexo = sexo; 
    }
    
    public void setId(int id ){ 
        this.id = id; 
    }

    public int getId() {
        return this.id; 
    }
    
    
    
}
