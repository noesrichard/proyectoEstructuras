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
public enum MENSAJE {
    
    AGREGAR_PARTICIPANTE("SE AGREGO AL PARTICIPANTE CORRECTAMENTE! ", "NO SE PUDO AGREGAR AL PARTICIPANTE DEBIDO A UN ERROR!"),
    BORRAR_PARTICIPANTE("SE BORRO AL PARTICIPANTE CORRECTAMENTE! ", "NO SE PUDO BORRAR AL PARTICIPANTE DEBIDO A UN ERROR!");
    
    private String valido, error; 
    
    private MENSAJE(String valido, String error){ 
        this.valido = valido; 
        this.error = error; 
    }
    
    private MENSAJE(String error){ 
        this.error = error; 
    }
    
    public void printValido(){ 
        System.out.println(this.valido);
    }
    
    public void printError(){ 
        System.out.println(this.error);
    }
    static void imprimirCabecera() {
        System.out.println("---------------------------------------------------"
                + "------------------------------------------------------------"
                + "-------");
        System.out.printf("%5s %10s %20s %20s %30s %4s %4s %9s %6s \n","ID",
                "CEDULA", "NOMBRE", "APELLIDO", "AUSPICIANTES",
                "EDAD", "SEXO", "CATEGORIA", "HORA");
        System.out.println("---------------------------------------------------"
                + "------------------------------------------------------------"
                + "------");
    }
}
