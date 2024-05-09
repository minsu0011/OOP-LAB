public class Wallet{
    private String name;
    private int balance;
    private int txIndex;
    public Wallet(String name){
        this.name = "my wallet";
        balance = 100;
        txIndex = 0;
    }
    public int getBalance(){
        return balance;
    }
    public void increaseIndex(){
        txIndex++;
    }
    public void decreaseBalance(int expense){
        balance = balance - expense;
    }
    public String toString(){
        return "name: " + this.name + ", #" + this.txIndex + ", balance: " + this.balance;
    }
    public void empty() throws Exception{
        if(balance <= 0) {
            Exception e = new Exception("Go Home");
            throw e;
        }
    }
}