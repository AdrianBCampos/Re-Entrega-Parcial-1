interface EstadoComision {

    public void inscribirAlumno(Comision unaComision, Alumno unAlumno);
    public void enEspera(Comision unaComision);
    public void activa(Comision unaComision);
    public void llena(Comision unaComision);
    public void comenzar(Comision unaComision);

    String getNombreEstado();


}