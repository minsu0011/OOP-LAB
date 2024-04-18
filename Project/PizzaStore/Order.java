public abstract class Order {
    private Pizza[] pizza; // 피자
    int pizzaCount = 0; // 오더 당 피자 갯수(추가)
    public Order(){} // 생성자
    public void addPizza(Pizza pizza){ 
        pizzaCount++; // 피자 개수 증가
        Pizza pizzaInput = new Pizza(pizza.getSize(), pizza.getHasPeperoni(), pizza.getHasMushrooms(), pizza.getHasCheese()); //추가할 피자 정보 임시 변수에 저장
        if(pizzaCount == 1){ // 처음 추가되는 피자일 경우
            this.pizza = new Pizza[pizzaCount]; // 배열 한칸 할당
            this.pizza[0] = pizzaInput; // 할당된 한칸에 피자 추가
        }
        else if(pizzaCount >= 2){ // 추가할 피자 이외에 기존에 피자가 존재할 경우
            Pizza[] pizzaTmp = new Pizza[pizzaCount - 1]; // 임시 배열 생성(피자 개수-1)
            for(int i = 0 ; i < pizzaCount - 1 ; i++) 
                pizzaTmp[i] = this.pizza[i]; // 임시 배열에 기존의 피자 정보들 복사
            this.pizza = new Pizza[pizzaCount]; // 새롭운 pizza 배열 생성 및 피자 개수만큼 할당
            for(int i = 0 ; i < pizzaCount - 1 ; i++)
                this.pizza[i] = pizzaTmp[i]; // 임시 배열에 저장되어 있는 기존 피자 정보들 새롭게 할당한 배열 pizza에 복사
            this.pizza[pizzaCount - 1] = pizzaInput; // 새롭게 추가할 피자 정보 저장
        }
    }

    public Pizza getPizza(int x){ // pizza 배열 한 칸에 접근하기 위한 getter
        return pizza[x - 1];
    }
    public int getPizzaCount(){ // pizza의 개수 getter
        return pizzaCount;
    }

    public void removePizza(int index){
        pizzaCount--; // 피자개수 감소
        if(pizzaCount == 0) // 피자가 없으면 pizza배열 null로 초기화
            pizza = null;
        else if(pizzaCount >= 1){ // 피자가 있으면
            Pizza[] pizzaTmp = new Pizza[pizzaCount]; // 임시 배열 생성
            int cnt = 0;
            for(int i = 0 ; i < pizzaCount + 1 ; i++){
                if(i == index) continue; // 해당 index 피자정보 복사하지 않음
                else pizzaTmp[cnt] = pizza[i]; // 임시 배열에 피자 정보 복사
                cnt++;
            }
            pizza = new Pizza[pizzaCount]; // 새로운 pizza 배열 할당
            for(int i = 0 ; i < pizzaCount ; i++)
                pizza[i] = pizzaTmp[i]; // 새로운 pizza에 임시 배열내 정보 복사
        }
    }
    abstract public double calculateOrderPrice(); //abstract
    public String toString(){ // order의 가격, 피자 개수 출력 + 각 피자의 정보
        String result = "Price: $" + calculateOrderPrice() + ", " + Integer.toString(pizzaCount) + " pizzas\n";
        for(int i = 0 ; i < pizzaCount ; i++)
            result = result + "Pizza " + Integer.toString(i+1) + ": " + pizza[i].toString() + "\n";
        
        return result;
    }
}