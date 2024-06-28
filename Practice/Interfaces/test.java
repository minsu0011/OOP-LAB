public class test extends Thread{
    private Counter countObject;
    public test(Counter ctr){
        countObject = ctr;
    }
    public void run(){
        countObject.increment();
    }
    public static void main(String[] args) throws InterruptedException{
        int i;
        test[] threads = new test[30000];
        Counter masterCounter = new Counter();
        for(i = 0 ; i < threads.length ; i++){
            threads[i] = new test(masterCounter);
            threads[i].start();
        }
        for(i = 0 ; i < threads.length ; i++){
            threads[i].join();
        }
        System.out.println("The counter is " + masterCounter.value());
    }
}