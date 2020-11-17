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
class MenuReportes {
    static Gestor g = Gestor.get_();
    static void menu() {
        boolean volver = false;
        do {
            int opcion = seleccionarOpcionMenuReportes();
            switch (opcion) {
                case 1:
                    reportesPorAuspiciante();
                    break;
                case 2:
                    reportesPorCategoria();
                    break;
                case 3:
                    g.imprimirNoParticipes();
                    break;
                case 4:
                    g.imprimirNoCompletaron();
                    break;
                case 5:
                    volver = true;
                    break;
            }
        } while (volver == false);
    }
    
    private static void reportesPorAuspiciante() {
        int numOpciones = g.cantidadDeAuspiciantes();
        if (numOpciones > 0) {
            g.imprimirListaAuspiciantes();
            ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
            int opcion = Integer.parseInt(Consola.ingresarDato(ENTRADAS.MENU));
            g.imprimirParticipantesPorAuspiciante(opcion);
        } 
        
    }
    
    private static void reportesPorCategoria() {
        int numOpciones = Mensajes.imprimirMenu(Mensajes.MENU_CATEGORIAS.values());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        int opcion = Integer.parseInt(Consola.ingresarDato(ENTRADAS.MENU));
        g.reportePorCategoria(opcion);
    }
    
    public static int seleccionarOpcionMenuReportes() {
        int numOpciones = Mensajes.imprimirMenu(Mensajes.MENU_REPORTES.values());
        ENTRADAS.MENU.setNumeroDeOpcionesMenu(numOpciones);
        return Integer.parseInt(Consola.ingresarDato(ENTRADAS.MENU));
    }

}
