package br.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entity.*;

@WebServlet("/StudentConsultController")
public class StudentConsultController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cpf = (String) request.getParameter("cpf");

		StringBuffer buf = new StringBuffer();
		Student s;
		IStudentAdmin ia = new StudentAdminUserController();
		s = ia.consult(cpf);

		if (cpf != null && !cpf.isEmpty() && (cpf != "")) {
			buf.append("<html><head>" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
			if (s != null) {
				buf.append("<style rel='stylesheet' type='text/css'>#interface {width: 150%; height: 80vh; background-color: white;"
								+ "margin-left: -4%; box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.5); padding: 20px 20px 20px 20px;} #form p{margin-left: 45.2%;"
								+ " padding: 2px;}</style>");
				buf.append("</head><body><div id='interfacex'><form id='form'>");
				buf.append("<table>");
				buf.append("<tr>");
				buf.append("<th>Name</th>");
				buf.append("<th>CPF</th>");
				buf.append("<th>RA</th>");
				buf.append("<th>Email</th>");
				buf.append("<th>Sex</th>");
				buf.append("<th>Course</th>\n");
				buf.append("<th>Lattes</th>");
				buf.append("<th>Linkedin</th>");
				buf.append("<th>Street</th>");
				buf.append("<th>Number</th>");
				buf.append("<th>Neighborhood</th>");
				buf.append("<th>City</th>");
				buf.append("<th>State</th>");
				buf.append("<th>Phone</th>");
				buf.append("</tr>");

				buf.append("<tr>");
				buf.append("<td>" + s.getName() + "</td><td>" + s.getCpf() + "</td><td>" + s.getRa() + "</td><td>"
						+ s.getEmail() + "</td><td>" + s.getSex() + "</td><td>" + s.getCourse() + "</td><td>"
						+ s.getLattes() + "</td><td>" + s.getLinkedin() + "</td><td>" + s.getStreet() + "</td><td>"
						+ s.getNumber() + "</td><td>" + s.getNeighborhood() + "</td><td>" + s.getCity() + "</td><td>"
						+ s.getState() + "</td><td>" + s.getPhone());
				buf.append("</td>");
			} else {
				buf.append("<h3 class='h3'> CPF NOT FOUND!</h3></form></div>");
			}

			buf.append("</body>");
			buf.append("</html>");
		}
		PrintWriter out = response.getWriter();
		out.println(buf.toString());
	}
}
