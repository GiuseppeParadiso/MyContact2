package it.paradisogiuseppe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.paradisogiuseppe.config.HibernateUtil;
import it.paradisogiuseppe.dao.ContactDaoImpl;
import it.paradisogiuseppe.model.ContactModel;
import it.paradisogiuseppe.model.UserModel;
import it.paradisogiuseppe.services.ContactService;
import it.paradisogiuseppe.services.ContactServiceImpl;
import it.paradisogiuseppe.services.HibernateService;
import it.paradisogiuseppe.services.UserService;
import it.paradisogiuseppe.services.UserServiceImpl;
import it.paradisogiuseppe.utility.StringValidation;

/**
 * Servlet implementation class SaveContact
 */
@WebServlet("/save")
public class SaveContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ListContact.class.getName());
    private static ContactService contactService =new ContactServiceImpl();
	private static final UserService userService=new UserServiceImpl();
    private static int idUser;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		idUser=(Integer)(request.getSession(false).getAttribute("idU"));
		request.getRequestDispatcher("save.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String telefono=request.getParameter("telefono");
		String email=request.getParameter("email");
		
		if((!(StringValidation.check(StringValidation.getEmailRegex(), email))) || (!(StringValidation.check(StringValidation.getTelRegex(), telefono)))){
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Telefono o email non corretti!');");
			   out.println("location='save.jsp';");
			   out.println("</script>");
		}else{
//			HibernateService.createSession();
			UserModel user=userService.getUserById(idUser);
			ContactModel contact = new ContactModel();
			contact.setNome(nome);
			contact.setCognome(cognome);
			contact.setEmail(email);
			contact.setTelefono(telefono);
			contact.setUser(user);
			user.getListContact().add(contact);
			contactService.addContact(contact);
//			HibernateService.closeSession();
//			HibernateUtil.shutdown();
			
//			response.sendRedirect("list?idU="+idUser);
			response.sendRedirect("list");
		}

	}

}
