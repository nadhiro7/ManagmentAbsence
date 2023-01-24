package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.AdminDAO;
import model.Teacher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("admin") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/TeacherServlet");
			dispatcher.include(request, response);
			PrintWriter wr = response.getWriter();
			wr.print("<script>\r\n"
					+ "        document.getElementById(\"1\").classList.add(\"active\");\r\n"
					+ "        document.getElementById(\"2\").classList.remove(\"active\");\r\n"
					+ "        document.getElementById(\"3\").classList.remove(\"active\");\r\n"
					+ "    </script>");
		} else {
			if(request.getSession().getAttribute("teacher") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/TeacherServlet");
				dispatcher.include(request, response);
				PrintWriter wr = response.getWriter();
				wr.print("<script>\r\n"
						+ "        document.getElementById(\"2\").classList.remove(\"active\");\r\n"
						+ "        document.getElementById(\"3\").classList.remove(\"active\");\r\n"
						+ "    </script>");
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
				dispatcher.include(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher;

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		System.out.println(role);
		AdminDAO adminDAO = new AdminDAO();

		try {

			if(role.equalsIgnoreCase("admin")) {
				Admin admin = adminDAO.checkLogin(email, password);
				if (admin != null) {
					
					
					HttpSession session = request.getSession();
					session.setAttribute("admin", admin);

					dispatcher = request.getRequestDispatcher("/TeacherServlet");
					dispatcher.forward(request, response);

				} else {

					PrintWriter out = response.getWriter();

					dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
					dispatcher.include(request, response);

					out.print("<script>\r\n"
							+ "        document.getElementById('incorrect').innerHTML = \"incorrect email or password\";\r\n"
							+ "</script>");
				}
			}else {
				Teacher teacher = adminDAO.checkLoginT(email, password);
				if (teacher != null) {
					
					
					HttpSession session = request.getSession();
					session.setAttribute("teacher", teacher);

					dispatcher = request.getRequestDispatcher("/EnsgServlet");
					dispatcher.forward(request, response);

				} else {

					PrintWriter out = response.getWriter();

					dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
					dispatcher.include(request, response);

					out.print("<script>\r\n"
							+ "        document.getElementById('incorrect').innerHTML = \"incorrect email or password\";\r\n"
							+ "</script>");
				}
			}

		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
