public class T2 extends Thread{
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    @Override
    public void run() {
        semaphore1.acquire();
        System.out.println("2.1");
        semaphore2.release();
        System.out.println("2.2");
    }

    T2(Semaphore semaphore1, Semaphore semaphore2){
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
    }

}
