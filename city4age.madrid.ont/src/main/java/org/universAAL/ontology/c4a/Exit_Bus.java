package org.universAAL.ontology.c4a;



/**
 * Ontological representation of Exit_Bus in the c4a ontology. 
 * Methods included in this class are the mandatory ones for representing an
 * ontological concept in Java classes for the universAAL platform. In addition
 * getters and setters for properties are included.
 * 
 * @author 
 * @author Generated by the OntologyUML2Java transformation of AAL Studio
 */
public class Exit_Bus extends InterventionWithTransportation {
  public static final String MY_URI = C4aOntology.NAMESPACE
    + "Exit_Bus";


  public Exit_Bus () {
    super();
  }
  
  public Exit_Bus (String uri) {
    super(uri);
  }

  public String getClassURI() {
    return MY_URI;
  }
  
  public int getPropSerializationType(String propURI) {
    return super.getPropSerializationType(propURI);
  } 

  public boolean isWellFormed() {
	return super.isWellFormed() ;
  }

}
