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
    private String nombre,apellido,auspiciantes; 
    private int edad, horaLlegada; 
    private char sexo,categoria; 
    
    public Participante(String nombre, String apellido, int edad, char sexo,String auspiciantes){ 
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
    
}
