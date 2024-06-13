public class InStoreOrder extends Order {
    private int tableNumber;
    public InStoreOrder(int tableNumber){ // 생성자
        this.tableNumber = tableNumber;
    }
    public double calculateOrderPrice(){
        double result = 0;
        for(int i = 0 ; i < getPizzaCount() ; i++)
            result += getPizza(i + 1).getPrice(); // 각 피자의 가격을 합산
        return result * 1.15; // 15% 팁 추가
    }
    public String toString(){ // table number 출력 및 order 정보 출력
        String result = super.toString();
        result = result + "Your table number is : " + Integer.toString(tableNumber);
        return result;
    }
}
