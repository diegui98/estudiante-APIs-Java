
package com.practica.estudiante.service;

import com.practica.estudiante.model.Tema;
import com.practica.estudiante.repository.TemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService {

    @Autowired
    private TemaRepository temaRepo;
    
    @Override
    public void saveTema(Tema tem) {
        temaRepo.save(tem);
    }

    @Override
    public List<Tema> getTemaList() {
        List<Tema> listaTema = temaRepo.findAll();
        return listaTema;
    }

    @Override
    public Tema findTema(Long id) {
        Tema tema = temaRepo.findById(id).orElse(null);
        return tema;
    }

    @Override
    public void deleteTema(Long id) {
        temaRepo.deleteById(id);
    }
    
}
