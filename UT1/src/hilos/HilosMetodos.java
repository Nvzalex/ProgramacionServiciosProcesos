package hilos;

public class HilosMetodos extends Thread {
	public static void main(String[] args) {
        String[] nums = {"1", "2", "3"};

        for (int i = 0; i < nums.length; i++) {
        	HilosMetodos h = new HilosMetodos(nums[i]);
		h.start();
		
		//h.run();
        }
	}
	private int max = 5;
	public HilosMetodos (String h) {
		this.setName(h);
		System.out.println("Hilo ejecutándose: " + this.getName());
	}
	
	public void run() {
		for (int count = 0; count <= max; count++) {	
			System.out.println("Información del HILO " + this.getName() + ": PRIORITY " + this.getPriority() + ", ID " + this.threadId() + ", " + Thread.currentThread());
		}
	}
}
