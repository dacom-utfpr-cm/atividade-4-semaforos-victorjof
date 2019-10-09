import java.util.LinkedList;
import java.util.Queue;

public class F1 {
    private Queue<Thread> queue;
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    public void insert(Thread t){
        queue.add(t);
    }

    //FIFO
    public void execute(){
        System.out.println("[F1] searching f2 pair");

        semaphore2.release();//if there`s no corresponding semaphore2.acquire() in F2, semaphore1.release() in F2 never happens
        semaphore1.acquire();

        queue.remove().start();
    }

    F1(Semaphore semaphore1, Semaphore semaphore2) {
        this.queue = new LinkedList<>();
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
    }
}
