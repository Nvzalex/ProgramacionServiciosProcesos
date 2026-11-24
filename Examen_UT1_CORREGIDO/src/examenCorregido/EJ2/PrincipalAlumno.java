package examenCorregido.EJ2;

public class PrincipalAlumno {
    public static void main(String[] args) {
        Cola cola = new Cola();

        Examen profesor = new Examen(cola, Alumno.nombres.length);
        profesor.start();

        for (String nombre : Alumno.nombres) {
            Alumno alumno = new Alumno(nombre, cola);
            alumno.start();
        }
    }
}