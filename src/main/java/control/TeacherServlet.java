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
import model.Teacher;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("admin") != null) {
			AdminDAO adminDAO = new AdminDAO();
			
			ArrayList<Teacher> teachersList = null;
			
			try {
				
				teachersList = adminDAO.getTeachers();
				
			} catch (InstantiationException | IllegalAccessException e) {
				
				e.printStackTrace();
			}
			
			request.setAttribute("teachersList",teachersList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teachers.jsp");
			dispatcher.include(request, response);
			PrintWriter wr = response.getWriter();
			wr.print("<script>\r\n"
					+ "        document.getElementById(\"2\").classList.add(\"active\");\r\n"
					+ "        document.getElementById(\"3\").classList.remove(\"active\");\r\n"
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
