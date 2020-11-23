/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradadedatos;

import gestion.Gestor;
import interfaz.MensajesMenus;
import interfaz.MenuPrincipal;
import main.Participante;

/**
 *
 * @author carri
 *
 * Los formularios se componen por uno o varios campos o entradas que deben ser completadas por el usuario y estos envian los datos recolectados al gestor.
 *
 */
public class Formularios {

    static Gestor g = Gestor.get_();

    public static void agregarParticipante() {
        String cedula = Consola.ingresarDatoConEscape(ENTRADA.CEDULA_NUEVA);
        if (!cedula.equals("0")) {
            String nombre = Consola.ingresarDato(ENTRADA.NOMBRE);
            String apellido = Consola.ingresarDato(ENTRADA.APELLIDO);
            int edad = Integer.parseInt(Consola.ingresarDato(ENTRADA.EDAD));
            char sexo = Consola.ingresarDato(ENTRADA.SEXO).charAt(0);
            String auspiciantes = Consola.ingresarDato(ENTRADA.AUSPICIANTES);
            g.agregarParticipante(cedula, nombre, apellido, edad, sexo, auspiciantes);
        }
    }

    public static Participante getParticipante() {
        System.out.println(MensajesMenus.ID_O_CEDULA.POR_ID.txt());
        System.out.println(MensajesMenus.ID_O_CEDULA.POR_CEDULA.txt());
        ENTRADA.MENU.setNumeroDeOpcionesMenu(2);
        String opcion = Consola.ingresarDato(ENTRADA.MENU);
        switch (opcion) {
            case "1":
                return getParticipantePorId();
            case "2":
                return getParticipantePorCedula();
        }
        return null;
    }
    
    private static Participante getParticipantePorId() {
        String id = Consola.ingresarDatoConEscape(ENTRADA.ID);
        if (!id.equals("0")) {
            return g.getParticipantePorId(id);
        }
        return null;
    }

    private static Participante getParticipantePorCedula() {
        String cedula = Consola.ingresarDatoConEscape(ENTRADA.CEDULA_EXISTENTE);
        if (!cedula.equals("0")) {
            return g.getParticipantePorCedula(cedula);
        }
        return null; 
    }

     public static void visualizarParticipante() {
        Participante p = getParticipante();
        if (p != null) {
            g.imprimirParticipante(p);
        }
    }

    public static void borrarParticipante() {
        Participante p = getParticipante();
        if (p != null) {
            g.borrarParticipante(p);
        }
    }
    
    public static void actualizarNombre(Participante participante) {
        String nombre = Consola.ingresarDato(ENTRADA.NOMBRE);
        g.getParticipante(participante).setNombre(nombre);
    }

    public static void actualizarApellido(Participante participante) {
        String apellido = Consola.ingresarDato(ENTRADA.APELLIDO);
        g.getParticipante(participante).setApellido(apellido);
    }

    public static void actualizarAuspiciantes(Participante participante) {
        String auspiciantes = Consola.ingresarDato(ENTRADA.AUSPICIANTES);
        g.getParticipante(participante).setAuspiciantes(auspiciantes);
    }

    public static void actualizarEdad(Participante participante) {
        int edad = Integer.parseInt(Consola.ingresarDato(ENTRADA.EDAD));
        g.getParticipante(participante).setEdad(edad);
    }

    public static void actualizarSexo(Participante participante) {
        char sexo = Consola.ingresarDato(ENTRADA.SEXO).charAt(0);
        g.getParticipante(participante).setSexo(sexo);
    }

    public static String seleccionarOpcionMenuParticipantes() {
        int numOpciones = MensajesMenus.imprimirMenu(MensajesMenus.MENU_PARTICIPANTE.values());
        ENTRADA.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Consola.ingresarDatoConEscape(ENTRADA.MENU);
    }

    public static String seleccionarOpcionMenuActualizar() {
        int numOpciones = MensajesMenus.imprimirMenu(MensajesMenus.MENU_ACTUALIZAR.values());
        ENTRADA.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Consola.ingresarDatoConEscape(ENTRADA.MENU);
    }

    public static String seleccionarOpcionMenuPrincipal() {
        int numOpciones = MenuPrincipal.imprimirMenuPrincipal();
        ENTRADA.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Consola.ingresarDatoConEscape(ENTRADA.MENU);
    }

    public static void registrarNoParticipe() {
        Participante p = getParticipante();
        if (p != null) {
            p.noParticipo();
        }
    }

    public static void registrarHoraDeLlegada() {
        Participante p = getParticipante();
        if (p != null) {
            String horas = Consola.ingresarDato(ENTRADA.HORAS);
            String minutos = Consola.ingresarDato(ENTRADA.MINUTOS);
            String segundos = Consola.ingresarDato(ENTRADA.SEGUNDOS);
            String tiempo = horas + ":" + minutos + ":" + segundos;
            p.setHoraDeLlegada(tiempo);
        }
    }
}
