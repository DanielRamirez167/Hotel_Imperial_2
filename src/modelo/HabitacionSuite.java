/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Danis
 */
public class HabitacionSuite extends Habitacion {
    
    private boolean conDesayuno;
    private boolean conJacuzzi;
    private boolean conBalcon;

    public HabitacionSuite(boolean conDesayuno, boolean conJacuzzi, boolean conBalcon, int numero, int piso, double precioPorNoche, boolean disponible, String tipo) {
        super(numero, piso, precioPorNoche, disponible, tipo);
        this.conDesayuno = conDesayuno;
        this.conJacuzzi = conJacuzzi;
        this.conBalcon = conBalcon;
    }

    public boolean isConBalcon() {
        return conBalcon;
    }

    public void setConBalcon(boolean conBalcon) {
        this.conBalcon = conBalcon;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    public boolean isConJacuzzi() {
        return conJacuzzi;
    }

    public void setConJacuzzi(boolean conJacuzzi) {
        this.conJacuzzi = conJacuzzi;
    }
    
    
    
}
