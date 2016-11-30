package br.com.model;

import java.io.IOException;
import java.util.ArrayList;

import br.com.dao.StudentDAO;
import br.com.entity.Student;

public class StudentModel {

	public String include(String name, String cpf, String ra, String email, String sex, String course, String street,
			int number, String neighborhood, String city, String state, String phone, String lattes, String linkedin)
			throws IOException {
		String result = "";

		Student s = new Student();

		s.setName(name);
		if (cpf.length() != 14) {
			return "<h1>CPF invalid</h1> <a href='./index.html'>Inicio</a>";
		} else {
			s.setCpf(cpf);
		}
		s.setRa(ra);
		s.setEmail(email);
		s.setSex(sex);
		s.setCourse(course);
		s.setStreet(street);
		s.setNumber(number);
		s.setNeighborhood(neighborhood);
		s.setCity(city);
		s.setState(state);
		s.setPhone(phone);
		s.setLattes(lattes);
		s.setLinkedin(linkedin);

		StudentDAO d = new StudentDAO();
		result = d.include(s);

		return result;
	}

	public String delete(String cpf) throws IOException {
		String result = "";

		Student s = new Student();
		s.setCpf(cpf);

		StudentDAO d = new StudentDAO();
		result = d.delete(s.getCpf());

		return result;
	}

	public Student consult(String cpf) throws IOException {

		StudentDAO d = new StudentDAO();
		return d.consult(cpf);
	}

	public ArrayList<Student> consultAll() throws IOException {

		StudentDAO d = new StudentDAO();
		return d.consultAll();
	}
	
	public String edit(String name, String cpf, String ra, String email, String sex, String course, String street,
			int number, String neighborhood, String city, String state, String phone, String lattes, String linkedin)
			throws IOException {
		String result = "";

		Student s = new Student();

		s.setName(name);
		if (cpf.length() != 14) {
			return "<h1>CPF invalid</h1> <a href='./index.html'>Inicio</a>";
		} else {
			s.setCpf(cpf);
		}
		s.setRa(ra);
		s.setEmail(email);
		s.setSex(sex);
		s.setCourse(course);
		s.setStreet(street);
		s.setNumber(number);
		s.setNeighborhood(neighborhood);
		s.setCity(city);
		s.setState(state);
		s.setPhone(phone);
		s.setLattes(lattes);
		s.setLinkedin(linkedin);

		StudentDAO d = new StudentDAO();
		result = d.edit(s);

		return result;
	}

}
