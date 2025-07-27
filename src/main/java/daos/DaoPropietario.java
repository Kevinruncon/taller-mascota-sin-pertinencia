/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.util.ArrayList;
import dto.DtoPropietario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Kevin
 */
public class DaoPropietario {
    
    private final String archivo = "data/Propietario.dat";

    public DaoPropietario() {
    }
    
   public boolean guardarPropietario(ArrayList<DtoPropietario> propietario) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
        oos.writeObject(propietario);
        return true; // Guardado exitosamente
    } catch (IOException e) {
        System.err.println("Error guardando personas: " + e.getMessage());
        return false;
    }
}

    

    public DtoPropietario buscarPropietario(String documento) {
        ArrayList<DtoPropietario> ListaPropietario = cargarPropietario();
        for (DtoPropietario p : ListaPropietario) {
            if (p.getDocumento().equals(documento)) {
                return p;
            }
        }
        return null;
    }
                                                                               
    public ArrayList<DtoPropietario> cargarPropietario() {
        ArrayList<DtoPropietario> ListaPropietario = new ArrayList<>();
        File archivoPropietario = new File(archivo);
        if (!archivoPropietario.exists()) {
            return ListaPropietario; // El archivo no existe, se retorna lista vacía
        }
        try {
            if (archivoPropietario.length() > 0) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                    ListaPropietario = (ArrayList<DtoPropietario>) ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar Propietarios: " + e.getMessage());
        }
           return ListaPropietario; 
       }

  /*  public boolean eliminarPropietario(String documento) {
        ArrayList<DtoPropietario> ListaPropietario = cargarPropietario();
        DtoPropietario p = buscarPropietario(documento);
        if (p != null) {
            ListaPropietario.remove(p);
            return guardarPropietario(ListaPropietario);
            }
        return false;
    }*/
    
    public boolean eliminarPropietario(String documento) {
    ArrayList<DtoPropietario> ListaPropietario = cargarPropietario();

    boolean eliminado = ListaPropietario.removeIf(p -> p.getDocumento().equals(documento));

    if (eliminado) {
        return guardarPropietario(ListaPropietario);
    }
    return false;
}


    public boolean editarPropietario(String documento, DtoPropietario Propietario) {
        ArrayList<DtoPropietario> ListaPropietario = cargarPropietario();
        for (DtoPropietario p : ListaPropietario) {
            if (p.getDocumento().equals(documento)) {
                p.setNombre(Propietario.getNombre());
                p.setTelefono(Propietario.getTelefono());
                
                return guardarPropietario(ListaPropietario);
            }
        }
        return false;
    }
      public ArrayList<DtoPropietario> obtenerTodos() {
        return new ArrayList<>(cargarPropietario());
      }
}
