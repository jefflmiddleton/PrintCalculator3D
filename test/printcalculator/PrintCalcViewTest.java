/*
 *  Jeff Middleton
 *  JeffLMiddleton@gmail.com
 *  Created  2018
 */
package printcalculator;

import java.awt.Container;
import javax.swing.JTextField;
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
public class PrintCalcViewTest {
    
    public PrintCalcViewTest() {
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
     * Test of clearTable method, of class PrintCalcView.
     */
    @Test
    public void testClearTable() {
        System.out.println("clearTable");
        PrintCalcView instance = null;
        instance.clearTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addComponentsToPane method, of class PrintCalcView.
     */
    @Test
    public void testAddComponentsToPane() {
        System.out.println("addComponentsToPane");
        Container cpane = null;
        PrintCalcView instance = null;
        instance.addComponentsToPane(cpane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class PrintCalcView.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        PrintCalcView instance = null;
        JTextField expResult = null;
        JTextField result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
