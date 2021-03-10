package com.example.ac1.controllers;

import com.example.ac1.entidade.Event;
import com.example.ac1.services.EventService;
import com.example.ac1.repositorio.EventRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
@RequestMapping("/main")
public class EventController {
    
    @Autowired
    EventRepository eventoRepository;
    EventService eventoService;
    

    //Retorna View com lista de funcionarios
    @GetMapping("/eventos")
    public ModelAndView listarEventos(){
        ModelAndView mv = new ModelAndView("eventos");//novo modelo e view com o nome da view
        mv.addObject("eventos",eventoService.getAllEvents());//add lista de objetos funcionario a view
        return mv;
    }

    //Retorna View para criaçao de um novo funcionario
    @GetMapping("/novofuncionario")
    public ModelAndView novoFuncionario(){
        ModelAndView mv = new ModelAndView("novoEvento");
        mv.addObject("evento", new Event());
        return mv;
    }

    //Salva funcionario criado / Atualiza funcionario existente com o mesmo id
    @PostMapping("/cadastrarevento")
    public String cadastrarFuncionario(@ModelAttribute Event event){
        eventoService.saveEvent(event);
        return "redirect:/main/eventos";
    }

    //Remove funcionario pelo id passado
    @GetMapping("/removerevento")
    public String removerFuncionario(@RequestParam Integer codigo){
        Event event = eventoService.getEventById(id);
        eventoService.removeFuncionario(event);
        //implementar - verificar se existe func - throw exception
        return "redirect:/main/eventos";
    }

    //Retorna view com dados do funcionario para edição
    @GetMapping("/editarevento")
    public ModelAndView editarFuncionario(@RequestParam Integer codigo){
        ModelAndView mv = new ModelAndView("editarEvento");
        mv.addObject("event", eventoService.getEventById(id));
        return mv;
    }
    
}
