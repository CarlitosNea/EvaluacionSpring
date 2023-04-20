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

    @PostMapping("/agregar")
    public String agregar(@RequestBody Estudiante estu){
        return servicio.agregar(estu);
    }

    @GetMapping("listarCurso/{curso}")
    public ArrayList<Estudiante> estudiantesCurso(@PathVariable("curso") String curso){
        return servicio.estudiantesCurso(curso);
    }

    @GetMapping("estadoCurso/{curso}")
    public String aprov_reprov(@PathVariable("curso") String curso){
        return servicio.aprov_reprov(curso);
    }
}
