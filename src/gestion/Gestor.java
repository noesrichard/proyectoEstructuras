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
    private ListaParticipantes listaParticipantes;
    private static Gestor instancia = null;
    private String estadoMaraton;  
    
    private Gestor() {
        this.listaParticipantes = new ListaParticipantes();
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
    }
    
    public String getEstadoMaraton() {
        return this.estadoMaraton;
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
    
    public boolean agregarParticipante(String cedula,String nombre,String apellido,
                                    int edad, char sexo,String auspiciantes){
        char categoria = determinarCategoria(edad);
        return listaParticipantes.add(new Participante(cedula,nombre,
                apellido, edad, sexo, auspiciantes, categoria));
    } 
    
    public void imprimirLista(){ 
        imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            System.out.println(listaParticipantes.iterar(i).toString());
        }
    }

    public void imprimirParticipantePorCedula(String cedula) {
        imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            if ( listaParticipantes.iterar(i).getCedula().equals(cedula)){
                System.out.println(listaParticipantes.iterar(i).toString());
            }
        }
    }

    public void borrarParticipantePorCedula(String cedula) {
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            if ( listaParticipantes.iterar(i).getCedula().equals(cedula)){
                listaParticipantes.borrar(i);
            }
        }
    }

    public Participante getParticipantePorCedula(String cedula) {
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            if ( listaParticipantes.iterar(i).getCedula().equals(cedula)){
                return listaParticipantes.iterar(i); 
            }
        }
        return null; 
    }

    public Participante getParticipante(Participante participante) {
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            if ( listaParticipantes.iterar(i) == participante){
                return listaParticipantes.iterar(i); 
            }
        }
        return null; 
    }

    public Participante getParticipantePorId(int id) {
        for ( int i = 0; i < listaParticipantes.length; i++){ 
            if ( listaParticipantes.iterar(i).getId() == id){
                return listaParticipantes.iterar(i); 
            }
        }
        return null;
    }

    public void imprimirPorCategoria(char categoria){ 
        imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            if ( listaParticipantes.iterar(i).getCategoria() == categoria ){
                System.out.println(listaParticipantes.iterar(i).toString());
            }
        }
    }
    
    public void imprimirNoParticipes(){ 
        imprimirCabecera();
        for ( int i = 0; i < listaParticipantes.length; i++){
            if ( !listaParticipantes.iterar(i).getParticipo() ){
                System.out.println(listaParticipantes.iterar(i).toString());
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
            if ( listaParticipantes.iterar(i).getHoraDeLlegada() == 0 ){
                System.out.println(listaParticipantes.iterar(i).toString());
            }
        }
    }

    
}
