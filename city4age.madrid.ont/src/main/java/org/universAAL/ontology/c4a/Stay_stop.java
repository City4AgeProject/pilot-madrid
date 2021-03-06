package org.universAAL.ontology.c4a;



/**
 * Ontological representation of Stay_stop in the c4a ontology. 
 * Methods included in this class are the mandatory ones for representing an
 * ontological concept in Java classes for the universAAL platform. In addition
 * getters and setters for properties are included.
 * 
 * @author 
 * @author Generated by the OntologyUML2Java transformation of AAL Studio
 */
public class Stay_stop extends Stay {
  public static final String MY_URI = C4aOntology.NAMESPACE
    + "Stay_stop";


  public Stay_stop () {
    super();
  }
  
  public Stay_stop (String uri) {
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
