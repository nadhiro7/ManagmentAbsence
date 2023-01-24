package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdminDAO;
import model.Student;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student newstudent = new Student();
		
		newstudent.setFirstname(request.getParameter("Efirstname"));
		newstudent.setLastname(request.getParameter("Elastname"));
		newstudent.setStudentId(request.getParameter("UID"));
		newstudent.setAddress(request.getParameter("Eaddress"));
		newstudent.setGroupe(request.getParameter("Egroupe"));
		newstudent.setEmail(request.getParameter("E-mail"));
		PrintWriter out = response.getWriter();
		String key = request.getParameter("key");
		try {
			AdminDAO adminDAO = new AdminDAO();
			adminDAO.editStudent(newstudent,key);
		} catch (InstantiationException e) {
			// TODO: handle exception
		} catch (IllegalAccessException e){
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentServlet");
		dispatcher.include(request, response);
	}

}
