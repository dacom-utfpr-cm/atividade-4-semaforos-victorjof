import java.util.LinkedList;
import java.util.Queue;

public class F2 {
    private Queue<Thread> queue;
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    public void insert(Thread t){
        //non blocking acquire(semaphore 2  -> when dequeuing from both F1 and F2 )
        new Thread(()->{
        synchronized (this) {//queue operations
            queue.add(t);

            //Both threads will execute
            semaphore2.acquire();
            semaphore1.release();

            queue.remove().start();
        }
        }

        ).start();
    }



    F2(Semaphore semaphore1, Semaphore semaphore2) {
        this.queue = new LinkedList<>();
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
    }
}
