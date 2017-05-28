package it.paradisogiuseppe.servlet;

import java.io.IOException;
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


/**
 * Servlet implementation class DeleteContact
 */
@WebServlet("/delete")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int cid=0;
    private static ContactService contactService =new ContactServiceImpl();
    private static int idUser;
    private static HttpSession session;
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HibernateService.createSession();
		session=request.getSession();
		String id = (String)session.getAttribute("idC");
		idUser = (Integer)(session.getAttribute("idU"));
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		cid=Integer.parseInt(id);
		
		ContactModel contatto=contactService.getContactById(Integer.parseInt(id));
		
		session.setAttribute("contact", contatto);
		
//		HibernateService.closeSession();
//		HibernateUtil.shutdown();
		request.getRequestDispatcher("delete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		String id = request.getParameter("id");
//		String save=request.getParameter("save");
//		if (id!=null){
//			cid=Integer.parseInt(id);
//			ContactModel contatto=ContactDAO.getContactById(Integer.parseInt(id));
//			HttpSession session=request.getSession();
//			session.setAttribute("contact", contatto);
//			request.getRequestDispatcher("delete.jsp").forward(request, response);
//		}
//		else if (save.equals("1")){
			
//			ContactDaoImpl.deleteContact(cid);
//		HibernateService.createSession();
		String action=request.getParameter("action");
		if (action==null){
			ContactModel contact = contactService.getContactById(cid);
	//		UserModel user=userService.getUserById(idUser);
			contactService.deleteContact(contact);
	//		HibernateService.closeSession();
	//		HibernateUtil.shutdown();
//			response.sendRedirect("list?idU="+idUser);
			response.sendRedirect("list");
		}
		else{
			doGet(request, response);
		}
	}

}
