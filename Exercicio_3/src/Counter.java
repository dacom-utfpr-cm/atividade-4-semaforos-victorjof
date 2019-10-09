public class Counter {
    private int value = 0;

    public void farewell_msg(){
        System.out.printf("%n%n******************[%s] has nothing more to  increment******************%n%n", Thread.currentThread().getName());
    }


    public void increment(){
        int past = value;
        this.value+=1;
        System.out.printf("%s incremented value: %d to:% d %n", Thread.currentThread().getName(), past, value);
    }
}