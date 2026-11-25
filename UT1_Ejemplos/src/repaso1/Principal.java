package repaso1;

public class Principal {

	public static void main(String[] args) {
		Cola cola = new Cola();
		
		Productor p = new Productor(cola, 1, 10);
		Consumidor c = new Consumidor(cola, 1, 10);
		
		p.start();
		c.start();

	}

}

