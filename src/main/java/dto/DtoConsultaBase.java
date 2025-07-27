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
public abstract class DtoConsultaBase implements Serializable{
    private static final long serialVersionUID = 1L;
    LocalDate fecha;
    int idMas;
    String codigo ;
    
    public DtoConsultaBase(String fecha, int idMas, String codigo) {
        setFecha(fecha);
        setIdMas(idMas);
        setCodigo(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

     public LocalDate getFecha() { return fecha; }

    public void setFecha(String fechaTexto) {
        try {
            this.fecha = LocalDate.parse(fechaTexto); // Formato YYYY-MM-DD
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido.");
        }
    }


    public int getIdMas() {
        return idMas;
    }

    public void setIdMas(int idMas) {
        this.idMas = idMas;
    }
    
    public abstract String mostrar();   
   
    
}
