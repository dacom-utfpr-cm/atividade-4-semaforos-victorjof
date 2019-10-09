/* 
Author: Victor Figueira
Date:  08/10/2019
Task: 5. Barreira
Após n threads sincronizarem em um ponto em comum, um trecho específico (ponto crítico) pode ser executado por cada uma delas.Faça um código que possibilite barrar N threads em um ponto específico de execução e, após todas alcançarem o ponto, todas devem executar o trecho de código após esse ponto.
*/


public class Exercicio_5 {
    public static void main(String[] args) {

        int num_threads = 3;
        int waiting_point = 5;

        //Changed semaphoreBarrier's implementation
        SemaphoreBarrier semaphoreBarrier = new SemaphoreBarrier(num_threads);


        for (int i = 0; i<num_threads;i++){

            Counter counter = new Counter(semaphoreBarrier,waiting_point);

            //create 3 threads, waiting point(defined in Counter) is 5
            new Thread(() -> {
                for (int j = 0; j < waiting_point+1; j++) {
                    counter.increment();
                }
                //after barrier
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
