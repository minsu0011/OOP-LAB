import java.util.ArrayList;

public class PizzaOven extends Thread implements Observable{
    private ArrayList<Observer> observers;
    private Boolean isCooking;
    private Pizza pizza;

    public PizzaOven(){ // 생성자
        observers = new ArrayList<Observer>(); // ArrayList할당
        isCooking = false;
    }

    public void setPizza(Pizza pizza){
        this.pizza = pizza;
    }

    public Boolean getIsCooking(){
        return isCooking;
    }

    public void setIsCooking(Boolean isCooking){
        if(isCooking) this.isCooking = true;
    }
    
    public void makePizza(int pizzaIndex, int orderIndex) throws InterruptedException{
        
        sleep(6000); // 6초
        for(int i = 0 ; i < observers.size() ; i++) // subsriber의 update 호출
            observers.get(i).update(pizzaIndex, orderIndex, 20);
        sleep(6000);
        for(int i = 0 ; i < observers.size() ; i++)
            observers.get(i).update(pizzaIndex, orderIndex, 40);
        sleep(6000);
        for(int i = 0 ; i < observers.size() ; i++)
            observers.get(i).update(pizzaIndex, orderIndex, 60);
        sleep(6000);
        for(int i = 0 ; i < observers.size() ; i++)
            observers.get(i).update(pizzaIndex, orderIndex, 80);
        sleep(6000);
        for(int i = 0 ; i < observers.size() ; i++)
            observers.get(i).update(pizzaIndex, orderIndex, 100);
    
        isCooking = false; // not iscooking
    }

    public void run(){
        try { // makePizza(~)
            makePizza(pizza.getPizzaIndex(), pizza.getOrderIndex());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void subscribe(Observer observer){
        observers.add(observer);
    }
    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }
}
