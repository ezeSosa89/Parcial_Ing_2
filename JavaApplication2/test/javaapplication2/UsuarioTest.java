/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ezequ
 */
public class UsuarioTest {
    
    private static Usuario usr;
    
    public UsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        usr = new Usuario("Juanjo", 1212);
        System.out.println("TEST de usuario");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin de las pruebas " + LocalDate.now().minusDays(1));
    }
    
    @Before
    public void setUp() {
        System.out.println("---------------------------");
    }
    
    @After
    public void tearDown() {
    }
  
    @Test
    public void testValidarPassword() {
       assertTrue(usr.validarPassword(1212));
       assertFalse(usr.validarPassword(54321));
    }

    /**
     * Test of cambioPassword method, of class Usuario.
     */
    @Test
    public void testCambioPassword() {
        usr.cambioPassword("67890");
        assertTrue(usr.validarPassword(67890));
    }

    /**
     * Test of delay method, of class Usuario.
     */
    @Test
    public void testDelay() {
        long startTime = System.currentTimeMillis();
        usr.delay(1000);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        assertTrue(elapsedTime >= 1000);
    }

    /**
     * Test of usuariosDiferentes method, of class Usuario.
     */
    @Test
    public void testUsuariosDiferentes() {
        Usuario usr2 = new Usuario("usuarioPrueba2", 54321);
        assertTrue(usr.usuariosDiferentes(usr2));

        usr2 = new Usuario("Juanjo", 1212);
        assertFalse(usr.usuariosDiferentes(usr2));
    }
    
    @Test
    public void testValidarUsr() {
        assertFalse(usr.validarPassword(2222));
    }

    // Test para validar el email (debe TENER ÉXITO)
    @Test
    public void testValidarEmail() {
        String email = "usuario@dominio.com";
        assertTrue(email.length() < 20 && email.contains("@") && email.contains("."));
        System.out.println("Vallidar Email");
    }

    // Test para cambiar la contraseña y comparar con assertEquals (debe TENER ÉXITO)
    @Test
    public void testCambioPass() {
        String newPass = "1234";
        usr.cambioPassword(newPass);
        assertEquals(Integer.parseInt(newPass), usr.getPass());
        System.out.println("Contraseña cambiada con éxito.");
    }
    
     // Test con timeout para el método delay (debe CAUSAR ERROR)
    @Test(timeout = 30)
    public void testDelay2() throws InterruptedException {
        usr.delay(50);
    }

    // Test para usuarios diferentes (debe TENER ÉXITO)
    @Test
    public void testUsuariosDiferentes2() {
        Usuario u1 = new Usuario("user1", 1111);
        Usuario u2 = new Usuario("user2", 2222);

        assertNotSame("Mismo usuario", u1, u2);
    }
    
}
