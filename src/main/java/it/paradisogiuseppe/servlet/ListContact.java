package it.paradisogiuseppe.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.paradisogiuseppe.config.HibernateUtil;
import it.paradisogiuseppe.model.ContactModel;
import it.paradisogiuseppe.services.ContactService;
import it.paradisogiuseppe.services.ContactServiceImpl;
import it.paradisogiuseppe.services.HibernateService;

/**
 * Servlet implementation class ListContact
 */
@WebServlet("/list")
public class ListContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ContactService contactService =new ContactServiceImpl();
    private static final Logger logger = Logger.getLogger(ListContact.class.getName());
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HibernateService.createSession();
		List<ContactModel>  listContacts=contactService.getContacts("FROM ContactModel c ORDER BY c.id ASC");
		HttpSession session=request.getSession();
		session.setAttribute("listContacts", listContacts);
		HibernateService.closeSession();
		HibernateUtil.shutdown();
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	 /**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String referrer = request.getHeader("referer");	
//		logger.warning("the servlet was being called from here: " + referrer);
//		request.getRequestDispatcher("save.jsp").forward(request, response);
	}
	
}
