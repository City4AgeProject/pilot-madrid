/*******************************************************************************
 * Copyright 2016 2011 Universidad Politécnica de Madrid
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
package es.upm.lst.city4age.vcard;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.universAAL.middleware.container.ModuleContext;
import org.universAAL.ri.servicegateway.GatewayPort;

/**
 * @author amedrano
 *
 */
public class HTTPService extends GatewayPort {
	
	static final String REPOSITORY_LOCATION = "./etc/vCards/";
	static final String TYPE = "text/vcard";

	
	
	/**
	 * @param mcontext
	 */
	public HTTPService(ModuleContext mcontext) {
		super(mcontext);
	}

	/** {@inheritDoc} */
	@Override
	public String url() {
		// TODO Auto-generated method stub
		return "/user";
	}

	/** {@inheritDoc} */
	@Override
	public String dataDir() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	/** {@inheritDoc} */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userID = req.getPathInfo().replaceFirst(url(), "");
		String path = REPOSITORY_LOCATION + userID;
		if (new File(path).exists()) {
			ServletOutputStream os = resp.getOutputStream();
			os.print(readFile(path));
			os.flush();
			resp.setContentType(TYPE);
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			ServletOutputStream os = resp.getOutputStream();
			os.print(" Attempted to access: " + path + " but it does not exists.");
			os.flush();
			resp.setContentType("text/text");
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	static String readFile(String path ) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, Charset.forName("UTF8"));
			}
}
