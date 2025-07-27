/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import dto.DtoPropietario;
import daos.DaoPropietario;
import java.util.ArrayList;
/**
 *
 * @author Kevin 
 */




public class PropietarioControlador {

    private final  DaoPropietario dao ;
    
    private ArrayList<DtoPropietario> ListaPropietario;
    
    public PropietarioControlador() {
        this.dao = new DaoPropietario();
        
    }

    public boolean guardarPropietario(DtoPropietario propietario) {
        if ((propietario.getNombre() == null || propietario.getNombre().isBlank()) ||
            (propietario.getDocumento() == null || propietario.getDocumento().length() < 5) ||
            (propietario.getTelefono() == null || propietario.getTelefono().length() < 5)) {
            return false;
        }
        ArrayList<DtoPropietario> ListaPropietario = dao.cargarPropietario();
        
        for(DtoPropietario p : ListaPropietario){
            if(p.getDocumento().equals(propietario.getDocumento())){
                return false;
        }
  }
        ListaPropietario.add(propietario);
        return dao.guardarPropietario(ListaPropietario);

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
        if ((documentoActual == null || documentoActual.isBlank()) ||
            (nuevoNombre == null || nuevoNombre.isBlank()) ||
            (nuevoTelefono == null || nuevoTelefono.length() < 5)) {
            return false;
        }

        DtoPropietario actualizado = new DtoPropietario(nuevoNombre, documentoActual, nuevoTelefono);
        return dao.editarPropietario(documentoActual, actualizado);
    }

    public boolean eliminarPropietario(String documento) {
        // Validar documento antes de eliminar
        if (documento == null || documento.isBlank()) {
            return false;
        }
        return dao.eliminarPropietario(documento);
    }
    
    public ArrayList<DtoPropietario> obtenerPropietarios(){
        return dao.obtenerTodos();
    }
}

