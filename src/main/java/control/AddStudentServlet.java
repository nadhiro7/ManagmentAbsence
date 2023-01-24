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
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
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
		
		newstudent.setFirstname(request.getParameter("fname"));
		newstudent.setLastname(request.getParameter("lname"));
		newstudent.setStudentId(request.getParameter("ID"));
		newstudent.setAddress(request.getParameter("address"));
		newstudent.setGroupe(request.getParameter("groupe"));
		newstudent.setEmail(request.getParameter("email"));
		PrintWriter out = response.getWriter();

		try {
			AdminDAO adminDAO = new AdminDAO();
			adminDAO.addStudent(newstudent);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentServlet");
		dispatcher.include(request, response);
	}

}
