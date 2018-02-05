package co.com.ceiba.parqueadero.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.com.ceiba.parqueadero.entity.ContactEntity;
import co.com.ceiba.parqueadero.model.ContactModel;
import co.com.ceiba.parqueadero.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contacService;
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/contactform")
	private String redirectContactForm(@RequestParam(name="id",required=false) int id,
			Model model) {
		ContactModel contact = new ContactModel();
		if(id != 0) {
			contact = contacService.findContactByIdModel(id);
		}
		model.addAttribute("contactModel",contact);
		return "contactform";
	}
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contacModel") ContactModel contactModel,
			Model model) {
		LOG.info("METHOD: addcontact() -- PARAMS:" + contactModel.toString());
		if(null != contacService.addContact(contactModel)) {
			model.addAttribute("result",1);
		}else {
			model.addAttribute("result",0);
		}		
		return "redirect:/contacts/showcontacts";		
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView("contacts");
		mav.addObject("contacts",contacService.listAllContacts());
		return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id",required=true) int id) {
		contacService.removeContact(id);
		return showContacts();
	}
}
