/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Kevin
 */
public class DtoVacuna extends DtoConsultaBase implements Serializable{
    private String tipo;
    private String lote;
    private LocalDate proximaDosis;

    public DtoVacuna(String tipo, String lote, String proximaDosis, String fecha, int idMas,String codigo) {
        super(fecha, idMas,codigo);
         setTipo(tipo);
        setLote(lote);
        setProximaDosis(proximaDosis); 
    }
 
   

    // Constructor con parámetros
    /*public DtoVacuna(String tipo, String lote, LocalDate fechaAplicacion, LocalDate proximaDosis) {
        setTipo(tipo);
        setLote(lote);
        setFechaAplicacion(fechaAplicacion);
        setProximaDosis(proximaDosis);
    }*/

    // Getter y Setter para tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo != null && !tipo.isBlank()) {
            this.tipo = tipo;
        }
    }

    // Getter y Setter para lote
    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        if (lote != null && !lote.isBlank()) {
            this.lote = lote;
        }
    }


 public LocalDate getProximaDosis() {
        return proximaDosis;
}

    // Getter y Setter para fechaAplicacion
    /* public LocalDate getFechaAplicacion() {
    return fechaAplicacion;
    }
    public void setFechaAplicacion(LocalDate fechaAplicacion) {
    if (fechaAplicacion != null) {
    this.fechaAplicacion = fechaAplicacion;
    }
    }
    // Getter y Setter para proximaDosis
    public LocalDate getProximaDosis() {
    return proximaDosis;
    }*/

    public void setProximaDosis(String proximaDosis) {
        if (proximaDosis == null || proximaDosis.trim().isEmpty()) {
            this.proximaDosis = null; // o decide si deberías lanzar excepción
            return;
        }
        
        try {
            this.proximaDosis = LocalDate.parse(proximaDosis);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Se esperaba yyyy-MM-dd.");
        }
    }



   /* // Método auxiliar si se desea mostrar
    public String mostrarVacuna() {
        return "Tipo: " + tipo + " | Lote: " + lote +
               " | Fecha Aplicación: " + fechaAplicacion +
               " | Próxima dosis: " + proximaDosis;
    }*/

    @Override
    public String mostrar(){
     return " Vacuna | Fecha: " + fecha + ", Tipo: " + tipo + "Lote: " + lote + "Proxima Dosis: "+ proximaDosis ;

    }

}