package com.crud.reglas.DTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReglasDTO {

    private long id;
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private String script;

    public ReglasDTO() {
        // Default constructor
    }

    public ReglasDTO(long id, String nombre, String descripcion, Date fechaInicio, Date fechaFin, String script) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.script = script;
    }
}
