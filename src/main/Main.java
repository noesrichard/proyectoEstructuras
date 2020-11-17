/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;



import entradadedatos.Formularios;
import gestion.Gestor;
import gestion.Lista;
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
        pruebas();
        /*
        while(true){ 
            MenuPrincipal.menuPrincipal();
        }
        */
        
        
        
       
    }
    
    public static void pruebas(){ 
        
    
        
        g.agregarParticipante("123","Richrad","Carrion",12,'M',"Nike");
        g.agregarParticipante("456","Richrad","Carrion",12,'M',"Adidas");
        g.agregarParticipante("789","Richrad","Carrion",12,'M',"Puma");
        g.agregarParticipante("1234","Richrad","Carrion",12,'M',"Nike");
        
        
        g.getParticipantePorCedula("123").setHoraDeLlegada(2);
        g.getParticipantePorCedula("456").setHoraDeLlegada(3);
        g.getParticipantePorCedula("789").setHoraDeLlegada(2);
        g.getParticipantePorCedula("1234").setHoraDeLlegada(5);
        
        g.finalizarMaraton();
        g.imprimirListaAuspiciantes();
       
        g.imprimirParticipantesPorAuspiciante(1);
    }
    
}
