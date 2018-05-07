/*
 *  Jeff Middleton
 *  JeffLMiddleton@gmail.com
 *  Created  2018
 */
package printcalculator;

import java.awt.Button;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeff Middleton
 */
public class PrintCalcControllerTest {
    
    public PrintCalcControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of control method, of class PrintCalcController.
     */
    @Test
    public void testControl() {
        System.out.println("contol");
        PrintCalcController instance = new PrintCalcController(null, null);
        instance.control();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of highlightErrors method, of class PrintCalcController.
     */
    @Test
    public void testHighlightErrors() {
        System.out.println("highlightErrors");
        PrintCalcController instance = new PrintCalcController(null, null);
        instance.highlightErrors();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateScale method, of class PrintCalcController.
     */
    @Test
    public void testCalculateScale() {
        System.out.println("calculateScale");
        PrintCalcController instance = new PrintCalcController(null, null);
        instance.calculateScale();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNumber method, of class PrintCalcController.
     */
    @Test
    public void testCheckNumber() {
        System.out.println("checkNumber");
        PrintCalcController instance = new PrintCalcController(null, null);
        Button a = new Button("click");
        KeyEvent evt = new KeyEvent(a, 1, 20, 1, 10, 'a');
//        KeyEvent evt = null;
        instance.checkNumber(evt);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
