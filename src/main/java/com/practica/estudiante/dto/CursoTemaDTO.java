
package com.practica.estudiante.dto;

import com.practica.estudiante.model.Tema;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CursoTemaDTO implements Serializable {
    
    private Long id_curso;
    private String nombre_curso;
    private List<Tema> temas;

    public CursoTemaDTO() {
    }
    
  
    
}
