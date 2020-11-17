/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradadedatos;

import gestion.Gestor;
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
        String auspiciantes = Consola.ingresarDato(ENTRADAS.AUSPICIANTES);
        g.guardarAuspiciantes(auspiciantes);
        g.agregarParticipante(cedula, nombre, apellido, edad, sexo, auspiciantes);
    }

    public static void visualizarParticipante() {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        g.imprimirParticipantePorCedula(cedula);
        
    }

    public static void borrarParticipante() {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        g.borrarParticipantePorCedula(cedula);
        
    }

    public static Participante getParticipantePorCedula() {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        g.imprimirParticipantePorCedula(cedula);
        return g.getParticipantePorCedula(cedula);
    }

    public static void actualizarNombre(Participante participante) {
        String nombre = Consola.ingresarDato(ENTRADAS.NOMBRE);
        g.getParticipante(participante).setNombre(nombre);
    }

    public static void actualizarApellido(Participante participante) {
        String apellido = Consola.ingresarDato(ENTRADAS.APELLIDO);
        g.getParticipante(participante).setApellido(apellido);
    }

    public static void actualizarAuspiciantes(Participante participante) {
        String auspiciantes = Consola.ingresarDato(ENTRADAS.AUSPICIANTES);
        g.getParticipante(participante).setAuspiciantes(auspiciantes);
    }

    public static void actualizarEdad(Participante participante) {
        int edad = Integer.parseInt(Consola.ingresarDato(ENTRADAS.EDAD));
        g.getParticipante(participante).setEdad(edad);
    }

    public static void actualizarSexo(Participante participante) {
        char sexo = Consola.ingresarDato(ENTRADAS.SEXO).charAt(0);
        g.getParticipante(participante).setSexo(sexo);
    }

    public static void registrarHoraDeLlegadaPorId() {
        int id = Integer.parseInt(Consola.ingresarDato(ENTRADAS.ID));
        String horas = Consola.ingresarDato(ENTRADAS.HORAS);
        String minutos = Consola.ingresarDato(ENTRADAS.MINUTOS);
        String segundos = Consola.ingresarDato(ENTRADAS.SEGUNDOS);
        int tiempo = Integer.parseInt(horas+minutos+segundos);
        g.getParticipantePorId(id).setHoraLLegada(tiempo);
    }
    
    public static void registrarHoraDeLlegadaPorCedula() {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        String horas = Consola.ingresarDato(ENTRADAS.HORAS);
        String minutos = Consola.ingresarDato(ENTRADAS.MINUTOS);
        String segundos = Consola.ingresarDato(ENTRADAS.SEGUNDOS);
        int tiempo = Integer.parseInt(horas+minutos+segundos);
        g.getParticipantePorCedula(cedula).setHoraLLegada(tiempo);
    }

    public static void registrarNoParticipePorId() {
        int id = Integer.parseInt(Consola.ingresarDato(ENTRADAS.ID));
        g.getParticipantePorId(id).noParticipo();
    }

    public static void registrarNoParticipePorCedula() {
       String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
       g.getParticipantePorCedula(cedula).noParticipo();
    }

    
    
}
