package com.crud.reglas.controller;

import com.crud.reglas.entities.Reglas;
import com.crud.reglas.service.ReglasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReglasController {

    private final ReglasService reglasService;

    public ReglasController(ReglasService reglasService) {
        this.reglasService = reglasService;
    }

    @GetMapping("/")
    public String listAllReglas(Model model){
        List<Reglas> reglasList = reglasService.listAllReglas();
        model.addAttribute("reglas", reglasList);
        model.addAttribute("titlePage", "Reglas");
        return  "reglas";
    }

    @GetMapping("/reglas")
    public String crearReglas(Model model){
        Reglas regla = new Reglas();
        model.addAttribute("regla", regla);
        model.addAttribute("titlePage", "Nueva regla");
        return "crear_regla";
    }

    @GetMapping("/reglas/editar/{id}")
    public String editarReglas(@PathVariable Long id, Model model){
        model.addAttribute("regla", reglasService.getReglasporId(id));
        model.addAttribute("titlePage", "Editar regla");
        return "editar_regla";
    }

    @PostMapping("/reglas")
    public String guardarReglas(@ModelAttribute("regla") Reglas regla){
        if (regla.getId() == null){
            reglasService.guardarReglas(regla);
        } else {
            reglasService.actualizarReglas(regla, regla.getId());
        }

        return "redirect:/";
    }

    @GetMapping("/reglas/{id}")
    public String eliminarReglas(@PathVariable Long id){
        reglasService.eliminarReglas(id);
        return "redirect:/";
    }
}
