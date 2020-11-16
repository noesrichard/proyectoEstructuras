/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradadedatos;

import entradadedatos.ENTRADAS;
import java.util.Scanner;

/**
 *
 * @author carri
 */
public class Consola {
    private static Consola instancia = null;
    public Scanner input;

    private Consola() {
        input = new Scanner(System.in);
    }

    public static Consola get_() {
        if (instancia == null) {
            instancia = new Consola();
        }
        return instancia;
    }

    public static String ingresarDato(ENTRADAS entrada) {
        String dato = null;
        while (dato == null) {
            System.out.print(entrada.getPeticion());
            dato = Consola.get_().input.nextLine().toUpperCase();
            dato = entrada.validar(dato);
            if ( dato == null )
                System.out.println(entrada.getError());
        }
        return dato; 
    }
    
    
}
