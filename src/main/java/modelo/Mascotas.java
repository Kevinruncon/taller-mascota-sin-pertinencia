/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
public class Mascotas {
    private int Id;
    private String nombre;
    private String especie;
    private int edad;
    // private ArrayList<Consulta> consultas;
    // ✅ Refactor: delegar a clase Historial
    private Historial historial;
    private String documentoPropietario;

    public Mascotas(String nombre, String especie, int edad, int Id) {
        /*this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.consultas = new ArrayList<>();*/
        // ✅ Refactor: usar setters + historial
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
        setId(Id);
        this.historial = new Historial();
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }


    // ✅ Nuevos setters con validación
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEdad(int edad) {
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
     public String getDocumentoProp() {
        return documentoPropietario;
    }

    public void setDocumentoProp(String documentoProp) {
        this.documentoPropietario = documentoProp;
    }

    public String toLineaArchivo() {
        return nombre + "," + especie + "," + edad + "," + Id;
    }

    public static Mascotas desdeLineaArchivo(String linea) {
        String[] partes = linea.split(",");
        if (partes.length != 3) return null;
        try {
            int edad = Integer.parseInt(partes[2]);
            int id = Integer.parseInt(partes[3]);
            return new Mascotas(partes[0], partes[1], edad,id);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

