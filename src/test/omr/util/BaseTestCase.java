//-----------------------------------------------------------------------//
//                                                                       //
//                        B a s e T e s t C a s e                        //
//                                                                       //
//  Copyright (C) Herve Bitteur 2000-2006. All rights reserved.          //
//  This software is released under the terms of the GNU General Public  //
//  License. Please contact the author at herve.bitteur@laposte.net      //
//  to report bugs & suggestions.                                        //
//-----------------------------------------------------------------------//

package omr.util;

import static junit.framework.Assert.*;

import junit.framework.*;

/**
 * Class <code>BaseTestCase</code> is a customized version of TestCase, in
 * order to factor additional test features.
 *
 * @author Herv&eacute; Bitteur
 * @version $Id$
 */
public class BaseTestCase
    extends TestCase
{
    //---------//
    // runTest //
    //---------//
    @Override
    protected void runTest() throws Throwable {
        System.out.println("\n---\n" + getName() +":");
        super.runTest();
        System.out.println("+++ End " + toString());
    }

    //-------//
    // print //
    //-------//
    public static void print (Object o)
    {
        System.out.println(o);
    }

    //----------------//
    // checkException //
    //----------------//
    public static void checkException (Exception ex)
    {
        System.out.println("Got " + ex);
        assertNotNull(ex.getMessage());
    }

    //-------------//
    // assertNears //
    //-------------//
    public static void assertNears (String msg,
                                    double a,
                                    double b)
    {
        assertNears(msg, a, b, 1E-5);
    }

    //-------------//
    // assertNears //
    //-------------//
    public static void assertNears (String msg,
                                    double a,
                                    double b,
                                    double maxDiff)
    {
        System.out.println("Comparing " + a + " and " + b);
        assertTrue(msg,
                   Math.abs(a - b) < maxDiff);
    }
}
