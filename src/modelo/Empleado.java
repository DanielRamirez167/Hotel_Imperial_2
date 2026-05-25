
package modelo;

/**
 *
 * @author Danis
 */
public class Empleado extends Persona{
    
    private String salario;

    public Empleado(String salario, String nombre, String apellido, String documento, String email) {
        super(nombre, apellido, documento, email);
        this.salario = salario;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    
    
}
