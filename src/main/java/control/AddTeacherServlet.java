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
import model.Teacher;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
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
		Teacher newteacher = new Teacher();
		
		newteacher.setFirstname(request.getParameter("fname"));
		newteacher.setLastname(request.getParameter("lname"));
		newteacher.setUsername(request.getParameter("username"));
		newteacher.setAddress(request.getParameter("address"));
		newteacher.setPassword(request.getParameter("password"));
		newteacher.setPhone(request.getParameter("phone"));
		PrintWriter out = response.getWriter();

		try {
			AdminDAO adminDAO = new AdminDAO();
			adminDAO.addTeacher(newteacher);
//			out.print("<script>\r\n"
//					+ "        document.querySelector(\"#addForm span\").innerHTML = \"Teacher added successfully\";\r\n"
//					+ "    </script>");
		} catch (InstantiationException e) {
			// TODO: handle exception
//			out.print("<script>\r\n"
//					+ "        document.querySelector(\"#addForm span\").innerHTML = \"Teacher added feild\";\r\n"
//					+ "    </script>");
		} catch (IllegalAccessException e){
//			out.print("<script>\r\n"
//					+ "        document.querySelector(\"#addForm span\").innerHTML = \"Teacher added feild\";\r\n"
//					+ "    </script>");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TeacherServlet");
		dispatcher.include(request, response);
	}

}
