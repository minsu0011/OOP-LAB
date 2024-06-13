public class Pizza {

    private int pizzaIndex;
    private int orderIndex;
    private int size; //pizza �ʵ弳��
    private boolean hasPeperoni;
    private boolean hasMushrooms;
    private boolean hasCheese;
    
    public Pizza(int size, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){ // ������
        this.size = size;
        this.hasPeperoni = hasPeperoni;
        this.hasMushrooms = hasMushrooms;
        this.hasCheese = hasCheese;
    }

    public void setPizzaIndex(int index){
        this.pizzaIndex = index;
    } 
    public int getPizzaIndex(){
        return pizzaIndex;
    }
    public void setOrderIndex(int index){
        this.orderIndex = index;
    }
    public int getOrderIndex(){
        return orderIndex;
    }
    public int getSize(){ // private������ �����ϱ����� getter ����
        return size;
    }
    public boolean getHasPeperoni(){
        return hasPeperoni;
    }
    public boolean getHasMushrooms(){
        return hasMushrooms;
    }
    public boolean getHasCheese(){
        return hasCheese;
    }

    public String toString(){ // ������, ����, ���� String ����
        String result = Integer.toString(size) + "cm, peperoni: ";
        if(hasPeperoni == true) result = result + "yes, mushrooms: ";
        else result = result + "no, mushrooms: ";
        if(hasMushrooms == true) result = result + "yes, cheese: ";
        else result = result + "no, cheese: ";
        if(hasCheese == true) result = result + "yes, $";
        else result = result + "no, $";
        result = result + Double.toString(getPrice());
        return result;
    }
    
    public double getPrice(){ // ������ ������ ����ϰ� ����
        int cnt = 0;
        double result = 0;
        if(hasPeperoni == true) cnt++;
        if(hasMushrooms == true) cnt++;
        if(hasCheese == true) cnt++;
        result = size * 0.25;
        result = result * (1.0 + cnt*0.1);
        return result;
    }
}