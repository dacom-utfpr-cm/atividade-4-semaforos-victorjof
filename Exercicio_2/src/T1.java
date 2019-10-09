public class T1 extends Thread{
    private Semaphore semaphore1;
    private Semaphore semaphore2;
    @Override
    public void run() {
        System.out.println("1.1");
        semaphore1.release();
        semaphore2.acquire();
        System.out.println("1.2");
    }

    T1(Semaphore semaphore1, Semaphore semaphore2){
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
    }
}
