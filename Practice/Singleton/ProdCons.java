package Singleton;

public class ProdCons {
    private Buffer buffer;
    private Producer[] producer;
    private Consumer[] consumer;

    public ProdCons(){
        buffer = new Buffer(5);
        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);
        producer = new Producer[2];
        consumer = new Consumer[2];
        producer[0] = producer1;
        producer[1] = producer2;
        consumer[0] = consumer1;
        consumer[1] = consumer2;
    }


    private class Producer extends Thread{
        private final Buffer buffer;
        private static int serial = 0;
        private int pid;
        public Producer(Buffer buf){
            pid = serial++;
            this.buffer = buf;
        }
        public void produce() throws InterruptedException{
            for(int i = 0 ; i < buffer.getSize() ; i++){
                System.out.println("Producer#" + pid + ":" + this);
                buffer.add(Math.random()*100, pid);
            }
        }
        public void run(){
            try{
                produce();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private class Consumer extends Thread{
        private final Buffer buffer;
        private static int serial;
        private int cid;
        public Consumer(Buffer buf){
            cid = serial++;
            this.buffer = buf;
        }
        public void consume() throws InterruptedException{
            for(int i = buffer.getSize() ; i > 0 ;i ++){
                System.out.println("Consumer#" + cid + ":" + this);
                buffer.remove(cid);
            }
        }
        public void run(){
            try{
                consume();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void startThread(){

        producer[0].start();
        producer[1].start();
        consumer[0].start();
        consumer[1].start();
    }
}
