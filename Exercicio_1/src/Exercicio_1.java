/* 
Author: Victor Figueira
Date:  08/10/2019
Task: 1. Sinalização
Enviar sinal para outra thread para indicar que um evento ocorreu.
Faça um código que uma thread t1 e t2 são inicializadas simultaneamente, mas a t2 pode somente continuar a execução após a sinalização de t1.
*/

public class Exercicio_1 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);

        new  T("1",false, semaphore).start();
        new  T("2",true, semaphore).start();

    }
}
