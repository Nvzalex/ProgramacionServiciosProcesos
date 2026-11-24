package examen;

public class Examen extends Thread {


	public void run() {
		long tiempo1 = (long) (Math.random() * 5) + 1;
		long tiempo2 = (long) (Math.random() * 2) + 1;

		try {
			
			for (int i = 0; i < 5; i++) {
				for (int i1 = 0; i1 <= Alumno.alumnos.length; i1++) {
					Thread.sleep(tiempo1);
					System.out.println(Alumno.alumnos[i1] + " finaliza su examen!!");
					Thread.sleep(tiempo2);
					System.out.println("Examen de "+Alumno.alumnos[i1] + " recogido y validado");
					if (i1 == Alumno.alumnos.length) {
						System.out.println("Proceso finalizado");
					}
				}
				
			}
			
		} catch (InterruptedException e) {

		}
	}
}
