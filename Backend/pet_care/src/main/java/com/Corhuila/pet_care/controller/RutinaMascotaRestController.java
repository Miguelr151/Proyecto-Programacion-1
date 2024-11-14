package com.Corhuila.pet_care.controller;

import com.Corhuila.pet_care.models.entity.RutinaMascota;
import com.Corhuila.pet_care.models.service.IRutinaMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RutinaMascotaRestController {

    @Autowired
    private IRutinaMascotaService rutinaMascotaService;

    @GetMapping("/rutinas")
    public List<RutinaMascota> index() {
        return rutinaMascotaService.findAll();
    }

    @GetMapping("/rutinas/{id}")
    public RutinaMascota show(@PathVariable Long id) {
        return rutinaMascotaService.findById(id);
    }

    @PostMapping("/rutinas")
    @ResponseStatus(HttpStatus.CREATED)
    public RutinaMascota create(@RequestBody RutinaMascota rutinaMascota) {
        return rutinaMascotaService.save(rutinaMascota);
    }

    @PutMapping("/rutinas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public RutinaMascota update(@RequestBody RutinaMascota rutinaMascota, @PathVariable Long id) {
        RutinaMascota rutinaActual = rutinaMascotaService.findById(id);

        rutinaActual.setHora(rutinaMascota.getHora());
        rutinaActual.setActividad(rutinaMascota.getActividad());

        return rutinaMascotaService.save(rutinaActual);
    }

    @DeleteMapping("/rutinas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        rutinaMascotaService.delete(id);
    }
}
