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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		
		newteacher.setFirstname(request.getParameter("Efirstname"));
		newteacher.setLastname(request.getParameter("Elastname"));
		newteacher.setUsername(request.getParameter("Eusername"));
		newteacher.setAddress(request.getParameter("Eaddress"));
		newteacher.setPassword(request.getParameter("Epassword"));
		newteacher.setPhone(request.getParameter("Ephone"));
		PrintWriter out = response.getWriter();
		String key = request.getParameter("key");
		try {
			AdminDAO adminDAO = new AdminDAO();
			adminDAO.editTeacher(newteacher,key);
		} catch (InstantiationException e) {
			// TODO: handle exception
		} catch (IllegalAccessException e){
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TeacherServlet");
		dispatcher.include(request, response);
	}

}
