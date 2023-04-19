package com.example.evaluaciojava.versionn.controlador;

import com.example.evaluaciojava.versionn.entidad.Estudiante;
import com.example.evaluaciojava.versionn.servicio.servicioEstudiante;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)


@RestController
public class controladorEstu {
    servicioEstudiante servicio=new servicioEstudiante();


    @GetMapping("/mostrar")
    public ArrayList<Estudiante> mostrar(){return servicio.mostrar();}

    @GetMapping("buscarDoc/{documento}")
    public Estudiante buscarDoc(@PathVariable("documento") String documento){return servicio.buscarDoc(documento);}

    @PostMapping("/agregar/{documento}/{nombre}/{apellido}/{curso}/{nota_final}")
    public String agregar(@PathVariable ("documento")String documento,
                          @PathVariable ("nombre") String nombre,
                          @PathVariable ("apellido") String apellido,
                          @PathVariable ("curso") String curso,
                          @PathVariable ("nota_final") double nota_final)
    {return servicio.agregar(documento,nombre,apellido,curso,nota_final);}

    @GetMapping("listarCurso/{curso}")
    public ArrayList<Estudiante> estudiantesCurso(@PathVariable("curso") String curso){
        return servicio.estudiantesCurso(curso);
    }

    @GetMapping("estadoCurso/{curso}")
    public String aprov_reprov(@PathVariable("curso") String curso){
        return servicio.aprov_reprov(curso);
    }
}
