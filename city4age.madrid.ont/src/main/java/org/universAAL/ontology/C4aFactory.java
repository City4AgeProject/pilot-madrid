
package org.universAAL.ontology;

import org.universAAL.middleware.rdf.Resource;
import org.universAAL.middleware.rdf.ResourceFactory;
import org.universAAL.ontology.c4a.BodyState;
import org.universAAL.ontology.c4a.Enter_Bus;
import org.universAAL.ontology.c4a.Enter_home;
import org.universAAL.ontology.c4a.Exit_Bus;
import org.universAAL.ontology.c4a.Exit_home;
import org.universAAL.ontology.c4a.IndoorHomeMonitoring;
import org.universAAL.ontology.c4a.InterventionWithTransportation;
import org.universAAL.ontology.c4a.LEA;
import org.universAAL.ontology.c4a.Stay;
import org.universAAL.ontology.c4a.Stay_start;
import org.universAAL.ontology.c4a.Stay_stop;
import org.universAAL.ontology.c4a.Walking;
import org.universAAL.ontology.c4a.Walking_info;
import org.universAAL.ontology.c4a.Walking_start;
import org.universAAL.ontology.c4a.Walking_stop;

public class C4aFactory implements ResourceFactory {


  public Resource createInstance(String classURI, String instanceURI, int factoryIndex) {

	switch (factoryIndex) {
     case 0:
       return new Walking_stop(instanceURI);
     case 1:
       return new Enter_home(instanceURI);
     case 2:
       return new Exit_home(instanceURI);
     case 3:
       return new Stay_stop(instanceURI);
     case 4:
       return new IndoorHomeMonitoring(instanceURI);
     case 5:
       return new Stay(instanceURI);
     case 6:
       return new Stay_start(instanceURI);
     case 7:
       return new LEA(instanceURI);
     case 8:
       return new Walking_info(instanceURI);
     case 9:
       return new Walking(instanceURI);
     case 10:
       return new Exit_Bus(instanceURI);
     case 11:
       return new Walking_start(instanceURI);
     case 12:
       return new BodyState(instanceURI);
     case 13:
       return new InterventionWithTransportation(instanceURI);
     case 14:
       return new Enter_Bus(instanceURI);

	}
	return null;
  }
}
