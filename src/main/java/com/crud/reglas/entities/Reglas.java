package com.crud.reglas.entities;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@NoArgsConstructor
@Data
@Entity
public class Reglas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nombre;

    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_inicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_fin;

  @Column(columnDefinition = "TEXT")
    private String script;

    public Reglas(String nombre, String descripcion, Date fecha_inicio, Date fecha_fin, String script) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.script = script;
    }
}
