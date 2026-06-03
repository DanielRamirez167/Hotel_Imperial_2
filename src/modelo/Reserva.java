/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Danis
 */
public class Reserva {
    
    
    private static int contadorReservas = 1;

    private int numeroReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private double costoTotal;

    public Reserva(Huesped huesped, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.numeroReserva = contadorReservas++;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.costoTotal = calcularCosto();
    }

    private double calcularCosto() {
        long noches = ChronoUnit.DAYS.between(fechaIngreso, fechaSalida);
        if (noches <= 0) return 0;
        return noches * habitacion.getPrecioPorNoche();
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        this.costoTotal = calcularCosto();
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
        this.costoTotal = calcularCosto();
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    /**
     * Devuelve un resumen legible para el comprobante.
     */
    public String generarComprobante() {
        long noches = ChronoUnit.DAYS.between(fechaIngreso, fechaSalida);
        return "===== COMPROBANTE DE RESERVA =====\n"
             + "N° Reserva   : " + numeroReserva + "\n"
             + "Huésped      : " + huesped.getNombre() + " " + huesped.getApellido() + "\n"
             + "Documento    : " + huesped.getDocumento() + "\n"
             + "Habitación   : " + habitacion.getNumero() + " (" + habitacion.getTipo() + ")\n"
             + "Piso         : " + habitacion.getPiso() + "\n"
             + "Fecha ingreso: " + fechaIngreso + "\n"
             + "Fecha salida : " + fechaSalida + "\n"
             + "Noches       : " + noches + "\n"
             + "Precio/noche : $" + habitacion.getPrecioPorNoche() + "\n"
             + "COSTO TOTAL  : $" + costoTotal + "\n"
             + "==================================";
    }
}

    

