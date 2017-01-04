package fr.eservices.structure.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eservices.structure.model.Structure;
import fr.eservices.structure.srv.StructureServiceImpl;

@Controller
@RequestMapping("/struct")
public class StructureCtrl {

	@Autowired
	StructureServiceImpl srv;
	
	@RequestMapping("/all")
	public String list(Model model){
		model.addAttribute("structures", srv.findAll());
		return "struct/all";
	}
}
