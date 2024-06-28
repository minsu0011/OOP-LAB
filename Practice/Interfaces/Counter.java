public class Counter{
    private int counter;
    public Counter(){
        counter = 0;
    }
    public int value(){
        return counter;
    }
    public void increment(){
        int local;
        synchronized (this){
        local = counter;
        local ++;
        counter = local;
        }
    }
}
