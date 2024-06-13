public abstract class Order {
    private Pizza[] pizza; // ����
    private static int orderIndex = 0;
    private int pizzaCount = 0; // ���� �� ���� ����(�߰�)
    public Order(){} // ������
    public void addPizza(Pizza pizza){ 
        pizzaCount++; // ���� ���� ����
        Pizza pizzaInput = new Pizza(pizza.getSize(), pizza.getHasPeperoni(), pizza.getHasMushrooms(), pizza.getHasCheese()); //�߰��� ���� ���� �ӽ� ������ ����
        pizzaInput.setPizzaIndex(pizzaCount); // pizzaIndex ����
        pizzaInput.setOrderIndex(orderIndex + 1); // orderIndex ����
        if(pizzaCount == 1){ // ó�� �߰��Ǵ� ������ ���
            this.pizza = new Pizza[pizzaCount]; // �迭 ��ĭ �Ҵ�
            this.pizza[0] = pizzaInput; // �Ҵ�� ��ĭ�� ���� �߰�
        }
        else if(pizzaCount >= 2){ // �߰��� ���� �̿ܿ� ������ ���ڰ� ������ ���
            Pizza[] pizzaTmp = new Pizza[pizzaCount - 1]; // �ӽ� �迭 ����(���� ����-1)
            for(int i = 0 ; i < pizzaCount - 1 ; i++) 
                pizzaTmp[i] = this.pizza[i]; // �ӽ� �迭�� ������ ���� ������ ����
            this.pizza = new Pizza[pizzaCount]; // ���ӿ� pizza �迭 ���� �� ���� ������ŭ �Ҵ�
            for(int i = 0 ; i < pizzaCount - 1 ; i++)
                this.pizza[i] = pizzaTmp[i]; // �ӽ� �迭�� ����Ǿ� �ִ� ���� ���� ������ ���Ӱ� �Ҵ��� �迭 pizza�� ����
            this.pizza[pizzaCount - 1] = pizzaInput; // ���Ӱ� �߰��� ���� ���� ����
        }
    }

    public void plusOrderIndex(){
        orderIndex ++;
    }
    public Pizza getPizza(int x){ // pizza �迭 �� ĭ�� �����ϱ� ���� getter
        return pizza[x - 1];
    }
    public int getPizzaCount(){ // pizza�� ���� getter
        return pizzaCount;
    }

    public void removePizza(int index){
        pizzaCount--; // ���ڰ��� ����
        if(pizzaCount == 0) // ���ڰ� ������ pizza�迭 null�� �ʱ�ȭ
            pizza = null;
        else if(pizzaCount >= 1){ // ���ڰ� ������
            Pizza[] pizzaTmp = new Pizza[pizzaCount]; // �ӽ� �迭 ����
            int cnt = 0;
            for(int i = 0 ; i < pizzaCount + 1 ; i++){
                if(i == index) continue; // �ش� index �������� �������� ����
                else pizzaTmp[cnt] = pizza[i]; // �ӽ� �迭�� ���� ���� ����
                cnt++;
            }
            pizza = new Pizza[pizzaCount]; // ���ο� pizza �迭 �Ҵ�
            for(int i = 0 ; i < pizzaCount ; i++){
                pizza[i] = pizzaTmp[i]; // ���ο� pizza�� �ӽ� �迭�� ���� ����
                pizza[i].setPizzaIndex(i + 1);
                pizza[i].setOrderIndex(orderIndex + 1);
            }
        }
    }
    abstract public double calculateOrderPrice(); //abstract
    public String toString(){ // order�� ����, ���� ���� ��� + �� ������ ����
        String result = "Price: $" + calculateOrderPrice() + ", " + Integer.toString(pizzaCount) + " pizzas\n";
        for(int i = 0 ; i < pizzaCount ; i++)
            result = result + "Pizza " + pizza[i].getPizzaIndex() + ": " + pizza[i].toString() + "\n";
        
        return result;
    }
}