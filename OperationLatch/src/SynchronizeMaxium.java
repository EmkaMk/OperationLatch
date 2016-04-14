import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SynchronizeMaxium {
	
	private static final int NUMBER_OF_CALCULATIONS = 10;
	private final CountDownLatch latch;
	private final ExecutorService service;
	private List<Future<Integer>> futures;
	ArrayList<Integer> results;
	
	public SynchronizeMaxium() {
		super();
		latch = new CountDownLatch(5);
		 service = Executors.newCachedThreadPool();
		 futures = new ArrayList<Future<Integer>>(10);
		results = new ArrayList<>();
	}
	
	public void startComplexCalculation()
	{
		for (int i = 0; i < NUMBER_OF_CALCULATIONS; i++) {
			futures.add(service.submit(new ComplexCalculation(latch)));

		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getResultFromComplexCalculation()
	{
		for (int i = 0; i < futures.size(); i++) {
			int result=0;
			try {
				result = futures.get(i).get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			results.add(result);
		}
	}
	
	public void findMax()
	
	{
		Collections.sort(results);
		System.out.println("Max value is : " + results.get(results.size() - 1));

		service.shutdownNow();
	}
	
	

}
