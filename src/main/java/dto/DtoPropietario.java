/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.Mascotas;

/**
 *
 * @author Kevin
 */
public class DtoPropietario extends DtoPersona implements Serializable{        
    private String documento;
    private String telefono;
    private ArrayList<DtoMascota> mascotas; // Relación 1 a muchos


    public DtoPropietario (String nombre, String documento, String telefono) {
        /*this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;*/
        // ✅ Refactor: se usa setters con validaciones
        super(nombre);
        setDocumento(documento);
        setTelefono(telefono);
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(DtoMascota mascota) {
        mascotas.add(mascota);
    }

  /*  public void mostrarInformacion() {
        System.out.println("👤 Propietario: " + nombre);
        System.out.println("🆔 Documento: " + documento);
        System.out.println("📞 Teléfono: " + telefono);
    }

   public void mostrarMascotas() {
        for (Mascotas m : mascotas) {
            System.out.println();
            m.mostrarHistorial();
        }
    }*/

   /* public String getNombre() {
        return nombre;
    }*/
    
    @Override
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        super.setNombre(nombre);
    }

    public String getDocumento() {
        return documento;
    }

  
    public void setDocumento(String documento) {
        if (documento == null || documento.length() < 5) {
            throw new IllegalArgumentException("Documento inválido.");
        }
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

  
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 5) {
            throw new IllegalArgumentException("Teléfono inválido.");
        }
        this.telefono = telefono;
    }

    public ArrayList<DtoMascota> getMascotas() {
        return new ArrayList<>(mascotas);
    }
 /*
    public String toLineaArchivo() {
        return nombre + "," + especie + "," + edad + "," + Id;
    }

    public static DtoMascota desdeLineaArchivo(String linea) {
        String[] partes = linea.split(",");
        if (partes.length != 3) return null;
        try {
            int edad = Integer.parseInt(partes[2]);
            int id = Integer.parseInt(partes[3]);
            return new DtoMascota(partes[0], partes[1], edad,id);
        } catch (NumberFormatException e) {
            return null;
        }
    

    }*/
}
