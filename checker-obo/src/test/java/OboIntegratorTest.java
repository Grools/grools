/*
 * Copyright LABGeM 26/03/15
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


import fr.cea.ig.grools.Grools;
import fr.cea.ig.grools.model.PriorKnowledge;
import fr.cea.ig.grools.model.NodeType;
import fr.cea.ig.grools.obo.OboIntegrator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class OboIntegratorTest {

    private Grools grools;
    private OboIntegrator oboIntegrator;

    @Before
    public void setUp(){
        grools = new Grools();
        assertNotNull(grools);
        oboIntegrator = new OboIntegrator(grools);
        assertNotNull(oboIntegrator);
        try {
            oboIntegrator.useDefault();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void testPathwayIntegration(){
        final PriorKnowledge knowledge = grools.hasKnowledgeId("UPA00033");
        assertNotNull(knowledge);
        assertTrue(knowledge.getId().equals("UPA00033"));
         assertTrue( knowledge.getNodeType() == NodeType.OR );
        final List<PriorKnowledge> variants = grools.getSubKnowledge(knowledge);
        assertNotNull( variants );
        final PriorKnowledge UPA00033Variant1 = (variants.get(0).getId().equals("UPA00033-alt-1"))  ? variants.get(0) :  variants.get(1);
        final PriorKnowledge UPA00033Variant2 = (variants.get(0).getId().equals("UPA00033-alt-2"))  ? variants.get(0) :  variants.get(1);
        assertTrue( UPA00033Variant1.getId().equals("UPA00033-alt-1") );
        assertTrue( UPA00033Variant2.getId().equals("UPA00033-alt-2") );
        final List<PriorKnowledge> uls = grools.getSubKnowledge(UPA00033Variant1);
        assertNotNull(uls);
        final PriorKnowledge ULS00013 = (uls.get(0).getId().equals("ULS00013"))  ? uls.get(0) :  uls.get(1);
        final PriorKnowledge ULS00012 = (uls.get(0).getId().equals("ULS00012"))  ? uls.get(0) :  uls.get(1);
        assertTrue(ULS00012.getId().equals("ULS00012"));
        assertTrue(ULS00013.getId().equals("ULS00013"));
    }



}
