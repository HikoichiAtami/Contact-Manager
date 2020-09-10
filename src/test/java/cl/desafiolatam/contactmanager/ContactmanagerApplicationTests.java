package cl.desafiolatam.contactmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import beans.Contacto;
import cl.desafiolatam.service.ContactService;

@SpringBootTest
class ContactmanagerApplicationTests {
	
	@Autowired
	ContactService contactService;
	
	@Test
	@DisplayName("Test Listar")
	void testListContact() {
		List<Contacto> contactList = new ArrayList<Contacto>();
		assertEquals(contactList,contactService.getContactList());
	}
	
	@Test
	@DisplayName("Test Agregar Contacto")
	void testAddContact() {
		Contacto contacto = new Contacto();
		contacto.setNombre("Freddy");
		contacto.setApellidoMaterno("Brevis");
		contacto.setApellidoPaterno("Zambrano");
		contacto.setDireccion("Mi Casa");
		contacto.setTelefono(975268857);
		assertTrue(contactService.addContact(contacto));
	}
	
	@Test
	@DisplayName("Test Eliminar Contacto")
	void testDeleteContact() {
		Contacto contacto = new Contacto();
		contacto.setNombre("Freddy");
		contacto.setApellidoMaterno("Brevis");
		contacto.setApellidoPaterno("Zambrano");
		contacto.setDireccion("Mi Casa");
		contacto.setTelefono(975268857);
		contactService.addContact(contacto);
		int id = 1;
		String nombre = "Freddy";
		assertEquals(nombre,contactService.deleteContact(id));
	}
	
	

}
