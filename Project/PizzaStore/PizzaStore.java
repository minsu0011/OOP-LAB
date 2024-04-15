import java.util.Scanner;

public class PizzaStore {
    private double cash = 2.5;
    private Order currentOrder;
    private int peperoniStock = 1;
    private int mushroomStock = 1;
    private int cheeseStock = 1;

    public PizzaStore(){} // 생성자
    public void createOrder(int pizzaSize, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){
        currentOrder = new Order(); // 새로운 Order 생성
        currentOrder.addPizza(pizzaSize, hasPeperoni, hasMushrooms, hasCheese);
    }
    public void restockPeperoni(int amount){
        cash = cash - amount * 1; // 1달러차감
        peperoniStock = peperoniStock + amount; // 재고추가
    }
    public void restockMushrooms(int amount){
        cash = cash - amount * 1.50; // 1.5달러 차감
        mushroomStock = mushroomStock + amount; // 재고추가
    }
    public void restockCheese(int amount){
        cash = cash - amount * 0.75; // 0.75달러 차감
        cheeseStock = cheeseStock + amount; // 재고추가
    }
    public String toString(){ // 잔고와 재고상황 출력
        String result = "cash : " + cash + " stock : " + Integer.toString(peperoniStock) + "peperonis " + Integer.toString(mushroomStock) + "mushrooms " + Integer.toString(cheeseStock) + "cheeses\n";
        if (currentOrder == null) return result; // Order가 없으면 그대로 리턴
        else return (result + currentOrder.toString()); // Order가 있으면 Order 내용도 추가
    }

    public static void main(String[] args){
        PizzaStore pizzastore = new PizzaStore(); // pizzastore 인스턴스 생성
        Scanner scan = new Scanner(System.in); // scanner 인스턴스 생성
        while(true){ // 작업을 계속 반복하기 위한 루프 (1, 2가 입력되지 않을시 루프 종료)
            System.out.printf("PizzaStore: cash: $%.2f, peperoni: %d, mushrooms: %d, cheeses: %d.%n", pizzastore.cash, pizzastore.peperoniStock, pizzastore.mushroomStock, pizzastore.cheeseStock); // 잔고 및 재료 상황 출력
            System.out.println("What would you like to do: ");
            System.out.println("1: place an order, 2: buy ingredients");
            String scan1 = scan.nextLine();
            if(scan1.equals("1")){ // 1이 입력되면
                int s = 0; // 사이즈 선언후 0으로 초기화
                boolean p = false; // 재료 boolean 변수 false로 초기화
                boolean m = false;
                boolean c = false;
                System.out.println("What size pizza do you want?");
                String scans = scan.nextLine();
                s = Integer.parseInt(scans); // string to int
                System.out.println("Do you want peperoni on your pizza? Y/N");
                String scanp = scan.nextLine();
                System.out.println("Do you want mushrooms on your pizza? Y/N");
                String scanm = scan.nextLine();
                System.out.println("Do you want cheese on your pizza? Y/N");
                String scanc = scan.nextLine();
                if(pizzastore.currentOrder != null){ // 오직 하나의 Order만 받음 + 아닐 시 에러메세지 출력
                    System.out.println("Only 1 order allowed this time");
                    continue;
                }
                if(scanp.equals("y")){ 
                	p = true; // 재료 추가 정보 저장
                	pizzastore.peperoniStock --; // 재고에서 1개 삭제
                }
                if(scanm.equals("y")) {
                	m = true;
                	pizzastore.mushroomStock --;
                }
                if(scanc.equals("y")) {
                	c = true;
                	pizzastore.cheeseStock --;
                }
                pizzastore.createOrder(s, p, m, c);
                pizzastore.cash += pizzastore.currentOrder.calculateOrderPrice(); // 피자팔아 번 돈 추가
                System.out.println("Your total will be $" + Double.toString(pizzastore.currentOrder.calculateOrderPrice()) + "."); // 피자의 가격 출력
            }
            else if(scan1.equals("2")){ // 2가 입력되면
                while(true){ // 재료 추가 작업을 반복하기 위한 루프(4 입력시 종료)
                    System.out.println("What ingredients do you want to buy?");
                    System.out.println("1: peperoni, 2: mushrooms, 3:cheese, 4: none");
                    String scani = scan.nextLine();
                    if(scani.equals("1") && pizzastore.cash >= 1) // 1이 입력되고 잔고가 남아있으면
                        pizzastore.restockPeperoni(1);
                    else if(scani.equals("2") && pizzastore.cash >= 1.5) // 2가 입력되고 잔고가 남아있으면
                        pizzastore.restockMushrooms(1);
                    else if(scani.equals("3") && pizzastore.cash >= 0.75) // 3이 입력되고 잔고가 남아있으면
                        pizzastore.restockCheese(1);
                    else if(scani.equals("4")) // 4가 입력되면 종료
                        break;
                    else {
                        System.out.println("no money!"); // 잔고가 부족하면 에러메세지 출력
                    }
                    System.out.printf("PizzaStore: cash: $%.2f, peperoni: %d, mushrooms: %d, cheeses: %d.%n", pizzastore.cash, pizzastore.peperoniStock, pizzastore.mushroomStock, pizzastore.cheeseStock); //재료 구입 후, 재고 및 재료 잔고 출력
                }
            }
            else { // 1,2 이외의 것이 입력되면 루프 종료
                break;
            }
        }
    }
}
