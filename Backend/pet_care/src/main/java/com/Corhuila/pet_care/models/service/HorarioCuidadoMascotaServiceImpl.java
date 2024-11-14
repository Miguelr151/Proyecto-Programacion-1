package com.Corhuila.pet_care.models.service;

import com.Corhuila.pet_care.models.dao.IHorarioCuidadoMascotaDao;
import com.Corhuila.pet_care.models.entity.HorarioCuidadoMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class HorarioCuidadoMascotaServiceImpl implements IHorarioCuidadoMascotaService {

    @Autowired
    private IHorarioCuidadoMascotaDao horarioCuidadoMascotaDao;

    @Override
    @Transactional(readOnly = true)
    public List<HorarioCuidadoMascota> findAll() {
        return (List<HorarioCuidadoMascota>) horarioCuidadoMascotaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public HorarioCuidadoMascota findById(Long id) {
        return horarioCuidadoMascotaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public HorarioCuidadoMascota save(HorarioCuidadoMascota horarioCuidadoMascota) {
        return horarioCuidadoMascotaDao.save(horarioCuidadoMascota);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        horarioCuidadoMascotaDao.deleteById(id);
    }
}
