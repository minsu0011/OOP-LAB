package Singleton;
import java.util.Arrays;

public class Buffer {
    private int loc = 0;
    private double[] data;

    public Buffer(int num){
        data = new double[num];
        System.out.println("New Buffer");
        System.out.println(Arrays.toString(data));
    }

    public int getSize(){
        return data.length;
    }

    public synchronized void add(double toAdd, int id) throws InterruptedException{
        while(loc >= data.length){
            System.out.println("Producer#" + id + " @ Buffer is full.\n");
            wait();
        }
        System.out.println("Producer#" + id + " Adding item on " + loc + ": " + toAdd);
        data[loc++] = toAdd;
        System.out.println(Arrays.toString(data));
        notifyAll();
    }

    public synchronized double remove(int id) throws InterruptedException{
        while(loc <= 0){
            System.out.println("Consumer#" + id + " @ Buffer is empty\n");
            wait();
        }
        double temp = data[--loc];
        System.out.println("Consumer#" + id + " Removing item on " + loc + ": " + temp);
        data[loc] = 0.0;
        System.out.println(Arrays.toString(data));
        notifyAll();
        return temp;
    }
}
