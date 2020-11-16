/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomaraton;



import entradadedatos.Formularios;
import gestor.Gestor;

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
        Formularios.agregarParticipante();
        g.imprimirLista();
    }
    
}
