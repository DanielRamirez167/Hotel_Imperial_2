/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Danis
 */
public class HabitacionDoble extends Habitacion {
    
    private boolean conDesayuno;

    public HabitacionDoble(boolean conDesayuno, int numero, int piso, double precioPorNoche, boolean disponible, String tipo) {
        super(numero, piso, precioPorNoche, disponible, tipo);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }
    
    
}
