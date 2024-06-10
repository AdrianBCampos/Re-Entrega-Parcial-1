class EnEspera implements EstadoComision{

     @Override
    public void inscribirAlumno(Comision comision, Alumno unAlumno) {
         comision.obtenerListaDeAlumnosInscriptos().add(unAlumno);
         System.out.println(unAlumno.obtenerNombreDelAlumno() + " " + unAlumno.obtenerApellidoDelAlumno() + " se inscribió correctamente.");
         comision.actualizarEstadoComision();

    }

    @Override
    public void enEspera(Comision comision) {
        // No cambia
    }

    @Override
    public void activa(Comision comision) {
        if (comision.obtenerListaDeAlumnosInscriptos().size() >= comision.verCupoMinimo()) {
            comision.cambiarEstadoComision(new Activa());
        }
    }

    @Override
    public void llena(Comision comision) {
        if (comision.obtenerListaDeAlumnosInscriptos().size() == comision.verCupoMaximo()) {
            comision.cambiarEstadoComision(new Llena());
        }
    }

    @Override
    public void comenzar(Comision comision) {
        System.out.println("La comisión no puede comenzar, aún no alcanza el cupo mínimo de alumnos para estar activa.");
    }

    @Override
    public String getNombreEstado() {
        return "En Espera";
    }

}