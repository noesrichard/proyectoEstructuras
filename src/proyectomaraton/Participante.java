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
    private int edad, horaDeLlegada; 
    private char sexo,categoria; 
    private boolean participo; 
    
    public Participante(String cedula,String nombre, String apellido, int edad, char sexo,String auspiciantes, char categoria){ 
        this.cedula = cedula; 
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.edad = edad; 
        this.sexo = sexo; 
        this.auspiciantes = auspiciantes; 
        this.categoria = categoria;
        this.participo = true; 
    }
    
    public int getHoraDeLlegada(){ 
        return this.horaDeLlegada; 
    }
    
    public void setHoraLLegada(int horaLlegada){ 
        this.horaDeLlegada = horaLlegada; 
    }
    
    public void setCategoria(char categoria){ 
        this.categoria = categoria; 
    }
    
    public String getCedula(){ 
        return this.cedula; 
    }
    
    @Override
    public String toString(){ 
        return String.format("%10s %20s %20s %30s %4s %4s %9s %8s \n", 
                this.cedula, this.nombre, this.apellido, this.auspiciantes, 
                this.edad, this.sexo, this.categoria, this.horaDeLlegada);
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
    
    public void noParticipo(){ 
        this.participo = false; 
    }
    
    public boolean getParticipo(){ 
        return this.participo; 
    }

    public char getCategoria() {
        return this.categoria; 
    }
    
}
