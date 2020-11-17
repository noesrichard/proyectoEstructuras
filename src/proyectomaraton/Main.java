/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomaraton;



import entradadedatos.Formularios;
import gestion.Gestor;
import gestion.ListaParticipantes;
import interfaz.MenuPrincipal;

/**
 *
 * @author carri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Gestor g = Gestor.get_();
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        while(true){ 
            MenuPrincipal.menuPrincipal();
        }
        */
        
        ListaParticipantes l = new ListaParticipantes();
        l.add(10);
        l.add(3);
        l.add(5);
        l.add(2);
        l.ordenar();
        l.imprimir();
    }
    
}
