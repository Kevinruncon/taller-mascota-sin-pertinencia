/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dto.DtoConsultaBase;
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

/**
 *
 * @author Kevin
 */
public class DaoConsultaBase {
  
  private final String archivo = "data/personas.dat";

    public boolean guardarConsulta(ArrayList<DtoConsultaBase> consultaBase) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
        oos.writeObject(consultaBase);
        return true; // éxito
    } catch (IOException e) {
        System.err.println("Error guardando consultas: " + e.getMessage());
        return false;
    }
}

    
    public DtoConsultaBase buscarConsulta(int id){
        ArrayList<DtoConsultaBase> ConsultasBase = cargarConsultas();
        for(    DtoConsultaBase c : ConsultasBase){
            if(c.getIdMas() == id){
                return c;
            }
            
        }
        return null;
                                                                                
    }

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
       

}
