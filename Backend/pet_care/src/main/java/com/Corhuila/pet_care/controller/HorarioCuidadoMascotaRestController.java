package com.Corhuila.pet_care.controller;


import com.Corhuila.pet_care.models.entity.HorarioCuidadoMascota;
import com.Corhuila.pet_care.models.service.IHorarioCuidadoMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class HorarioCuidadoMascotaRestController {

    @Autowired
    private IHorarioCuidadoMascotaService horarioCuidadoMascotaService;

    @GetMapping("/mascotas")
    public List<HorarioCuidadoMascota> index() {
        return horarioCuidadoMascotaService.findAll();
    }

    @GetMapping("/mascotas/{id}")
    public HorarioCuidadoMascota show(@PathVariable Long id) {
        return horarioCuidadoMascotaService.findById(id);
    }

    @PostMapping("/mascotas")
    @ResponseStatus(HttpStatus.CREATED)
    public HorarioCuidadoMascota create(@RequestBody HorarioCuidadoMascota horarioCuidadoMascota) {
        return horarioCuidadoMascotaService.save(horarioCuidadoMascota);
    }

    @PutMapping("/mascotas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HorarioCuidadoMascota update(@RequestBody HorarioCuidadoMascota horarioCuidadoMascota, @PathVariable Long id) {
        HorarioCuidadoMascota horarioActual = horarioCuidadoMascotaService.findById(id);

        horarioActual.setNombreMascota(horarioCuidadoMascota.getNombreMascota());
        horarioActual.setTipo(horarioCuidadoMascota.getTipo());
        horarioActual.setRutina(horarioCuidadoMascota.getRutina());

        return horarioCuidadoMascotaService.save(horarioActual);
    }

    @DeleteMapping("/mascotas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        horarioCuidadoMascotaService.delete(id);
    }


}

