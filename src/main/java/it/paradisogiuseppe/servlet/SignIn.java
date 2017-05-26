package it.paradisogiuseppe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import it.paradisogiuseppe.model.UserModel;
import it.paradisogiuseppe.services.UserService;
import it.paradisogiuseppe.services.UserServiceImpl;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signin")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("signin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		String dob=request.getParameter("dob");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserModel user=new UserModel();
		user.setNome(name);
		user.setCognome(surname);
		user.setDataNascita(dob);
		user.setUsername(username);
		user.setPassword(password);
		
		try{
			userService.addUser(user);
			PrintWriter out=response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Salvataggio avvenuto correttamente!');");
			out.println("location='signin.jsp';");
			out.println("</script>");
		}
		catch(HibernateException e){
			PrintWriter out=response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Errore nel salvataggio dei dati!');");
			out.println("location='signin.jsp';");
			out.println("</script>");
		}finally{
			response.sendRedirect("login");
			
		}
			
	}

}
