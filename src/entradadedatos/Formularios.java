/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradadedatos;

import gestor.Gestor;
import proyectomaraton.Participante;

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

    public static void visualizarParticipante() {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        g.mostrarParticipantePorCedula(cedula);
        
    }

    public static void borrarParticipante() {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        g.borrarParticipantePorCedula(cedula);
        
    }

    public static Participante getParticipante() {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        g.mostrarParticipantePorCedula(cedula);
        return g.getParticipantePorCedula(cedula);
    }

    public static void actualizarNombre(Participante participante) {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        String nombre = Consola.ingresarDato(ENTRADAS.NOMBRE);
        g.getParticipantePorCedula(cedula).setNombre(nombre);
    }

    public static void actualizarApellido(Participante participante) {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        String apellido = Consola.ingresarDato(ENTRADAS.APELLIDO);
        g.getParticipantePorCedula(cedula).setApellido(apellido);
    }

    public static void actualizarAuspiciantes(Participante participante) {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        String auspiciantes = Consola.ingresarDato(ENTRADAS.APELLIDO);
        g.getParticipantePorCedula(cedula).setAuspiciantes(auspiciantes);
    }

    public static void actualizarEdad(Participante participante) {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        int edad = Integer.parseInt(Consola.ingresarDato(ENTRADAS.APELLIDO));
        g.getParticipantePorCedula(cedula).setEdad(edad);
    }

    public static void actualizarSexo(Participante participante) {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        char sexo = Consola.ingresarDato(ENTRADAS.APELLIDO).charAt(0);
        g.getParticipantePorCedula(cedula).setSexo(sexo);
    }

    public static void registrarHoraLlegada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
