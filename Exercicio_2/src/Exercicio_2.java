/* 
Author: Victor Figueira
Date:  08/10/2019
Task: 2. Rendezvous (Encontro)
Enviar sinalização para um ponto de encontro entre threads.Faça um código que uma thread t1 e t2 são inicializadas e t1 espera por t2 e vice-versa.
Exemplo:
t1:
- trecho1.1
- trecho1.2
t2:
- trecho2.1
- trecho2.2
thecho1.1 ocorre antes trecho2.2 e threcho2.1 ocorre antes de trecho1.2.
*/

public class Exercicio_2 {
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);

        new T1(semaphore1,semaphore2).start();
        new T2(semaphore1,semaphore2).start();

    }
}
