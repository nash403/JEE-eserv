package fr.eservices.structure.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.eservices.structure.model.Structure;
import fr.eservices.structure.srv.StructureServiceImpl;
import fr.eservices.structure.srv.UserMockService;

@Controller
public class StructureCtrl {

	@Autowired
	StructureServiceImpl srv;

	@RequestMapping(method=RequestMethod.GET)
	public void home(HttpServletResponse resp) throws IOException{
		resp.sendRedirect("/structure-srv/index.jsp");
	}

	@RequestMapping(value = "/struct/all")
	public String list(Model model) {
		List<Structure> ss = srv.findAll();
		model.addAttribute("structs", ss);
		for (Structure s : ss) {
			System.out.println("Une structure => " + s);
		}
		return "struct/all";
	}

	@RequestMapping(value = "/struct/filter")
	public String listFiltered(Model model, @RequestParam("regionflt") String filter) {
		String trimed = filter == null ? null : filter.trim();
		if (trimed != null & trimed.length() > 0) {
			List<Structure> ss = srv.filterByRegion(trimed);
			model.addAttribute("structs", ss);
			for (Structure s : ss) {
				System.out.println("Une structure filtrée avec \"" + trimed + "\" => " + s);
			}
		}
		return "struct/all";
	}

	@RequestMapping(value="/struct/create", method=RequestMethod.GET)
	public ModelAndView showForm(){
			return new ModelAndView("struct/create-edit", "structure", new Structure());
	}

	@RequestMapping(value="/struct/create/{id}", method=RequestMethod.GET)
	public ModelAndView showForm(@PathVariable(value="id",required=false) Long id){
			return new ModelAndView("struct/create-edit","structure",srv.findStructById(id));
	}

	@RequestMapping(value="/struct/create", method=RequestMethod.POST)
	public void createStructure(Model model, @ModelAttribute Structure structure, HttpServletResponse resp){

			srv.create(structure);
			model.addAttribute("structure", structure);
			try {
				resp.sendRedirect("/structure-srv/app/struct/all");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@RequestMapping(value="/struct/create/{id}", method=RequestMethod.POST)
	public void createStructure(Model model, @ModelAttribute Structure structure, HttpServletResponse resp,@PathVariable(value="id",required=false) Long id){

		Structure structureFound = srv.findStructById(id);
		structureFound.setCity(structure.getCity());
		structureFound.setCountry(structure.getCountry());
		structureFound.setName(structure.getName());
		structureFound.setRegion(structure.getRegion());
		structureFound.setStatus(structure.getStatus());
		structureFound.setStreet(structure.getStreet());
		structureFound.setZipcode(structure.getZipcode());
		srv.update(structureFound);
		model.addAttribute("structure",structureFound);
	try {
		resp.sendRedirect("/structure-srv/app/struct/all");
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	@RequestMapping(value="/change-user")
	public void updateUser(HttpServletResponse resp) throws IOException {
		UserMockService.changeUser();
		resp.sendRedirect("/structure-srv/index.jsp");
	}

}
