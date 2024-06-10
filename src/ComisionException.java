public class ComisionException extends RuntimeException {
    public ComisionException(String message) {
        super(message);
    }

    public static ComisionException alumnoNoRegular(Alumno alumno) {
        return new ComisionException(alumno.obtenerNombreDelAlumno() + " " + alumno.obtenerApellidoDelAlumno() + " no puede inscribirse porque no es regular.");
    }

    public static ComisionException alumnoYaInscripto(Alumno alumno) {
        return new ComisionException(alumno.obtenerNombreDelAlumno() + " " + alumno.obtenerApellidoDelAlumno() + " ya está inscrito en la comisión.");
    }

    public static ComisionException alumnoNoInscripto(Alumno alumno) {
        return new ComisionException(alumno.obtenerNombreDelAlumno() + " " + alumno.obtenerApellidoDelAlumno() + " no se encuentra inscrito en la comisión.");
    }
}