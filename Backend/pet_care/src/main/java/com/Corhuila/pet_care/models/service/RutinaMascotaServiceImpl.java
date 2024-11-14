package com.Corhuila.pet_care.models.service;

import com.Corhuila.pet_care.models.dao.IRutinaMascotaDao;
import com.Corhuila.pet_care.models.entity.RutinaMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RutinaMascotaServiceImpl implements IRutinaMascotaService {

    @Autowired
    private IRutinaMascotaDao rutinaMascotaDao;

    @Override
    @Transactional(readOnly = true)
    public List<RutinaMascota> findAll() {
        return (List<RutinaMascota>) rutinaMascotaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public RutinaMascota findById(Long id) {
        return rutinaMascotaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public RutinaMascota save(RutinaMascota rutinaMascota) {
        return rutinaMascotaDao.save(rutinaMascota);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        rutinaMascotaDao.deleteById(id);
    }
}
