package it.paradisogiuseppe.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import it.paradisogiuseppe.model.ContactModel;

public class ContactDaoImpl extends HibernateDao implements ContactDao{
	
//	private static List<ContactModel> listContacts=new ArrayList<>();
//	private static int ID_MAX=0;
	
	
	public ContactDaoImpl(){
//		populate();
	}
	
//	public static void populate(){
//		if(listContacts.size()==0){
//			listContacts.add(new ContactModel(1, "Giuseppe1", "Paradiso1", "1111111-1", "giuseppe.paradiso92_1@gmail.com"));
//			listContacts.add(new ContactModel(2, "Giuseppe2", "Paradiso2", "1111111-2", "giuseppe.paradiso92_2@gmail.com"));
//			listContacts.add(new ContactModel(3, "Giuseppe3", "Paradiso3", "1111111-3", "giuseppe.paradiso92_3@gmail.com"));
//			listContacts.add(new ContactModel(4, "Giuseppe4", "Paradiso4", "1111111-4", "giuseppe.paradiso92_4@gmail.com"));
//			listContacts.add(new ContactModel(5, "Giuseppe5", "Paradiso5", "1111111-5", "giuseppe.paradiso92_5@gmail.com"));
//			listContacts.add(new ContactModel(6, "Giuseppe6", "Paradiso6", "1111111-6", "giuseppe.paradiso92_6@gmail.com"));
//			listContacts.add(new ContactModel(7, "Giuseppe7", "Paradiso7", "1111111-7", "giuseppe.paradiso92_7@gmail.com"));
//			listContacts.add(new ContactModel(8, "Giuseppe8", "Paradiso8", "1111111-8", "giuseppe.paradiso92_8@gmail.com"));
//			listContacts.add(new ContactModel(9, "Giuseppe9", "Paradiso9", "1111111-9", "giuseppe.paradiso92_9@gmail.com"));
//			listContacts.add(new ContactModel(10, "Giuseppe10", "Paradiso10", "1111111-10", "giuseppe.paradiso92_10@gmail.com"));
//			ID_MAX=11;
//		}
//	}
	
//	public static int getIdMax(){return ID_MAX;}
	
	public ContactModel getContactById(int id){
		Criteria criteria = getSession().createCriteria(ContactModel.class);
		criteria.add(Restrictions.eq("id", id));
		return (ContactModel) criteria.uniqueResult();
		
//		ContactModel contact=new ContactModel();
//		boolean fine=false;
//		int i=0;
//		while(!fine){
//			if(listContacts.get(i).getId()==id){
//				fine=true;
//				contact=listContacts.get(i);
//			}
//			i++;
//		}
//		return contact;
	}
	
	@SuppressWarnings("unchecked")
	public List<ContactModel> getContactsByUserId(int id){
//	Criteria criteria=getSession().createCriteria(ContactModel.class, "contact");
//	criteria.createAlias("contact.user", "userId");
//	criteria.add(Restrictions.eq("userId.id", id));
//	return (List<ContactModel>)criteria.list();
		
		Query namedQuery = getSession().getNamedQuery("findAllContacts");
		namedQuery.setParameter("idU", id);
		return (List<ContactModel>) namedQuery.list();
		
//		return (List<ContactModel>) getAll(queryHQL);
		
//		return listContacts;
	}
	
	public ContactModel updateContact(ContactModel contact){
		return (ContactModel)update(contact);
//		boolean fine=false;
//		int i=0;
//		while(!fine){
//			if(listContacts.get(i).getId()==contact.getId()){
//				fine=true;
////				listContacts.remove(i);
////				listContacts.add(i, contact);
//				listContacts.set(i, contact);
//			}
//			i++;
//		}
//		return contact;
	}
	
	public ContactModel deleteContact(ContactModel contact){
		return (ContactModel)delete(contact);
//		boolean fine=false;
//		int i=0;
//		while(!fine){
//			if(listContacts.get(i).getId()==id){
//				fine=true;
//			}
//			i++;
//		}
//		listContacts.remove(i-1);
	}
	public ContactModel addContact(ContactModel contact){
		return (ContactModel)persist(contact);
//		listContacts.add(contact);
//		ID_MAX++;
	}
	
	public ContactModel findByNameAndSurname(String name, String surname) {
		Query namedQuery = getSession().getNamedQuery("findByName");
		namedQuery.setParameter("nome", name);
		namedQuery.setParameter("cognome", surname);
		ContactModel uniqueResult = (ContactModel) namedQuery.uniqueResult();
		return uniqueResult;
	}
	
}
