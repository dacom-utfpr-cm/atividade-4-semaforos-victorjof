public class SemaphoreBarrier {
    private int max_value;
    private int count;
    private int init_max_value;


    synchronized private void acquire(){

        max_value-=1;

        while(max_value > 0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        check_end();


    }


    synchronized private void release(){
        this.notify();
    }

    synchronized private void rebuild(){
        this.max_value = this.count;//the same as init_max_value
        this.count = 0;
    }

    synchronized private void check_end(){
        this.count+=1;

        if(this.count == this.init_max_value){// number of acquire() == number of release() -> all threads crossed the barrier.
            rebuild();
        }
    }


    public void activate(){
        this.acquire();
        this.release();
    }

    SemaphoreBarrier(int max_value){
        this.max_value = max_value;
        this.init_max_value = max_value;
    }
}
