
package org.universAAL.ontology;

import org.universAAL.middleware.container.ModuleActivator;
import org.universAAL.middleware.container.ModuleContext;
import org.universAAL.middleware.owl.OntologyManagement;
import org.universAAL.ontology.c4a.C4aOntology;


public class C4aActivator implements ModuleActivator {

  C4aOntology _c4aOntology = new C4aOntology();


  public void start(ModuleContext mc) throws Exception {
    OntologyManagement.getInstance().register(mc, _c4aOntology);
  }

  public void stop(ModuleContext mc) throws Exception {
    OntologyManagement.getInstance().unregister(mc, _c4aOntology);
  }
}	
