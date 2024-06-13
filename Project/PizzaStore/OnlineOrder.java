public class OnlineOrder extends Order{
    private String deliveryAddress;
    public OnlineOrder(String address){ // 생성자
        deliveryAddress = address;
    }
    public double calculateOrderPrice(){
        double result = 0;
        for(int i = 0 ; i < getPizzaCount() ; i++)
            result += getPizza(i + 1).getPrice(); // 각 피자의 가격 합산
        if(getPizzaCount() == 0) return 0; // 피자가 없을 때 result = 0 출력
        return result + 3; // 피자가 있을때 +3 해서 출력
    }
    public String toString(){ // 배달주소 및 order 정보 출력
        String result = super.toString();
        result = result + "Address : " + deliveryAddress;
        return result;
    }
}