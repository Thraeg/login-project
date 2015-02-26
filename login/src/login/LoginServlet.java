package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		acctMan.AccountManager mgr = (acctMan.AccountManager) context.getAttribute("manager");
		String name = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");
		
		if(name == null || password == null) routeToIndex(request, response); //catches error if user bookmarked the servlet rather than arriving through the form on the index.
		
		if(mgr.tryLogin(name, password)) welcome(response, name);
		else loginFail(response);
	}
	
	private void routeToIndex(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatch = request.getRequestDispatcher("index.html");
		try {
			dispatch.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}	
	}

	protected void welcome(HttpServletResponse response, String name){	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\" />");
			out.println("<title>Welcome " + name + "</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Welcome " + name + "</h1>");
			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	protected void loginFail(HttpServletResponse response){
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\" />");
			out.println("<title>Information Incorrect</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Please Try Again</h1>");
			out.println("Either your user name or password is incorrect. Please try again.");
			out.println("<form action=\"LoginServlet\" method=\"post\">");
			out.println("User Name: <input type=\"text\" name=\"name\"><br>");
			out.println("Password: <input type=\"text\" name=\"password\">");
			out.println("<input type=\"submit\" value=\"Login\">");
			out.println("</form>");
			out.println("<a href=\"NewAccount.html\">Create New Account</a>");
			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
