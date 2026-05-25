
package modelo;

/**
 *
 * @author Danis
 */
public class Empleado extends Persona{
    
    private String salario;

    public Empleado(String salario, String nombre, String apellido, String documento, String email, String telefono) {
        super(nombre, apellido, documento, email, telefono);
        this.salario = salario;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    
    
}
