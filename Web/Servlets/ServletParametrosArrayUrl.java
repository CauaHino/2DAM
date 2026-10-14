package es.servlet.parametros.array.url;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet que recibe parámetros a procesar por url
 */
@WebServlet("/ServletParametrosArrayUrl")
public class ServletParametrosArrayUrl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Método que muestra por pantalla los colores que le hemos pasado por url
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] colores = request.getParameterValues("color");
		PrintWriter out = response.getWriter();

		if (colores != null) {
			out.println("<html><body>");
			out.println("<h2>Colores seleccionados:</h2>");
			for (String c : colores) {
				out.println("<p>" + c + "</p>");
			}
		} else {
			out.println("<p>No se seleccionó ningún color</p>");
		}
		out.println("</body></html>");
	}
}
