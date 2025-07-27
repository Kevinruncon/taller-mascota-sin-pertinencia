/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.DaoMascotas;
import dto.DtoPropietario;
import daos.DaoPropietario;
import dto.DtoMascota;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */

public class PropietarioControlador {

    private final DaoPropietario dao;
    private ArrayList<DtoPropietario> listaPropietario;

    public PropietarioControlador() {
        this.dao = DaoPropietario.getInstancia();
        this.listaPropietario = dao.listar(); // Cargar la lista inicial desde archivo
    }

    public ArrayList<DtoPropietario> listar() {
        // Siempre se actualiza la lista más reciente
        listaPropietario = dao.listar();
        return listaPropietario;
    }

    public boolean guardarPropietario(DtoPropietario propietario) {
        if ((propietario.getNombre() == null || propietario.getNombre().isBlank())
                || (propietario.getDocumento() == null || propietario.getDocumento().length() < 5)
                || (propietario.getTelefono() == null || propietario.getTelefono().length() < 5)) {
            return false;
        }

        for (DtoPropietario p : listaPropietario) {
            if (p.getDocumento().equals(propietario.getDocumento())) {
                return false; // Ya existe
            }
        }

        dao.guardarPropietario(propietario);
        listaPropietario = listar();
        return true;
    }

    public DtoPropietario buscarPropietario(String documento) {
        // Validar que el documento no esté vacío
        if (documento == null || documento.isBlank()) {
            return null;
        }
        return dao.buscarPropietario(documento);
    }

    public boolean editarPropietario(String documentoActual, String nuevoNombre, String nuevoTelefono) {
        // Validar datos nuevos y actuales
        if ((documentoActual == null || documentoActual.isBlank())
                || (nuevoNombre == null || nuevoNombre.isBlank())
                || (nuevoTelefono == null || nuevoTelefono.length() < 5)) {
            return false;
        }
        DtoPropietario existe = dao.buscarPropietario(documentoActual);
        if (existe == null) {
            return false;
        }
        DtoPropietario actualizado = new DtoPropietario(nuevoNombre, documentoActual, nuevoTelefono);
        dao.actualizarPropietario(documentoActual, actualizado);
        listaPropietario = listar();
        return true;
    }

    public boolean eliminarPropietario(String documento) {
        // Validar documento antes de eliminar
        if (documento == null || documento.isBlank()) {
            return false;
        }
        DtoPropietario existe = dao.buscarPropietario(documento);
        if (existe == null) {
            return false;
        }
        dao.eliminarPropietario(documento);
        listaPropietario = listar();
        return true;
    }
}

/*  public ArrayList<DtoPropietario> obtenerPropietarios(){
        return dao.obtenerTodos();
    }
}*/
