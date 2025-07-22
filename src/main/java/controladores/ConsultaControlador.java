/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import modelo.Consulta;
import daos.DaoConsulta;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Veterinario;
/**
 *
 * @author Kevin 
 */

public class ConsultaControlador {

    private DaoConsulta dao;
    private Veterinario veterinario;
    public ConsultaControlador() {
        this.dao = new DaoConsulta();
    }

    public boolean registrarConsulta(String codigo, String fecha, Veterinario veterinario, String documentoPropCons, String nombreMasCons,String diagnostico,String tratamiento) {
        // Validar que el código y la fecha no estén vacíos
        if ( documentoPropCons == null||documentoPropCons.isBlank() ||fecha == null || fecha.isBlank() || codigo == null || codigo.isBlank()|| veterinario == null ||tratamiento == null
           ||tratamiento.isBlank() || diagnostico == null || diagnostico.isBlank()) {
            return false;
        }
        // Validar formato de fecha (YYYY-MM-DD)
        if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }
        // Crear consulta usando setters validados en la clase modelo
        Consulta c = new Consulta(codigo, fecha, veterinario, documentoPropCons, nombreMasCons, diagnostico, tratamiento);
        return dao.guardarConsulta(c);
    }

    public Consulta buscarConsulta(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return null;
        }
        return dao.buscarConsulta(codigo);
    }

    public boolean eliminarConsulta(Consulta consulta) {
        if (consulta.getCodigo() == null || consulta.getCodigo().isBlank()) {
            return false;
        }
        Consulta c = dao.buscarConsulta(consulta.getCodigo());
        if (c != null) {
            return dao.eliminarConsulta(consulta);
        }
        return false;
    }

   public boolean editarConsulta(String codigo, String fecha, Veterinario veterinario, String documentoPropCons, String nombreMasCons,String diagnostico,String tratamiento) {
        // Validar que el código y la fecha no estén vacíos
        if ( documentoPropCons == null||documentoPropCons.isBlank() ||fecha == null || fecha.isBlank() || codigo == null || codigo.isBlank()|| veterinario == null ||tratamiento == null
           ||tratamiento.isBlank() || diagnostico == null || diagnostico.isBlank()) {
            return false;
        }

    if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
        return false;
    }

    try {
       Consulta nuevaConsulta = new Consulta(codigo, fecha, veterinario, documentoPropCons, nombreMasCons, diagnostico, tratamiento);
       Consulta confirmar = dao.buscarConsulta(nuevaConsulta.getCodigo());
       if(confirmar != null){
        return dao.editarConsulta(nuevaConsulta);
       }
    } catch (IllegalArgumentException e) {
        return false;
    }
    return false;
  }
   public ArrayList<Consulta> obtenerConsultas(){
       return dao.obtenerTodas();
   }
}


/*public class ControladorReserva {
    private ReservaDAO reservaDAO;
    private HabitacionDAO habitacionDAO;

    public ControladorReserva(ReservaDAO reservaDAO, HabitacionDAO habitacionDAO) {
        this.reservaDAO = reservaDAO;
        this.habitacionDAO = habitacionDAO;
    }

    public boolean registrarReserva(DtoReserva dto) {
        // 1. Validar fechas
        if (dto.getFechaEntrada().isAfter(dto.getFechaSalida())) {
            throw new IllegalArgumentException("Fechas inválidas");
        }

        // 2. Validar disponibilidad
        for (Habitacion hab : dto.getListaHabitacion()) {
            if (!habitacionDisponible(hab, dto.getFechaEntrada(), dto.getFechaSalida())) {
                return false;
            }
        }

        // 3. Convertir DTO a modelo
        Reserva reserva = new Reserva(dto.getIdReserva(), dto.getFechaEntrada(), dto.getFechaSalida());
        // convertir y agregar huéspedes y habitaciones...

        return reservaDAO.guardar(reserva);
    }

    public boolean habitacionDisponible(Habitacion hab, LocalDate entrada, LocalDate salida) {
        for (Reserva r : reservaDAO.listar()) {
            if (r.getListaHabitacion().contains(hab) &&
                entrada.isBefore(r.getFechaSalida()) &&
                salida.isAfter(r.getFechaEntrada()) &&
                hab.getEstado().equalsIgnoreCase("libre")) {
                return false;
            }
        }
        return true;
    }
}
*/
