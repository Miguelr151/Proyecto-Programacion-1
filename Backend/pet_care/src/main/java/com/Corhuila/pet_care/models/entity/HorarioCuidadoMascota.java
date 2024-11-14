package com.Corhuila.pet_care.models.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="horarios_cuidado_mascotas")
public class HorarioCuidadoMascota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_mascota", length = 50, nullable = false)
    private String nombreMascota;

    @Column(length = 30)
    private String tipo; // Ej., Perro, Gato

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "horario_id")
    private List<RutinaMascota> rutina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<RutinaMascota> getRutina() {
        return rutina;
    }

    public void setRutina(List<RutinaMascota> rutina) {
        this.rutina = rutina;
    }

    private static final long serialVersionUID=1L;
}
