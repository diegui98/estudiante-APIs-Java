
package com.practica.estudiante.service;

import com.practica.estudiante.model.Curso;
import com.practica.estudiante.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoRepository cursoRepo;
    
    @Override
    public void saveCurso(Curso cur) {
        
        cursoRepo.save(cur);
        
    }

    @Override
    public List<Curso> getCursoList() {
        
        List<Curso> listaCursos = cursoRepo.findAll();
        return listaCursos;
        
    }

    @Override
    public Curso findCurso(Long id) {
        Curso curso = cursoRepo.findById(id).orElse(null);
        return curso;
    }
    
    @Override
    public void deleteCurso(Long id) {
        cursoRepo.deleteById(id);
    }
    
}
