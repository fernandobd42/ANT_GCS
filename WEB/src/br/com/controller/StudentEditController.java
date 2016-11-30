package br.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entity.IStudentAdmin;
import br.com.entity.Student;

@WebServlet("/StudentEditController")
public class StudentEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cpf = (String) request.getParameter("cpf");

		StringBuffer buf = new StringBuffer();
		Student s;
		IStudentAdmin ia = new StudentAdminUserController();
		s = ia.consult(cpf);

		if (cpf != null && !cpf.isEmpty() && (cpf != "")) {
			buf.append("<html><head> <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
			
			if (s != null) {				
				buf.append("<style rel='stylesheet' type='text/css'>#interface {width: 90%; height: 100%;background-color: white; margin-left: 0%;"+
						"box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.5); padding: 20px 20px 20px 20px;}</style>");
				buf.append("</head><body><div id='interfacex'><form id='form' action='/web2aps1ra1652745/StudentEditedController'> ");
				buf.append("<input name='txt_cpf' id='cpf' value="+s.getCpf()+" type='hidden' required='required'/>\n");
				buf.append("<p> Name: <br><input name='txt_name' id='name' value='"+s.getName()+"' type='text' required='required'/></p>\n");
				buf.append("<p> RA: <br><input name='txt_ra' id='ra' value='"+s.getRa()+"' type='text' required='required'/></p>\n");
				buf.append("<p> Email: <br><input name='txt_email' id='email' value='"+s.getEmail()+"' type='text' required='required'/></p>\n");
				buf.append("<p> Sex: <br><select name='txt_sex' id='sex'>");
						if (s.getSex() == "Male") {
							buf.append("<option value='Female'>Female</option>"+
							"<option value='Male' selected>Male</option>");
						} else {
							buf.append("<option value='Female' selected>Female</option>"+
									"<option value='Male' selected>Male</option>");
						}
						buf.append("</select>");
				buf.append("<p> Course: <br><select name='txt_course' id='course'>");
						switch (s.getCourse()) {
						case "Agronomy":
							buf.append("<option value='Agronomy' selected>Agronomy</option>"
									+ "<option value='Biology'>Biology</option>"
									+ "<option value='Bioprocess Engineering'>Bioprocess Engineering</option>"
									+ "<option value='Forest Engineering'>Forest Engineering</option>"
									+ "<option value='Software Engineering'>Software Engineering</option>"
									+ "<option value='Zootechnics'>Zootechnics</option>");
						break;								
						case "Biology":
							buf.append("<option value='Agronomy'>Agronomy</option>"
									+ "<option value='Biology' selected>Biology</option>"
									+ "<option value='Bioprocess Engineering'>Bioprocess Engineering</option>"
									+ "<option value='Forest Engineering'>Forest Engineering</option>"
									+ "<option value='Software Engineering'>Software Engineering</option>"
									+ "<option value='Zootechnics'>Zootechnics</option>");
						break;
						case "Bioprocess Engineering":
							buf.append("<option value='Agronomy'>Agronomy</option>"
									+ "<option value='Biology'>Biology</option>"
									+ "<option value='Bioprocess Engineering' selected>Bioprocess Engineering</option>"
									+ "<option value='Forest Engineering'>Forest Engineering</option>"
									+ "<option value='Software Engineering'>Software Engineering</option>"
									+ "<option value='Zootechnics'>Zootechnics</option>");
						break;
						case "Forest Engineering":
							buf.append("<option value='Agronomy'>Agronomy</option>"
									+ "<option value='Biology'>Biology</option>"
									+ "<option value='Bioprocess Engineering'>Bioprocess Engineering</option>"
									+ "<option value='Forest Engineering' selected>Forest Engineering</option>"
									+ "<option value='Software Engineering'>Software Engineering</option>"
									+ "<option value='Zootechnics'>Zootechnics</option>");
						break;
						case "Software Engineering":
							buf.append("<option value='Agronomy'>Agronomy</option>"
									+ "<option value='Biology'>Biology</option>"
									+ "<option value='Bioprocess Engineering'>Bioprocess Engineering</option>"
									+ "<option value='Forest Engineering'>Forest Engineering</option>"
									+ "<option value='Software Engineering' selected>Software Engineering</option>"
									+ "<option value='Zootechnics'>Zootechnics</option>");
						break;
						case "Zootechnics":
							buf.append("<option value='Agronomy'>Agronomy</option>"
									+ "<option value='Biology'>Biology</option>"
									+ "<option value='Bioprocess Engineering'>Bioprocess Engineering</option>"
									+ "<option value='Forest Engineering'>Forest Engineering</option>"
									+ "<option value='Software Engineering'>Software Engineering</option>"
									+ "<option value='Zootechnics' selected>Zootechnics</option>");
						break;
						}
				buf.append("</select>");
				buf.append("<p> Lattes: <br><input name='txt_lattes' id='lattes' value='"+s.getLattes()+"' type='text'required='required'/></p>\n");
				buf.append("<p> Linkedin: <br><input name='txt_linkedin' id='linkedin' value='"+s.getLinkedin()+"' type='text' required='required'/></p>\n");
				buf.append("<p> Street: <br><input name='txt_street' id='street' value='"+s.getStreet()+"' type='text' required='required'/></p>\n");
				buf.append("<p> Number: <br><input name='txt_number' id='number' value='"+s.getNumber()+"' type='text' required='required'/></p>\n");
				buf.append("<p> Neighborhood: <br><input name='txt_neigh' id='neigh' value='"+s.getNeighborhood()+"' type='text' required='required'/></p>\n");
				buf.append("<p> City: <br><input name='txt_city' id='city' value='"+s.getCity()+"' type='text' required='required'/></p>\n");
				buf.append("<p> State: <br><input name='txt_state' id='state' value='"+s.getState()+"' type='text' required='required'/></p>\n");
				buf.append("<p> Phone: <br><input name='txt_phone' id='phone' value='"+s.getPhone()+"' type='text' required='required'/></p>\n");
				buf.append("<input name='bt_include' class='button' type='submit'"+
				"value='Edit Student'/>");
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
