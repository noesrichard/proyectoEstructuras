/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomaraton;



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
        Lista l = new Lista();
        Participante p = new Participante("123","Richrad","Carrion",12,'M',"Nike",'A'); 
        Participante p2 = new Participante("456","Richrad","Carrion",12,'M',"Nike",'A'); 
        Participante p3 = new Participante("789","Richrad","Carrion",12,'M',"Nike",'A'); 
        Participante p4 = new Participante("159","Richrad","Carrion",12,'M',"Nike",'A'); 
        Participante p5 = new Participante("357","Richrad","Carrion",12,'M',"Nike",'A'); 
        
        g.agregarParticipante("123","Richrad","Carrion",12,'M',"Nike");
        g.agregarParticipante("456","Richrad","Carrion",12,'M',"Nike");
        g.agregarParticipante("789","Richrad","Carrion",12,'M',"Nike");
        g.agregarParticipante("1234","Richrad","Carrion",12,'M',"Nike");
        
        
        g.getParticipantePorCedula("123").setHoraLLegada(2);
        g.getParticipantePorCedula("456").setHoraLLegada(3);
        g.getParticipantePorCedula("789").setHoraLLegada(2);
        g.getParticipantePorCedula("1234").setHoraLLegada(5);
        
        g.finalizarMaraton();
        
        g.imprimirListaParticipantes();
    }
    
}
