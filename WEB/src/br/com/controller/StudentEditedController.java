package br.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entity.IStudentAdmin;

@WebServlet("/StudentEditedController")
public class StudentEditedController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String result = "";
			String name, cpf, ra, email, sex, street, neighborhood, city, state, phone, course, lattes, linkedin;
			int number;

			IStudentAdmin ia = new StudentAdminUserController();

			try {
			name = (String) request.getParameter("txt_name");
			cpf = (String) request.getParameter("txt_cpf");
			ra = (String) request.getParameter("txt_ra");
			email = (String) request.getParameter("txt_email");
			sex = (String) request.getParameter("txt_sex");
			street = (String) request.getParameter("txt_street");
			number = Integer.parseInt((String) request.getParameter("txt_number"));
			neighborhood = (String) request.getParameter("txt_neigh");
			city = (String) request.getParameter("txt_city");
			state = (String) request.getParameter("txt_state");
			phone = (String) request.getParameter("txt_phone");
			course = (String) request.getParameter("txt_course");
			lattes = (String) request.getParameter("txt_lattes");
			linkedin = (String) request.getParameter("txt_linkedin");
			
			result = ia.edit(name, cpf, ra, email, sex, course, street, number, neighborhood, city, state, phone,
					lattes, linkedin);
			} catch (Exception e) {
				return;
			}		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Resultado</title>");
			out.println("</head>");
			out.println("<body>");
			out.println(result);
			out.println("</body>");
			out.println("</html>");
		}
}
