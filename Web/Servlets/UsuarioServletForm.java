package es.servlet.parametros.formulario;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet controlador para manejar los datos del formulario
 */
@WebServlet("/usuarioServletForm")
public class UsuarioServletForm extends HttpServlet {
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
