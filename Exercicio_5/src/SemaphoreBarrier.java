public class SemaphoreBarrier {
    private int max_value;


    synchronized private void acquire(){

        max_value-=1;

        while(max_value > 0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    synchronized private void release(){
        this.notify();
    }

    public void activate(){
        this.acquire();
        this.release();
    }

    SemaphoreBarrier(int max_value){
        this.max_value = max_value;
    }
}
