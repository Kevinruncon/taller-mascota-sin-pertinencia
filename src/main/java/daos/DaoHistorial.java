/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.util.ArrayList;
import java.util.stream.Collectors;
import persistencia.GestorPersistencia;
import dto.DtoConsultaBase;
import dto.DtoMascota;

/**
 *
 * @author Kevin
 */
public class DaoHistorial {

    private static DaoHistorial instancia;

    private final String rutaConsultas = "data/ConsultasYVacunas.dat";
    private final String rutaMascotas = "data/mascotas.dat";

    private final GestorPersistencia gestor = GestorPersistencia.getInstance();

    private DaoHistorial() {}

    public static DaoHistorial getInstancia() {
        if (instancia == null) {
            instancia = new DaoHistorial();
        }
        return instancia;
    }

    // Método principal para obtener el historial
    public ArrayList<DtoConsultaBase> obtenerHistorialPorIdMascota(int idMascota) {
        ArrayList<DtoConsultaBase> historial = new ArrayList<>();

        if (idMascota <= 0) {
            return historial; // ID inválido
        }

        // 1. Cargar mascotas
        ArrayList<DtoMascota> listaMascotas = gestor.cargarLista(rutaMascotas);
        DtoMascota mascota = null;

        // 2. Buscar mascota por ID
        for (DtoMascota m : listaMascotas) {
            if (m.getId() == idMascota) {
                mascota = m;
                break;
            }
        }

        // 3. Si no se encuentra, retornar vacío
        if (mascota == null) {
            System.out.println("❌ Mascota no encontrada con ID: " + idMascota);
            return historial;
        }

        // 4. Cargar historial desde archivo combinado
        ArrayList<DtoConsultaBase> registros = gestor.cargarLista(rutaConsultas);

        // 5. Filtrar los que pertenecen a esta mascota
        for (DtoConsultaBase entrada : registros) {
            if (entrada.getIdMas() == idMascota) {
                historial.add(entrada);
            }
        }
        return historial;
    }

    // Método opcional si necesitas obtener los datos de la mascota por separado
    public DtoMascota obtenerMascotaPorId(int idMascota) {
        ArrayList<DtoMascota> listaMascotas = gestor.cargarLista(rutaMascotas);
        for (DtoMascota m : listaMascotas) {
            if (m.getId() == idMascota) {
                return m;
            }
        }
        return null;
    }
}


