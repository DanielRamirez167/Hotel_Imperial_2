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
    
    private Huesped huespedes;
    private Hotel hotel;

    public ControladorHuespedes() {

        hotel = new Hotel("123456","Hotel Imperial 2",new ArrayList<>());
    }
    
   
    

    public ControladorHuespedes(Huesped huesped) {
        this.huespedes = huesped;
    }

    public Huesped getHuesped() {
        return huespedes;
    }

    public void setHuesped(Huesped huesped) {
        this.huespedes= huesped;
    }
    
    
    
    /*
    * Nombre del método: CrearCliente
    * Parámetros recibidos: Documento, Nombre, Correo, Fecha Nacimiento
    * Tipo de retorno: Cliente
    * Descripción: Crear un nuevo cliente
    */
    public Huesped crearHuesped(String documento, String nombre,String apellido, String email, String nacionalidad, int diaNacimiento, int mesNacimiento, int anioNacimiento) {
        
        if (buscarHuesped(documento) == null) {
            try {
                LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);

                Huesped huesped = new Huesped(nacionalidad, fechaNacimiento, nombre, apellido, documento, email);
                hotel.getLstHuespedes().add(huesped);
                
                return huesped;
            } catch (Exception ex) {
                System.out.println("error al crear Huesped: " + ex.getMessage());
                return null;
            } 
        } else {
            System.out.println("El Huesped ya existe: " + documento);
            return null;
        }
    }

    
    
    
     /*
    * Nombre del método: BuscarCliente
    * Parámetros recibidos: Documento
    * Tipo de retorno: Cliente
    * Descripción: Buscar un cliente
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
    * Nombre del método: BorrarCliente
    * Parámetros recibidos: Documento
    * Tipo de retorno: boolean
    * Descripción: Borrar un cliente
    */
    public boolean borrarHuesped(String documento) {
        try {
            Huesped huesped = (Huesped) buscarHuesped(documento);
        
            if (huesped == null) {
                return false;
            }

           hotel.getLstHuespedes().remove(huesped);
            return true;
        } catch (Exception ex) {
            System.out.println("Error al borrar Huesped: " + ex.getMessage());
            return false;
        }
    }
    
}
