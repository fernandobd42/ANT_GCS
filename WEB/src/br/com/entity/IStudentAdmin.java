package br.com.entity;

import java.util.ArrayList;

public interface IStudentAdmin {
	public String include(String name, String cpf, String ra, String email, String sex, String course, String street, int number,
			String neighborhood, String city, String state, String phone, String lattes, String linkedin);
	
	public String delete(String cpf);
	
	public Student consult(String cpf);
	
	public ArrayList<Student> consultAll();
	
	public String edit(String name, String cpf, String ra, String email, String sex, String course, String street, int number,
			String neighborhood, String city, String state, String phone, String lattes, String linkedin);
}
