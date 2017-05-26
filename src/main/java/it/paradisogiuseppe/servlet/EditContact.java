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
import it.paradisogiuseppe.services.ContactService;
import it.paradisogiuseppe.services.ContactServiceImpl;
import it.paradisogiuseppe.services.HibernateService;
import it.paradisogiuseppe.utility.StringValidation;

/**
 * Servlet implementation class EditContacts
 */
@WebServlet("/update")
public class EditContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(EditContact.class.getName());
	private int previousId=-1;
    private static ContactService contactService = new ContactServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(previousId==-1 || id!=null){
			HibernateService.createSession();
			ContactModel contatto=contactService.getContactById(Integer.parseInt(id));
			previousId=Integer.parseInt(id);
			HttpSession session=request.getSession();
			session.setAttribute("contact", contatto);
			HibernateService.closeSession();
			HibernateUtil.shutdown();

			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
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
			   out.println("location='update.jsp';");
			   out.println("</script>");
		}else{
//			ContactModel contact = new ContactModel(previousId, nome, cognome, telefono, email);
//			ContactDaoImpl.updateContact(contact);
			HibernateService.createSession();
			ContactModel contact=contactService.getContactById(previousId);
			contact.setNome(nome);
			contact.setCognome(cognome);
			contact.setEmail(email);
			contact.setTelefono(telefono);
			contactService.updateContact(contact);
			previousId=-1;
			HibernateService.closeSession();
			HibernateUtil.shutdown();
			response.sendRedirect("list");
		}

	}

}
