class Activa implements EstadoComision {
    @Override
    public void inscribirAlumno(Comision comision, Alumno unAlumno) {
        comision.obtenerListaDeAlumnosInscriptos().add(unAlumno);
        System.out.println(unAlumno.obtenerNombreDelAlumno() + " " + unAlumno.obtenerApellidoDelAlumno() + " se inscribió correctamente.");
            comision.actualizarEstadoComision();

    }

    @Override
    public void enEspera(Comision comision) {
        if (comision.obtenerListaDeAlumnosInscriptos().size() < comision.verCupoMinimo()) {
            comision.cambiarEstadoComision(new EnEspera());
        }
    }

    @Override
    public void activa(Comision comision) {
        // No cambia
    }

    @Override
    public void llena(Comision comision) {
        if (comision.obtenerListaDeAlumnosInscriptos().size() == comision.verCupoMaximo()) {
            comision.cambiarEstadoComision(new Llena());
        }
    }

    @Override
    public void comenzar(Comision comision) {
        System.out.println("La comisión de la materia " + comision.obtenerNombreMateria() + " de los días " + comision.verDiaCursada(comision) + " está comenzando a cursarse.");
    }

    @Override
    public String getNombreEstado() {
        return "Activa";
    }



}
