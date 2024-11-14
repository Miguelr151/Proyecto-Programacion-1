package com.Corhuila.pet_care.models.service;

import com.Corhuila.pet_care.models.entity.HorarioCuidadoMascota;

import java.util.List;

public interface IHorarioCuidadoMascotaService {
    List<HorarioCuidadoMascota> findAll();
    HorarioCuidadoMascota findById(Long id);
    HorarioCuidadoMascota save(HorarioCuidadoMascota horarioCuidadoMascota);
    void delete(Long id);
}
