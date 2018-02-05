package co.com.ceiba.parqueadero.service;

import java.util.List;

import co.com.ceiba.parqueadero.entity.ContactEntity;
import co.com.ceiba.parqueadero.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel) ; 
	public abstract List<ContactModel> listAllContacts();
	public abstract ContactEntity findContactById(int id);
	public abstract ContactModel findContactByIdModel(int id);
	public abstract void removeContact(int id);
}
