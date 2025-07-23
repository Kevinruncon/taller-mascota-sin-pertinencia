/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dto.DtoMascota;
import java.util.ArrayList;
import java.util.List;
import modelo.Mascotas;
import persistencia.ArchivoManager;
import persistencia.ArchivoUtil;

/**
 *
 * @author Kevin
 */
public class DaoMascotas {
   private final ArchivoManager archivo;

   private ArrayList<DtoMascota> listaMascotas = new ArrayList<>();

    public DaoMascotas() {
    archivo = new ArchivoManager("data/mascotas.txt");
    listaMascotas = getMascotas();

    }
    
    private void sobrescribirLista(List<DtoMascota> mascotas) {
        List<String> lineas = new ArrayList<>();
        for (DtoMascota m : mascotas) {
            lineas.add(m.toLineaArchivo());
        }
        archivo.sobrescribirArchivo(lineas);
    }


    public boolean guardarMascota(DtoMascota mascota) {
        for (DtoMascota m : listaMascotas){
            if( m.getId() == (mascota.getId())){
                return false;
            }
        }
        listaMascotas.add(mascota);
        archivo.escribirLinea(mascota.toLineaArchivo());
        //archivo.escribirLinea(mascota.toLineaArchivo());
        return true;
    }

    public boolean actualizarMascota(DtoMascota mascota) {
        for (DtoMascota m : listaMascotas) {
            if (m.getId() == mascota.getId()) {
                m.setEdad(mascota.getEdad());
                m.setEspecie(mascota.getEspecie());
                m.setNombre(mascota.getNombre());
                sobrescribirLista(listaMascotas);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<DtoMascota> getMascotas() {
       ArrayList<DtoMascota> mascotas = new ArrayList<>();
        for (String linea : archivo.leerLineas()) {
            DtoMascota m = DtoMascota.desdeLineaArchivo(linea);
            if (m != null){
                mascotas.add(m);
            }
        }
        return mascotas;
    }
    


    public boolean eliminarMascota(int id) {
        for (DtoMascota m : listaMascotas) {
            if (m.getId() ==  id) {
                listaMascotas.remove(m);
                sobrescribirLista(listaMascotas);
                return true;
            }
        }
        return false;
    }

    public DtoMascota buscarMascota(int id) {
        for (String  linea : archivo.leerLineas()) {
            DtoMascota m = DtoMascota.desdeLineaArchivo(linea);
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<DtoMascota> buscarUsandoPropietario(String documento) {
        ArrayList<DtoMascota> devolverMas = new ArrayList<>();
        for (String m : archivo.leerLineas()) {
            DtoMascota mascota = DtoMascota.desdeLineaArchivo(m);
            if (mascota.getDocumentoPropietario().equals(documento)) {
                devolverMas.add(mascota);
            }
        }
        return devolverMas; 
    }
}
    
  
/*
public class MascotaDAO {
    private final ArchivoManager archivo;

    public MascotaDAO() {
        archivo = new ArchivoManager("data/mascotas.txt");
    }

    public void guardar(Mascotas mascota) {
        archivo.escribirLinea(mascota.toLineaArchivo());
    }

    public List<Mascotas> listar() {
        List<Mascotas> mascotas = new ArrayList<>();
        for (String linea : archivo.leerLineas()) {
            Mascotas m = Mascotas.desdeLineaArchivo(linea);
            if (m != null) mascotas.add(m);
        }
        return mascotas;
    }

    public void eliminarPorNombre(int id) {
        List<Mascotas> mascotas = listar();
        mascotas.removeIf(m -> String.valueOf(m.getId()).equalsIgnoreCase(String.valueOf(id)));
        sobrescribirLista(mascotas);
    }

    public void actualizar(String nombreClave, Mascotas nueva) {
        List<Mascotas> mascotas = listar();
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i).getNombre().equalsIgnoreCase(nombreClave)) {
                mascotas.set(i, nueva);
                break;
            }
        }
        sobrescribirLista(mascotas);
    }

    private void sobrescribirLista(List<Mascotas> mascotas) {
        List<String> lineas = new ArrayList<>();
        for (Mascotas m : mascotas) {
            lineas.add(m.toLineaArchivo());
        }
        archivo.sobrescribirArchivo(lineas);
    }
}
}
*/