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
public class Lista {
    Nodo primero;
    Nodo ultimo;
    int length; 
    
    Lista(){ 
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
        }
        this.ultimo.siguiente = nuevo; 
        this.ultimo = this.ultimo.siguiente;
        this.length ++;
        return true; 
    }
    
    Object iterar(int i){ 
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
}