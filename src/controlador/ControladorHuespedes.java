/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author Danis
 */
public class ControladorHuespedes {

    private Hotel hotel;

    public ControladorHuespedes() {
        hotel = new Hotel("123456", "Hotel Imperial 2", new ArrayList<>());
    }

    public Hotel getHotel() {
        return hotel;
    }

    /*
    * Nombre del método: crearHuesped
    * Parámetros recibidos: documento, nombre, apellido, email, nacionalidad, dia, mes, anio
    * Tipo de retorno: Huesped
    * Descripción: Registrar un nuevo huésped
    */
    public Huesped crearHuesped(String documento, String nombre, String apellido,
            String email, String nacionalidad,
            int diaNacimiento, int mesNacimiento, int anioNacimiento) {

        if (buscarHuesped(documento) == null) {
            try {
                LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
                Huesped huesped = new Huesped(nacionalidad, fechaNacimiento, nombre, apellido, documento, email);
                hotel.getLstHuespedes().add(huesped);
                return huesped;
            } catch (Exception ex) {
                System.out.println("Error al crear huésped: " + ex.getMessage());
                return null;
            }
        } else {
            System.out.println("El huésped ya existe: " + documento);
            return null;
        }
    }

    /*
    * Nombre del método: buscarHuesped
    * Parámetros recibidos: documento
    * Tipo de retorno: Huesped
    * Descripción: Buscar un huésped por documento
    */
    public Huesped buscarHuesped(String documento) {
        for (Huesped huesped : hotel.getLstHuespedes()) {
            if (huesped.getDocumento().equals(documento)) {
                return huesped;
            }
        }
        return null;
    }

    /*
    * Nombre del método: actualizarHuesped
    * Parámetros recibidos: documento, nombre, apellido, email, nacionalidad, dia, mes, anio
    * Tipo de retorno: boolean
    * Descripción: Actualizar la información de un huésped existente
    */
    public boolean actualizarHuesped(String documento, String nombre, String apellido,
            String email, String nacionalidad,
            int diaNacimiento, int mesNacimiento, int anioNacimiento) {

        Huesped huesped = buscarHuesped(documento);

        if (huesped != null) {
            try {
                LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
                huesped.setNombre(nombre);
                huesped.setApellido(apellido);
                huesped.setEmail(email);
                huesped.setNacionalidad(nacionalidad);
                huesped.setFechaNacimiento(fechaNacimiento);
                return true;
            } catch (Exception ex) {
                System.out.println("Error al actualizar huésped: " + ex.getMessage());
                return false;
            }
        } else {
            System.out.println("El huésped no existe: " + documento);
            return false;
        }
    }

    /*
    * Nombre del método: borrarHuesped
    * Parámetros recibidos: documento
    * Tipo de retorno: boolean
    * Descripción: Eliminar un huésped por documento
    */
    public boolean borrarHuesped(String documento) {
        try {
            Huesped huesped = buscarHuesped(documento);

            if (huesped == null) {
                return false;
            }

            hotel.getLstHuespedes().remove(huesped);
            return true;
        } catch (Exception ex) {
            System.out.println("Error al borrar huésped: " + ex.getMessage());
            return false;
        }
    }
}