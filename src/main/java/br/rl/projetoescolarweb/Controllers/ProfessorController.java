package br.rl.projetoescolarweb.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.rl.projetoescolarweb.dao.ProfessorDao;
import br.rl.projetoescolarweb.modelo.Professor;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	ProfessorDao professorRepository;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String listProfessor(ModelMap model) {
		List<Professor> professor = professorRepository.findAll();
		
		model.addAttribute("professorList",professor);
		model.addAttribute("message", "Lista de Professores");
		
		System.out.println("list");
		return "professor/list";
		
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newProfessor(ModelMap model) {
		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		model.addAttribute("edit", false);
		
		return "professor/form";
	}
	
	@RequestMapping(value= {"/new"}, method=RequestMethod.POST)
	public String saveProfessor(@Valid @ModelAttribute Professor professor,BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "professor/form";
		}
		
		professorRepository.saveAndFlush(professor);
		
		model.addAttribute("mensagem", "Professor " + professor.getNome() + " cadastrado com sucesso");
		
		return "redirect:/professor/list";
	}
	
	@RequestMapping(value = {"/edit-{id}-professor"}, method = RequestMethod.GET)
	public String editProfessor(@PathVariable("id") Long id, ModelMap model) {
		Professor professor = professorRepository.getOne(id);
		model.addAttribute("professor", professor);
		model.addAttribute("edit", true);
		return "professor/form";
	}
	
	@RequestMapping(value = {"/edit-{id}-professor"}, method = RequestMethod.POST)
	public String updateProfessor(@Valid Professor professor, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "professor/form";
		}
		
		professorRepository.saveAndFlush(professor);
		
		model.addAttribute("mensagem", "Professor" + professor.getNome() + " atualizado com sucesso");
		
		return "redirect:/professor/list";
	}
	
	@RequestMapping(value = { "/delete-{id}-professor" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable Long id) {
		professorRepository.deleteById(id);
		return "redirect:/professor/list";
	}
}
