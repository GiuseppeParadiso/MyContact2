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
	private static HttpSession session;
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HibernateService.createSession();
//		String idS=request.getParameter("idU");
		
//		int id=Integer.parseInt(idS);
		session=request.getSession(false);
		int id=(Integer)(session.getAttribute("idU"));
		List<ContactModel>  listContacts=contactService.getContactsByUserId(id);
		
		session.setAttribute("listContacts", listContacts);
//		session.setAttribute("idU", id);
//		HibernateService.closeSession();
//		HibernateUtil.shutdown();
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	 /**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String action=request.getParameter("action");
		if (action==null || action.equals("login"))
			doGet(request, response);
		else{
			session.setAttribute("idC", request.getParameter("idC"));
			switch(action){
			
				case "update":
					request.getRequestDispatcher("update").forward(request, response);
					break;
				case "delete":
//					session.setAttribute("idC", request.getParameter("idC"));
					request.getRequestDispatcher("delete").forward(request, response);
					break;
				case "logout":
					session.removeAttribute("idU");
					response.sendRedirect("login");
					break;
				default: break;
			}
		}
//		int id=Integer.parseInt(request.getParameter("id"));	
		//		String referrer = request.getHeader("referer");	
//		logger.warning("the servlet was being called from here: " + referrer);
//		request.getRequestDispatcher("save.jsp").forward(request, response);
	}
	
}
