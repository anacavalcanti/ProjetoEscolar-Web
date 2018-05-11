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
import br.rl.projetoescolarweb.dao.CursoDao;
import br.rl.projetoescolarweb.modelo.Curso;

@Controller
@RequestMapping("/curso")
public class CursoController {
	@Autowired
	CursoDao cursoRepository;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String listCurso(ModelMap model) {
		List<Curso> curso = cursoRepository.findAll();
		
		model.addAttribute("cursoList",curso);
		model.addAttribute("message", "Lista de Cursos");
		
		System.out.println("list");
		return "curso/list";
		
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newCurso(ModelMap model) {
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
		model.addAttribute("edit", false);
		
		return "curso/form";
	}
	
	@RequestMapping(value= {"/new"}, method=RequestMethod.POST)
	public String saveCurso(@Valid @ModelAttribute Curso curso,BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "curso/form";
		}
		
		cursoRepository.saveAndFlush(curso);
		
		model.addAttribute("mensagem", "Curso " + curso.getNome() + " cadastrado com sucesso");
		
		return "redirect:/curso/list";
	}
	
	@RequestMapping(value = {"/edit-{id}-curso"}, method = RequestMethod.GET)
	public String editCurso(@PathVariable("id") Long id, ModelMap model) {
		Curso curso = cursoRepository.getOne(id);
		model.addAttribute("curso", curso);
		model.addAttribute("edit", true);
		return "curso/form";
	}
	
	@RequestMapping(value = {"/edit-{id}-curso"}, method = RequestMethod.POST)
	public String updateCurso(@Valid Curso curso, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "curso/form";
		}
		
		cursoRepository.saveAndFlush(curso);
		
		model.addAttribute("mensagem", "Curso" + curso.getNome() + " atualizado com sucesso");
		
		return "redirect:/curso/list";
	}
	
	@RequestMapping(value = { "/delete-{id}-curso" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable Long id) {
		cursoRepository.deleteById(id);
		return "redirect:/curso/list";
	}
}
