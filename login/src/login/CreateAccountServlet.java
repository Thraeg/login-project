package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Tries to create a new account with the supplied name and password. 
	 * Routes user to welcome or failure page as appropriate.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		acctMan.AccountManager mgr = (acctMan.AccountManager) context.getAttribute("manager");
		String name = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");
		
		if(!mgr.checkName(name)){
			mgr.addUser(name, password);
			welcome(request, response, name);
		}
		else nameInUse(request, response, name);
	}
	
	private void nameInUse(HttpServletRequest request, HttpServletResponse response, String name) {
		RequestDispatcher dispatch = request.getRequestDispatcher("NameInUse.jsp");
		request.setAttribute("name", name);
		try {
			dispatch.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	protected void welcome(HttpServletRequest request, HttpServletResponse response, String name){
		RequestDispatcher dispatch = request.getRequestDispatcher("Welcome.jsp");
		request.setAttribute("name", name);
		try {
			dispatch.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
