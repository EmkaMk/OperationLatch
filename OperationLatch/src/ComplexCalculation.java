import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ComplexCalculation implements Callable<Integer> {

	private CountDownLatch latch;

	public ComplexCalculation(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Complex calculation started...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Complex calculation completed.");
		latch.countDown();

		return new Random().nextInt(100 + 1);
	}

}