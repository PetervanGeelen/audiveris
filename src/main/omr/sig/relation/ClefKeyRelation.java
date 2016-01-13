//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                  C l e f K e y R e l a t i o n                                 //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2016. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package omr.sig.relation;

import omr.constant.Constant;
import omr.constant.ConstantSet;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class {@code ClefKeyRelation} represents a support relation between a clef and a
 * compatible key signature.
 *
 * @author Hervé Bitteur
 */
@XmlRootElement(name = "clef-key")
public class ClefKeyRelation
        extends AbstractSupport
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Constants constants = new Constants();

    //~ Constructors -------------------------------------------------------------------------------
    /**
     * Creates a new {@code ClefKeyRelation} object.
     */
    public ClefKeyRelation ()
    {
    }

    //~ Methods ------------------------------------------------------------------------------------
    //----------------//
    // getSourceCoeff //
    //----------------//
    @Override
    protected double getSourceCoeff ()
    {
        return constants.clefSupportCoeff.getValue();
    }

    //----------------//
    // getTargetCoeff //
    //----------------//
    @Override
    protected double getTargetCoeff ()
    {
        return constants.keySupportCoeff.getValue();
    }

    //~ Inner Classes ------------------------------------------------------------------------------
    //-----------//
    // Constants //
    //-----------//
    private static final class Constants
            extends ConstantSet
    {
        //~ Instance fields ------------------------------------------------------------------------

        private final Constant.Ratio clefSupportCoeff = new Constant.Ratio(
                5,
                "Value for (source) clef coeff in support formula");

        private final Constant.Ratio keySupportCoeff = new Constant.Ratio(
                5,
                "Value for (target) key coeff in support formula");
    }
}
