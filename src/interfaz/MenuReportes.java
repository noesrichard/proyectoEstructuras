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
class MenuReportes {
    static Gestor g = Gestor.get_();
    static void menu() {
        boolean volver = false;
        do {
            int opcion = Formularios.seleccionarOpcionMenuReportes();
            switch (opcion) {
                case 1:
                    Formularios.reportesPorAuspiciante();
                    break;
                case 2:
                    Formularios.reportesPorCategoria();
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
    
    
    
    
    
    

}
