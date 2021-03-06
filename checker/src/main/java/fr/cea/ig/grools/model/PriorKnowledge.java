package fr.cea.ig.grools.model;

/*
 * Copyright LABGeM 21/01/15
 *
 * author: Jonathan MERCIER
 *
 * This software is a computer program whose purpose is to annotate a complete genome.
 *
 * This software is governed by the CeCILL  license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 */
/*
 * @startuml
 * interface  PriorKnowledge extends Fact{
 *  + getPartOf()       : PriorKnowledge[]
 *  + getNodeType()     : NodeType
 *  + getConclusion()   : Conclusion
 *  + getIsA()          : List<PriorKnowledge>
 *  + addIsA( PriorKnowledge k )             : void
 *  + setConclusion( Conclusion conclusion ) : void
 *  + setPresence( FourState presence )      : void
 * }
 * hide  PriorKnowledge fields
 * hide  Fact fields
 * PriorKnowledge "0..*" *-- "1" PriorKnowledge
 * @enduml
 */
public interface PriorKnowledge extends Fact{
    @NotNull
    public PriorKnowledge[]  getPartOf();
    @NotNull
    public NodeType     getNodeType();
    @NotNull
    public Conclusion   getConclusion();

    public void setConclusion( final @NotNull Conclusion conclusion);
    public void setPresence( final @NotNull FourState presence );

    @NotNull
    List<PriorKnowledge> getIsA();

    public void addIsA(final @NotNull PriorKnowledge k);
}
