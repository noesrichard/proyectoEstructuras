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
        
        //pruebas();
        
       
    }
    
    public static void pruebas(){ 
         ListaParticipantes l = new ListaParticipantes();
        Participante p = new Participante("123","Richrad","Carrion",12,'M',"Nike",'A'); 
        Participante p2 = new Participante("456","Richrad","Carrion",12,'M',"Nike",'A'); 
        Participante p3 = new Participante("789","Richrad","Carrion",12,'M',"Nike",'A'); 
        Participante p4 = new Participante("159","Richrad","Carrion",12,'M',"Nike",'A'); 
        Participante p5 = new Participante("357","Richrad","Carrion",12,'M',"Nike",'A'); 
        
        
        
        l.add(p);
        l.add(p2);
        l.add(p3);
        l.add(p4);
        l.add(p5);
        
        p.setHoraLLegada(10);
        p2.setHoraLLegada(5);
        p3.setHoraLLegada(11);
        p4.setHoraLLegada(2);
        p5.setHoraLLegada(2);
        
        l.ordenar();
        l.imprimir();
    }
    
}
