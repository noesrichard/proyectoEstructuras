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
    Lista listaParticipantes;
    private static Gestor instancia = null;
    
    private Gestor() {
        this.listaParticipantes = new Lista();
        

    }

    public static Gestor get_() {
        if (instancia == null) {
            instancia = new Gestor();
        }
        return instancia;
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
