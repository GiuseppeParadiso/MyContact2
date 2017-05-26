package it.paradisogiuseppe.dao;

import java.util.List;

import it.paradisogiuseppe.model.ContactModel;

public interface ContactDao {
	public ContactModel getContactById(int id);
	public List<ContactModel> getContacts(String queryHQL);
	public ContactModel updateContact(ContactModel contact);
	public ContactModel deleteContact(ContactModel contact);
	public ContactModel addContact(ContactModel contact);
	public ContactModel findByNameAndSurname(String name, String surname) ;


}
