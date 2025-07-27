/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import modelo.Consulta;
import modelo.Historial;
import modelo.Mascotas;

/**
 *
 * @author Kevin
 */
public class DtoMascota implements Serializable{
   private static final long serialVersionUID = 1L;

    private int Id;
    private String nombre;
    private String especie;
    private int edad;
    // private ArrayList<Consulta> consultas;
    // ✅ Refactor: delegar a clase Historial
    private Historial historial;
    private String documentoPropietario;

    public DtoMascota() {
    }

    public DtoMascota(String nombre, String especie,int edad, int id, String documentoPropietario) {
        /*this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.consultas = new ArrayList<>();*/
        // ✅ Refactor: usar setters + historial
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
        setId(id);
        setDocumentoPropietario(documentoPropietario);
        
        this.historial = new Historial();
    }

//    public String getDocumentoPropietario() {
//        return documentoPropietario;
//    }
//
//    public void setDocumentoPropietario(String documentoPropietario) {
//        this.documentoPropietario = documentoPropietario;
//    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void agregarConsulta(Consulta consulta) {
        // consultas.add(consulta);
        historial.agregarConsulta(consulta); // ✅ delegar
    }

  /*  public void mostrarHistorial() {
        System.out.println("📋 Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años");
        System.out.println("Historial de consultas:");
        /*if (consultas.isEmpty()) {
            System.out.println("Sin consultas registradas.");
        } else {
            for (Consulta c : consultas) {
                c.mostrarConsulta();
                System.out.println("--------------------------");
            }
        }
        historial.mostrarConsultas(); // ✅ nuevo método
    }*/

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido.");
        }
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("Especie inválida.");
        }
        this.especie = especie;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }
    
    public int getEdad() {
        return edad;
    }
     public String getDocumentoPropietario() {
        return documentoPropietario;
    }

    public void setDocumentoPropietario(String documentoPropietario) {
      if(documentoPropietario == null || documentoPropietario.length() < 5){
            throw new IllegalArgumentException("Documento invalido, revise bien su documento");
        }
        this.documentoPropietario = documentoPropietario;
    }
    public String toLineaArchivo() {
        return nombre + "," + especie + "," + edad + "," + Id + "," + documentoPropietario;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public static DtoMascota desdeLineaArchivo(String linea) {
        String[] partes = linea.split(",");
        if (partes.length != 5) return null;
        try {
            int edad = Integer.parseInt(partes[2]);
            int id = Integer.parseInt(partes[3]);
            return new DtoMascota(partes[0], partes[1],edad,id,partes[4]);
        } catch (NumberFormatException e) {
            return null;
        }
    }


}

