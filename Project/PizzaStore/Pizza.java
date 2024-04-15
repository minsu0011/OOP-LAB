public class Pizza {

    private int size; //pizza 변수설정
    private boolean hasPeperoni;
    private boolean hasMushrooms;
    private boolean hasCheese;
    
    public Pizza(int size, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){ // 생성자
        this.size = size;
        this.hasPeperoni = hasPeperoni;
        this.hasMushrooms = hasMushrooms;
        this.hasCheese = hasCheese;
    }

    public int getSize(){ // private변수에 접근하기위한 getter 설정 이번 과제에서는 사용하지 않음
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



    public String toString(){ // 사이즈, 재료들 리턴
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
    
    public double getPrice(){ // 피자의 가격을 계산하고 리턴
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