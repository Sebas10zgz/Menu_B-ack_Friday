import java.security.InvalidParameterException;

public class Productos {
    private int id;
    private String nombre;
    private double precio;

    public String toString() {

        return "\nID: " +this.id+
                "\nNombre: " +this.nombre+
                "\nPrecio: " +this.precio+
                "\n===========";
    }

    public Productos(int id, String nombre, double precio){
        this.setId(id);
        this.setNombre(nombre);
        this.setPrecio(precio);
    }
    public Productos(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
