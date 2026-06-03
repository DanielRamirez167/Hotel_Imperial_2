/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;


/**
 *
 * @author Danis
 */
public class Huesped extends Persona {
    
    private String nacionalidad;
    private LocalDate fechaNacimiento;

    public Huesped(String nacionalidad, LocalDate fechaNacimiento, String nombre, String apellido, String documento, String email) {
        super(nombre, apellido, documento, email);
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    
    


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    }
   
    
    
    

