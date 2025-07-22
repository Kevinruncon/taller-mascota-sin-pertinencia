/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.util.ArrayList;
import modelo.Vacuna;

/**
 *
 * @author Kevin
 */
public class DaoVacuna {
    private ArrayList<Vacuna> listaVacunas = new ArrayList<>();
    
    public boolean guardarVacuna(Vacuna vacuna) {
        if (vacuna != null) {
            listaVacunas.add(vacuna);
            return true;
        }
        return false;
    }

    public Vacuna buscarVacuna(Vacuna vacuna) {
        for (Vacuna v : listaVacunas) {
            if (v.getTipo().equals(vacuna.getTipo()) && v.getLote().equals(vacuna.getLote())) {
                return v;
            }
        }
        return null;
    }

    public boolean eliminarVacuna(Vacuna vacuna) {
        for (Vacuna v : listaVacunas) {
            if (v.getTipo().equals(vacuna.getTipo()) && v.getLote().equals(vacuna.getLote())) {
                listaVacunas.remove(v);
                return true;
            }
        }
        return false;
    }

    public boolean editarVacuna(Vacuna vacuna) {
        for (Vacuna v : listaVacunas) {
            if (v.getTipo().equals(vacuna.getTipo()) && v.getLote().equals(vacuna.getLote())) {
                v.setFechaAplicacion(vacuna.getFechaAplicacion());
                v.setProximaDosis(vacuna.getProximaDosis());
                return true;
            }
        }
        return false;
    }

    public ArrayList<Vacuna> obtenerTodas() {
        return new ArrayList<>(listaVacunas);
    }
}
