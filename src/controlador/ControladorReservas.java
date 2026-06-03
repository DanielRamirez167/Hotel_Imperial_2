
package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author Danis
 */
public class ControladorReservas {
    private Hotel hotel;
    private ControladorHabitaciones ctrHabitaciones;
    private ArrayList<Reserva> lstReservas;

    public ControladorReservas(Hotel hotel, ControladorHabitaciones ctrHabitaciones) {
        this.hotel = hotel;
        this.ctrHabitaciones = ctrHabitaciones;
        this.lstReservas = new ArrayList<>();
    }

    
    public Reserva crearReserva(String documentoHuesped, int numeroHabitacion,
                                LocalDate fechaIngreso, LocalDate fechaSalida) {

        if (fechaIngreso == null || fechaSalida == null || !fechaSalida.isAfter(fechaIngreso)) {
            return null;
        }

        Huesped huesped = buscarHuesped(documentoHuesped);
        if (huesped == null) return null;

        Habitacion habitacion = ctrHabitaciones.buscarHabitacion(numeroHabitacion);
        if (habitacion == null || !habitacion.isDisponible()) return null;

        Reserva reserva = new Reserva(huesped, habitacion, fechaIngreso, fechaSalida);
        lstReservas.add(reserva);

        // Usa el controlador de habitaciones para marcarla ocupada y registrar la asignación
        ctrHabitaciones.asignarHuesped(numeroHabitacion,
                huesped.getNombre() + " " + huesped.getApellido());

        return reserva;
    }

    
    public Reserva buscarReserva(int numeroReserva) {
        for (Reserva r : lstReservas) {
            if (r.getNumeroReserva() == numeroReserva) {
                return r;
            }
        }
        return null;
    }

    
    public boolean cancelarReserva(int numeroReserva) {
        Reserva reserva = buscarReserva(numeroReserva);
        if (reserva == null) return false;

        ctrHabitaciones.liberarHabitacion(reserva.getHabitacion().getNumero());
        lstReservas.remove(reserva);
        return true;
    }

    
    public ArrayList<Habitacion> getHabitacionesDisponibles() {
        return ctrHabitaciones.getHabitacionesDisponibles();
    }

    public ArrayList<Reserva> getLstReservas() {
        return lstReservas;
    }

    // ── Helper privado ────────────────────────────────────────────────────────

    private Huesped buscarHuesped(String documento) {
        for (Huesped h : hotel.getLstHuespedes()) {
            if (h.getDocumento().equals(documento)) {
                return h;
            }
        }
        return null;
    }
}
