public class T extends Thread{
    private String name;
    private boolean waiting;
    private Semaphore semaphore;



    @Override
    public void run() {
        System.out.printf("[Thread %s] started %n",this.name);

        if(waiting){
            semaphore.acquire();
            System.out.printf("[Thread %s] I'm done waiting %n",this.name);
        }

        else{
            try{
                System.out.printf("[Thread %s] I will make u wait 3 seconds %n",this.name);
                Thread.sleep(3000);
                semaphore.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    T(String name, boolean waiting, Semaphore semaphore){
        this.name = name;
        this.waiting = waiting;
        this.semaphore = semaphore;
    }

}

