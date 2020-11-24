/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;



/**
 *
 * @author carri
 */
public class Lista {

    Nodo primero;
    Nodo ultimo;
    Nodo iteracion; 
    int length;

    Lista() {
        this.primero = null;
        this.iteracion = this.primero; 
    }

    boolean add(Object dato) {
        Nodo nuevo;
        try {
            nuevo = new Nodo(dato);
        } catch (Exception e) {
            return false;
        }
        if (this.primero == null) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            this.length = 1;
            return true;
        }
        this.ultimo.siguiente = nuevo;
        this.ultimo = this.ultimo.siguiente;
        this.length++;
        return true;
    }
    
    Object iterar(int i ){
        if ( i == 0 ){ 
            this.iteracion = this.primero;
        }
        Object dato = this.iteracion.dato;
        this.iteracion = this.iteracion.siguiente; 
        return dato; 
    }
    
    Object getPorPosicion(int posicion ){ 
        if ( posicion == 0 ){ 
            return this.primero;
        }
        Nodo aux = this.primero; 
        for ( int i = 0 ; i < posicion; i ++ ){
            aux = aux.siguiente; 
        }
        return aux.dato; 
    }

   
    boolean borrar(int posicion) {
        if (this.length == 1) {
            this.primero = null;
            this.length--;
            return true;
        } else if (posicion == 0) {
            this.primero = this.primero.siguiente;
            this.length--;
            return true;
        }
        
        Nodo aux = this.primero;
        for (int i = 1; i < posicion; i++) {
            aux = aux.siguiente;
        }
        if ( aux.siguiente.siguiente == null ){ 
            this.ultimo = aux; 
        }
        aux.siguiente = aux.siguiente.siguiente;
        
        this.length--;
        return true;
    }
 
   
    public void imprimir() {
        Nodo aux = this.primero;
        while (aux != null) {
            System.out.println(aux.dato.toString());
            aux = aux.siguiente;
        }
    }
}
