/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradadedatos;

import validacion.Validador;

/**
 *
 * @author carri
 */
public enum ENTRADAS {
    NOMBRE(MENSAJES.NOMBRE, REGEX.NOMBRE.txt());

    private enum MENSAJES {
        NOMBRE("INGRESE EL NOMBRE DEL PARTICIPANTE: ", "EL NOMBRE DEL PARTICIPANTE ES INVALIDO");
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

        NOMBRE("[a-zA-Z]+");

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

}
