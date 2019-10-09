public class Semaphore {
    private int max_value;

    synchronized public void acquire(){
        while(max_value == 0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        max_value-=1;
    }

    synchronized public void release(){
        max_value = max_value + 1;
        this.notify();
    }


    Semaphore(int max_value){
        this.max_value = max_value;
    }
}
