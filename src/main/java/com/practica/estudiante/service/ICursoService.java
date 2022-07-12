
package com.practica.estudiante.service;

import com.practica.estudiante.model.Curso;
import com.practica.estudiante.model.Tema;
import java.util.List;


public interface ICursoService {
    
    public void saveCurso(Curso cur);
    
    public List<Curso> getCursoList();
    
    public Curso findCurso(Long id);
    
    public void deleteCurso(Long id);
    
}
