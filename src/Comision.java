import java.util.List;
import java.util.ArrayList;

class Comision extends Observable {

    private String nombreComision;
    private Materia materia;
    private int cupoMax;
    private int cupoMin;
    private List<Alumno> alumnosInscriptos;
    private List<Alumno> alumnosEnEspera;
    private String diaDeClase;
    private EstadoComision estadoComision;


    public Comision(String nombreComision, Materia materia, int cupoMax, int cupoMin, String diaDeClase) {
        this.nombreComision = nombreComision;
        this.materia = materia;
        this.cupoMax = cupoMax;
        this.cupoMin = cupoMin;
        this.alumnosInscriptos = new ArrayList<Alumno>();
        this.alumnosEnEspera = new ArrayList<Alumno>();
        this.diaDeClase = diaDeClase;
        this.estadoComision = new EnEspera(); // Estado Inicial

    }


    private int getCupoMax() {
        return cupoMax;
    }

    public int verCupoMaximo() {
        return getCupoMax();
    }


    private int getCupoMin() {
        return cupoMin;
    }

    public int verCupoMinimo() {
        return getCupoMin();
    }


    private List<Alumno> getAlumnosInscriptos() {
        return alumnosInscriptos;
    }

    public List<Alumno> obtenerListaDeAlumnosInscriptos() {
        return this.getAlumnosInscriptos();
    }


    private List<Alumno> getAlumnosEnEspera() {
        return alumnosEnEspera;
    }

    public List<Alumno> obtenerListaDeAlumnosEnEspera() {
        return this.getAlumnosEnEspera();
    }

    /*private EstadoComision getEstadoComision() {
        return estadoComision;
    }

    public EstadoComision obtenerEstadoComision() {
        return this.getEstadoComision();
    }*/

    public String verEstadoComision() {
        return estadoComision.getNombreEstado();
    }



    /*private void setEstadoComision(EstadoComision estadoComision) {
        this.estadoComision = estadoComision;
    }*/

    public void cambiarEstadoComision(EstadoComision nuevoEstado) {
        this.estadoComision = nuevoEstado;
    }


    /*public void enEspera(Comision comision) {
        this.estadoComision.enEspera(this);
    }

    public void Activa(Comision comision) {
        this.estadoComision.activa(this);
    }

    public void Llena(Comision comision) {
        this.estadoComision.llena(this);
    }*/


    private boolean estaInscripto(Alumno unAlumno) {
        return alumnosInscriptos.contains(unAlumno);
    }


    public void inscribirAlumno(Alumno unAlumno) {
        try {
            // Verificar si el alumno ya está inscrito
            if (estaInscripto(unAlumno)) {
                throw ComisionException.alumnoYaInscripto(unAlumno);
            } else {
                estadoComision.inscribirAlumno(this, unAlumno);
            }
        } catch (ComisionException e) {
            System.out.println(e.getMessage());
        }
    }



    /*public void cancelarInscripcionAlumno(Alumno unAlumno) {
        try {
            if (alumnosInscriptos.remove(unAlumno)) {
                System.out.println("Se canceló correctamente la inscripción de " + unAlumno.getNombre() + " " + unAlumno.getApellido());

                // Actualizar el estado de la comisión basado en el nuevo tamaño de la lista de inscritos
                if (alumnosInscriptos.size() < cupoMin) {
                    setEstadoComision(new EnEspera());
                } else if (alumnosInscriptos.size() < cupoMax) {
                    setEstadoComision(new Activa());
                }

                // Si hay alumnos en espera, inscribir al primero de la lista
                if (!alumnosEnEspera.isEmpty()) {
                    Alumno alumnoEnEspera = alumnosEnEspera.remove(0); // Eliminar el primer alumno de la lista de espera
                    inscribirAlumno(alumnoEnEspera); // Intentar inscribir al alumno de la lista de espera
                    notifyObservers(this); // Notificar al primer observador
                }

            } else {
                throw ComisionException.alumnoNoInscripto(unAlumno);
            }
        } catch (ComisionException e) {
            System.out.println(e.getMessage());
        }
    }*/
    //////////////////////////////////////////////////////////////////

    public void cancelarInscripcionAlumno(Alumno unAlumno) {
    try {
        if (alumnosInscriptos.remove(unAlumno)) {
            procesarCancelacion(unAlumno);


        } else {
            throw ComisionException.alumnoNoInscripto(unAlumno);
        }
    } catch (ComisionException e) {
        System.out.println(e.getMessage());
    }
}

    private void procesarCancelacion(Alumno unAlumno) {
        System.out.println("Se canceló correctamente la inscripción de " + unAlumno.obtenerNombreDelAlumno() + " " + unAlumno.obtenerApellidoDelAlumno());
        actualizarEstadoComision();
        inscribirAlumnoEnEspera();
    }

    protected void actualizarEstadoComision() {
        estadoComision.enEspera(this);
        estadoComision.activa(this);
        estadoComision.llena(this);
    }

    private void inscribirAlumnoEnEspera() {
        if (!alumnosEnEspera.isEmpty()) {
            Alumno alumnoEnEspera = alumnosEnEspera.remove(0);
            inscribirAlumno(alumnoEnEspera);
            notifyObservers(this);
            // Remover el observador cuando se cancela la inscripción
            removeObserver(alumnoEnEspera);

        }
    }

    //////////////////////////////////////////////////////////////////////////////




    public void comenzar() {
        estadoComision.comenzar(this);
    }

    /*public List<Alumno> listaDeInscriptos() {
        return new ArrayList<>(alumnosInscriptos);
    }

    public List<Alumno> listaDeEspera() {
        return new ArrayList<>(alumnosEnEspera);
    }*/



    @Override
    public void notifyObservers(Comision comisionObservada) {
        super.notifyObservers(comisionObservada); // Llamar al método de la clase padre
    }

    private Materia getMateria() {
        return materia;
    }

    public String obtenerNombreMateria() {
        Materia materia = this.getMateria();
        return materia.nombreDeLaMateria(materia);
    }

    private String getDiaDeClase() {
        return diaDeClase;
    }

    public String verDiaCursada(Comision unaComision){
        return unaComision.getDiaDeClase();
    }

    private String getNombreComision() {
        return nombreComision;
    }

    public String obtenerNombreDeLaComision(){
        return getNombreComision();
    }

    @Override
    public String toString() {
        return "Comision de " + this.obtenerNombreMateria() + " los días " + diaDeClase;
    }

}
