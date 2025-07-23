/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import modelo.Mascotas;
import daos.DaoMascotas;
import dto.DtoMascota;
import java.util.ArrayList;

/**
 *
 * @author Kevin 
 */

public class MascotaControlador {

    private DaoMascotas dao;

    public MascotaControlador() {
        this.dao = new DaoMascotas();
    }

    public boolean guardarMascota(DtoMascota mascota) {
    if (mascota == null || mascota.getNombre() == null || mascota.getEspecie() == null || mascota.getId() < 5 || mascota.getEdad() < 0) {
        return false;
    }      
          dao.guardarMascota(mascota);
          return true;
}


    public DtoMascota buscarMascota(int id ) {
        if (id < 0) {
            return null;
        }
        return dao.buscarMascota(id);
    }

    public boolean editarMascota(int id, String nuevoNombre, String nuevaEspecie, int nuevaEdad, String documentoProp) {
        if ((id < 5 ) ||
            (nuevoNombre == null || nuevoNombre.isBlank()) ||
            (nuevaEspecie == null || nuevaEspecie.isBlank()) ||
            (nuevaEdad < 0)) {
            return false;
        }
        
        DtoMascota actualizada = new DtoMascota(nuevoNombre, nuevaEspecie, nuevaEdad,id, documentoProp);
        return dao.actualizarMascota(actualizada);
    }

        public boolean eliminarMascota(int id) {
        if (id < 0 ) {
            return false;
        }

        DtoMascota m = dao.buscarMascota(id);
        if (m != null) {
            return dao.eliminarMascota(id);
        }
        return false;
    }
    
    public ArrayList<DtoMascota> buscarPorDocumentoPropietario(String documento) {
    if (documento != null && !documento.equals("")) {
        return dao.buscarUsandoPropietario(documento);
    }
    return new ArrayList<>();
}
    
    public ArrayList<DtoMascota> obtenerTodasMascotas() {
    if (dao == null) {
        return new ArrayList<>();
    }
    return dao.getMascotas();
}
}


