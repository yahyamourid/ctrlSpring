package com.mourid.services;

import com.mourid.dao.IDao;
import com.mourid.entities.Service;
import com.mourid.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IDao<Service> {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Service create(Service o) {
        return serviceRepository.save(o);
    }

    @Override
    public Service update(Service o) {
        return serviceRepository.save(o);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean delete(Service o) {
        try{
            serviceRepository.delete(o);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
