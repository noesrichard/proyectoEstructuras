/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import main.Participante;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author carri
 */
public class GestorTest {
    static final Gestor refeInstance = Gestor.get_();
    public GestorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Gestor g = Gestor.get_(); 
        g.agregarParticipante("123","Richrad","Carrion",12,'M',"Nike");
        g.agregarParticipante("456","Manuel","Valarezo",18,'M',"Adidas");
        g.agregarParticipante("789","Jessica","Tituana",36,'M',"Puma");
        g.agregarParticipante("1234","Carlos","Llamuca",12,'M',"Nike");
        g.getParticipantePorCedula("456").setHoraDeLlegada(1);
        g.getParticipantePorCedula("789").setHoraDeLlegada(2);
        g.getParticipantePorCedula("1234").setHoraDeLlegada(5);
        g.getParticipantePorCedula("123").noParticipo();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test of get_ method, of class Gestor.
     */
    @Test
    public void testGet_() {
        System.out.println("get_");
    
        Gestor expResult = refeInstance;
        Gestor result = Gestor.get_();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of imprimirCabecera method, of class Gestor.
     */
    
    
    @Test
    public void testImprimirCabecera() {
        System.out.println("imprimirCabecera");
        Gestor instance = Gestor.get_();
        instance.imprimirCabecera();
    }

    /**
     * Test of iniciarMaraton method, of class Gestor.
     */
    @Test
    public void testIniciarMaraton() {
        System.out.println("iniciarMaraton");
        Gestor instance = Gestor.get_();
        instance.iniciarMaraton();
    }

    /**
     * Test of finalizarMaraton method, of class Gestor.
     */
    @Test
    public void testFinalizarMaraton() {
        System.out.println("finalizarMaraton");
        Gestor instance = Gestor.get_();
        instance.finalizarMaraton();
    }

    /**
     * Test of getEstadoMaraton method, of class Gestor.
     */
    @Test
    public void testGetEstadoMaraton() {
        System.out.println("getEstadoMaraton");
        Gestor instance = Gestor.get_();
        String expResult = "";
        String result = instance.getEstadoMaraton();
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarParticipante method, of class Gestor.
     */
    @Test
    public void testAgregarParticipante() {
        System.out.println("agregarParticipante");
        String cedula = "";
        String nombre = "";
        String apellido = "";
        int edad = 0;
        char sexo = ' ';
        String auspiciantes = "Apple";
        Gestor instance = refeInstance;
        instance.agregarParticipante(cedula, nombre, apellido, edad, sexo, auspiciantes);
    }

    /**
     * Test of imprimirListaParticipantes method, of class Gestor.
     */
    @Test
    public void testImprimirListaParticipantes() {
        System.out.println("imprimirListaParticipantes");
        Gestor instance = refeInstance;
        instance.imprimirListaParticipantesSiParticipes();
    }

    /**
     * Test of imprimirParticipantePorCedula method, of class Gestor.
     */
    @Test
    public void testImprimirParticipantePorCedula() {
        System.out.println("imprimirParticipantePorCedula");
        String cedula = "";
        Gestor instance = refeInstance;
        instance.imprimirParticipantePorCedula(cedula);
    }

    /**
     * Test of borrarParticipantePorCedula method, of class Gestor.
     */
    @Test
    public void testBorrarParticipantePorCedula() {
        System.out.println("borrarParticipantePorCedula");
        String cedula = "";
        Gestor instance = refeInstance;
        instance.borrarParticipantePorCedula(cedula);
    }

    /**
     * Test of getParticipantePorCedula method, of class Gestor.
     */
    @Test
    public void testGetParticipantePorCedula() {
        System.out.println("getParticipantePorCedula");
        String cedula = "";
        Gestor instance = refeInstance;
        Participante expResult = null;
        Participante result = instance.getParticipantePorCedula(cedula);
        assertEquals(expResult, result);
    }

    /**
     * Test of getParticipante method, of class Gestor.
     */
    @Test
    public void testGetParticipante() {
        System.out.println("getParticipante");
        Participante participante = null;
        Gestor instance = refeInstance;
        Participante expResult = null;
        Participante result = instance.getParticipante(participante);
        assertEquals(expResult, result);
    }

    /**
     * Test of getParticipantePorId method, of class Gestor.
     */
    @Test
    public void testGetParticipantePorId() {
        System.out.println("getParticipantePorId");
        int id = 0;
        Gestor instance = refeInstance;
        Participante expResult = null;
        Participante result = instance.getParticipantePorId(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of imprimirPorCategoria method, of class Gestor.
     */
    @Test
    public void testImprimirPorCategoria() {
        System.out.println("imprimirPorCategoria");
        char categoria = 'A';
        Gestor instance = refeInstance;
        instance.imprimirPorCategoria(categoria);
    }

    /**
     * Test of imprimirNoParticipes method, of class Gestor.
     */
    @Test
    public void testImprimirLisatParticipesNoParticipes() {
        System.out.println("imprimirNoParticipes");
        Gestor instance = refeInstance;
        instance.imprimirListaParticipantesNoParticipes();
    }

    /**
     * Test of reportePorCategoria method, of class Gestor.
     */
    @Test
    public void testReportePorCategoria() {
        System.out.println("reportePorCategoria");
        int opcion = 0;
        Gestor instance = refeInstance;
        instance.reportePorCategoria(opcion);
    }

    /**
     * Test of imprimirNoCompletaron method, of class Gestor.
     */
    @Test
    public void testImprimirNoCompletaron() {
        System.out.println("imprimirNoCompletaron");
        Gestor instance = refeInstance;
        instance.imprimirNoCompletaron();
    }

    /**
     * Test of guardarAuspiciantes method, of class Gestor.
     */
    @Test
    public void testGuardarAuspiciantes() {
        System.out.println("guardarAuspiciantes");
        String auspiciantes = "Pull n Bear";
        Gestor instance = refeInstance;
        instance.guardarAuspiciantes(auspiciantes);
    }

    /**
     * Test of cantidadDeAuspiciantes method, of class Gestor.
     */
    @Test
    public void testCantidadDeAuspiciantes() {
        System.out.println("cantidadDeAuspiciantes");
        Gestor instance = refeInstance;
        int expResult = 3;
        int result = instance.cantidadDeAuspiciantes();
        assertEquals(expResult, result);
    }

    /**
     * Test of imprimirParticipantesPorAuspiciante method, of class Gestor.
     */
    @Test
    public void testImprimirParticipantesPorAuspiciante() {
        System.out.println("imprimirParticipantesPorAuspiciante");
        int opcion = 1;
        Gestor instance = refeInstance;
        instance.imprimirParticipantesPorAuspiciante(opcion);
    }

    /**
     * Test of imprimirListaAuspiciantes method, of class Gestor.
     */
    @Test
    public void testImprimirListaAuspiciantes() {
        System.out.println("imprimirListaAuspiciantes");
        Gestor instance = refeInstance;
        instance.imprimirListaAuspiciantes();
    }
   
    
}
