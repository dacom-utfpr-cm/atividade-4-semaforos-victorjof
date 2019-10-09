/* 
Author: Victor Figueira
Date:  08/10/2019
Task: 7. Fila
Semáforos podem ser usadas para representar uma fila.Faça um código que implemente duas filas (F1 e F2) com semáforos. As threads colocadas na F1 sópodem executar se tiver um par na F2. Nesse caso, ambas as threads na primeira fila são executadas.
*/


public class Exercicio_7 {
    public static void main(String[] args) {
        int num_f1 = 5;
        int num_f2 = 2;

        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);

        F1 f1 = new F1(semaphore1,semaphore2);
        F2 f2 = new F2(semaphore1,semaphore2);

        for(int i =0; i<num_f1; i++){
            f1.insert(new Thread(() -> System.out.println("[THREAD F1] Released/paired")));
        }


        for(int i =0; i<num_f2; i++){
            f2.insert(new Thread(() -> System.out.println("[THREAD F2] Released/paired")));
        }

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){};

        for(int i =0; i<num_f1;i++){
            f1.execute();//may block
        }


    }
}
