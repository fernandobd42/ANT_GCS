package br.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entity.IStudentAdmin;

@WebServlet("/StudentDeleteController")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result;

		String cpf = (String) request.getParameter("cpf");

		StringBuffer buf = new StringBuffer();
		IStudentAdmin ia = new StudentAdminUserController();
		result = ia.delete(cpf);

		if (cpf != null && !cpf.isEmpty() && (cpf != "")) {
			buf.append("<html><head>" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
			buf.append("</head><body>");

			if (result != null) {
				buf.append("<h3 class='h3'>Student deleted with success!</h3>");
			} else {
				buf.append("<h3 class='h3'> CPF NOT FOUND!</h3>");
			}
			buf.append("</body>");
			buf.append("</html>");
		}
		PrintWriter out = response.getWriter();
		out.println(buf.toString());
	}
}
