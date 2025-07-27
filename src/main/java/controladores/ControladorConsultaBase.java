/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelo.Persona;
import daos.DaoConsultaBase;
import dto.DtoConsultaBase;

/**
 *
 * @author Kevin
 */
public class ControladorConsultaBase {
   
    private final DaoConsultaBase dao;
    private ArrayList<DtoConsultaBase> ListaconsultasBase;

    public ControladorConsultaBase() {
        this.dao = new DaoConsultaBase();
        this.ListaconsultasBase = dao.cargarConsultas();
    }

    public ArrayList<DtoConsultaBase> listar() {
        return ListaconsultasBase;
    }

    public boolean agregar(DtoConsultaBase consultasBase) {
        ListaconsultasBase.add(consultasBase);
       return dao.guardarConsulta(ListaconsultasBase);
    }
    
    public DtoConsultaBase buscarConsulta(String codigo, Class<?> tipo){
       return dao.buscarConsulta(codigo, tipo);
    }
    
//    public DtoConsultaBase buscarPorCodigo(String codigo){
//       return dao.buscarPorCodigo(codigo);
//    }


    public boolean eliminarPorIdentificacion( String codigo, Class<?> tipo) {
     //  DtoConsultaBase buscar = dao.buscarConsulta(codigo, tipo);
     //  if(buscar != null){
        ListaconsultasBase.removeIf(p -> p.getCodigo().equals(codigo) && tipo.isInstance(p));
       return dao.guardarConsulta(ListaconsultasBase);
       }
    } 
    

