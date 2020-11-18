/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradadedatos;

import validacion.Cedula;
import validacion.Validador;

/**
 *
 * @author carri
 */
enum ENTRADAS {
    NOMBRE          (MENSAJES.NOMBRE, REGEX.NOMBRE_APELLIDO.txt()),
    CEDULA_NUEVA    (MENSAJES.CEDULA,new Cedula(Cedula.CEDULA_NUEVA)), 
    APELLIDO        (MENSAJES.APELLIDO, REGEX.NOMBRE_APELLIDO.txt()), 
    EDAD            (MENSAJES.EDAD, REGEX.NUMEROS_ENTEROS.txt()), 
    SEXO            (MENSAJES.SEXO, REGEX.SEXO.txt()),
    MENU            (MENSAJES.MENU, REGEX.MENU.txt()), 
    CEDULA_EXISTENTE(MENSAJES.CEDULA, new Cedula(Cedula.CEDULA_EXISTENTE)), 
    ID              (MENSAJES.ID, REGEX.NUMEROS_ENTEROS.txt()), 
    AUSPICIANTES    (MENSAJES.AUSPICIANTES, REGEX.TODO.txt()), 
    HORAS           (MENSAJES.HORAS, REGEX.NUMEROS_ENTEROS.txt()), 
    MINUTOS         (MENSAJES.MINUTOS, REGEX.MIN_SEG.txt()), 
    SEGUNDOS        (MENSAJES.SEGUNDOS, REGEX.MIN_SEG.txt());

    private enum MENSAJES {
        NOMBRE      ("INGRESE EL NOMBRE DEL PARTICIPANTE: ", "EL NOMBRE DEL PARTICIPANTE ES INVALIDO!"),
        CEDULA      ("INGRESE LA CEDULA: ","CEDULA NO VALIDA!"),
        APELLIDO    ("INGRESE EL APELLIDO DEL PARTICIPANTE: ","EL APELLIDO DEL PARTICIPANTE ES INVALIDO!"), 
        EDAD        ("INGRESE LA EDAD DEL PARTICIPANTE: ","LA EDAD DEL PARTICIPANTE ES INVALIDA!"), 
        SEXO        ("INGRESE EL SEXO DEL PARTICIPANTE (M|F): ","EL SEXO DEL PARTICIPANTE NO ES VALIDO!"), 
        MENU        ("OPCION: ","OPCION NO VALIDA!"),
        ID          ("INGRESE EL NUMERO DE ID DEL PARTICIPANTE: ","NUMERO ERRONEO!"), 
        AUSPICIANTES("INGRESE LOS AUSPICIANTES DEL PARTICIPANTE (X,Y,...): ","FORMATO NO VALIDO!"), 
        HORAS       ("HORAS (HH): ","FORMATO NO VALIDO!"), 
        MINUTOS     ("MINUTOS (MM): ","FORMATO NO VALIDO!"), 
        SEGUNDOS    ("SEGUNDOS (SS): ","FORMATO NO VALIDO!");
        
        private String peticion, error;

        private MENSAJES(String peticion, String error) {
            this.peticion = peticion;
            this.error = error;
        }
        String getPeticion() {
            return this.peticion;
        }
        String getError() {
            return this.error;
        }
    }

    private enum REGEX {
        NOMBRE_APELLIDO ("[a-zA-Z]+"), 
        NUMEROS_ENTEROS ("[0-9]+"), 
        SEXO            ("M|F"), 
        MENU            ("[0-%d]"), 
        TODO            (".{0,}"), 
        MIN_SEG         ("[0-5][0-9]");

        private String valor;

        private REGEX(String valor) {
            this.valor = valor;
        }
        public String txt() {
            return this.valor;
        }
    }

    private MENSAJES mensajes;
    private String regex;
    private Validador validador = null;

    private ENTRADAS(MENSAJES mensajes, String regex) {
        this.mensajes = mensajes;
        this.regex = regex;
    }

    private ENTRADAS(MENSAJES mensajes, Validador validador) {
        this.mensajes = mensajes;
        this.validador = validador;
    }

    public String validar(String dato) {
        if (this.validador != null) {
            return this.validador.validar(dato);
        } else if (dato.matches(regex)) {
            return dato;
        }
        return null;
    }

    public String getPeticion() {
        return this.mensajes.getPeticion();
    }

    public String getError() {
        return this.mensajes.getError();
    }
    
    public void setNumeroDeOpcionesMenu(int numOpciones){ 
        this.regex = String.format("[0-%d]", numOpciones);
    }

}
