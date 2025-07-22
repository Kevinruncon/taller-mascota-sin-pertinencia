/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class Propietario extends Persona {

    private String documento;
    private String telefono;
    private ArrayList<Mascotas> mascotas; // Relación 1 a muchos

    public Propietario(String nombre, String documento, String telefono) {
        /*this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;*/
        // ✅ Refactor: se usa setters con validaciones
        super(nombre);
        setDocumento(documento);
        setTelefono(telefono);
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascotas mascota) {
        mascotas.add(mascota);
    }

   /* public void mostrarInformacion() {
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

 /*   public String getNombre() {
        return nombre;
    }*/

    public void setNombre(String nombre) {
      super.setNombre(nombre);
    }

    /*public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }*/

    public String getDocumento() {
        return documento;
    }

    /*public void setDocumento(String documento) {
        this.documento = documento;
    }*/

    public void setDocumento(String documento) {
      /*  if (documento == null || documento.length() < 5) {
            throw new IllegalArgumentException("Documento inválido.");
        }*/
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    /*public void setTelefono(String telefono) {
        this.telefono = telefono;
    }*/

    public void setTelefono(String telefono) {
      /*  if (telefono == null || telefono.length() < 5) {
            throw new IllegalArgumentException("Teléfono inválido.");
        }*/
        this.telefono = telefono;
    }

    public ArrayList<Mascotas> getMascotas() {
        // return mascotas;
        return new ArrayList<>(mascotas);
    }

    /*public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }*/
}


