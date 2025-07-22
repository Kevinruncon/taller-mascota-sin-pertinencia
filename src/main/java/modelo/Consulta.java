/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Kevin
 */
public class Consulta {

    private String codigo;
    // private String fecha;
    // ✅ Refactor:
    private LocalDate fecha;
    private Veterinario veterinario;
    private String documentoPropCons;
    private String nombreMasCons;
    private String diagnostico;
    private String tratamiento;
    

    public Consulta(String codigo, String fecha, Veterinario veterinario, String documentoPropCons, String nombreMasCons,String diagnostico,String tratamiento) {
        /*this.codigo = codigo;
        this.fecha = fecha;
        this.veterinario = veterinario;*/
        // ✅ Validación y conversión de fecha
        setDocumentoPropCons(documentoPropCons);
        setDiagnostico(diagnostico);
        setTratamiento(tratamiento);
        setNombreMasCons(nombreMasCons);
        setCodigo(codigo);
        setFecha(fecha);
        setVeterinario(veterinario);
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDocumentoPropCons() {
        return documentoPropCons;
    }

    public void setDocumentoPropCons(String documentoPropCons) {
        this.documentoPropCons = documentoPropCons;
    }

    public String getNombreMasCons() {
        return nombreMasCons;
    }

    public void setNombreMasCons(String nombreMasCons) {
        this.nombreMasCons = nombreMasCons;
    }
    

   /* public void mostrarConsulta() {
        System.out.println("Consulta Código: " + codigo);
        System.out.println("Fecha: " + fecha);
        if (veterinario != null) {
            veterinario.mostrarPerfil();
        } else {
            System.out.println("Sin veterinario asignado.");
        }
    }*/

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código inválido.");
        }
        this.codigo = codigo;
    }

    // public String getFecha() { return fecha; }
    public LocalDate getFecha() { return fecha; }

    public void setFecha(String fechaTexto) {
        try {
            this.fecha = LocalDate.parse(fechaTexto); // Formato YYYY-MM-DD
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido.");
        }
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        if (veterinario == null) {
            throw new IllegalArgumentException("Veterinario requerido.");
        }
        this.veterinario = veterinario;
    }
}


