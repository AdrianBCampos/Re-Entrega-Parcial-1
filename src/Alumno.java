
class Alumno implements Observer {
    private String legajo;
    private String dni;
    private String email;
    private String nombre;
    private String apellido;
    private boolean esRegular;

    public Alumno(String legajo, String dni, String email, String nombre, String apellido, boolean esRegular) {
        this.legajo = legajo;
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.esRegular = esRegular;
    }




    @Override
    public void update(Comision comisionObservada) {
        String mensaje = "Hola " + this.getNombre() + " " + this.getApellido() + " : Se liberó un cupo en la comisión del día " + comisionObservada.verDiaCursada(comisionObservada) + " correspondence a la materia " + comisionObservada.obtenerNombreMateria()+ " y ahora estás inscripto.";

        //Enviar el mensaje por correo electrónico
        EmailSender emailSender = new EmailSender();
        emailSender.send (this.email, mensaje);

    }

    public void inscribirse(Comision unaComision) {
        try {
            if (esRegular) {
                unaComision.inscribirAlumno(this);
            } else {
                throw ComisionException.alumnoNoRegular(this);
            }
        } catch (ComisionException e) {
                System.out.println(e.getMessage());

            }
    }


    private String getNombre() {
        return nombre;
    }
    public String obtenerNombreDelAlumno(){
        return getNombre();
    }

    private String getApellido() {
        return apellido;
    }
    public String obtenerApellidoDelAlumno(){
        return getApellido();
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre= '" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", legajo='" + legajo + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}