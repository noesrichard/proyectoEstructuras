/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradadedatos;

import gestor.Gestor;

/**
 *
 * @author carri
 */
public class Formularios {
    static Gestor g = Gestor.get_();
    
    public static void agregarParticipante(){ 
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_NUEVA);
        String nombre = Consola.ingresarDato(ENTRADAS.NOMBRE);
        String apellido = Consola.ingresarDato(ENTRADAS.APELLIDO);
        int edad = Integer.parseInt(Consola.ingresarDato(ENTRADAS.EDAD));
        char sexo = Consola.ingresarDato(ENTRADAS.SEXO).charAt(0);
        g.agregarParticipante(cedula, nombre, apellido, edad, sexo, apellido);
    }
    
}
