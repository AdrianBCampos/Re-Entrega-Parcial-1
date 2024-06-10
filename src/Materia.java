import java.util.ArrayList;
import java.util.List;

class Materia {
    private Profesor profesor;
    private String nombreMateria;
    private List<Comision> comisiones;

    public Materia(Profesor profesor, String nombreMateria) {
        this.profesor = profesor;
        this.nombreMateria = nombreMateria;
        this.comisiones = new ArrayList<>();
    }

    public void agregarComision(Comision unaComision) {
        comisiones.add(unaComision);
    }

    private String getNombreMateria() {
        return nombreMateria;
    }

    public String nombreDeLaMateria(Materia unaMateria){
        return unaMateria.getNombreMateria();

    }


    public List<String> verComisionesDeLaMateria() {
        List<String> comisionesDeLaMateria = new ArrayList<>();
        for (Comision comision : comisiones) {
            comisionesDeLaMateria.add(comision.obtenerNombreDeLaComision());
        }
        return comisionesDeLaMateria;
    }
    @Override
    public String toString() {
        return "Materia: " + nombreMateria + ", Profesor: " + profesor.obtenerNombreDelProfesor() + " " + profesor.obtenerApellidoDelProfesor();
    }
}