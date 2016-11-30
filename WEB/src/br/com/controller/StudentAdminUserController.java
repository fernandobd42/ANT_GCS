package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import br.com.entity.IStudentAdmin;
import br.com.entity.Student;
import br.com.model.*;

public class StudentAdminUserController implements IStudentAdmin {

	public String include(String name, String cpf, String ra, String email, String sex, String course, String street,
			int number, String neighborhood, String city, String state, String phone, String lattes, String linkedin) {
		String result = "";

		StudentModel model = new StudentModel();
		try {
			result = model.include(name, cpf, ra, email, sex, course, street, number, neighborhood, city, state, phone,
					lattes, linkedin);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String delete(String cpf) {
		String result = "";

		StudentModel model = new StudentModel();
		try {
			result = model.delete(cpf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Student consult(String cpf) {
		StudentModel model = new StudentModel();
		Student s = null;
		
		try {
			s = model.consult(cpf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
		
	}

	public ArrayList<Student> consultAll() {
		StudentModel model = new StudentModel();
		ArrayList<Student> students = null;
		
		try {
			students = model.consultAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}


	public String edit(String name, String cpf, String ra, String email, String sex, String course, String street,
			int number, String neighborhood, String city, String state, String phone, String lattes, String linkedin) {

		String result = "";

		StudentModel model = new StudentModel();
		try {
			result = model.edit(name, cpf, ra, email, sex, course, street, number, neighborhood, city, state, phone,
					lattes, linkedin);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}