/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.util.ArrayList;
import dto.DtoPropietario;

/**
 *
 * @author Kevin
 */
public class DaoPropietario {
    
    private ArrayList<DtoPropietario> listPropietario = new ArrayList<>();

    public DaoPropietario() {
    }
    
     public boolean guardarPropietario(DtoPropietario propietario) {
        for (DtoPropietario p : listPropietario) {
            if (p.getDocumento().equals(propietario.getDocumento())) {
                return false; // Ya existe
            }
        }
        listPropietario.add(propietario);
        return true;
    }

    public DtoPropietario buscarPropietario(String documento) {
        for (DtoPropietario p : listPropietario) {
            if (p.getDocumento().equals(documento)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarPropietario(String documento) {
        DtoPropietario p = buscarPropietario(documento);
        if (p != null) {
            listPropietario.remove(p);
            return true;
        }
        return false;
    }

    public boolean editarPropietario(String documento, DtoPropietario Propietario) {
        for (DtoPropietario p : listPropietario) {
            if (p.getDocumento().equals(documento)) {
                p.setNombre(Propietario.getNombre());
                p.setTelefono(Propietario.getTelefono());
                return true;
            }
        }
        return false;
    }
      public ArrayList<DtoPropietario> obtenerTodos() {
        return new ArrayList<>(listPropietario);
      }
}
