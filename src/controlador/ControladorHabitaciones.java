/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.HashMap;
import modelo.*;

/**
 *
 * @author Danis
 */
public class ControladorHabitaciones {
    
    private HashMap<Integer, String> asignaciones = new HashMap<>();
    private Hotel hotel;

    public ControladorHabitaciones(Hotel hotel) {
        this.hotel = hotel;
        precargarHabitaciones();
    }

    public Hotel getHotel() {
        return hotel;
    }

    /*
    * Nombre del método: precargarHabitaciones
    * Descripción: Carga 10 habitaciones al iniciar la app
    *              4 Simples (piso 1), 3 Dobles (piso 2), 3 Suites (piso 3)
    */
    private void precargarHabitaciones() {
        // Piso 1 - Simples
        hotel.getLstHabitaciones().add(new Habitacion(101, 1, 80000, true, "Simple"));
        hotel.getLstHabitaciones().add(new Habitacion(102, 1, 80000, true, "Simple"));
        hotel.getLstHabitaciones().add(new Habitacion(103, 1, 80000, true, "Simple"));
        hotel.getLstHabitaciones().add(new Habitacion(104, 1, 80000, true, "Simple"));
        // Piso 2 - Dobles
        hotel.getLstHabitaciones().add(new HabitacionDoble(true,  201, 2, 130000, true, "Doble"));
        hotel.getLstHabitaciones().add(new HabitacionDoble(false, 202, 2, 120000, true, "Doble"));
        hotel.getLstHabitaciones().add(new HabitacionDoble(true,  203, 2, 130000, true, "Doble"));
        // Piso 3 - Suites
        hotel.getLstHabitaciones().add(new HabitacionSuite(true, true,  true,  301, 3, 300000, true, "Suite"));
        hotel.getLstHabitaciones().add(new HabitacionSuite(true, false, true,  302, 3, 250000, true, "Suite"));
        hotel.getLstHabitaciones().add(new HabitacionSuite(true, true,  false, 303, 3, 270000, true, "Suite"));
    }

    /*
    * Nombre del método: buscarHabitacion
    * Descripción: Busca una habitación por número
    */
    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion hab : hotel.getLstHabitaciones()) {
            if (hab.getNumero() == numero) {
                return hab;
            }
        }
        return null;
    }

    /*
    * Nombre del método: actualizarDisponibilidad
    * Descripción: Cambia el estado disponible/ocupada de una habitación
    */
    public boolean asignarHuesped(int numeroHab, String nombreHuesped) {
    Habitacion hab = buscarHabitacion(numeroHab);
    if (hab != null) {
        hab.setDisponible(false);
        asignaciones.put(numeroHab, nombreHuesped);
        return true;
    }
    return false;
}

public boolean liberarHabitacion(int numeroHab) {
    Habitacion hab = buscarHabitacion(numeroHab);
    if (hab != null) {
        hab.setDisponible(true);
        asignaciones.remove(numeroHab);
        return true;
    }
    return false;
}

public HashMap<Integer, String> getAsignaciones() {
    return asignaciones;
}

    /*
    * Nombre del método: getHabitacionesDisponibles
    * Descripción: Retorna solo las habitaciones disponibles para mostrar en el ComboBox
    */
    public java.util.ArrayList<Habitacion> getHabitacionesDisponibles() {
        java.util.ArrayList<Habitacion> disponibles = new java.util.ArrayList<>();
        for (Habitacion hab : hotel.getLstHabitaciones()) {
            if (hab.isDisponible()) {
                disponibles.add(hab);
            }
        }
        return disponibles;
    }
}

