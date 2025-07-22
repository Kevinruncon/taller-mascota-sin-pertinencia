/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.util.ArrayList;
import modelo.Propietario;

/**
 *
 * @author Kevin
 */
public class DaoPropietario {
    
    private ArrayList<Propietario> listPropietario = new ArrayList<>();

    public DaoPropietario() {
    }
    
     public boolean guardarPropietario(Propietario propietario) {
        for (Propietario p : listPropietario) {
            if (p.getDocumento().equals(propietario.getDocumento())) {
                return false; // Ya existe
            }
        }
        listPropietario.add(propietario);
        return true;
    }

    public Propietario buscarPropietario(String documento) {
        for (Propietario p : listPropietario) {
            if (p.getDocumento().equals(documento)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarPropietario(String documento) {
        Propietario p = buscarPropietario(documento);
        if (p != null) {
            listPropietario.remove(p);
            return true;
        }
        return false;
    }

    public boolean editarPropietario(String documento, Propietario Propietario) {
        for (Propietario p : listPropietario) {
            if (p.getDocumento().equals(documento)) {
                p.setNombre(Propietario.getNombre());
                p.setTelefono(Propietario.getTelefono());
                return true;
            }
        }
        return false;
    }
      public ArrayList<Propietario> obtenerTodos() {
        return new ArrayList<>(listPropietario);
      }
}
