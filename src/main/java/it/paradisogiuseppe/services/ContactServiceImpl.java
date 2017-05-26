package it.paradisogiuseppe.services;

import java.util.List;

import it.paradisogiuseppe.dao.ContactDao;
import it.paradisogiuseppe.dao.ContactDaoImpl;
import it.paradisogiuseppe.model.ContactModel;

public class ContactServiceImpl implements ContactService {
	private ContactDao contactDao = new ContactDaoImpl();
	@Override
	public ContactModel getContactById(int id) {
		return contactDao.getContactById(id);
	}

	@Override
	public List<ContactModel> getContactsByUserId(int id) {
		return contactDao.getContactsByUserId(id);
	}

	@Override
	public ContactModel updateContact(ContactModel contact) {
		return contactDao.updateContact(contact);
	}

	@Override
	public ContactModel deleteContact(ContactModel contact) {
		return contactDao.deleteContact(contact);
	}

	@Override
	public ContactModel addContact(ContactModel contact) {
		return contactDao.addContact(contact);
	}

	@Override
	public ContactModel findByNameAndSurname(String name, String surname) {
		return contactDao.findByNameAndSurname(name, surname);
	}

}
