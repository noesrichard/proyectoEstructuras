/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


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
            String opcion = Formularios.seleccionarOpcionMenuParticipantes();
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
                case "0":
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
                String opcion = Formularios.seleccionarOpcionMenuActualizar(); 
                switch (opcion) {
                    case "1":
                        Formularios.actualizarNombre(participante);
                        break;
                    case "2":
                        Formularios.actualizarApellido(participante);
                        break;
                    case "3":
                        Formularios.actualizarAuspiciantes(participante);
                        break;
                    case "4":
                        Formularios.actualizarEdad(participante);
                        break;
                    case "5":
                        Formularios.actualizarSexo(participante);
                        break;
                    case "0":
                        volver = true;
                        break;
                }
            } else {
                volver = true;
            }
        } while (volver == false);
    }
    
}
