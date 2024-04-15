public class Order {
    private Pizza pizza; // 피자
    public Order(){} // 생성자
    public void addPizza(int size, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){
        pizza = new Pizza(size, hasPeperoni, hasMushrooms, hasCheese); // 새로운 피자 생성
    }
    public double calculateOrderPrice(){
        return pizza.getPrice(); // 피자의 가격 불러오기
    }
    public String toString(){
        String result = pizza.toString(); // Pizza 클래스의 toString과 동일
        return result;
    }
}