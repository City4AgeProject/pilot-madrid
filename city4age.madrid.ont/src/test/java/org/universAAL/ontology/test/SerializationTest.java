/*******************************************************************************
 * Copyright 2016 Universidad Politécnica de Madrid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.universAAL.ontology.test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;

import org.universAAL.middleware.bus.junit.BusTestCase;
import org.universAAL.middleware.context.ContextEvent;
import org.universAAL.middleware.context.ContextEventPattern;
import org.universAAL.middleware.context.owl.ContextProvider;
import org.universAAL.middleware.context.owl.ContextProviderType;
import org.universAAL.middleware.owl.MergedRestriction;
import org.universAAL.middleware.owl.OntologyManagement;
import org.universAAL.middleware.serialization.turtle.TurtleSerializer;
import org.universAAL.ontology.c4a.C4aOntology;
import org.universAAL.ontology.c4a.Enter_Bus;
import org.universAAL.ontology.c4a.LEA;
import org.universAAL.ontology.location.LocationOntology;
import org.universAAL.ontology.phThing.PhThingOntology;
import org.universAAL.ontology.profile.ProfileOntology;
import org.universAAL.ontology.profile.User;
import org.universAAL.ontology.shape.ShapeOntology;
import org.universAAL.ontology.vcard.VCardOntology;

/**
 * @author amedrano
 *
 */
public class SerializationTest extends BusTestCase {

	protected void setUp() throws Exception {
		super.setUp();

		OntologyManagement.getInstance().register(mc, new LocationOntology());
		OntologyManagement.getInstance().register(mc, new ShapeOntology());
		OntologyManagement.getInstance().register(mc, new PhThingOntology());
		OntologyManagement.getInstance().register(mc, new VCardOntology());
		OntologyManagement.getInstance().register(mc, new ProfileOntology());
		OntologyManagement.getInstance().register(mc, new C4aOntology());
	    }
	

	public void testContextProvider() throws FileNotFoundException {
		ContextEventPattern cep = new ContextEventPattern();
		cep.addRestriction(MergedRestriction.getAllValuesRestriction(ContextEvent.PROP_RDF_OBJECT, LEA.MY_URI));
		
		ContextProvider cp = new ContextProvider("http://eu.city4age.madrid/android#Publisher");
		cp.setType(ContextProviderType.gauge);
		cp.setProvidedEvents(new ContextEventPattern[] { cep});

		TurtleSerializer ts = new TurtleSerializer();
		String s = ts.serialize(cp);
		
		PrintWriter out = new PrintWriter("target/ContextProvider.ttl");
		out.print(s);
		out.flush();
		out.close();
	}
	
	public void testContextEvent() throws FileNotFoundException {
		User u = new User("userID");
		Enter_Bus lea = new Enter_Bus();
//		GregorianCalendar c = new GregorianCalendar();
//		c.setTime(new Date());
//		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//		lea.setTimestamp(new XML);
		u.setProperty(C4aOntology.PROP_USER_ENACTS, new Enter_Bus());
		ContextEvent ce = new ContextEvent(u, C4aOntology.PROP_USER_ENACTS);
		
		TurtleSerializer ts = new TurtleSerializer();
		String s = ts.serialize(ce);
		
		PrintWriter out = new PrintWriter("target/ContextEvent.ttl");
		out.print(s);
		out.flush();
		out.close();
	}

}
