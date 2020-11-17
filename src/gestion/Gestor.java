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
public class Gestor {
    private Lista listaParticipantes;
    private Lista listaAuspiciantes; 
    private static Gestor instancia = null;
    private String estadoMaraton;  
    
    private Gestor() {
        this.listaParticipantes = new Lista();
        this.listaAuspiciantes = new Lista();
        this.estadoMaraton = "";
    }

    public static Gestor get_() {
        if (instancia == null) {
            instancia = new Gestor();
        }
        return instancia;
    }
    
    public void imprimirCabecera() {
        System.out.println("---------------------------------------------------"
                + "------------------------------------------------------------"
                + "-------");
        System.out.printf("%10s %20s %20s %30s %4s %4s %9s %6s \n",
                "CEDULA", "NOMBRE", "APELLIDO", "AUSPICIANTES",
                "EDAD", "SEXO", "CATEGORIA", "HORA");
        System.out.println("---------------------------------------------------"
                + "------------------------------------------------------------"
                + "------");
    }
    
    public void iniciarMaraton(){ 
        this.estadoMaraton = "Iniciado";
    }
    
    public void finalizarMaraton(){ 
        this.estadoMaraton = "Finalizado";
        ordenarListaParticipantes();
    }
    
    public String getEstadoMaraton() {
        return this.estadoMaraton;
    }
    
    private boolean ordenarListaParticipantes(){ 
        for ( int i = 0; i < listaParticipantes.length-1; i++ ){
            Nodo aux = listaParticipantes.primero;
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
    
    private char determinarCategoria(int edad){ 
        int EDAD_A = 1;
        int EDAD_B = 18;
        int EDAD_C = 35;
        if ( edad >= EDAD_A && edad < EDAD_B ){ 
            return 'A';
        } else if( edad >= EDAD_B && edad < EDAD_C ){ 
            return 'B';
        }else if ( edad >= EDAD_C ){ 
            return 'C';
        }
        return 'N';
    }
    
    public void agregarParticipante(String cedula,String nombre,String apellido,
                                    int edad, char sexo,String auspiciantes){
        char categoria = determinarCategoria(edad);
        Participante p = new Participante(cedula, nombre, apellido, edad, sexo, auspiciantes, categoria);
        listaParticipantes.add(p);
        p.setId(listaParticipantes.length);
    } 
    
    public void imprimirListaParticipantes(){ 
        imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            System.out.println(listaParticipantes.iterar(i).toString());
        }
    }

    public void imprimirParticipantePorCedula(String cedula) {
        imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getCedula().equals(cedula)){
                System.out.println(p.toString());
            }
        }
    }

    public void borrarParticipantePorCedula(String cedula) {
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getCedula().equals(cedula)){
                listaParticipantes.borrar(i);
            }
        }
    }

    public Participante getParticipantePorCedula(String cedula) {
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getCedula().equals(cedula)){
                return p; 
            }
        }
        return null; 
    }

    public Participante getParticipante(Participante participante) {
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p == participante){
                return p; 
            }
        }
        return null; 
    }

    public Participante getParticipantePorId(int id) {
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getId() == id){
                return p; 
            }
        }
        return null;
    }

    public void imprimirPorCategoria(char categoria){ 
        imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getCategoria() == categoria ){
                System.out.println(p.toString());
            }
        }
    }
    
    public void imprimirNoParticipes(){ 
        imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( !p.getParticipo() ){
                System.out.println(p.toString());
            }
        }
    }

    public void reportePorCategoria(int opcion) {
        switch(opcion){ 
            case 1: 
                imprimirPorCategoria('A');
                break;
            case 2: 
                imprimirPorCategoria('B');
                break; 
            case 3: 
                imprimirPorCategoria('C');
                break;
        }
    }

    public void imprimirNoCompletaron() {
        imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getHoraDeLlegada() == 0 ){
                System.out.println(p.toString());
            }
        }
    }
    
    private boolean existeAuspiciante(String auspiciante){ 
        for ( int i = 0; i < listaAuspiciantes.length; i++ ){ 
            if( listaParticipantes.iterar(i).equals(auspiciante)){ 
                return true; 
            }
        }
        return false; 
    }
    
    public void guardarAuspiciantes(String auspiciantes) {
        if (auspiciantes.contains(",")) {
            String[] split = auspiciantes.split(",");
            for (String auspiciante : split) {
                if (!auspiciante.equals(" ")
                        && !existeAuspiciante(auspiciante)) {
                    listaAuspiciantes.add(auspiciante);
                }
            }
        } else if (!existeAuspiciante(auspiciantes)) {
                listaAuspiciantes.add(auspiciantes);
            }
    }

    
}
