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
    public DtoConsultaBase buscarConsulta(int id){
       return dao.buscarConsulta(id);
    }

    public void eliminarPorIdentificacion( String codigo) {
        ListaconsultasBase.removeIf(p -> p.getCodigo().equals(codigo));
        dao.guardarConsulta(ListaconsultasBase);
    } 
}
