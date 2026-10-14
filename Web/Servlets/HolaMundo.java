package es.servlet.holamundo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet básico que imprime un saludo
 */
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Método GET estándar del Servlet
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet de saludo</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hola desde un servlet con JDK 21 y Tomcat 10.1</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}