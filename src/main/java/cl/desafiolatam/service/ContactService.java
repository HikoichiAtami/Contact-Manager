package cl.desafiolatam.service;

import java.util.List;
import beans.Contacto;

public interface ContactService {

	List<Contacto> getContactList();
	boolean addContact(Contacto contacto);
	String deleteContact(int ID);
}
