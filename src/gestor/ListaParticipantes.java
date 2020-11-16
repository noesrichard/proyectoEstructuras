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
public class ListaParticipantes {
    Nodo primero;
    Nodo ultimo;
    int length; 
    
    ListaParticipantes(){ 
        this.primero = null;
    }
    
    boolean add(Object dato){ 
        Nodo nuevo; 
        try{ 
            nuevo = new Nodo(dato);
        }catch(Exception e ){ 
            return false; 
        }
        if ( this.primero == null ){ 
            this.primero = nuevo; 
            this.ultimo = nuevo; 
            this.length = 1;
            ((Participante)(nuevo.dato)).setId(length);
            return true; 
        }
        this.ultimo.siguiente = nuevo; 
        this.ultimo = this.ultimo.siguiente;
        this.length ++;
        ((Participante)(nuevo.dato)).setId(length);
        return true; 
    }
    
    Participante iterar(int i){ 
        Nodo aux = this.primero; 
        if ( this.length < 1 ){ 
            return null; 
        }
        if ( i == 0 ){ 
            return (Participante)(aux.dato); 
        }
        for ( int j = 0; j < i; j++){ 
            aux = aux.siguiente; 
        }
        return (Participante)(aux.dato); 
    }
    
    boolean borrar(int posicion){
        if ( this.length == 1 ){ 
            this.primero = null;
            this.length --;
            return true; 
        }
        else if ( posicion == 0 ){ 
            this.primero = this.primero.siguiente; 
            this.length --;
            return true; 
        }
        Nodo aux = this.primero; 
        for ( int i = 1; i < posicion ; i++){ 
            aux  = aux.siguiente; 
        }
        aux.siguiente = aux.siguiente.siguiente; 
        this.length --;
        return true; 
    }
}
