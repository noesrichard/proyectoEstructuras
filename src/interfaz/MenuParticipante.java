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
import main.Participante;

/**
 *
 * @author carri
 */
class MenuParticipante {
    static Gestor g = Gestor.get_();
    static void menu() {
        boolean volver = false;
        do {
            String opcion = seleccionarOpcionMenuParticipantes();
            switch (opcion) {
                case "1":
                    Formularios.agregarParticipante();
                    break;
                case "2":
                    Formularios.visualizarParticipante();
                    break;
                case "3":
                    menuActualizarParticipante();
                    break;
                case "4":
                    Formularios.borrarParticipante();
                    break;
                case "5":
                    volver = true;
                    break;
            }
        } while (volver == false);
    }
    private static void menuActualizarParticipante() {
        boolean volver = false;
        Participante participante = Formularios.getParticipantePorCedula();
        do {            
            if (participante != null) {
                String opcion = seleccionarOpcionMenuActualizar(); 
                switch (opcion) {
                    case "1":
                        Formularios.actualizarNombre(participante);
                    case "2":
                        Formularios.actualizarApellido(participante);
                    case "3":
                        Formularios.actualizarAuspiciantes(participante);
                    case "4":
                        Formularios.actualizarEdad(participante);
                    case "5":
                        Formularios.actualizarSexo(participante);
                    case "6":
                        volver = true;
                        break;
                }
            } else {
                volver = true;
            }
        } while (volver == false);
    }
    
    public static String seleccionarOpcionMenuParticipantes() {
        int numOpciones = Mensajes.imprimirMenu(Mensajes.MENU_PARTICIPANTE.values());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Consola.ingresarDato(ENTRADAS.MENU);
    }
    
    
    public static String seleccionarOpcionMenuActualizar() {
        int numOpciones = Mensajes.imprimirMenu(Mensajes.MENU_ACTUALIZAR.values());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Consola.ingresarDato(ENTRADAS.MENU);
    }
}
