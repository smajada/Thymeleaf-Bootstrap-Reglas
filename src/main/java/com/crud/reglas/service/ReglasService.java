package com.crud.reglas.service;

import com.crud.reglas.entities.Reglas;
import com.crud.reglas.repository.ReglasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReglasService {

    private final ReglasRepository reglasRepository;

    public ReglasService(ReglasRepository reglasRepository) {
        this.reglasRepository = reglasRepository;
    }

    public List<Reglas> listAllReglas(){
        return reglasRepository.findAll();
    }

    public Reglas guardarReglas(Reglas reglas){
        return reglasRepository.save(reglas);
    }

    public Reglas getReglasporId(Long id){
        return reglasRepository.getReferenceById(id);
    }

    public void actualizarReglas(Reglas reglas, Long id){
        reglasRepository.findById(id)
                .ifPresent(reglas1 -> {
                    reglas1.setNombre(reglas.getNombre());
                    reglas1.setDescripcion(reglas.getDescripcion());
                    reglas1.setFecha_inicio(reglas.getFecha_inicio());
                    reglas1.setFecha_fin(reglas.getFecha_fin());
                    reglas1.setScript(reglas.getScript());

                    reglasRepository.save(reglas1);
                });
    }

    public void eliminarReglas(Long id){
        reglasRepository.deleteById(id);
    }
}
