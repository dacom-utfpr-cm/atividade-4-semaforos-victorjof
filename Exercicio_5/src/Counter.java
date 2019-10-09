public class Counter {
    private int value = 0;
    private SemaphoreBarrier semaphoreBarrier;
    private final int waiting_point;


    private boolean is_waiting_point(){
        return(value == waiting_point);
    }

    public void farewell_msg(){
        System.out.printf("%n%n******************[%s] after barrier******************%n%n", Thread.currentThread().getName());
    }


    public void increment(){

        int past = value;
        this.value+=1;
        System.out.printf("%s incremented value: %d to:% d %n", Thread.currentThread().getName(), past, value);

        if(is_waiting_point()){
            System.out.printf("[%s] Reached waiting point %n",Thread.currentThread().getName());
            semaphoreBarrier.activate();
        }

        try {
            Thread.sleep((int) (Math.random()*1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        }


    Counter(SemaphoreBarrier semaphoreBarrier, int waiting_point){
        this.semaphoreBarrier = semaphoreBarrier;
        this.waiting_point = waiting_point;
    }
}