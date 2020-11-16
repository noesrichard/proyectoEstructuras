/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import entradadedatos.Consola;
import entradadedatos.ENTRADAS;
import entradadedatos.Formularios;
import gestion.Gestor;

/**
 *
 * @author carri
 */
public class MenuPrincipal {

    static Gestor g = Gestor.get_();

    public static boolean menuPrincipal() {
        int opcion = seleccionarOpcionMenuPrincipal();
        switch (opcion) {
            case 1:
                opcionUno();
                break;
            case 2:
                opcionDos();
                break;
            case 3:
                opcionTres();
                break;
            case 0:
                return true;
        }
        return false;
    }

    private static void opcionUno() {
        switch (g.getEstadoMaraton()) {
            case "":
                MenuParticipante.menu();
                break;
            case "Iniciado":
                menuRegistrarHoraDeLlegada();
                break;
            case "Finalizado":
                MenuReportes.menu();
                break;
            default:
                break;
        }
    }

    private static void opcionDos() {
        switch (g.getEstadoMaraton()) {
            case "":
                g.iniciarMaraton();
                break;
            case "Iniciado":
                menuRegistrarNoParticipe(); 
                break;
            default:
                break;
        }
    }

    private static void opcionTres() {
        if (g.getEstadoMaraton().equals("Iniciado")) {
            g.finalizarMaraton();
        }
    }

    private static int seleccionarOpcionMenuPrincipal() {
        int numOpciones = imprimirMenuPrincipal();
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Integer.parseInt(Consola.ingresarDato(ENTRADAS.MENU));
    }
    
    private static int imprimirMenuPrincipal(){ 
        int numOpciones = 0;
        System.out.println("\n");
        System.out.println(Mensajes.MENU_PRINCIPAL.CABEZERA.txt());
        switch (g.getEstadoMaraton()) {
            case "":
                System.out.println(Mensajes.MENU_PRINCIPAL.MENU_PARTICIPANTES.txt());
                System.out.println(Mensajes.MENU_PRINCIPAL.SALIDA.txt());
                numOpciones = 2;
                break;
            case "Iniciado":
                System.out.println(Mensajes.MENU_PRINCIPAL.REGISTRAR_HORA.txt());
                System.out.println(Mensajes.MENU_PRINCIPAL.REGISTRAR_NO_PARTICIPES.txt());
                System.out.println(Mensajes.MENU_PRINCIPAL.FINALIZAR.txt());
                numOpciones = 3;
                break;
            case "Finalizado":
                System.out.println(Mensajes.MENU_PRINCIPAL.VER_REPORTES.txt());
                numOpciones = 1;
                break;
        }
        System.out.println(Mensajes.MENU_PRINCIPAL.SALIR.txt());
        return numOpciones; 
    }
    
    
    private static void menuRegistrarNoParticipe() {
        System.out.println(Mensajes.ID_O_CEDULA.REGISTRAR_POR_ID.txt());
        System.out.println(Mensajes.ID_O_CEDULA.REGISTRAR_POR_CEDULA.txt());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(2);
        String opcion = Consola.ingresarDato(ENTRADAS.MENU);
        switch(opcion){ 
            case "1": 
                Formularios.registrarNoParticipePorId();
                break; 
            case "2": 
                Formularios.registrarNoParticipePorCedula();
                break;
        }
    }
    
    
    private static void menuRegistrarHoraDeLlegada(){ 
        System.out.println(Mensajes.ID_O_CEDULA.REGISTRAR_POR_ID.txt());
        System.out.println(Mensajes.ID_O_CEDULA.REGISTRAR_POR_CEDULA.txt());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(2);
        String opcion = Consola.ingresarDato(ENTRADAS.MENU);
        switch(opcion){ 
            case "1":
                Formularios.registrarHoraDeLlegadaPorId();
                break;
            case "2": 
                Formularios.registrarHoraDeLlegadaPorCedula();
                break; 
        }
    }
}
