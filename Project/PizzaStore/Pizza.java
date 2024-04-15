public class Pizza {

    private int size; //pizza ��������
    private boolean hasPeperoni;
    private boolean hasMushrooms;
    private boolean hasCheese;
    
    public Pizza(int size, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){ // ������
        this.size = size;
        this.hasPeperoni = hasPeperoni;
        this.hasMushrooms = hasMushrooms;
        this.hasCheese = hasCheese;
    }

    public int getSize(){ // private������ �����ϱ����� getter ���� �̹� ���������� ������� ����
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



    public String toString(){ // ������, ���� ����
        String result = "size : " + Integer.toString(size);
        result = result + " Ingredients : ";
        if(hasPeperoni == true) result = result + "1 peperoni ";
        else {
            result = result + "0 peperoni ";
        }
        if(hasMushrooms == true) result = result + "1 mushroom ";
        else{
            result = result + "0 mushroom ";
        }
        if(hasCheese == true) result = result + "1 cheese ";
        else{
            result = result + "0 cheese ";
        }
        result = result + "Price : " + Double.toString(getPrice());
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