package com.example.evaluaciojava.versionn.entidad;

public class Estudiante {
    private String documento;
    private String nombre;
    private String apellido;
    private String curso;
    private double nota_final;
    private String observacion;

    public Estudiante(String documento, String nombre, String apellido, String curso, double nota_final) {
        this.setDocumento(documento);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCurso(curso);
        this.setNota_final(nota_final);
    }


    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota_final() {
        return nota_final;
    }

    public void setNota_final(double nota_final) {
        this.nota_final = nota_final;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
