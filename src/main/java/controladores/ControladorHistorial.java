/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.DaoHistorial;
import daos.DaoMascotas;
import dto.DtoConsultaBase;
import dto.DtoMascota;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class ControladorHistorial {
    
    private final DaoHistorial dao;

    public ControladorHistorial() {
        this.dao = DaoHistorial.getInstancia();
    }

    public ArrayList<DtoConsultaBase> obtenerHistorial(int idMascota) {
        return dao.obtenerHistorialPorIdMascota(idMascota);
    }
    public DtoMascota obtenerMascota(int id) {
    return DaoMascotas.getInstancia().buscarMascota(id);
}

}


