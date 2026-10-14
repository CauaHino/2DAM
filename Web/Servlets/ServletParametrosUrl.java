package es.servlet.parametros.url;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet que procesa los parámetros que llegan por url
 */
@WebServlet("/ServletParametrosUrl")
public class ServletParametrosUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");

		try (PrintWriter out = response.getWriter()) {
			out.println("<html><body>");
			if (nombre != null) {
				out.println("<h1>Hola " + nombre + "!</h1>");
			}
			if (edad != null) {
				out.println("<p>Tu edad es: " + edad + "</p>");
			}
			out.println("</body></html>");
		}
	}

}