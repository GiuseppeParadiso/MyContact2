package it.paradisogiuseppe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.paradisogiuseppe.model.UserModel;
import it.paradisogiuseppe.services.HibernateService;
import it.paradisogiuseppe.services.UserService;
import it.paradisogiuseppe.services.UserServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserService userService=new UserServiceImpl();
    private static final Logger logger = Logger.getLogger(ListContact.class.getName());
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HibernateService.createSession();
		request.getSession(true);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		switch(action){
		case "login":
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			UserModel user=userService.getUserByUsernameAndPassword(username, password);
			if(user==null){
				PrintWriter out=response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Username o password errati!');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}else{
				//PRE
//				response.sendRedirect("list?idU="+user.getId());
				
				
				
//				request.setAttribute("idU", user.getId());
//				response.sendRedirect("list");
				request.getSession().setAttribute("idU", user.getId());

				request.getRequestDispatcher("list").forward(request, response);
				
//				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			break;
		case "signin":
			response.sendRedirect("signin");
			break;
		default: 
			break;
		}
	}

}
