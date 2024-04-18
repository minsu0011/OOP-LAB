public class Pizza {

    private int size; //pizza 필드설정
    private boolean hasPeperoni;
    private boolean hasMushrooms;
    private boolean hasCheese;
    
    public Pizza(int size, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){ // 생성자
        this.size = size;
        this.hasPeperoni = hasPeperoni;
        this.hasMushrooms = hasMushrooms;
        this.hasCheese = hasCheese;
    }

    public int getSize(){ // private변수에 접근하기위한 getter 설정
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

    public String toString(){ // 사이즈, 재료들, 가격 String 리턴
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