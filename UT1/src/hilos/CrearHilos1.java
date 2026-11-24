package hilos;

public class CrearHilos1{
    public static void main(String[] args) {
        String[] nums = {"1", "2", "3"};

        for (int i = 0; i < nums.length; i++) {
            Hilo1 h = new Hilo1(nums[i]);
		h.start();
		
		//h.run();
        }
	}
}


