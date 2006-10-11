//----------------------------------------------------------------------------//
//                                                                            //
//                         T o g g l e H a n d l e r                          //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2006. All rights reserved.               //
//  This software is released under the terms of the GNU General Public       //
//  License. Please contact the author at herve.bitteur@laposte.net           //
//  to report bugs & suggestions.                                             //
//----------------------------------------------------------------------------//
//
package omr.ui;

import omr.lag.LagView;

import omr.util.Implement;
import omr.util.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * Class <code>ToggleHandler</code> handles the general-purpose toggle button of
 * the user interface, according to the currently selected view within the
 * {@link SheetAssembly}.
 *
 * <p>When the related view is active (and this is handled through the
 * AncestorListener interface), pressing the toggle button triggers the {@link
 * omr.lag.LagView#toggle} method of the selected {@link omr.lag.LagView}.
 *
 * @author Herv&eacute; Bitteur
 * @version $Id$
 */
public class ToggleHandler
    implements ActionListener, AncestorListener
{
    //~ Static fields/initializers ---------------------------------------------

    private static final Logger logger = Logger.getLogger(ToggleHandler.class);

    //~ Instance fields --------------------------------------------------------

    private JButton button;
    private LagView lagView;
    private String  tip;
    private String  title;

    //~ Constructors -----------------------------------------------------------

    //---------------//
    // ToggleHandler //
    //---------------//
    /**
     * Creates a new ToggleHandler object.
     *
     * @param title (for debugging) name of the containing frame
     * @param lagView the view to toggle
     * @param tip tool tip for the toggle button
     */
    public ToggleHandler (String  title,
                          LagView lagView,
                          String  tip)
    {
        this.title = title;
        this.lagView = lagView;
        this.tip = tip;
        button = omr.Main.getJui().sheetController.getToggleButton();
        useButton();
    }

    //~ Methods ----------------------------------------------------------------

    //-----------------//
    // actionPerformed //
    //-----------------//
    /**
     * Method called by the toggle button when pressed
     *
     * @param e the action event
     */
    @Implement(ActionListener.class)
    public void actionPerformed (ActionEvent e)
    {
        lagView.toggle();
    }

    //---------------//
    // ancestorAdded //
    //---------------//
    /**
     * Method called when the related view becomes visible
     *
     * @param event
     */
    @Implement(AncestorListener.class)
    public void ancestorAdded (AncestorEvent event)
    {
        useButton();
    }

    //---------------//
    // ancestorMoved //
    //---------------//
    /**
     * Not interested in that method, imposed by the AncestorListener interface
     *
     * @param event
     */
    @Implement(AncestorListener.class)
    public void ancestorMoved (AncestorEvent event)
    {
    }

    //-----------------//
    // ancestorRemoved //
    //-----------------//
    /**
     * Method called when the related view gets hidden
     *
     * @param event
     */
    @Implement(AncestorListener.class)
    public void ancestorRemoved (AncestorEvent event)
    {
        discardButton();
    }

    //---------------//
    // discardButton //
    //---------------//
    private void discardButton ()
    {
        if (logger.isFineEnabled()) {
            logger.fine(title + " discardButton");
        }

        button.setToolTipText("");
        button.setEnabled(false);
        button.removeActionListener(this);
    }

    //-----------//
    // useButton //
    //-----------//
    private void useButton ()
    {
        if (logger.isFineEnabled()) {
            logger.fine(title + " useButton");
        }

        button.setToolTipText(tip);
        button.setEnabled(true);
        button.removeActionListener(this); // Safer
        button.addActionListener(this);
    }
}
