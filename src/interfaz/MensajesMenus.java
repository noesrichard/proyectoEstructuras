/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author carri
 */
public class MensajesMenus {

    private interface MENSAJES_MENUS {

        public String txt();
    }

    public enum MENU_PRINCIPAL implements MENSAJES_MENUS {
        CABEZERA                ("******************** MENU PRINCIPAL ********************"),
        MENU_PARTICIPANTES      ("[1] MENU PARTICIPANTES "),
        SALIDA                  ("[2] DAR SALIDA AL MARATON "),
        REGISTRAR_HORA          ("[1] REGISTAR LLEGADA PARTICIPANTE"),
        REGISTRAR_NO_PARTICIPES ("[2] REGISTRAR INSCRITO QUE NO PARTICIPO"),
        FINALIZAR               ("[3] FINALIZAR MARATON "),
        VER_REPORTES            ("[1] VER REPORTES "),
        SALIR                   ("[0] SALIR");
        

        private String valor;

        private MENU_PRINCIPAL(String v) {
            valor = v;
        }

        @Override
        public String txt() {
            return valor;
        }
    }

    public enum MENU_PARTICIPANTE implements MENSAJES_MENUS {

        CABEZERA    ("******************** MENU PARTICIPANTE ********************"),
        CREAR       ("[1] CREAR PARTICIPANTE"),
        VISUALIZAR  ("[2] VISUALIZAR PARTICIPANTE"),
        ACTUALIZAR  ("[3] ACTUALIZAR PARTICIPANTE"),
        BORRAR      ("[4] BORRAR PARTICIPANTE"),
        VOLVER      ("[0] VOLVER");

        private String valor;

        private MENU_PARTICIPANTE(String v) {
            valor = v;
        }

        @Override
        public String txt() {
            return valor;
        }
    }

    public enum MENU_ACTUALIZAR implements MENSAJES_MENUS {
        CABEZERA("******************** MENU ACTUALIZAR ********************"),
        OPCION_1("[1] ACTULIZAR NOMBRE"),
        OPCION_2("[2] ACTUALIZAR APELLIDO"),
        OPCION_3("[3] ACTUALIZAR AUSPICIANTES"),
        OPCION_4("[4] ACTUALIZAR EDAD"),
        OPCION_5("[5] ACTUALIZAR SEXO"),
        VOLVER  ("[0] VOLVER");

        private String valor;

        private MENU_ACTUALIZAR(String v) {
            valor = v;
        }

        @Override
        public String txt() {
            return valor;
        }
    }
    
    public enum ID_O_CEDULA{ 
        
        POR_ID    ("[1] POR ID"),
        POR_CEDULA("[2] POR CEDULA\n");
        
        private String valor;

        private ID_O_CEDULA(String v) {
            valor = v;
        }
        public String txt() {
            return valor;
        }
    }
    
    public static int imprimirMenu(MENSAJES_MENUS[] menu) {
        int numOpciones = 0;
        for (MENSAJES_MENUS mensaje : menu) {
            System.out.println(mensaje.txt());
            numOpciones++;
        }
        return numOpciones-2;
    }  

}
