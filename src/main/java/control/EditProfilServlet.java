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
import model.Session;
import model.Teacher;

/**
 * Servlet implementation class EditProfilServlet
 */
@WebServlet("/EditProfilServlet")
public class EditProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDAO bd = new AdminDAO();
		if (request.getSession().getAttribute("teacher") != null) {
			Teacher teacher = (Teacher) request.getSession().getAttribute("teacher") ;
			Teacher teacher1 = null;
			try {
				teacher1 = bd.getTeacher(teacher.getId());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("teacher1",teacher1);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editProfile.jsp");
			dispatcher.include(request, response);
			PrintWriter wr = response.getWriter();
			wr.print("<script>\r\n"
					+ "        document.getElementById(\"2\").classList.remove(\"active\");\r\n"
					+ "        document.getElementById(\"3\").classList.add(\"active\");\r\n"
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
		// TODO Auto-generated method stub
				Teacher newteacher = new Teacher();
				Teacher teacher = (Teacher) request.getSession().getAttribute("teacher") ;
				newteacher.setFirstname(request.getParameter("fname"));
				newteacher.setLastname(request.getParameter("lname"));
				newteacher.setUsername(request.getParameter("username"));
				newteacher.setAddress(request.getParameter("address"));
				newteacher.setPassword(request.getParameter("password"));
				newteacher.setPhone(request.getParameter("phone"));
				PrintWriter out = response.getWriter();
				String key = teacher.getId();
				try {
					AdminDAO adminDAO = new AdminDAO();
					adminDAO.editProfilTeacher(newteacher,key);
				} catch (InstantiationException e) {
					// TODO: handle exception
				} catch (IllegalAccessException e){
				}
		doGet(request, response);
	}

}
