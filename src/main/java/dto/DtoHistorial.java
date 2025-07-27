/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.Consulta;

/**
 *
 * @author Kevin
 */
public class DtoHistorial implements Serializable {
    private ArrayList<Consulta> consultas;

    public DtoHistorial() {
        this.consultas = new ArrayList<>();
    }

    public void agregarConsulta(Consulta consulta) {
        if (consulta != null) {
            consultas.add(consulta);
        }
    }

    /*public void mostrarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Sin consultas registradas.");
        } else {
            for (Consulta c : consultas) {
                c.mostrarConsulta();
                System.out.println("--------------------------");
            }
        }
    }*/

    public ArrayList<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }
}

