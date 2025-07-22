/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import modelo.Propietario;
import daos.DaoPropietario;
import java.util.ArrayList;
/**
 *
 * @author Kevin 
 */




public class PropietarioControlador {

    private DaoPropietario dao;

    public PropietarioControlador() {
        this.dao = new DaoPropietario();
    }

    public boolean guardarPropietario(Propietario propietario) {
        // Validar que los campos no estén vacíos y tengan longitud adecuada
        if ((propietario.getNombre() == null || propietario.getNombre().isBlank()) ||
            (propietario.getDocumento() == null || propietario.getDocumento().length() < 5) ||
            (propietario.getTelefono() == null || propietario.getTelefono().length() < 5)) {
            return false;
        }
        return dao.guardarPropietario(propietario);
    }

    public Propietario buscarPropietario(String documento) {
        // Validar que el documento no esté vacío
        if (documento == null || documento.isBlank()) {
            return null;
        }
        return dao.buscarPropietario(documento);
    }

    public boolean editarPropietario(String documentoActual, String nuevoNombre, String nuevoTelefono) {
        // Validar datos nuevos y actuales
        if ((documentoActual == null || documentoActual.isBlank()) ||
            (nuevoNombre == null || nuevoNombre.isBlank()) ||
            (nuevoTelefono == null || nuevoTelefono.length() < 5)) {
            return false;
        }

        Propietario actualizado = new Propietario(nuevoNombre, documentoActual, nuevoTelefono);
        return dao.editarPropietario(documentoActual, actualizado);
    }

    public boolean eliminarPropietario(String documento) {
        // Validar documento antes de eliminar
        if (documento == null || documento.isBlank()) {
            return false;
        }
        return dao.eliminarPropietario(documento);
    }
    
    public ArrayList<Propietario> obtenerPropietarios(){
        return dao.obtenerTodos();
    }
}

