public class Order {
    private Pizza pizza; // ����
    public Order(){} // ������
    public void addPizza(int size, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){
        pizza = new Pizza(size, hasPeperoni, hasMushrooms, hasCheese); // ���ο� ���� ����
    }
    public double calculateOrderPrice(){
        return pizza.getPrice(); // ������ ���� �ҷ�����
    }
    public String toString(){
        String result = pizza.toString(); // Pizza Ŭ������ toString�� ����
        return result;
    }
}