import java.util.Scanner;

public class PizzaStore {
    private double cash;
    private Order currentOrder;
    private int peperoniStock;
    private int mushroomStock;
    private int cheeseStock;
    private int tableNumber = 0; // main method에서 제어하는 tableNumber 필드
    private String address; // main method에서 입력받은 address 정보 임시 저장 필드
    public PizzaStore(double cash, int peperoniStock, int mushroomStock, int cheeseStock){ // 생성자, 각 필드값 초기화
        this.cash = cash;
        this.peperoniStock = peperoniStock;
        this.mushroomStock = mushroomStock;
        this.cheeseStock = cheeseStock;
    }
    public void createOrder(String type){
        if(type == "InStore") currentOrder = new InStoreOrder(++tableNumber); // InStore일때 새로운 order를 instoreorder로 생성(tableNumber 자동배정)
        if(type == "Online") currentOrder = new OnlineOrder(address); // Online일때 새로운 order를 onlineorder로 생성(전에 입력받은 address값 사용)
    }
    public void AddPizzaToOrder(int size, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){
        Pizza pizza = new Pizza(size, hasPeperoni, hasMushrooms, hasCheese); // 새로운 피자 할당
        currentOrder.addPizza(pizza); // order에 피자 추가
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
    public String toString(){ // 잔고와 재고상황 출력 + Last Order가 있다면 출력
        String result = "PizzaStore: cash: $" + cash + ", peperoni: " + Integer.toString(peperoniStock) + ", mushrooms: " + Integer.toString(mushroomStock) + ", cheese: " + Integer.toString(cheeseStock) + ".";
        if (currentOrder == null) return result; // Order가 없으면 그대로 리턴
        else return (result + "\nLast Order : \n" + currentOrder.toString()); // Order가 있으면 Order 내용도 추가
    }

    public static void main(String[] args){
        String typeOfFile = null;
        String fileLocation = null;
        TXTHandler txthandler = null;
        CSVHandler csvhandler = null;
        Scanner scan = new Scanner(System.in); // scanner 인스턴스 생성
        System.out.println("What type of file do you want to use?");
        System.out.println("1: CSV, 2: TXT");
        scan.nextLine();
        PizzaStore pizzastore;
        LOOP3 :
        while(true){
            try{
                System.out.println("What is the location of the file?");
                fileLocation = scan.nextLine();
                int periodLocation = fileLocation.lastIndexOf("."); // 마지막 . 의 index 위치 저장
                typeOfFile = fileLocation.substring(periodLocation + 1); // 파일의 형식 저장(ex. txt)
                if(typeOfFile.equals("txt")){ //txt
                    txthandler = new TXTHandler(); // txt handler
                    pizzastore = txthandler.InitPizzaStore(fileLocation); // pizzastore 객체 생성
                    if(pizzastore == null) continue LOOP3; // Exception이 발생 -> 다시 fileLocation 입력받음
                    else break LOOP3;
                }
                else if(typeOfFile.equals("csv")){ // csv
                    csvhandler = new CSVHandler(); // csv handler
                    pizzastore = csvhandler.InitPizzaStore(fileLocation); // pizzastore 객체 생성
                    if(pizzastore == null) continue LOOP3; // Exception -> 다시 fileLocation 입력받음
                    else break LOOP3;
                }
                else throw new Exception(); // txt 혹은 csv가 아니면
            } catch(Exception e){
                System.out.println("File Type Error!");
                continue LOOP3;
            }
        }
        LOOPMAIN : // Order 생성, 재료 구매를 반복
        while(true){ // 작업을 계속 반복하기 위한 루프 (1, 2가 입력되지 않을시 루프 종료)
            System.out.println(pizzastore.toString()); // 잔고 및 재료 상황 출력
            System.out.println("What would you like to do: ");
            System.out.println("1: place an order, 2: buy ingredients, 3: Save and quit");
            String scan1 = scan.nextLine();
            if(scan1.equals("1")){ // 1이 입력되면
                System.out.println("What type of order?");
                System.out.println("1: In Store, 2: Online, 3: Back.");
                String scan2 = scan.nextLine();
                if(scan2.equals("1")){
                    System.out.println("Chosen: In Store");
                    pizzastore.createOrder("InStore"); // order 생성
                }
                else if(scan2.equals("2")){
                    System.out.println("Chosen: Online");
                    System.out.println("What is the delivery address?");
                    pizzastore.address = scan.nextLine();
                    pizzastore.createOrder("Online"); // order 생성
                }
                else continue LOOPMAIN; // 3 포함 다른 문자가 입력 되면 back to the LoopMain
                
                LOOP1 : // pizza생성 반복
                while(true){
                    int s = 0; // 사이즈 선언후 0으로 초기화
                    boolean p = false; // 재료 boolean 변수 false로 초기화
                    boolean m = false;
                    boolean c = false;
                    System.out.println("What size pizza do you want?");
                    String scans = scan.nextLine();
                    s = Integer.parseInt(scans); // string to int
                    System.out.println("Do you want peperoni on your pizza? Y/N");
                    String scanp = scan.nextLine();
                    System.out.println("Do you want cheese on your pizza? Y/N");
                    String scanc = scan.nextLine();
                    System.out.println("Do you want mushrooms on your pizza? Y/N");
                    String scanm = scan.nextLine();
                    if(scanp.equals("y")){ 
                	    p = true; // 재료 추가 정보 저장
                	    pizzastore.peperoniStock --; // 재고에서 1개 삭제
                    }
                    if(scanc.equals("y")) {
                	    c = true;
                	    pizzastore.cheeseStock --;
                    }
                    if(scanm.equals("y")) {
                	    m = true;
                	    pizzastore.mushroomStock --;
                    }
                    pizzastore.AddPizzaToOrder(s, p, m, c);
                    System.out.printf("Added: One %dcm pizza ",s); // 피자 추가 완료 문구 출력
                    if(m == true || p == true || c == true) System.out.print("with"); // 하나라도 재료가 있으면 with 출력
                    if(p == true){
                        if(m == false && c == false) System.out.print(" peperoni"); // 페페로니가 마지막 재료이면 쉼표 출력 안함
                        else System.out.print(" peperoni,"); // 뒤에 다른 재료도 있으면 쉼표 출력
                    }
                    if(m == true && c == false) System.out.print(" mushrooms"); // 치즈가 없으면 쉼표 출력 안함
                    if(m == true && c == true) System.out.print(" mushrooms,"); // 치즈가 있으면 쉼표 출력
                    if(c == true) System.out.print(" cheese");
                    System.out.println("\nDo you want to order another pizza? (Y/N)");
                    String scan3 = scan.nextLine();
                    if(scan3.equals("y")) continue LOOP1; // 피자 생성으로 돌아감
                    if(scan3.equals("n")) { // n이 입력되면
                        LOOP2 : // Order 수정여부 반복
                        while(true){
                            System.out.println("Your final order is: ");
                            System.out.println(pizzastore.currentOrder.toString()); // order 정보 출력
                            System.out.println("Do you want to change your order? (Y/N)");
                            String scancc = scan.nextLine();
                            if(scancc.equals("y")){
                                System.out.println("Waht do you want to do?");
                                System.out.println("1: Add a pizza, 2: Remove a pizza, 3: Nothing.");
                                String scan10 = scan.nextLine();
                                if(scan10.equals("1")) continue LOOP1; // 피자 생성으로 돌아감
                                if(scan10.equals("2")){
                                    System.out.println("Which pizza do you want to remove?");
                                    String scanrm = scan.nextLine();
                                    pizzastore.currentOrder.removePizza(Integer.parseInt(scanrm) - 1); // 해당 index의 피자 삭제
                                    continue LOOP2; // 추가 Order 수정 여부로 돌아감
                                }
                                else { // nothing이 입력되면 Order 수정 종료 및 확정 and 잔고에 추가 and LOOPMAIN으로 돌아감
                                    pizzastore.cash += pizzastore.currentOrder.calculateOrderPrice(); // 피자팔아 번 돈 추가
                                    break LOOP1;
                                }
                            }
                            else{ // Order 수정 생각 없으면 Order 확정 및 잔고에 추가 and LOOPMAIN으로 돌아감 (break LOOP1)
                                pizzastore.cash += pizzastore.currentOrder.calculateOrderPrice(); // 피자팔아 번 돈 추가
                                break LOOP1;
                            } 
                        }
                    }
                }
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
                    System.out.println(pizzastore.toString()); //재료 구입 후, 재고 및 재료 잔고 출력
                }
            }
            else if(scan1.equals("3")){ // Save and Quit
                String text = null;
                if(typeOfFile.equals("txt")){ // txt
                    text = "Money;" + pizzastore.cash + "\r\nCheese;" + pizzastore.cheeseStock + "\r\nPeperoni;" + pizzastore.peperoniStock + "\r\nMushroom;" + pizzastore.mushroomStock; // txt형식으로 text 작성
                    txthandler.writeToFile(fileLocation, text); // fileLocation에 text rewrite
                }
                else if(typeOfFile.equals("csv")){ // csv
                    String t = Double.toString(pizzastore.cash);
                    t = t.replace(".", ","); // 12.00 -> 12,00
                    text = "Money,\"" + t + "\"\r\nMushroom," + pizzastore.mushroomStock + "\r\nPeperoni," + pizzastore.peperoniStock + "\r\nCheese," + pizzastore.cheeseStock; // csv 형식으로 text 작성
                    csvhandler.writeToFile(fileLocation, text); // fileLocation에 text rewrite
                }
                break LOOPMAIN; // program exit
            }
            else break LOOPMAIN; // 1, 2, 3 이외의 숫자가 입력되면 종료
        }
    }
}