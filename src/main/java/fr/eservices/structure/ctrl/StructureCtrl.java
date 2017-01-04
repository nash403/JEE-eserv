package fr.eservices.structure.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eservices.structure.dto.StructureEditDto;
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
		model.addAttribute("structures", srv.findAll());
		return "struct/all";
	}
	
	@RequestMapping(value = "/filter")
	public String listFiltered(Model model,@RequestParam("regionflt") String filter){
		String trimed = filter == null ? null : filter.trim();
		if (trimed != null & trimed.length() > 0){			
			List<Structure> ss = srv.filterByRegion(trimed);
			model.addAttribute("structs", ss);
			for (Structure s : ss) {
				System.out.println("Une structure filtrée avec \""+trimed+"\" => "+s);
			}
		}
		return "struct/all";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String edit(Model model, @RequestBody() StructureEditDto structureRequest){
		Structure struct = new Structure();
		struct.setName(structureRequest.getName());
		struct.setStreet(structureRequest.getStreet());
		struct.setZipcode(structureRequest.getZipcode());
		struct.setRegion(structureRequest.getRegion());
		struct.setCity(structureRequest.getCity());
		struct.setCountry(structureRequest.getCountry());
		struct.setStatus(Structure.Status.values() [structureRequest.getStatus()]);
		srv.create(struct);
		return "struct/all";
	}
}
