package com.Corhuila.pet_care.models.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="rutina_mascota")
public class RutinaMascota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hora;

    @Column(length = 100)
    private String actividad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    private static final long serialVersionUID=1L;
}
