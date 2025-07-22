/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.util.ArrayList;
import modelo.Mascotas;

/**
 *
 * @author Kevin
 */
public class DaoMascotas {

    private ArrayList<Mascotas> listaMascotas = new ArrayList<>();

    public DaoMascotas() {
    }

    public boolean guardarMascota(Mascotas mascota) {
        for (Mascotas m : listaMascotas){
            if( m.getId() == (mascota.getId())){
                return false;
            }
        }
        listaMascotas.add(mascota);
        return true;
    }

    public boolean actualizarMascota(Mascotas mascota) {
        for (Mascotas m : listaMascotas) {
            if (m.getId() == mascota.getId()) {
                m.setEdad(mascota.getEdad());
                m.setEspecie(mascota.getEspecie());
                m.setNombre(mascota.getNombre());
                return true;
            }
        }
        return false;
    }
    public ArrayList<Mascotas> getMascotas() {
    return listaMascotas;
}


    public boolean eliminarMascota(int id) {
        for (Mascotas m : listaMascotas) {
            if (m.getId() ==  id) {
                listaMascotas.remove(m);
                return true;
            }
        }
        return false;
    }

    public Mascotas buscarMascota(int id) {
        for (Mascotas m : listaMascotas) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Mascotas> buscarUsandoPropietario(String documento) {
        ArrayList<Mascotas> devolverMas = new ArrayList<>();
        for (Mascotas m : listaMascotas) {
            if (m.getDocumentoProp().equals(documento)) {
                devolverMas.add(m);
            }
        }
        return devolverMas;
    }
}
