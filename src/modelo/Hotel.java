package modelo;

import java.util.ArrayList;

public class Hotel {

    private String nit;
    private String nombre;
    private ArrayList<Huesped> lstHuespedes;

    public Hotel(String nit,
             String nombre,
             ArrayList<Huesped> lstHuespedes) {

    this.nit = nit;
    this.nombre = nombre;
    this.lstHuespedes = lstHuespedes;
    }

    public ArrayList<Huesped> getLstHuespedes() {
        return lstHuespedes;
    }

    public void setLstHuespedes(ArrayList<Huesped> lstHuespedes) {
        this.lstHuespedes = lstHuespedes;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
    


    
    

    

    

   
