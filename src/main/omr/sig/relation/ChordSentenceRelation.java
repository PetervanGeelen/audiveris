//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                            C h o r d S e n t e n c e R e l a t i o n                           //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Hervé Bitteur and others 2000-2016. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package omr.sig.relation;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class {@code ChordSentenceRelation} represents a support relation between a chord
 * and a sentence (direction, chordName).
 *
 * @author Hervé Bitteur
 */
@XmlRootElement(name = "chord-sentence")
public class ChordSentenceRelation
        extends AbstractSupport
{
}
