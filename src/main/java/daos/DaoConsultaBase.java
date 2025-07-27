/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dto.DtoConsultaBase;
import dto.DtoMascota;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;
import persistencia.ArchivoManager;
import persistencia.GestorPersistencia;

/**
 *
 * @author Kevin
 */
public class DaoConsultaBase {
    private final String ruta = "data/ConsultasYVacunas.dat";
    private final GestorPersistencia gestor = GestorPersistencia.getInstance();

    public DaoConsultaBase () {
    }

    private static DaoConsultaBase instancia;

    public static DaoConsultaBase getInstancia() {
        if (instancia == null) {
            instancia = new DaoConsultaBase();
        }
        return instancia;
    }

    public boolean guardar(DtoConsultaBase consultaBase, Class<?> tipo) {
        ArrayList<DtoConsultaBase> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            if( lista.get(i).getCodigo().equals(consultaBase.getCodigo()) && tipo.isInstance(lista.get(i))){
                return false;
            }
        }
        lista.add(consultaBase);
        gestor.guardarLista(ruta, lista);
        return true;   
    }

    public ArrayList<DtoConsultaBase> listar() {
        ArrayList<DtoConsultaBase> lista = gestor.cargarLista(ruta);
        return lista != null ? lista : new ArrayList<>();
    }

    public boolean eliminar(String codigo, Class<?> tipo) {
        ArrayList<DtoConsultaBase> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo().equals(codigo) && tipo.isInstance(lista.get(i))) {
                lista.remove(i);
                gestor.guardarLista(ruta, lista);
                return true;
            }
        }
        return false;
    }

    public boolean actualizar(DtoConsultaBase consultaBase, Class<?> tipo) {
        ArrayList<DtoConsultaBase> lista = listar();

        for (int i = 0; i < lista.size(); i++) {
            DtoConsultaBase actual = lista.get(i);
            if (actual.getCodigo().equals(consultaBase.getCodigo()) && tipo.isInstance(lista.get(i))) {
                lista.set(i, consultaBase);
                gestor.guardarLista(ruta, lista);
                return true;
            }
        }
        return false;
    }

    public DtoConsultaBase buscarConsultas(String codigo, Class<?> tipo){
        ArrayList<DtoConsultaBase> lista = listar();
       for (int i = 0; i < lista.size(); i++) {
           if(lista.get(i).getCodigo().equals(codigo) && tipo.isInstance(lista.get(i))){
               return lista.get(i);  
           }
       }
       return null;

    }
            
}

  
 /* private final String archivo = "data/ConsultasyVacunas.dat";

    public boolean guardarConsulta(ArrayList<DtoConsultaBase> consultaBase) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
        oos.writeObject(consultaBase);
        return true; // éxito
    } catch (IOException e) {
        System.err.println("Error guardando consultas: " + e.getMessage());
        return false;
    }
}

    
    public DtoConsultaBase buscarConsulta(String codigo, Class<?> tipo){
        ArrayList<DtoConsultaBase> ConsultasBase = cargarConsultas();
        for(    DtoConsultaBase c : ConsultasBase){
            if(c.getCodigo().equals(codigo) && tipo.isInstance(c)){
                return c;
            }
            
        }
        return null;
                                                                                
    }
//    
//      public DtoConsultaBase buscarPorCodigo(String codigo){
//        ArrayList<DtoConsultaBase> ConsultasBase = cargarConsultas();
//        for(    DtoConsultaBase c : ConsultasBase){
//            if(c.getCodigo().equals(codigo)){
//                return c;
//            }
//            
//        }
//        return null;
//                                                                                
//    }


       public ArrayList<DtoConsultaBase> cargarConsultas() {
        ArrayList<DtoConsultaBase> ConsultasBase = new ArrayList<>();
        File archivoConsulta = new File(archivo);
        if (!archivoConsulta.exists()) {
            return ConsultasBase; // El archivo no existe, se retorna lista vacía
        }
        try {
            if (archivoConsulta.length() > 0) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                    ConsultasBase = (ArrayList<DtoConsultaBase>) ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar personas: " + e.getMessage());
        }
           return ConsultasBase; 
       }
       

}*/
