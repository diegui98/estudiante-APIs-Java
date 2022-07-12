
package com.practica.estudiante.service;

import com.practica.estudiante.model.Tema;
import java.util.List;


public interface ITemaService {

    public void saveTema(Tema tem);

    public List<Tema> getTemaList();
    
    public Tema findTema(Long id);
    
    public void deleteTema(Long id);
    
}
