package org.bcb.gcm.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
// @WebServlet("/BaseServlet")
@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

	static final boolean DEBUG = true;
	protected final Logger logger = Logger.getLogger(getClass().getName());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (DEBUG) {
			doPost(request, response);
		} else {

			super.doGet(request, response);
		}

	}

	protected String getParameter(HttpServletRequest request, String did)
			throws ServletException {
		String value = request.getParameter(did);
		if (value == null || value.trim().isEmpty()) {
			if (DEBUG) {
				StringBuilder parameters = new StringBuilder();

				Enumeration<String> names = request.getParameterNames();
				while (names.hasMoreElements()) {
					String name = names.nextElement();
					String param = request.getParameter(name);
					parameters.append(name).append("=").append(param)
							.append("\n");
				}

				logger.fine("Parameters: " + parameters);
			}

			throw new ServletException("Device ID: " + did + " not found");
		}

		return value.trim();

	}

	protected String getParameter(HttpServletRequest request, String parameter,
			String defaultValue) {
		String value = request.getParameter(parameter);
		if (value == null || value.trim().isEmpty()) {
			value = defaultValue;
		}

		return value.trim();

	}

}
