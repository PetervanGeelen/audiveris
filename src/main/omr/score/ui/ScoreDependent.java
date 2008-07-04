//----------------------------------------------------------------------------//
//                                                                            //
//                        S c o r e D e p e n d e n t                         //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2007. All rights reserved.               //
//  This software is released under the GNU General Public License.           //
//  Contact author at herve.bitteur@laposte.net to report bugs & suggestions. //
//----------------------------------------------------------------------------//
//
package omr.score.ui;

import omr.selection.Selection;
import omr.selection.SelectionHint;
import omr.selection.SelectionObserver;
import omr.selection.SelectionTag;

import omr.sheet.Sheet;

import omr.ui.SheetDependent;

import omr.util.Implement;
import omr.util.Logger;

/**
 * Class <code>ScoreDependent</code> handles the dependency on score
 * availability
 *
 * @author Herv&eacute Bitteur
 * @version $Id$
 */
public abstract class ScoreDependent
    extends SheetDependent
{
    //~ Static fields/initializers ---------------------------------------------

    /** Usual logger utility */
    private static final Logger logger = Logger.getLogger(ScoreDependent.class);

    //~ Instance fields --------------------------------------------------------

    /** Indicates whether there is a current score */
    protected boolean scoreAvailable = false;

    //~ Constructors -----------------------------------------------------------

    //----------------//
    // ScoreDependent //
    //----------------//
    /**
     * Creates a new ScoreDependent object.
     */
    protected ScoreDependent ()
    {
    }

    //~ Methods ----------------------------------------------------------------

    //---------//
    // getName //
    //---------//
    /**
     * {@inheritDoc}
     */
    @Implement(SelectionObserver.class)
    @Override
    public String getName ()
    {
        return "ScoreDependent";
    }

    //-------------------//
    // setScoreAvailable //
    //-------------------//
    /**
     * Setter for scoreAvailable property
     * @param scoreAvailable the new property value
     */
    public void setScoreAvailable (boolean scoreAvailable)
    {
        boolean oldValue = this.scoreAvailable;
        this.scoreAvailable = scoreAvailable;
        firePropertyChange("scoreAvailable", oldValue, this.scoreAvailable);
    }

    //------------------//
    // isScoreAvailable //
    //------------------//
    /**
     * Getter for scoreAvailable property
     * @return the current property value
     */
    public boolean isScoreAvailable ()
    {
        return scoreAvailable;
    }

    //--------//
    // update //
    //--------//
    /**
     * Notification of sheet selection (and thus related score if any)
     *
     * @param selection the selection object (SHEET)
     * @param hint processing hint (not used)
     */
    @Implement(SelectionObserver.class)
    @Override
    public void update (Selection     selection,
                        SelectionHint hint)
    {
        super.update(selection, hint);

        if (selection.getTag() == SelectionTag.SHEET) {
            Sheet sheet = (Sheet) selection.getEntity();
            setScoreAvailable((sheet != null) && (sheet.getScore() != null));
        }
    }
}