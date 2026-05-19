import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Set;


public class MatrixMultiplication {
    
    // Di dalam method run() dalam runnable WAJIB panggil ThreadTracker.mark();
    // Misal :
    // new Thread(() -> {
    //     ThreadTracker.mark(); <- tambahkan ini ketika ingin submit jawaban
    //     //kode lainnya
    // });
    //
    // Atau
    //
    // run(){
    //   ThreadTracker.mark(); <- tambahkan ini ketika ingin submit jawaban
    //   //kode lainnya
    // }
    
    public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] C = new int[m][p];

        int cells = m*p;
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < p; j++) {
        //         for (int k = 0; k < n; k++) {
        //             C[i][j] += A[i][k] * B[k][j];
        //         }
        //     }
        // }

        for (int t=0; t<numThreads; t++) { 
            final int threadIdx = t;
            threads[t] = new Thread(() -> {
                ThreadTracker.mark();
                for (int cell=threadIdx; cell<cells; cell+=numThreads) {
                    int i = cell/p;
                    int j = cell%p;
                    int sum = 0;
                    for (int k=0; k<n; k++) {
                        sum += A[i][k]*B[k][j];
                    }
                    C[i][j] = sum;
                }
            });
            threads[t].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return C;
    }
}
