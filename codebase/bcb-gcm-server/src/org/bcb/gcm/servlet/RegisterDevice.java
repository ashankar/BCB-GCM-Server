/**
 * 
 */
package org.bcb.gcm.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bcb.gcm.resource.IForward;
import org.bcb.gcm.resource.IString;

/**
 * @author Anand Shankar
 * 
 */
@SuppressWarnings("serial")
public class RegisterDevice extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		try {

			String did = getParameter(request, IString.DEVICE_ID);
			DataStore.register(did);
			request.setAttribute("did", did);
			request.setAttribute("msg", " registered");
			RequestDispatcher rd = request
					.getRequestDispatcher(IForward.ACKNOWLEDGEMENT);
			rd.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
