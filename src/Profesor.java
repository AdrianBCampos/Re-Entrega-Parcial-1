public class Profesor {

    private String nombre;
    private String apellido;

    public Profesor(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    private String getNombre() {
        return nombre;
    }
    public String obtenerNombreDelProfesor(){
        return getNombre();
    }

    private String getApellido() {
        return apellido;
    }
    public String obtenerApellidoDelProfesor(){
        return getApellido();
    }


}
