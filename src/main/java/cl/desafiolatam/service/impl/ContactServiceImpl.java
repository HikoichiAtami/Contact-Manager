package cl.desafiolatam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.Contacto;
import cl.desafiolatam.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService{

	@Autowired
	private Contacto contact;
	
	private List<Contacto> listContact = new ArrayList<Contacto>();
	
	public ContactServiceImpl(List<Contacto> listContact) {
		super();
		this.listContact = listContact;
	}

	@Override
	public List<Contacto> getContactList() {
		// TODO Auto-generated method stub
		for(Contacto contact : listContact) {
			if(contact.getNombre() == null || contact.getApellidoPaterno() == null || contact.getApellidoMaterno() == null ||
					contact.getDireccion() == null) {
				listContact.remove(contact);
			}
		}
		return listContact;
	}

	@Override
	public boolean addContact(Contacto contacto) {
		for(int i = 0; i<listContact.size();i++) {
			if(listContact.get(i).getNombre() == null || 
					listContact.get(i).getApellidoPaterno() == null ||
					listContact.get(i).getApellidoMaterno() == null ||
							listContact.get(i).getDireccion() == null) {
				listContact.remove(i);
			}
		}
		contact = contacto;
		if(listContact.size() == 0) {
			contacto.setId(1);
			listContact.add(contacto);
			return true;
		}
		if(listContact.size() > 0) {
		for(Contacto c : listContact) {
			if(c.getNombre().equals(contact.getNombre()) && 
					c.getApellidoPaterno().equals(contact.getApellidoPaterno()) &&
					c.getTelefono() == contact.getTelefono() &&
					c.getDireccion().equals(contact.getDireccion())) {
				return false;
			}
		}
		}
		contacto.setId(listContact.get(listContact.size() - 1).getId() + 1);
		listContact.add(contacto);
		return true;
	}

	@Override
	public String deleteContact(int ID) {
		String nombre;
		if(listContact.size() ==0) {
			return null;
		}
		for(int i = 0; i<listContact.size();i++) {
			if(listContact.get(i).getId() == ID) {
				nombre = listContact.get(i).getNombre();
				listContact.remove(i);
				return nombre;
			}
		}
		return null;
	}
	
}
