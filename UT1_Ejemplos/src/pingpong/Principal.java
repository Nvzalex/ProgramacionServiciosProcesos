package pingpong;

public class Principal {
	public static void main(String[] args) {
		int totalMensajes = 10;
		Cola cola = new Cola();

		Productor p = new Productor(cola, totalMensajes);
		Consumidor c = new Consumidor(cola, totalMensajes);

		p.start();
		c.start();
	}
}