/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelo.Persona;
import daos.DaoConsultaBase;
import daos.DaoMascotas;
import dto.DtoConsultaBase;
import dto.DtoMascota;



public class ControladorConsultaBase {

    private final DaoConsultaBase dao;
    private ArrayList<DtoConsultaBase> listaCosnultasyVacunas;

    public ControladorConsultaBase() {
        this.dao = DaoConsultaBase.getInstancia();
        this.listaCosnultasyVacunas = dao.listar(); // Cargar la lista inicial desde archivo
    }

    public ArrayList<DtoConsultaBase> listar() {
        // Siempre se actualiza la lista más reciente
        listaCosnultasyVacunas = dao.listar();
        return listaCosnultasyVacunas;
    }

    public boolean agregar(DtoConsultaBase consultasBase, Class<?> tipo) {
        if (consultasBase == null || consultasBase.getCodigo() == null
                || consultasBase.getCodigo().isBlank() || consultasBase.getFecha() == null
                || consultasBase.getIdMas() <= 0 || tipo == null) {
            return false;
        }
        dao.guardar(consultasBase, tipo);
        listaCosnultasyVacunas = listar();
        return true;
    }

    public DtoConsultaBase buscarConsulta(String codigo, Class<?> tipo) {
         if(codigo == null || codigo.isBlank() || tipo == null){
        return null;
        }
        return dao.buscarConsultas(codigo, tipo);
    }


    public boolean eliminarPorIdentificacion(String codigo, Class<?> tipo) {
        if(codigo == null || codigo.isBlank() || tipo == null){
            return false;
        }
        DtoConsultaBase buscar = dao.buscarConsultas(codigo, tipo);
        if (buscar != null) {
            dao.eliminar(codigo, tipo);
            listaCosnultasyVacunas = listar();
            return true;
        }
        return false;

    }
    
    public boolean actualizarConsulta(DtoConsultaBase consultasBase, Class<?> tipo){
     if (consultasBase == null || consultasBase.getCodigo() == null
        || consultasBase.getCodigo().isBlank() || consultasBase.getFecha() == null
        || consultasBase.getIdMas() <= 0 || tipo == null) {
            return false;
        }
     DtoConsultaBase buscar = dao.buscarConsultas(consultasBase.getCodigo(), tipo);
     if(buscar != null){
         dao.actualizar(consultasBase, tipo);
         listaCosnultasyVacunas = listar();
         return true;
     }
         return false;

    }

}
