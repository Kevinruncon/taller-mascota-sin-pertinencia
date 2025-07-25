/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import modelo.Vacuna;
import daos.DaoVacuna;
import java.time.LocalDate;

/**
 *
 * @author Kevin 
 */

public class VacunaControlador {

//    private DaoVacuna dao;
//
//    // Constructor
//    public VacunaControlador(DaoVacuna dao) {
//        this.dao = dao;
//    }
//
//    // Método para registrar vacuna
//    public boolean registrarVacuna(String tipo, String lote, LocalDate fechaAplicacion, LocalDate proximaDosis) {
//        if (tipo == null || tipo.isBlank() || lote == null || lote.isBlank() || fechaAplicacion == null || proximaDosis == null) {
//            return false;
//        }
//
//        Vacuna nueva = new Vacuna(tipo, lote, fechaAplicacion, proximaDosis);
//        return dao.guardarVacuna(nueva);
//    }
//
//    // Método para buscar vacuna
//    public Vacuna buscarVacuna(Vacuna vacuna) {
//        if (vacuna.getTipo() != null && vacuna.getLote() != null && !vacuna.getTipo().isBlank() && !vacuna.getLote().isBlank()) {
//            return dao.buscarVacuna(vacuna);
//        }
//        return null;
//    }
//
//    // Método para editar vacuna existente
//    public boolean editarVacuna(Vacuna vacuna) {
//        if (vacuna.getTipo() == null || vacuna.getLote() == null || vacuna.getFechaAplicacion() == null || vacuna.getProximaDosis() == null) {
//            return false;
//        }
//
//        Vacuna nueva = new Vacuna(vacuna.getLote(),vacuna.getTipo(), vacuna.getFechaAplicacion(),vacuna.getProximaDosis());
//        return dao.editarVacuna(vacuna);
//    }
//
//    // Método para eliminar vacuna
//    public boolean eliminarVacuna(Vacuna vacuna) {
//        if (vacuna.getTipo() != null && vacuna.getTipo() != null && !vacuna.getTipo().isBlank() && !vacuna.getLote().isBlank()) {
//            return dao.eliminarVacuna(vacuna);
//        }
//        return false;
//    }
}
