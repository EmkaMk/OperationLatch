import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchApplication {



	public static void main(String[] args) throws Exception {

		SynchronizeMaxium sync=new SynchronizeMaxium();
		sync.startComplexCalculation();
		sync.getResultFromComplexCalculation();
		sync.findMax();

	}

}