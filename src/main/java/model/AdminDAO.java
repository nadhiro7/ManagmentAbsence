package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO {
	private Connection connection;

	public AdminDAO() {
		this.connection = null;
	}

	// connection to database
	public void connectDB() throws InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:7077/gestionpr�sence", "root", "2001nadhir");
			System.out.println("Connection avec succes a la base de donnees !");
		} catch (ClassNotFoundException cnf) {
			System.out.print("Driver non charg�...");
		} catch (SQLException sqlex) {
			System.out.println("Incapable de connecter a la base de donnees...");
		}
	}

	
	public Admin checkLogin(String email, String password)
			throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement statement;
		
		Admin admin = null;

		try {
			
			connectDB();
			
			requete = "SELECT * FROM admins WHERE email = ? and password = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();			
			
	        if (result.next()) {
	        	admin = new Admin();
	        	admin.setFirstname(result.getString("firstname"));
	        	admin.setLastname(result.getString("lastname"));
	            admin.setEmail(result.getString("email"));
	            admin.setPassword(result.getString("password"));
	        }
	        
			statement.close();
			System.out.println("succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return admin;
	}
	public Teacher checkLoginT(String username, String password)
			throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement statement;
		
		Teacher teacher = null;

		try {
			
			connectDB();
			
			requete = "SELECT * FROM teachers WHERE username = ? and password = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();			
			
	        if (result.next()) {
	        	teacher = new Teacher();
	        	teacher.setId(result.getString("id"));
	        	teacher.setFirstname(result.getString("firstname"));
	        	teacher.setLastname(result.getString("lastname"));
	        	teacher.setUsername(result.getString("username"));
	        	teacher.setPassword(result.getString("password"));
	        	teacher.setAddress(result.getString("address"));
	        	teacher.setPhone(result.getString("phone"));
	        }
	        
			statement.close();
			System.out.println("succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return teacher;
	}
	
	public Teacher getTeacher(String id)
			throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement statement;
		
		Teacher teacher = null;

		try {
			
			connectDB();
			
			requete = "SELECT * FROM teachers WHERE id = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, id);
			
			ResultSet result = statement.executeQuery();			
			
	        if (result.next()) {
	        	teacher = new Teacher();
	        	teacher.setId(result.getString("id"));
	        	teacher.setFirstname(result.getString("firstname"));
	        	teacher.setLastname(result.getString("lastname"));
	        	teacher.setUsername(result.getString("username"));
	        	teacher.setPassword(result.getString("password"));
	        	teacher.setAddress(result.getString("address"));
	        	teacher.setPhone(result.getString("phone"));
	        }
	        
			statement.close();
			System.out.println("succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return teacher;
	}
	
	public ArrayList<Teacher> getTeachers() throws InstantiationException, IllegalAccessException {
		String requete;
		PreparedStatement statement;
		
		Teacher teacher = null;
		ArrayList<Teacher> teachersList = new ArrayList<Teacher>();
		
		try {
			
			connectDB();
			
			requete = "SELECT * FROM teachers";
			statement = connection.prepareStatement(requete);
			
			
			ResultSet result = statement.executeQuery();			
			
	        while (result.next()) {
	        	
	        	teacher = new Teacher();
	        	teacher.setId(result.getString("id"));
	        	teacher.setFirstname(result.getString("firstname"));
	            teacher.setLastname(result.getString("lastname"));
	            teacher.setAddress(result.getString("address"));
	            teacher.setPhone(result.getString("phone"));
	            teacher.setUsername(result.getString("username"));
	            teacher.setPassword(result.getString("password"));
	            
	            
	            teachersList.add(teacher);
	        }
	        
			statement.close();

			System.out.println("Users --- succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return teachersList;
	}
	public ArrayList<Session> getSessions(String string) throws InstantiationException, IllegalAccessException {
		String requete;
		PreparedStatement statement;
		
		Session session = null;
		ArrayList<Session> sessionsList = new ArrayList<Session>();
		
		try {
			
			connectDB();
			
			requete = "SELECT * FROM sessions WHERE teacherId = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, string);
			
			ResultSet result = statement.executeQuery();			
			
	        while (result.next()) {
	        	
	        	session = new Session();
	        	session.setSessionId(result.getInt("id"));
	        	session.setDate(result.getString("dateS"));
	        	session.setGroupe(result.getString("groupSs"));
	        	session.setNameModule(result.getString("nameM"));
	        	session.setTeacherId(result.getString("teacherId"));
	            
	            
	        	sessionsList.add(session);
	        }
	        
			statement.close();

			System.out.println("Users --- succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return sessionsList;
	}
	public ArrayList<Student> getStudents() throws InstantiationException, IllegalAccessException {
		String requete;
		PreparedStatement statement;
		
		Student student = null;
		ArrayList<Student> studentsList = new ArrayList<Student>();
		
		try {
			
			connectDB();
			
			requete = "SELECT * FROM students";
			statement = connection.prepareStatement(requete);
			
			
			ResultSet result = statement.executeQuery();			
			
	        while (result.next()) {
	        	
	        	student = new Student();
	        	student.setFirstname(result.getString("firstname"));
	        	student.setLastname(result.getString("lastname"));
	        	student.setAddress(result.getString("address"));
	        	student.setGroupe(result.getString("groupe"));
	        	student.setEmail(result.getString("email"));
	        	student.setStudentId(result.getString("studentId"));
	            
	            
	            studentsList.add(student);
	        }
	        
			statement.close();

			System.out.println("Users --- succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return studentsList;
	}

	public void addTeacher(Teacher newteacher) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		
		try {
			connectDB();
			requet = "INSERT INTO teachers(username, firstname, lastname, phone, address, password) VALUES(?,?,?,?,?,?)";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1,newteacher.getUsername());
			stmt.setString(2,newteacher.getFirstname());
			stmt.setString(3,newteacher.getLastname());
			stmt.setString(4,newteacher.getPhone());
			stmt.setString(5,newteacher.getAddress());
			stmt.setString(6,newteacher.getPassword());
			stmt.executeUpdate();
			stmt.close();

			System.out.println("Inserted");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public void editTeacher(Teacher newteacher, String key) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		
		try {
			connectDB();
			requet = "UPDATE teachers SET username = ?, firstname = ?, lastname = ?, phone = ?, address = ?, password = ? WHERE username = ?";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1,newteacher.getUsername());
			stmt.setString(2,newteacher.getFirstname());
			stmt.setString(3,newteacher.getLastname());
			stmt.setString(4,newteacher.getPhone());
			stmt.setString(5,newteacher.getAddress());
			stmt.setString(6,newteacher.getPassword());
			stmt.setString(7, key);
			stmt.executeUpdate();
			stmt.close();

			System.out.println("edit succ");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public void editProfilTeacher(Teacher newteacher, String key) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		
		try {
			connectDB();
			requet = "UPDATE teachers SET username = ?, firstname = ?, lastname = ?, phone = ?, address = ?, password = ? WHERE id = ?";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1,newteacher.getUsername());
			stmt.setString(2,newteacher.getFirstname());
			stmt.setString(3,newteacher.getLastname());
			stmt.setString(4,newteacher.getPhone());
			stmt.setString(5,newteacher.getAddress());
			stmt.setString(6,newteacher.getPassword());
			stmt.setString(7, key);
			stmt.executeUpdate();
			stmt.close();

			System.out.println("edit succ");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public void deleteTeacher(String key) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		
		try {
			connectDB();
			requet = "DELETE FROM teachers WHERE username = ?";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1, key);
			stmt.executeUpdate();
			stmt.close();

			System.out.println("edit succ");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public void deleteSession(String key) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		deleteSessionList(key);
		try {
			connectDB();
			requet = "DELETE FROM sessions WHERE teacherId = ?";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1, key);
			stmt.executeUpdate();
			stmt.close();

			System.out.println("edit succ");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public void deleteSessionList(String key) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		
		try {
			connectDB();
			requet = "DELETE FROM sessionList WHERE idTeacher = ?";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1, key);
			stmt.executeUpdate();
			stmt.close();

			System.out.println("edit succ");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public void addStudent(Student newstudent) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		
		try {
			connectDB();
			requet = "INSERT INTO students(studentID, firstname, lastname, groupe, email, address) VALUES(?,?,?,?,?,?)";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1,newstudent.getStudentId());
			stmt.setString(2,newstudent.getFirstname());
			stmt.setString(3,newstudent.getLastname());
			stmt.setString(4,newstudent.getGroupe());
			stmt.setString(5,newstudent.getEmail());
			stmt.setString(6,newstudent.getAddress());
			stmt.executeUpdate();
			stmt.close();

			System.out.println("Inserted");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public void editStudent(Student newstudent, String key) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		
		try {
			connectDB();
			requet = "UPDATE students SET studentID = ?, firstname = ?, lastname = ?, groupe = ?, email = ?, address = ? WHERE studentID = ?";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1,newstudent.getStudentId());
			stmt.setString(2,newstudent.getFirstname());
			stmt.setString(3,newstudent.getLastname());
			stmt.setString(4,newstudent.getGroupe());
			stmt.setString(5,newstudent.getEmail());
			stmt.setString(6,newstudent.getAddress());
			stmt.setString(7, key);
			stmt.executeUpdate();
			stmt.close();

			System.out.println("edit succ");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public void deleteStudent(String key) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		
		try {
			connectDB();
			requet = "DELETE FROM students WHERE studentID = ?";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1, key);
			stmt.executeUpdate();
			stmt.close();

			System.out.println("edit succ");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public void addSession(Session session) throws SQLException {
		String requet;
		PreparedStatement stmt = null;
		try {
			connectDB();
			requet = "INSERT INTO sessions(dateS,nameM,teacherId, groupSs) VALUES(?,?,?,?)";
			stmt = connection.prepareStatement(requet , stmt.RETURN_GENERATED_KEYS);
			stmt.setString(1,session.getNameModule());
			stmt.setString(2,session.getDate());
			stmt.setString(3,session.getTeacherId());
			stmt.setString(4,session.getGroupe());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			 
			System.out.println("Inserted record's ID: " + generatedKey);
			addSessionList(generatedKey, session);
			stmt.close();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addSessionList(int sessionId , Session session) throws InstantiationException, IllegalAccessException {
		String requete , requet;
		PreparedStatement statement , stmt = null;
		
		Student student = null;
		ArrayList<Student> studentsList = new ArrayList<Student>();
		
		try {
			
			connectDB();
			
			requete = "SELECT * FROM students Where groupe = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, session.getGroupe());
			
			ResultSet result = statement.executeQuery();			
			
	        while (result.next()) {
	        	
	        	requet = "INSERT INTO sessionList(student, sessionId, state, grp, idTeacher,firstname,lastname) VALUES(?,?,?,?,?,?,?)";
				stmt = connection.prepareStatement(requet);
				stmt.setString(1,result.getString("studentID"));
				stmt.setInt(2, sessionId);
				stmt.setString(3,"-");
				stmt.setString(4,session.getGroupe());
				stmt.setString(5,session.getTeacherId());
				stmt.setString(6,result.getString("firstname"));
				stmt.setString(7,result.getString("lastname"));
				stmt.executeUpdate();
				
	            
	            
	            studentsList.add(student);
	        }
	        stmt.close();
	        statement.close();
			System.out.println("Users --- succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public ArrayList<Student> getStudentSessionList(String id) throws InstantiationException, IllegalAccessException {
		String requete;
		PreparedStatement statement;
		
		Student student = null;
		ArrayList<Student> studentsList = new ArrayList<Student>();
		
		try {
			
			connectDB();
			
			requete = "SELECT * FROM sessionList WHERE sessionId = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, id);
			
			ResultSet result = statement.executeQuery();			
			
	        while (result.next()) {
	        	
	        	student = new Student();
	        	student.setFirstname(result.getString("firstname"));
	        	student.setLastname(result.getString("lastname"));
	        	student.setGroupe(result.getString("grp"));
	        	student.setState(result.getString("state"));
	        	student.setStudentId(result.getString("student"));
	            
	            
	            studentsList.add(student);
	        }
	        
			statement.close();

			System.out.println("Users --- succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return studentsList;
	}
	public void changeStudentState(String studentid, String state) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String requet;
		PreparedStatement stmt;
		
		
		
		try {
			connectDB();
			requet = "UPDATE sessionList SET state = ? WHERE student = ?";
			stmt = connection.prepareStatement(requet);
			stmt.setString(1,state);
			stmt.setString(2,studentid);
			stmt.executeUpdate();
			stmt.close();

			System.out.println("edit succ");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
}
