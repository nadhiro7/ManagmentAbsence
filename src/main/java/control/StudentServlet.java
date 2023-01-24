package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdminDAO;
import model.Student;
import model.Teacher;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("admin") != null) {
AdminDAO adminDAO = new AdminDAO();
			
			ArrayList<Student> studentsList = null;
			
			try {
				
				studentsList = adminDAO.getStudents();
				
			} catch (InstantiationException | IllegalAccessException e) {
				
				e.printStackTrace();
			}
			
			request.setAttribute("studentsList",studentsList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/students.jsp");
			dispatcher.include(request, response);
			PrintWriter wr = response.getWriter();
			wr.print("<script>\r\n"
					+ "        document.getElementById(\"1\").classList.remove(\"active\");\r\n"
					+ "        document.getElementById(\"3\").classList.add(\"active\");\r\n"
					+ "        document.getElementById(\"2\").classList.remove(\"active\");\r\n"
					+ "    </script>");
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
			dispatcher.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
