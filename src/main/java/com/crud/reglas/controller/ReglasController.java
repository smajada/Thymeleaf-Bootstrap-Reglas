package com.crud.reglas.controller;

import com.crud.reglas.DTO.ReglasDTO;
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
//        Reglas reglas = new Reglas();
//        model.addAttribute("reglas", reglas);
        model.addAttribute("titlePage", "Nueva regla");
        return "crear_reglas";
    }

    @GetMapping("/reglas/editar/{id}")
    public String getReglasporId(Model model){
//        Reglas reglas = reglasService.getReglasporId(id);
//        model.addAttribute("reglas", reglas);
        model.addAttribute("titlePage", "Editar regla");
        return "editar_regla";
    }
//
    @PostMapping("/reglas")
    public ReglasDTO guardarReglas(@RequestBody Reglas reglas){
        Reglas savedReglas = reglasService.guardarReglas(reglas);
        return convertToDTO(savedReglas);
    }

    @PutMapping("/reglas/{id}")
    public void actualizarReglas(@PathVariable Long id, @RequestBody Reglas reglas){
        reglasService.actualizarReglas(reglas, id);
    }

    @DeleteMapping("/reglas/{id}")
    public void eliminarReglas(@PathVariable Long id){
        reglasService.eliminarReglas(id);
    }

    private ReglasDTO convertToDTO(Reglas reglas) {
        return new ReglasDTO(reglas.getId(),
                reglas.getNombre(),
                reglas.getDescripcion(),
                reglas.getFecha_inicio(),
                reglas.getFecha_fin(),
                reglas.getScript());
    }
}
