/**
 * 
 */
package org.bcb.gcm.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

/**
 * @author Anand Shankar
 * 
 */
@SuppressWarnings("serial")
public class SendMessage extends BaseServlet {

	private Sender sender;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sender = newSender(config);
	}

	protected Sender newSender(ServletConfig config) {
		String key = (String) config.getServletContext().getAttribute(
				ApiKeyInitializer.ATTRIBUTE_ACCESS_KEY);
		return new Sender(key);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		List<String> devices = DataStore.getDevices();
		StringBuilder status = new StringBuilder();
		if (devices.isEmpty()) {
			status.append("Message ignored as there is no device registered!");
		} else {
			List<Result> results;
			if (devices.size() == 1) {
				String registrationId = devices.get(0);
				Message message = new Message.Builder().build();
				Result result = sender.send(message, registrationId, 5);
				results = Arrays.asList(result);
			} else {
				Message message = new Message.Builder().build();
				MulticastResult result = sender.send(message, devices, 5);
				results = result.getResults();
			}
			for (int i = 0; i < devices.size(); i++) {
				Result result = results.get(i);
				if (result.getMessageId() != null) {
					status.append("Succesfully sent message to device #")
							.append(i);
					String canonicalRegId = result.getCanonicalRegistrationId();
					if (canonicalRegId != null) {
						logger.finest("canonicalRegId " + canonicalRegId);
						devices.set(i, canonicalRegId);
						status.append(". Also updated registration id!");
					}
				} else {
					String error = result.getErrorCodeName();
					if (error.equals(Constants.ERROR_NOT_REGISTERED)) {
						status.append("Unregistered device #").append(i);
						String regId = devices.get(i);
						DataStore.unregister(regId);
					} else {
						status.append("Error sending message to device #")
								.append(i).append(": ").append(error);
					}
				}
				status.append("<br/>");
			}
		}
		req.setAttribute(HomeServlet.ATTRIBUTE_STATUS, status.toString());
		getServletContext().getRequestDispatcher("/home").forward(req, resp);
	}

}
