package com.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository er;
		
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form(){
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evento){
		
		er.save(evento);

    		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping("/eventos")
	public ModelAndView listaEventos(){
		ModelAndView mv = new ModelAndView("listaEventos");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
}
