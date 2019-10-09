/* 
Author: Victor Figueira
Date:  08/10/2019
Task: 6. Barreira Reusável
Threds em um laço executam uma série de passos e sincronizam em uma barreira a cada passo.Faça um código que implemente uma barreira reusável que feche a si própria após todas as threads passarem.
*/

public class Exercicio_6 {
    public static void main(String[] args) {
        int num_threads = 3;
        int waiting_point = 5;
        //Changed semaphoreBarrier's implementation
        SemaphoreBarrier semaphoreBarrier = new SemaphoreBarrier(num_threads);

        test_reusable_barrier(semaphoreBarrier, num_threads, waiting_point);

        try{Thread.sleep(3000);}catch (InterruptedException e){};

        //again, using the same barrier
        test_reusable_barrier(semaphoreBarrier, num_threads, waiting_point);

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void test_reusable_barrier(SemaphoreBarrier semaphoreBarrier, int num_threads, int waiting_point){
        for (int i = 0; i<num_threads;i++){

            Counter counter = new Counter(semaphoreBarrier,waiting_point);

            //create 3 threads, waiting point(defined in Counter) is 5
            new Thread(() -> {
                for (int j = 0; j < waiting_point; j++) {
                    counter.increment();
                }
                counter.farewell_msg();
            }).start();
        }

    }


}
