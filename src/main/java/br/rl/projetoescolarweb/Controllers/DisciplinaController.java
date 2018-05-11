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
import br.rl.projetoescolarweb.dao.DisciplinaDao;
import br.rl.projetoescolarweb.modelo.Disciplina;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {
	@Autowired
	DisciplinaDao disciplinaRepository;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String listDisciplina(ModelMap model) {
		List<Disciplina> disciplina = disciplinaRepository.findAll();
		
		model.addAttribute("disciplinaList",disciplina);
		model.addAttribute("message", "Lista de Disciplinas");
		
		System.out.println("list");
		return "disciplina/list";
		
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newDisciplina(ModelMap model) {
		Disciplina disciplina = new Disciplina();
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("edit", false);
		
		return "disciplina/form";
	}
	
	@RequestMapping(value= {"/new"}, method=RequestMethod.POST)
	public String saveDisciplina(@Valid @ModelAttribute Disciplina disciplina,BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "disciplina/form";
		}
		
		disciplinaRepository.saveAndFlush(disciplina);
		
		model.addAttribute("mensagem", "Disciplina " + disciplina.getNome() + " cadastrada com sucesso");
		
		return "redirect:/disciplina/list";
	}
	
	@RequestMapping(value = {"/edit-{id}-disciplina"}, method = RequestMethod.GET)
	public String editDisciplina(@PathVariable("id") Long id, ModelMap model) {
		Disciplina disciplina = disciplinaRepository.getOne(id);
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("edit", true);
		return "disciplina/form";
	}
	
	@RequestMapping(value = {"/edit-{id}-disciplina"}, method = RequestMethod.POST)
	public String updateDisciplina(@Valid Disciplina disciplina, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "disciplina/form";
		}
		
		disciplinaRepository.saveAndFlush(disciplina);
		
		model.addAttribute("mensagem", "Disciplina" + disciplina.getNome() + " atualizada com sucesso");
		
		return "redirect:/disciplina/list";
	}
	
	@RequestMapping(value = { "/delete-{id}-disciplina" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable Long id) {
		disciplinaRepository.deleteById(id);
		return "redirect:/disciplina/list";
	}
}

