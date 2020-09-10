package cl.desafiolatam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beans.Contacto;
import cl.desafiolatam.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;

	private final static Logger logger = LoggerFactory.getLogger(ContactController.class);
	String mensaje = "";
	
	@RequestMapping(value="/contactManager", method=RequestMethod.GET)
	public String getContactList(ModelMap model) {
		logger.info("Lista de contactos");
		model.put("contacto", contactService.getContactList());
		model.addAttribute("mensaje", mensaje);
		return "contactManager";
	}
	
	@RequestMapping(value="/addContact", method=RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contacto contacto) {
		if(contactService.addContact(contacto) == false) {
			logger.info("El usuario " + contacto.getNombre() + " ya existe");
			mensaje = "El usuario " + contacto.getNombre() + " ya existe";
			return "redirect:/contactManager";
		}
		logger.info("Contacto Agregado");
		mensaje = "Usuario " + contacto.getNombre() + " agregado correctamente";
		return "redirect:/contactManager";
	}
	
	@RequestMapping(value="/deleteContact",method=RequestMethod.GET)
	public String deleteContact(@RequestParam("select")int delete) {
		String nombre = contactService.deleteContact(delete);
		logger.info("Ha entrado a delete");
		if(nombre != null) {
			logger.info(nombre + " Eliminado correctamente");
			mensaje = nombre + " Eliminado correctamente";
			return "redirect:/contactManager";
		}
			
		logger.error("No ha sido posible eliminar el usuario");
		mensaje =  "No ha sido posible eliminar el usuario";
		return "redirect:/contactManager";
	}
	
}
