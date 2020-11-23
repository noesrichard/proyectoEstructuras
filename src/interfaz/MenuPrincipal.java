/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import entradadedatos.Formularios;
import gestion.Gestor;

/**
 *
 * @author carri
 */
public class MenuPrincipal {

    static Gestor g = Gestor.get_();

    public static boolean menuPrincipal() {
        String opcion = Formularios.seleccionarOpcionMenuPrincipal();
        switch (opcion) {
            case "1":
                opcionUno();
                break;
            case "2":
                opcionDos();
                break;
            case "3":
                opcionTres();
                break;
            case "0":
                return false;
        }
        return true;
    }

    private static void opcionUno() {
        switch (g.getEstadoMaraton()) {
            case "":
                MenuParticipante.menu();
                break;
            case "Iniciado":
                Formularios.registrarHoraDeLlegada();
                break;
            case "Finalizado":
                System.out.println("OPCION NO IMPLEMENTADA (REPORTES)");
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
                Formularios.registrarNoParticipe(); 
                break;
            default:
                break;
        }
    }

    private static void opcionTres() {
        if (g.getEstadoMaraton().equals("Iniciado")) {
            g.finalizarMaraton();
            g.ordenarListaParticipantes();
        }
    }

    
    
    public static int imprimirMenuPrincipal(){ 
        int numOpciones = 0;
        System.out.println("\n");
        System.out.println(MensajesMenus.MENU_PRINCIPAL.CABEZERA.txt());
        switch (g.getEstadoMaraton()) {
            case "":
                System.out.println(MensajesMenus.MENU_PRINCIPAL.MENU_PARTICIPANTES.txt());
                System.out.println(MensajesMenus.MENU_PRINCIPAL.SALIDA.txt());
                numOpciones = 2;
                break;
            case "Iniciado":
                System.out.println(MensajesMenus.MENU_PRINCIPAL.REGISTRAR_HORA.txt());
                System.out.println(MensajesMenus.MENU_PRINCIPAL.REGISTRAR_NO_PARTICIPES.txt());
                System.out.println(MensajesMenus.MENU_PRINCIPAL.FINALIZAR.txt());
                numOpciones = 3;
                break;
            case "Finalizado":
                System.out.println(MensajesMenus.MENU_PRINCIPAL.VER_REPORTES.txt());
                numOpciones = 1;
                break;
        }
        System.out.println(MensajesMenus.MENU_PRINCIPAL.SALIR.txt());
        return numOpciones; 
    }
    
    
    
}
