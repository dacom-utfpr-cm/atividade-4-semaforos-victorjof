/* 
Author: Victor Figueira
Date:  08/10/2019
Task: 3.  Mutex (Exclusão Mútua)
Garantir acesso exclusivo à seção crítica.Faça um código que possibilite que 2 ou mais threads realizem o incremento de um contador. Faça aexclusão mútua com semáforo.
*/

public class Exercicio_3 {
    public static void main(String[] args) {
        int num_threads = 10;

        Semaphore semaphore = new Semaphore(1);
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
