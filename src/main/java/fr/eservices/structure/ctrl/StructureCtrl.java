package fr.eservices.structure.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eservices.structure.srv.StructureServiceImpl;

@Controller
@RequestMapping("/struct")
public class StructureCtrl {

	@Autowired
	StructureServiceImpl srv;
	
	@RequestMapping("/all")
	public String list(Model model){
		model.addAttribute("resellers", srv.findAll());
		return "struct/all";
	}
}
