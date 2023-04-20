package com.example.evaluaciojava.versionn.servicio;

import com.example.evaluaciojava.versionn.entidad.Estudiante;

import java.time.Period;
import java.util.ArrayList;

public class servicioEstudiante {
    private ArrayList<Estudiante> lista=new ArrayList<>();
    public servicioEstudiante(){
        lista.add(new Estudiante("1001","Carlos","Rodriguez","Decimo", 4.5));
        lista.add(new Estudiante("1010","Gabriela","Lopez","Decimo", 2.8));
        lista.add(new Estudiante("1110","Esteban","Acosta","Decimo", 3));
        lista.add(new Estudiante("1100","Camila","Estrada","Once", 4.3));
        lista.add(new Estudiante("1000","Richard","Hernandez","Once", 2.9));
    }

    public ArrayList<Estudiante> mostrar(){
        return lista;
    }


    public Estudiante buscarDoc(String documento){
        Estudiante estu=null;
        for (Estudiante e:lista){
            if (e.getDocumento().equals(documento)){
                estu=e;
                break;
            }
        }
        return estu;
    }

    public ArrayList<Estudiante> estudiantesCurso(String curso_buscar) {
        ArrayList<Estudiante> lista_curso=new ArrayList<>();
        Estudiante estu=null;
        for (Estudiante e:lista){
            if (e.getCurso().equals(curso_buscar)){
                estu=e;
                lista_curso.add(estu);
            }
        }
        return lista_curso;
    }

    public String agregar(Estudiante novo_estu){
        String msg;
        lista.add(novo_estu);
        msg="Registro exitoso";
        return msg;

    }

    public String aprov_reprov(String curso){
        ArrayList<Estudiante> listaAR=estudiantesCurso(curso);
        int aprobados = 0;
        int reprobados = 0;
        for (Estudiante e : listaAR){
            if (e.getNota_final()>=3){
                e.setObservacion("Aprobado");
                aprobados+=1;
            }
            else {
                e.setObservacion("Reprobado");
                reprobados+=1;
            }
        }
        return "aprobados: "+aprobados+", reprobados:"+reprobados;
    }





}
