
package com.practica.estudiante.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Curso implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_curso;
    private String nombre;
    private String tipo_curso;
    private String fecha_finalizacion;
    
    
    
}
