/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import modelo.Mascotas;
import daos.DaoMascotas;
import dto.DtoMascota;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin 
 */

public class MascotaControlador {

    private final DaoMascotas dao;
    private ArrayList<DtoMascota> listaMascotas;

    public MascotaControlador() {
        this.dao = DaoMascotas.getInstancia();
        this.listaMascotas = dao.listar(); // Cargar la lista inicial desde archivo
    }

    public ArrayList<DtoMascota> listar() {
        // Siempre se actualiza la lista más reciente
        listaMascotas = dao.listar();
        return listaMascotas;
    }
    public boolean guardarMascota(DtoMascota mascota) {
    if (mascota == null || mascota.getNombre() == null || mascota.getEspecie() == null || mascota.getId() < 5 || mascota.getEdad() < 0) {
        return false;
    }      
          dao.guardar(mascota);
          listaMascotas = listar();
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
         dao.actualizar(actualizada);
         listaMascotas = listar();
         return true;
    }

        public boolean eliminarMascota(int id) {
        if (id < 0 ) {
            return false;
        }

        DtoMascota m = dao.buscarMascota(id);
        if (m != null) {
            dao.eliminar(id);
            listaMascotas = listar();
            return true;
        }
        return false;
    }
}
    
   /* public ArrayList<DtoMascota> buscarPorDocumentoPropietario(String documento) {
    if (documento != null && !documento.equals("")) {
        return dao.buscarUsandoPropietario(documento);
    }
    return new ArrayList<>();
}*/
    



