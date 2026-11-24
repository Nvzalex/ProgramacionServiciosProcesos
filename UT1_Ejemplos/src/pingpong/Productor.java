package pingpong;

public class Productor extends Thread{
	private Cola cola;
	private String[] cadena = {" Ping ", " Pong "};
	
	public Productor(Cola cola) {
		this.cola = cola;
	}

	public void run () {

		System.out.println(cadena[0]);
		for (int i = 1; i <= 11; i++) {
			
			if (i % 2 == 0) {
				cola.put(cadena[0]);
				System.out.println("Productor a hecho " + cadena[0]);
			} else {
				cola.put(cadena[1]);
				System.out.println("Productor a hecho " + cadena[1]);
			}
			
		}
		
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}