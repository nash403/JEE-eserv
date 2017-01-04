package fr.eservices.structure.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eservices.structure.model.Structure;
import fr.eservices.structure.srv.StructureServiceImpl;

@Controller
@RequestMapping(value = "/struct")
public class StructureCtrl {

	@Autowired
	StructureServiceImpl srv;
	
	
	@RequestMapping(value = "/welcome")
	public String showIndex(Model model){
		
		return "index";
	}
	
	@RequestMapping(value = "/create-edit")
	public String createStructure(Model model){
		
		return "struct/create-edit";
	}
	
	
	@RequestMapping(value = "/all")
	public String list(Model model){
		List<Structure> ss = srv.findAll();
		model.addAttribute("structs", ss);
		for (Structure s : ss) {
			System.out.println("Une structure => "+s);
		}
		return "struct/all";
	}
}
