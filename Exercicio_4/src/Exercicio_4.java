/* 
Author: Victor Figueira
Date:  08/10/2019
Task: 4. Multiplex
Garantir acesso à seção crítica para no máximo N threads.Faça um código que possibilite que N threads estejam na seção crítica simultaneamente.
*/

public class Exercicio_4 {
    public static void main(String[] args) {
        int num_threads = 10;
        int num_multiplex = 2;

        //this time 2 threads can increase the counter simultaneous.
        Semaphore semaphore = new Semaphore(num_multiplex);
        Counter counter = new Counter();

        for (int i = 0; i<num_threads;i++){
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    semaphore.acquire();
                    counter.increment();
                    semaphore.release();
                }
                counter.farewell_msg();
            }).start();
        }

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
