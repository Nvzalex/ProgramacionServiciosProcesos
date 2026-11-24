package examen;

public class Alumno extends Thread {
	

	public static String[] alumnos = { "Alumno1", "Alumno2", "Alumno3", "Alumno4", "Alumno5", "Alumno6", "Alumno7",
			"Alumno8", "Alumno9", "Alumno0" };

	public void run() {
		long tiempo = (long) (Math.random() * 5) + 1;

		for (int i = 0; i <= alumnos.length; i++) {

			System.out.println(alumnos[i] + " inicia su examen");
		}
	}
}
