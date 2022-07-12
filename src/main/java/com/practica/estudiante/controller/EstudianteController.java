
package com.practica.estudiante.controller;

import com.practica.estudiante.dto.CursoTemaDTO;
import com.practica.estudiante.model.Curso;
import com.practica.estudiante.model.Tema;
import com.practica.estudiante.service.ICursoService;
import com.practica.estudiante.service.ITemaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudianteController {
    
    @Autowired
    private ICursoService interCurso;
    
    @Autowired
    private ITemaService interTema;
    
    @PostMapping("estudiante/tema/crear")
    public String saveTema(@RequestBody Tema tema){
        
        interTema.saveTema(tema);
        return "Se guardo un nuevo tema";
    }
    
    @PostMapping("estudiante/curso/crear")
    public String saveCurso(@RequestBody Curso curso){
        
        interCurso.saveCurso(curso);
        return "Se guardo un nuevo Curso";
    }
    
    @GetMapping("estudiante/curso")
    public List<Curso> getCursoList(){
        
        return interCurso.getCursoList();
        
    }
    
    @GetMapping("estudiante/curso/{nombre}")
    @ResponseBody
    public CursoTemaDTO getCursoTemaList(@PathVariable String nombre){
             
        CursoTemaDTO cursoTema = new CursoTemaDTO();
        
        List<Curso> cursoList = interCurso.getCursoList();
        Curso curso = new Curso();
        for(Curso cur: cursoList){
            if (cur.getNombre().equals(nombre)){
                curso = cur ;              
            }
        }
        
        List<Tema> temaList = interTema.getTemaList();
        List<Tema> temaCursoList = new ArrayList<>();
        for(Tema tem: temaList){
            if(tem.getCurso().equals(nombre)){
                temaCursoList.add(tem);
            }
        }
        
        cursoTema.setId_curso(curso.getId_curso());
        cursoTema.setNombre_curso(curso.getNombre());
        cursoTema.setTemas(temaCursoList);
        
        return cursoTema;
        
    }
    
    @GetMapping("estudiante/java")
    public List<Curso> getCursoJavaList(){
        
        List<Curso> cursoList = interCurso.getCursoList();
        List<Curso> cursoJavaList = new ArrayList<>();
        for(Curso cur: cursoList){
            String nombre = cur.getNombre();
            if(nombre.contains("Java")){
                cursoJavaList.add(cur);
            }
        }
        return cursoJavaList;
    }
    
    @PutMapping("estudiante/curso/editar/{id}")
    public Curso modificarCurso(@PathVariable Long id,
                                @RequestParam String nombre,
                                @RequestParam String tipo,
                                @RequestParam String fecha){
        
        Curso curso = interCurso.findCurso(id);
        curso.setNombre(nombre);
        curso.setTipo_curso(tipo);
        curso.setFecha_finalizacion(fecha);
        
        interCurso.saveCurso(curso);
        return curso;
        
    }
    
    @PutMapping("estudiante/tema/editar/{id}")
    public Tema modificarTema(@PathVariable Long id,
                              @RequestParam String nombre,
                              @RequestParam String descripcion,
                              @RequestParam String curso){
        
        Tema tema = interTema.findTema(id);
        tema.setNombre(nombre);
        tema.setDescripcion(descripcion);
        tema.setCurso(curso);
        
        interTema.saveTema(tema);
        return tema;
    }
}
