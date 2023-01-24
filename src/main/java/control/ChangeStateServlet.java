package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdminDAO;

/**
 * Servlet implementation class ChangeStateServlet
 */
@WebServlet("/ChangeStateServlet")
public class ChangeStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				AdminDAO adminDAO = new AdminDAO();
				String sessionId = request.getParameter("sessionId");
				request.setAttribute("sessionId",sessionId);
				String studentId = request.getParameter("studentId");
				String state = request.getParameter("role");
				System.out.println(state + " " + studentId);
					try {
						adminDAO.changeStudentState(studentId, state);
					} catch (InstantiationException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(sessionId);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/SessionListServlet");
					dispatcher.forward(request, response);
	}

}
