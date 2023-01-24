package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
 * Servlet implementation class AddSessionServlet
 */
@WebServlet("/AddSessionServlet")
public class AddSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSessionServlet() {
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
		Session newsession = new Session();
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		newsession.setNameModule(request.getParameter("nameM"));
		newsession.setDate(request.getParameter("date"));
		newsession.setGroupe(request.getParameter("Gr"));
		newsession.setTeacherId(teacher.getId());
		PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("nameM"));
		System.out.println(request.getParameter("Gr"));
		System.out.println(request.getParameter("date"));
		try {
			AdminDAO adminDAO = new AdminDAO();
			adminDAO.addSession(newsession);
//			out.print("<script>\r\n"
//					+ "        document.querySelector(\"#addForm span\").innerHTML = \"Teacher added successfully\";\r\n"
//					+ "    </script>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/EnsgServlet");
		dispatcher.include(request, response);
	}

}
