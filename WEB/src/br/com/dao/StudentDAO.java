package br.com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.entity.PathDB;
import br.com.entity.Student;

public class StudentDAO {
	public String include(Student s) throws IOException {
		String result = "";

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException eString) {
			System.err.println("Could not init JDBC driver - driver not found" + eString);
		}

		Connection connection = null;
		try {
			new PathDB();
			String absolutePath = PathDB.read();
			connection = DriverManager.getConnection("jdbc:sqlite:" + absolutePath);

			String student = "INSERT INTO Student VALUES ('" + s.getName() + "', '" + s.getCpf() + "', '" + s.getRa()
					+ "', '" + s.getEmail() + "', '" + s.getSex() + "' , '" + s.getCourse() + "', '" + s.getLattes()
					+ "' , '" + s.getLinkedin() + "')";

			String address = "INSERT INTO Address (street, number, neighborhood, city, state, cpf) VALUES ('"
					+ s.getStreet() + "', '" + s.getNumber() + "', '" + s.getNeighborhood() + "', '" + s.getCity()
					+ "', '" + s.getState() + "', '" + s.getCpf() + "')";

			String phone = "INSERT INTO Phone (phone, cpf) VALUES ('" + s.getPhone() + "', '" + s.getCpf() + "')";

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate(student);
			statement.executeUpdate(address);
			statement.executeUpdate(phone);

			result = "Included with success! <a href='./IncludeStudent.html'>Include Student</a>  <a href='./index.html'>Index</a>";
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return result;
	}

	public String delete(String cpf) throws IOException {
		String result = "";

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException eString) {
			System.err.println("Could not init JDBC driver - driver not found" + eString);
		}

		Connection connection = null;
		try {
			new PathDB();
			String absolutePath = PathDB.read();
			connection = DriverManager.getConnection("jdbc:sqlite:" + absolutePath);

			String student = "DELETE FROM Student WHERE cpf='" + cpf + "'";
			String address = "DELETE FROM Address WHERE cpf='" + cpf + "'";
			String phone = "DELETE FROM Phone WHERE cpf='" + cpf + "'";

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			ResultSet resultSet = statement
					.executeQuery("SELECT COUNT (cpf) as c FROM Student WHERE cpf='" + cpf + "'");

			if (resultSet.getInt("c") > 0) {
				statement.executeUpdate(student);
				statement.executeUpdate(address);
				statement.executeUpdate(phone);
				result = "Deleted with success!";
			} else {
				result = null;
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return result;
	}

	public Student consult(String cpf) throws IOException {
		Student s = new Student();

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException eString) {
			System.err.println("Could not init JDBC driver - driver not found" + eString);
		}

		Connection connection = null;
		try {
			new PathDB();
			String absolutePath = PathDB.read();
			connection = DriverManager.getConnection("jdbc:sqlite:" + absolutePath);

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			ResultSet resultSet = statement
					.executeQuery("SELECT COUNT (cpf) as c FROM Student WHERE cpf='" + cpf + "'");

			if (resultSet.getInt("c") > 0) {
				ResultSet st = statement.executeQuery(
						"SELECT s.name, s.cpf, s.ra, s.email, s.sex, s.course, s.lattes, s.linkedin, a.street, a.number, a.neighborhood, a.city, a.state, p.phone FROM Student as s, Address as a, Phone as p WHERE s.cpf = a.cpf and s.cpf = p.cpf and s.cpf='"
								+ cpf + "'");
				s.setName(st.getString("name"));
				s.setCpf(st.getString("cpf"));
				s.setRa(st.getString("ra"));
				s.setEmail(st.getString("email"));
				s.setSex(st.getString("sex"));
				s.setCourse(st.getString("course"));
				s.setLattes(st.getString("lattes"));
				s.setLinkedin(st.getString("linkedin"));
				s.setStreet(st.getString("street"));
				s.setNumber(st.getInt("number"));
				s.setNeighborhood(st.getString("neighborhood"));
				s.setCity(st.getString("city"));
				s.setState(st.getString("state"));
				s.setPhone(st.getString("phone"));
			} else {
				s = null;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return s;
	}

	public ArrayList<Student> consultAll() throws IOException {
		ArrayList<Student> students = new ArrayList<Student>();

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException eString) {
			System.err.println("Could not init JDBC driver - driver not found" + eString);
		}

		Connection connection = null;
		try {
			new PathDB();
			String absolutePath = PathDB.read();
			connection = DriverManager.getConnection("jdbc:sqlite:" + absolutePath);

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			ResultSet st = statement.executeQuery(
					"SELECT s.name, s.cpf, s.ra, s.email, s.sex, s.course, s.lattes, s.linkedin, a.street, a.number, a.neighborhood, "
					+ "a.city, a.state, p.phone FROM Student as s, Address as a, Phone as p WHERE s.cpf = a.cpf and s.cpf = p.cpf");

			while (st.next()) {
				Student s = new Student();
				s.setName(st.getString("name"));
				s.setCpf(st.getString("cpf"));
				s.setRa(st.getString("ra"));
				s.setEmail(st.getString("email"));
				s.setSex(st.getString("sex"));
				s.setCourse(st.getString("course"));
				s.setLattes(st.getString("lattes"));
				s.setLinkedin(st.getString("linkedin"));
				s.setStreet(st.getString("street"));
				s.setNumber(st.getInt("number"));
				s.setNeighborhood(st.getString("neighborhood"));
				s.setCity(st.getString("city"));
				s.setState(st.getString("state"));
				s.setPhone(st.getString("phone"));

				students.add(s);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return students;
	}
	
	public String edit(Student s) throws IOException {
		String result = "";

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException eString) {
			System.err.println("Could not init JDBC driver - driver not found" + eString);
		}

		Connection connection = null;
		try {
			new PathDB();
			String absolutePath = PathDB.read();
			connection = DriverManager.getConnection("jdbc:sqlite:" + absolutePath);

			String student = "UPDATE Student SET name='" + s.getName() + "', ra='" + s.getRa()
					+ "', email='" + s.getEmail() + "', sex='" + s.getSex() + "' , course='" + s.getCourse() + "', lattes='" + s.getLattes()
					+ "' , linkedin='" + s.getLinkedin() + "' WHERE cpf='" + s.getCpf() + "'";
			String address = "UPDATE Address SET street='"+ s.getStreet() + "', number='" + s.getNumber() + "', neighborhood='" + s.getNeighborhood()
					+ "', city='" + s.getCity()+ "', state='" + s.getState() + "' WHERE cpf='" + s.getCpf() + "'";
			String phone = "UPDATE Phone set phone='"+s.getPhone()+ "' WHERE cpf='" + s.getCpf() + "'";

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

				statement.executeUpdate(student);
				statement.executeUpdate(address);
				statement.executeUpdate(phone);
				result = "Edited with success! <a href='./EditStudent.html'>Edit</a>  <a href='./index.html'>Index</a>";
				} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return result;
	}
}