package pingpong;

public class Consumidor extends Thread{
	private Cola cola;
	private String cadena;
	
	public Consumidor(Cola cola) {
		this.cola = cola;
	}

	public void run () {
		String cadena;
		for (int i = 0; i <= 10; i++) {
			cadena = cola.get();
			System.out.println(cadena);
		}
	}
}