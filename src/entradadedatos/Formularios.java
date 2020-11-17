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
 * Los formularios se componen por uno o varios campos o entradas 
 * que deben ser completadas por el usuario y estos envian los datos
 * recolectados al gestor. 
 * 
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
        g.getParticipantePorId(id).setHoraDeLlegada(tiempo);
    }
    
    public static void registrarHoraDeLlegadaPorCedula() {
        String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
        String horas = Consola.ingresarDato(ENTRADAS.HORAS);
        String minutos = Consola.ingresarDato(ENTRADAS.MINUTOS);
        String segundos = Consola.ingresarDato(ENTRADAS.SEGUNDOS);
        int tiempo = Integer.parseInt(horas+minutos+segundos);
        g.getParticipantePorCedula(cedula).setHoraDeLlegada(tiempo);
    }

    public static void registrarNoParticipePorId() {
        int id = Integer.parseInt(Consola.ingresarDato(ENTRADAS.ID));
        g.getParticipantePorId(id).noParticipo();
    }

    public static void registrarNoParticipePorCedula() {
       String cedula = Consola.ingresarDato(ENTRADAS.CEDULA_EXISTENTE);
       g.getParticipantePorCedula(cedula).noParticipo();
    }
    
    public static String seleccionarOpcionMenuParticipantes() {
        int numOpciones = MensajesMenus.imprimirMenu(MensajesMenus.MENU_PARTICIPANTE.values());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Consola.ingresarDato(ENTRADAS.MENU);
    }
    public static String seleccionarOpcionMenuActualizar() {
        int numOpciones = MensajesMenus.imprimirMenu(MensajesMenus.MENU_ACTUALIZAR.values());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Consola.ingresarDato(ENTRADAS.MENU);
    }
    public static String seleccionarOpcionMenuPrincipal() {
        int numOpciones = MenuPrincipal.imprimirMenuPrincipal();
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Consola.ingresarDato(ENTRADAS.MENU);
    }
    
    public static void menuRegistrarNoParticipe() {
        System.out.println(MensajesMenus.ID_O_CEDULA.REGISTRAR_POR_ID.txt());
        System.out.println(MensajesMenus.ID_O_CEDULA.REGISTRAR_POR_CEDULA.txt());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(2);
        String opcion = Consola.ingresarDato(ENTRADAS.MENU);
        switch(opcion){ 
            case "1": 
                registrarNoParticipePorId();
                break; 
            case "2": 
                registrarNoParticipePorCedula();
                break;
        }
    }
    
    
    public static void menuRegistrarHoraDeLlegada(){ 
        System.out.println(MensajesMenus.ID_O_CEDULA.REGISTRAR_POR_ID.txt());
        System.out.println(MensajesMenus.ID_O_CEDULA.REGISTRAR_POR_CEDULA.txt());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(2);
        String opcion = Consola.ingresarDato(ENTRADAS.MENU);
        switch(opcion){ 
            case "1":
                registrarHoraDeLlegadaPorId();
                break;
            case "2": 
                registrarHoraDeLlegadaPorCedula();
                break; 
        }
    }
    
    public static void reportesPorAuspiciante() {
        int numOpciones = g.cantidadDeAuspiciantes();
        if (numOpciones > 0) {
            g.imprimirListaAuspiciantes();
            ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
            int opcion = Integer.parseInt(Consola.ingresarDato(ENTRADAS.MENU));
            g.imprimirParticipantesPorAuspiciante(opcion);
        } 
        
    }
    
    public static void reportesPorCategoria() {
        int numOpciones = MensajesMenus.imprimirMenu(MensajesMenus.MENU_CATEGORIAS.values());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        String opcion = Consola.ingresarDato(ENTRADAS.MENU);
        switch (opcion) {
            case "1": 
                g.imprimirPorCategoria('A');
                break;
            case "2": 
                g.imprimirPorCategoria('B');
                break; 
            case "3": 
                g.imprimirPorCategoria('C');
                break;
        }
    }
    
    public static int seleccionarOpcionMenuReportes() {
        int numOpciones = MensajesMenus.imprimirMenu(MensajesMenus.MENU_REPORTES.values());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Integer.parseInt(Consola.ingresarDato(ENTRADAS.MENU));
    }
}
