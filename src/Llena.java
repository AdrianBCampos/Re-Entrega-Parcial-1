class Llena implements EstadoComision {
    @Override
    public void inscribirAlumno(Comision comision, Alumno unAlumno) {
        // Verificar si el alumno ya está en la lista de espera
        if (comision.obtenerListaDeAlumnosEnEspera().contains(unAlumno)) {
            System.out.println(unAlumno.obtenerNombreDelAlumno() + " " + unAlumno.obtenerApellidoDelAlumno() + " ya está en la lista de espera.");
        } else {
            comision.obtenerListaDeAlumnosEnEspera().add(unAlumno);

            // Verificar si el alumno ya está en la lista de observadores
            if (!comision.obtenerListaDeObservers().contains(unAlumno)) {
                comision.addObserver(unAlumno);
            }

            System.out.println("La comisión está llena. " + unAlumno.obtenerNombreDelAlumno() + " " + unAlumno.obtenerApellidoDelAlumno() + " será agregado a la lista de espera.");
        }
    }

    @Override
    public void enEspera(Comision comision) {
        if (comision.obtenerListaDeAlumnosInscriptos().size() < comision.verCupoMinimo()) {
            comision.cambiarEstadoComision(new EnEspera());
        }
    }

    @Override
    public void activa(Comision comision) {
        if (comision.obtenerListaDeAlumnosInscriptos().size() >= comision.verCupoMinimo() && comision.obtenerListaDeAlumnosInscriptos().size() < comision.verCupoMaximo()) {
            comision.cambiarEstadoComision(new Activa());
        }
    }

    @Override
    public void llena(Comision comision) {
        // No cambia
    }

    @Override
    public void comenzar(Comision comision) {
        System.out.println("La comisión de la materia " + comision.obtenerNombreMateria() + " de los días " + comision.verDiaCursada(comision) + " está comenzando a cursarse.");
    }

    @Override
    public String getNombreEstado() {
        return "Llena";
    }

}