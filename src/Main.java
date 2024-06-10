import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear un profesor y una materia
        Profesor profesor = new Profesor("Juan", "Pérez");
        Materia materia01 = new Materia(profesor, "Programación");

        // Crear una comisión con cupo mínimo 1 y cupo máximo 3
        Comision comision01 = new Comision("Comision01",materia01, 3, 2, "Lunes");
        Comision comision02 = new Comision("Comision02",materia01, 5, 2, "Miercoles");

        // Agregar la comision a la materia
        materia01.agregarComision(comision01);
        materia01.agregarComision(comision02);
        System.out.println("Comisiones que conforman la materia " + materia01.nombreDeLaMateria(materia01)+" : " + materia01.verComisionesDeLaMateria());

        // Crear 4 alumnos
        Alumno alumno1 = new Alumno("111", "28546987", "Adrian_alumno1@gmail.com", "Adrian", "López", true);
        Alumno alumno2 = new Alumno("112", "29521001", "Pedro_alumno2@gmail.com", "Pedro", "Martínez", true);
        Alumno alumno3 = new Alumno("113", "27589990", "Natacha_alumno3@gmail.com", "Natacha", "González", true);
        Alumno alumno4 = new Alumno("114", "30004788", "Pablo_alumno4@gmail.com", "Pablo", "Roldan", true);
        Alumno alumno5 = new Alumno("115", "28029614", "Fernanda_alumno5@gmail.com", "Fernanda", "Barroetaveña", false);

        System.out.println("\nEstado de la comision: " + comision01.verEstadoComision() + ".\n");

        // Inscribir a los alumnos en la comisión
        alumno1.inscribirse(comision01);

        System.out.println("\nEstado de la comision: " + comision01.verEstadoComision() + ".\n");

        alumno2.inscribirse(comision01);

        System.out.println("\nEstado de la comision: " + comision01.verEstadoComision() + ".\n");

        alumno2.inscribirse(comision01);

        System.out.println("\nEstado de la comision: " + comision01.verEstadoComision() + ".\n");

        alumno3.inscribirse(comision01);

        System.out.println("\nEstado de la comision: " + comision01.verEstadoComision() + ".\n");

        alumno4.inscribirse(comision01);

        System.out.println("\nEstado de la comision: " + comision01.verEstadoComision() + ".\n");

        alumno5.inscribirse(comision01);

        System.out.println("\nEstado de la comision: " + comision01.verEstadoComision() + ".\n");

        // Mostrar el estado de la comisión
        System.out.println("Listados de la comisión después de las inscripciones:");

        // Imprimir la lista de alumnos inscriptos
        System.out.println("\nLista de alumnos inscriptos en la "+ comision01.obtenerNombreDeLaComision() + " de la materia " + comision01.obtenerNombreMateria() + " :");
        if (comision01.obtenerListaDeAlumnosInscriptos().isEmpty()) {
            System.out.println("La lista de alumnos inscriptos está vacía.");
        } else {
            for (Alumno alumno : comision01.obtenerListaDeAlumnosInscriptos()) {
                System.out.println(alumno);
            }
        }

        // Imprimir la lista de alumnos en espera
        System.out.println("\nLista de alumnos en espera de la " + comision01.obtenerNombreDeLaComision() + " de la materia " + comision01.obtenerNombreMateria() + " :");
        if (comision01.obtenerListaDeAlumnosEnEspera().isEmpty()) {
            System.out.println("La lista de alumnos en espera está vacía.");
        } else {
            for (Alumno alumno : comision01.obtenerListaDeAlumnosEnEspera()) {
                System.out.println(alumno);
            }
        }

        System.out.println("\nEstado de la comision: " + comision01.verEstadoComision() + ".\n");


        // Dar de baja a un alumno
        System.out.println("\nCancelando inscripción del alumno 2...");
        comision01.cancelarInscripcionAlumno(alumno2);

        // Mostrar el estado de la comisión después de la baja
        System.out.println("\nListados de la comisión después de la baja:");

        // Imprimir la lista de alumnos inscriptos
        System.out.println("\nLista de alumnos inscriptos en la "+ comision01.obtenerNombreDeLaComision() + " de la materia " + comision01.obtenerNombreMateria() + " :");
        if (comision01.obtenerListaDeAlumnosInscriptos().isEmpty()) {
            System.out.println("La lista de alumnos inscriptos está vacía.");
        } else {
            for (Alumno alumno : comision01.obtenerListaDeAlumnosInscriptos()) {
                System.out.println(alumno);
            }
        }

        // Imprimir la lista de alumnos en espera
        System.out.println("\nLista de alumnos en espera de la " + comision01.obtenerNombreDeLaComision() + " de la materia " + comision01.obtenerNombreMateria() + " :");
        if (comision01.obtenerListaDeAlumnosEnEspera().isEmpty()) {
            System.out.println("La lista de alumnos en espera está vacía.");
        } else {
            for (Alumno alumno : comision01.obtenerListaDeAlumnosEnEspera()) {
                System.out.println(alumno);
            }
        }

        System.out.println ("\nEstado de la comision: " + comision01.verEstadoComision()+". \n");

        // Verificar si la comisión puede comenzar
        comision01.comenzar();

        // Imprimir la lista de alumnos inscriptos
        System.out.println("\nLista de alumnos inscriptos en la "+ comision01.obtenerNombreDeLaComision() + " de la materia " + comision01.obtenerNombreMateria() + " :");
        if (comision01.obtenerListaDeAlumnosInscriptos().isEmpty()) {
            System.out.println("La lista de alumnos inscriptos está vacía.");
        } else {
            for (Alumno alumno : comision01.obtenerListaDeAlumnosInscriptos()) {
                System.out.println(alumno);
            }
        }

        // Imprimir la lista de alumnos en espera
        System.out.println("\nLista de alumnos en espera de la " + comision01.obtenerNombreDeLaComision() + " de la materia " + comision01.obtenerNombreMateria() + " :");
        if (comision01.obtenerListaDeAlumnosEnEspera().isEmpty()) {
            System.out.println("La lista de alumnos en espera está vacía.");
        } else {
            for (Alumno alumno : comision01.obtenerListaDeAlumnosEnEspera()) {
                System.out.println(alumno);
            }
        }

        // Obtener la lista de observadores de comision1
        List<Observer> observadores = comision01.obtenerListaDeObservers();

        // Imprimir la lista de observadores
        System.out.println("\nLista de observadores:");
        if (observadores.isEmpty()) {
            System.out.println("La lista de observadores está vacía.");
        } else {
            for (Observer observador : observadores) {
                System.out.println(observador);
            }
        }

    }
}