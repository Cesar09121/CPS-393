package lab16;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
	// Vector a of size n
		public static int[] nInteger(int n, Random r) {
			int[]a=new int[n];
			for(int i=0;i<n;i++) {
				a[i]=r.nextInt(10)+1;
			}
			return a;
		}
		// n separate n-dimensional array, each of size n
		public static int[][] nDimensionalInteger(int n,Random r){
			int[][]b= new int[n][n];
			for(int j =0;j<n;j++) {
				for(int i=0;i<n;i++) {
					b[j][i]=r.nextInt(10)+1;			}
			}
			return b;
		}
		
		// a. Sequential nested loop (each j, compute sum of a[i] * b[j][i])
		public static long[] sequential(int[] a,int[][]b) {
			int n = a.length;
			long[]results=new long[n];
			
			for(int j =0;j<n;j++) {
				long sum=0;
				for(int i =0;i<n;i++) {
					sum+=(long)a[i]*b[j][i];
				}
				results[j] =sum; 
			}
			return results;
			
		}
		
		// b. Thread pool
		public static long[]parallel(int[]a,int[][]b)throws Exception{
			int n = a.length;
			int cores = Runtime.getRuntime().availableProcessors();
			ExecutorService pool = Executors.newFixedThreadPool(cores);
			 int chunkSize = (int) Math.ceil((double) n / cores);
			
			@SuppressWarnings("unchecked")
			Future<long[]>[] futures = new Future[cores];
			
			for (int c = 0; c < cores; c++) {
		        final int start = c * chunkSize;
		        final int end = Math.min(start + chunkSize, n); // don't go past n

		        futures[c] = pool.submit(() -> {
		            long[] partialResults = new long[end - start];
		            for (int j = start; j < end; j++) {
		                long sum = 0;
		                for (int i = 0; i < a.length; i++) {
		                    sum += (long) a[i] * b[j][i];
		                }
		                partialResults[j - start] = sum;
		            }
		            return partialResults;
		        });
		    }

		    // Reassemble results from each chunk
		    long[] results = new long[n];
		    for (int c = 0; c < cores; c++) {
		        long[] partial = futures[c].get();
		        int start = c * chunkSize;
		        for (int k = 0; k < partial.length; k++) {
		            results[start + k] = partial[k];
		        }
		    }

		    pool.shutdown();
		    return results;
		}
		
		// c. Timing
		public static void benchmark(int n)throws Exception{
			Random ran = new Random(42);
			int[]a = nInteger(n,ran);
			int[][]b = nDimensionalInteger(n,ran);
			
			sequential(a,b);
			parallel(a,b);
			
			long start = System.nanoTime();
			sequential(a, b);
			long seqTime = System.nanoTime() - start;
			
			
			start = System.nanoTime();
			parallel(a, b);
			long parTime = System.nanoTime() -start;
			
			System.out.printf("n=%-6d | Sequential: %8.2f ms | Parallel: %8.2f ms | Speedup: %.2fx%n", n, seqTime / 1e6, parTime / 1e6, (double) seqTime / parTime);
		}
	public static void main(String[] args) throws Exception {
		// Question 1
		System.out.println("Try Three Times");
		DoNotGiveUp<String> t1 = new TryThreeTimes();
		System.out.println("Result: "+t1.execute());
		
		System.out.println("Try Forever");
		DoNotGiveUp<String> t2 = new TryForEver();
		System.out.println("Result: "+t2.execute());
		
		
		// Question 2
		System.out.println("Question 2");
		int[]a= {1,2,3};
		int[][]b= {{4,5,6},{7,8,9},{1,2,3}};
		
		long[]results= sequential(a,b);
		for(int j=0;j<results.length;j++) {
			System.out.println("j=" + (j+1) + ": sum(a[i] * b^" + (j+1) + "[i]) = " + results[j]);
		}
		
		// Benchmark Test
		System.out.println("Benchmarks");
        System.out.println("Cores available: " + Runtime.getRuntime().availableProcessors());
        System.out.println();
        benchmark(1000);
        benchmark(5000);
        benchmark(10000);
		

	}

}
