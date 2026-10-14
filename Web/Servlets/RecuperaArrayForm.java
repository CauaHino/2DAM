package es.servlet.array.formulario;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet que muestra por pantalla lo colores seleccionados en el formulario
 */
@WebServlet("/recuperaArrayForm")
public class RecuperaArrayForm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Método GET del Servlet que imprimirá por pantalla los colores seleccionados
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] colores = request.getParameterValues("color");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (colores != null) {
			out.println("<h2>Colores seleccionados:</h2>");
			for (String c : colores) {
				out.println("<p>" + c + "</p>");
			}
		} else {
			out.println("<p>No se seleccionó ningún color</p>");
		}
	}
}
