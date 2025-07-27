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
import daos.DaoConsultaBase;
import dto.DtoMascota;
import persistencia.GestorPersistencia;

/**
 *
 * @author Kevin
 */
public class DaoPropietario {
      private final String ruta = "data/propietario.dat";
    private final GestorPersistencia gestor = GestorPersistencia.getInstance();

    public DaoPropietario() {
    }

    private static DaoPropietario instancia;

    public static DaoPropietario getInstancia() {
        if (instancia == null) {
            instancia = new DaoPropietario();
        }
        return instancia;
    }

    public boolean guardarPropietario(DtoPropietario propietario) {
        ArrayList<DtoPropietario> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            if( lista.get(i).getDocumento().equals(propietario.getDocumento())){
                return false;
            }
        }
        lista.add(propietario);
        gestor.guardarLista(ruta, lista);
        return true;   
    }

    public ArrayList<DtoPropietario> listar() {
        ArrayList<DtoPropietario> lista = gestor.cargarLista(ruta);
        return lista != null ? lista : new ArrayList<>();
    }

    public boolean eliminarPropietario(String documento) {
        ArrayList<DtoPropietario> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDocumento().equals(documento)) {
                lista.remove(i);
                gestor.guardarLista(ruta, lista);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarPropietario( String documento, DtoPropietario propietario) {
        ArrayList<DtoPropietario> lista = listar();

        for (int i = 0; i < lista.size(); i++) {
            DtoPropietario actual = lista.get(i);
            if (actual.getDocumento().equals(documento)) {
                lista.set(i, propietario);
                gestor.guardarLista(ruta, lista);
                return true;
            }
        }
        return false;
    }

    public DtoPropietario buscarPropietario(String documento){
        ArrayList<DtoPropietario> lista = listar();
       for (int i = 0; i < lista.size(); i++) {
           if(lista.get(i).getDocumento().equals(documento)){
               return lista.get(i);  
           }
       }
       return null;

    }
            
}

    
   /* private final String archivo = "data/Propietario.dat";
    private DaoConsultaBase dao;

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

    public boolean eliminarPropietario(String documento) {
        ArrayList<DtoPropietario> ListaPropietario = cargarPropietario();
        DtoPropietario p = buscarPropietario(documento);
        if (p != null) {
            ListaPropietario.remove(p);
            return guardarPropietario(ListaPropietario);
            }
        return false;
    }
    
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
}*/
