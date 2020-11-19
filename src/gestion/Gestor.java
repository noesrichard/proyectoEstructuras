/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;


import main.Participante;

/**
 *
 * @author carri
 */
public class Gestor {
    private final Lista listaParticipantes;
    private final Lista listaAuspiciantes; 
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
                    Object tempo = aux.dato;
                    aux.dato = aux.siguiente.dato;
                    aux.siguiente.dato = tempo;
                }
                aux = aux.siguiente;
            }
        }
        return true;
    }
    
    private char determinarCategoria(int edad){ 
        int EDAD_A = 1, EDAD_B = 18, EDAD_C = 35;
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
        if ( listaParticipantes.add(p) ) {
            MENSAJE.AGREGAR_PARTICIPANTE.printValido();
            p.setId(listaParticipantes.length);
            guardarAuspiciantes(auspiciantes);
        }
        else{ 
            MENSAJE.AGREGAR_PARTICIPANTE.printError();
        }   
    } 
    
    public void borrarParticipantePorCedula(String cedula) {
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getCedula().equals(cedula)){
                if ( listaParticipantes.borrar(i) ){ 
                    MENSAJE.BORRAR_PARTICIPANTE.printValido();
                }else{ 
                    MENSAJE.BORRAR_PARTICIPANTE.printError();
                }
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
    
    
    private boolean existeAuspiciante(String auspiciante){ 
        for ( int i = 0; i < listaAuspiciantes.length; i++ ){ 
            if( ((String)listaAuspiciantes.iterar(i)).equals(auspiciante)){ 
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

    public int cantidadDeAuspiciantes() {
        return listaAuspiciantes.length; 
    }
    
    public void imprimirListaParticipantes(){ 
        MENSAJE.imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++ ){ 
            Participante p = (Participante)listaParticipantes.iterar(i);
            System.out.println(p.toString());
        }
    }
    
    public void imprimirListaParticipantesSiParticipes(){ 
        MENSAJE.imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getHoraDeLlegada() != 0) {
                System.out.println(p.toString());
            }
            
        }
    }
    
    public void imprimirParticipantePorCedula(String cedula) {
        MENSAJE.imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getCedula().equals(cedula)){
                System.out.println(p.toString());
            }
        }
    }
    public void imprimirPorCategoria(char categoria){ 
        MENSAJE.imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getCategoria() == categoria && p.getHoraDeLlegada() != 0){
                System.out.println(p.toString());
            }
        }
    }
        
    public void imprimirListaParticipantesNoParticipes(){ 
        MENSAJE.imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( !p.getParticipo() ){
                System.out.println(p.toString());
            }
        }
    }

    
    public void imprimirNoCompletaron() {
        MENSAJE.imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getHoraDeLlegada() == 0 && p.getParticipo()){
                System.out.println(p.toString());
            }
        }
    }
    public void imprimirParticipantesPorAuspiciante(int opcion){ 
        MENSAJE.imprimirCabecera();
        String auspiciante = (String)listaAuspiciantes.iterar(opcion-1);
        for ( int i = 0; i < listaParticipantes.length; i++){
            Participante p = (Participante)listaParticipantes.iterar(i);
            if ( p.getAuspiciantes().contains(auspiciante) && p.getHoraDeLlegada() != 0){
                System.out.println(p.toString());
            }
        }
    }

   
    public void imprimirListaAuspiciantes() {
        for ( int i = 0; i < listaAuspiciantes.length; i++){ 
            System.out.println("["+(i+1)+"] "+listaAuspiciantes.iterar(i).toString());
        }
    }

    public void imprimirParticipante(Participante participante) {
        for ( int i = 0; i< listaParticipantes.length; i++ ){ 
            Participante p = (Participante)listaParticipantes.iterar(i); 
            if ( p == participante ){ 
                System.out.println(p.toString());
            }
        }
    }

    

    
}
