/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;


import proyectomaraton.Participante;

/**
 *
 * @author carri
 */
public class Gestor {
    private ListaParticipantes listaParticipantes;
    private static Gestor instancia = null;
    private String estadoMaraton;  
    
    private Gestor() {
        this.listaParticipantes = new ListaParticipantes();
        this.estadoMaraton = null;
    }

    public static Gestor get_() {
        if (instancia == null) {
            instancia = new Gestor();
        }
        return instancia;
    }
    
    public void iniciarMaraton(){ 
        this.estadoMaraton = "Iniciado";
    }
    
    public void finalizarMarton(){ 
        this.estadoMaraton = "Finalizado";
    }
    
    public boolean agregarParticipante(String cedula,String nombre,String apellido,
                                    int edad, char sexo,String auspiciantes){ 
        return listaParticipantes.add(new Participante(cedula,nombre,apellido,
                                                        edad,sexo,auspiciantes));
    } 
    
    public void imprimirLista(){ 
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            System.out.println(listaParticipantes.iterar(i).toString());
        }
    }
}
