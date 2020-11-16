/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradadedatos;

import entradadedatos.Campos.CAMPOS;
import java.util.Scanner;

/**
 *
 * @author carri
 */
public class Entrada {
    private static Entrada instancia = null;
    public Scanner entrada;

    private Entrada() {
        entrada = new Scanner(System.in);
    }

    public static Entrada get_() {
        if (instancia == null) {
            instancia = new Entrada();
        }
        return instancia;
    }

    public static String ingresarDato(CAMPOS campo) {
        String dato = null;
        while (dato == null) {
            System.out.print(campo.getPeticion());
            dato = Entrada.get_().entrada.nextLine().toUpperCase();
            dato = campo.validar(dato);
            if ( dato == null )
                System.out.println(campo.getError());
        }
        return dato; 
    }
    
    
}
