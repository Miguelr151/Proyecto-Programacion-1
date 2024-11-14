package com.Corhuila.pet_care.models.service;

import com.Corhuila.pet_care.models.entity.RutinaMascota;
import java.util.List;

public interface IRutinaMascotaService {
    List<RutinaMascota> findAll();
    RutinaMascota findById(Long id);
    RutinaMascota save(RutinaMascota rutinaMascota);
    void delete(Long id);
}
