package co.com.ceiba.parqueadero.converter;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.entity.ContactEntity;
import co.com.ceiba.parqueadero.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {
	
	public ContactEntity convertContactMo2ContactEnt(ContactModel contactModel) {
		ContactEntity contactEntity = new ContactEntity();
		contactEntity.setCity(contactModel.getCity());
		contactEntity.setFirstname(contactModel.getFirstname());
		contactEntity.setLastname(contactModel.getLastname());
		contactEntity.setTelephone(contactModel.getTelephone());
		contactEntity.setId(contactModel.getId());
		return contactEntity;		
	}
	
	public ContactModel convertContactEnt2ContactMod(ContactEntity contactEntity) {
		ContactModel contactModel = new ContactModel();
		contactModel.setCity(contactEntity.getCity());
		contactModel.setFirstname(contactEntity.getFirstname());
		contactModel.setLastname(contactEntity.getLastname());
		contactModel.setTelephone(contactEntity.getTelephone());
		contactModel.setId(contactEntity.getId());
		return contactModel;
	}
}
