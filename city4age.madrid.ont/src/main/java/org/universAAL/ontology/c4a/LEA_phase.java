package org.universAAL.ontology.c4a;

import org.universAAL.middleware.owl.ManagedIndividual;

public class LEA_phase extends ManagedIndividual {
  public static final String MY_URI = C4aOntology.NAMESPACE
    + "LEA_phase";

  public static final int START = 0;
  public static final int STOP = 1;
  public static final int INFO = 2;

  private static final String[] names = {
    "start","stop","info" };

  public static final LEA_phase start = new LEA_phase(START);
  public static final LEA_phase stop = new LEA_phase(STOP);
  public static final LEA_phase info = new LEA_phase(INFO);

  private int order;

  private LEA_phase(int order) {
    super(C4aOntology.NAMESPACE + names[order]);
    this.order = order;
  }

  public int getPropSerializationType(String propURI) {
    return PROP_SERIALIZATION_OPTIONAL;
  }

  public boolean isWellFormed() {
    return true;
  }

  public String name() {
    return names[order];
  }

  public int ord() {
    return order;
  }

  public String getClassURI() {
    return MY_URI;
  }

  public static LEA_phase getLEA_phaseByOrder(int order) {
    switch (order) {
      case START:
        return start;
      case STOP:
        return stop;
      case INFO:
        return info;
    default:
      return null;    }
  }

  public static final LEA_phase valueOf(String name) {
	if (name == null)
	    return null;

	if (name.startsWith(C4aOntology.NAMESPACE))
	    name = name.substring(C4aOntology.NAMESPACE.length());

	for (int i = START; i <= INFO; i++)
	    if (names[i].equals(name))
		return getLEA_phaseByOrder(i);

	return null;
  }
}
