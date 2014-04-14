package com.licenta;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Busapp14aprServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, Bus app 14 apr");
	}
}
