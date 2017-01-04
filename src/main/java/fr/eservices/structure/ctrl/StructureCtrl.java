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

@Controller
@RequestMapping(value = "/struct")
public class StructureCtrl {

	@Autowired
	StructureServiceImpl srv;

	@RequestMapping(value = "")
	public String showIndex(Model model) {

		return "index";
	}
	
	@RequestMapping(value = "/create-edit")
	public String showStructure(Model model) {

		return "struct/create-edit";
	}

	@RequestMapping(value = "/all")
	public String list(Model model){
		model.addAttribute("structures", srv.findAll());
		return "struct/all";
	}

	@RequestMapping(value = "/filter")
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

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("struct/create-edit", "structure", new Structure());
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createStructure(Model model, @ModelAttribute Structure structure, HttpServletResponse resp) {
		srv.create(structure);
		model.addAttribute("structure", structure);
		try {
			resp.sendRedirect("all");
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editStructure(Model model, @RequestParam("idStruct") final Long idStruct) {
		Structure structToEdit = srv.findStructById(idStruct);
		model.addAttribute("structToEdit", structToEdit);

		return "struct/create-edit";
	}

}
