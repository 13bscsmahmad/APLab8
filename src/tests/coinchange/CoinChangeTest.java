/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MMA
 */
public class CoinChangeTest {

    public CoinChangeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of changeGreedy method, of class CoinChange.
     */
    @Test
    public void testChangeGreedy() {
        System.out.println("changeGreedy");
        int money = 200;
        int[] expResult = {8,0,0,0};
        int[] result = CoinChange.changeGreedy(money);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of minChange method, of class CoinChange.
     */
    @Test
    public void testMinChange() {
        System.out.println("minChange");
        int[] denom = {1,5,10,25};
        int targetAmount = 200;
        int expResult = 8;
        int result = CoinChange.minChange(denom, targetAmount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class CoinChange.
     */
    @Test
    public void testPrint() {
        System.out.println("print");

        int[] denominations = CoinChange.changeGreedy(200);
        CoinChange.print(denominations);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CoinChange.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CoinChange.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
