/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import proyectomaraton.Participante;

/**
 *
 * @author carri
 */
public class Lista {

    Nodo primero;
    Nodo ultimo;
    int length;

    public Lista() {
        this.primero = null;
    }

    public boolean add(Object dato) {
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
            //((Participante)(nuevo.dato)).setId(length);
            return true;
        }
        this.ultimo.siguiente = nuevo;
        this.ultimo = this.ultimo.siguiente;
        this.length++;
        //((Participante)(nuevo.dato)).setId(length);
        return true;
    }

    Object iterar(int i) {
        Nodo aux = this.primero;
        if (this.length < 1) {
            return null;
        }
        if (i == 0) {
            return  aux.dato;
        }
        for (int j = 0; j < i; j++) {
            aux = aux.siguiente;
        }
        return aux.dato;
    }

    public boolean borrar(int posicion) {
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
        aux.siguiente = aux.siguiente.siguiente;
        this.length--;
        return true;
    }
    /*
    public boolean ordenar() {
        for ( int i = 0; i < length-1; i++ ){
            Nodo aux = this.primero;
            while (aux.siguiente != null) {
                if ( ((Participante)aux.dato).getHoraDeLlegada() > 
                        ((Participante)aux.siguiente.dato).getHoraDeLlegada()) {
                    Object data = aux.dato;
                    aux.dato = aux.siguiente.dato;
                    aux.siguiente.dato = data;
                }
                aux = aux.siguiente;
            }
        }
        return true;
    }
    */
    public void imprimir() {
        Nodo aux = this.primero;
        while (aux != null) {
            System.out.println(aux.dato.toString());
            aux = aux.siguiente;
        }
    }
}
