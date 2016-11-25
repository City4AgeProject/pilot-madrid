package org.universAAL.ontology.c4a;



/**
 * Ontological representation of Enter_home in the c4a ontology. 
 * Methods included in this class are the mandatory ones for representing an
 * ontological concept in Java classes for the universAAL platform. In addition
 * getters and setters for properties are included.
 * 
 * @author 
 * @author Generated by the OntologyUML2Java transformation of AAL Studio
 */
public class Enter_home extends IndoorHomeMonitoring {
  public static final String MY_URI = C4aOntology.NAMESPACE
    + "Enter_home";


  public Enter_home () {
    super();
  }
  
  public Enter_home (String uri) {
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
