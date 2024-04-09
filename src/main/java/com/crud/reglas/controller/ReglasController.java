package com.crud.reglas.controller;

import com.crud.reglas.DTO.ReglasDTO;
import com.crud.reglas.entities.Reglas;
import com.crud.reglas.service.ReglasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class ReglasController {

    private final ReglasService reglasService;

    public ReglasController(ReglasService reglasService) {
        this.reglasService = reglasService;
    }

    @GetMapping("/reglas")
    public List<ReglasDTO> listAllReglas(Model model){
        List<Reglas> reglasList = reglasService.listAllReglas();
        model.addAttribute("reglas", reglasList);
        return
    }

    @GetMapping("/reglas/{id}")
    public ReglasDTO getReglasporId(@PathVariable Long id){
        Reglas reglas = reglasService.getReglasporId(id);
        return convertToDTO(reglas);
    }

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
