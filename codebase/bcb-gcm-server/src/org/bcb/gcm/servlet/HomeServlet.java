package org.bcb.gcm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@SuppressWarnings("serial")
public class HomeServlet extends BaseServlet {

	static final String ATTRIBUTE_STATUS = "status";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<html><body>");
		out.print("<head>");
		out.print("  <title>GCM Demo</title>");
		out.print("  <link rel='icon' href='favicon.png'/>");
		out.print("</head>");
		String status = (String) request.getAttribute(ATTRIBUTE_STATUS);
		if (status != null) {
			out.print(status);
		}
		
		List<String> devices = DataStore.getDevices();
		if (devices.isEmpty()) {
			out.print("<h2>No devices registered!</h2>");
		} else {
			out.print("<h2>" + devices.size() + " device(s) registered!</h2>");
			out.print("<form name='form' method='POST' action='sendAll'>");
			out.print("<input type='submit' value='Send Message' />");
			out.print("</form>");
		}
		out.print("</body></html>");
		response.setStatus(HttpServletResponse.SC_OK);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
