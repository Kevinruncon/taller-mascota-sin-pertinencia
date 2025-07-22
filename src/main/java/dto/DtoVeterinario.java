/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Kevin
 */
public class DtoVeterinario extends DtoPersona {
     private String especialidad;

    public DtoVeterinario (String nombre, String especialidad) {
        /*this.nombre = nombre;
        this.especialidad = especialidad;*/
        super(nombre);
        setEspecialidad(especialidad);
    }

   /* public void mostrarPerfil() {
        System.out.println("Veterinario: " + nombre + " | Especialidad: " + especialidad);
    }

    public String getNombre() {
        return nombre;
    }*/

    /*public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/
     @Override
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del veterinario no puede estar vacío.");
        }
        super.setNombre(nombre);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    /*public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }*/
    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        this.especialidad = especialidad;
    }
}

