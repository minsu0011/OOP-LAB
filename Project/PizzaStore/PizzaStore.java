import java.util.Scanner;

public class PizzaStore {
    private double cash;
    private Order currentOrder;
    private int peperoniStock;
    private int mushroomStock;
    private int cheeseStock;
    private int tableNumber = 0; // main method���� �����ϴ� tableNumber �ʵ�
    private String address; // main method���� �Է¹��� address ���� �ӽ� ���� �ʵ�

    public PizzaStore(){ // ������, �� �ʵ尪 �ʱ�ȭ
        this.cash = 2.5;
        this.peperoniStock = 1;
        this.mushroomStock = 1;
        this.cheeseStock = 1;
    }
    public void createOrder(String type){
        if(type == "InStore") currentOrder = new InStoreOrder(++tableNumber); // InStore�϶� ���ο� order�� instoreorder�� ����(tableNumber �ڵ�����)
        if(type == "Online") currentOrder = new OnlineOrder(address); // Online�϶� ���ο� order�� onlineorder�� ����(���� �Է¹��� address�� ���)
    }
    public void AddPizzaToOrder(int size, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){
        Pizza pizza = new Pizza(size, hasPeperoni, hasMushrooms, hasCheese); // ���ο� ���� �Ҵ�
        currentOrder.addPizza(pizza); // order�� ���� �߰�
    }
    public void restockPeperoni(int amount){
        cash = cash - amount * 1; // 1�޷�����
        peperoniStock = peperoniStock + amount; // ����߰�
    }
    public void restockMushrooms(int amount){
        cash = cash - amount * 1.50; // 1.5�޷� ����
        mushroomStock = mushroomStock + amount; // ����߰�
    }
    public void restockCheese(int amount){
        cash = cash - amount * 0.75; // 0.75�޷� ����
        cheeseStock = cheeseStock + amount; // ����߰�
    }
    public String toString(){ // �ܰ�� ����Ȳ ��� + Last Order�� �ִٸ� ���
        String result = "PizzaStore: cash: $" + cash + ", peperoni: " + Integer.toString(peperoniStock) + ", mushrooms: " + Integer.toString(mushroomStock) + ", cheese: " + Integer.toString(cheeseStock) + ".";
        if (currentOrder == null) return result; // Order�� ������ �״�� ����
        else return (result + "\nLast Order : \n" + currentOrder.toString()); // Order�� ������ Order ���뵵 �߰�
    }

    public static void main(String[] args){
        PizzaStore pizzastore = new PizzaStore(); // pizzastore �ν��Ͻ� ����
        Scanner scan = new Scanner(System.in); // scanner �ν��Ͻ� ����
        LOOPMAIN : // Order ����, ��� ���Ÿ� �ݺ�
        while(true){ // �۾��� ��� �ݺ��ϱ� ���� ���� (1, 2�� �Էµ��� ������ ���� ����)
            System.out.println(pizzastore.toString()); // �ܰ� �� ��� ��Ȳ ���
            System.out.println("What would you like to do: ");
            System.out.println("1: place an order, 2: buy ingredients");
            String scan1 = scan.nextLine();
            if(scan1.equals("1")){ // 1�� �ԷµǸ�
                System.out.println("What type of order?");
                System.out.println("1: In Store, 2: Online, 3: Back.");
                String scan2 = scan.nextLine();
                if(scan2.equals("1")){
                    System.out.println("Chosen: In Store");
                    pizzastore.createOrder("InStore"); // order ����
                }
                else if(scan2.equals("2")){
                    System.out.println("Chosen: Online");
                    System.out.println("What is the delivery address?");
                    pizzastore.address = scan.nextLine();
                    pizzastore.createOrder("Online"); // order ����
                }
                else continue LOOPMAIN; // 3 ���� �ٸ� ���ڰ� �Է� �Ǹ� back to the LoopMain
                
                LOOP1 : // pizza���� �ݺ�
                while(true){
                    int s = 0; // ������ ������ 0���� �ʱ�ȭ
                    boolean p = false; // ��� boolean ���� false�� �ʱ�ȭ
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
                    if(scanp.equals("y")){ 
                	    p = true; // ��� �߰� ���� ����
                	    pizzastore.peperoniStock --; // ����� 1�� ����
                    }
                    if(scanm.equals("y")) {
                	    m = true;
                	    pizzastore.mushroomStock --;
                    }
                    if(scanc.equals("y")) {
                	    c = true;
                	    pizzastore.cheeseStock --;
                    }
                    pizzastore.AddPizzaToOrder(s, p, m, c);
                    System.out.printf("Added: One %dcm pizza ",s); // ���� �߰� �Ϸ� ���� ���
                    if(m == true || p == true || c == true) System.out.print("with"); // �ϳ��� ��ᰡ ������ with ���
                    if(p == true){
                        if(m == false && c == false) System.out.print(" peperoni"); // ����δϰ� ������ ����̸� ��ǥ ��� ����
                        else System.out.print(" peperoni,"); // �ڿ� �ٸ� ��ᵵ ������ ��ǥ ���
                    }
                    if(m == true && c == false) System.out.print(" mushrooms"); // ġ� ������ ��ǥ ��� ����
                    if(m == true && c == true) System.out.print(" mushrooms,"); // ġ� ������ ��ǥ ���
                    if(c == true) System.out.print(" cheese");
                    System.out.println("\nDo you want to order another pizza? (Y/N)");
                    String scan3 = scan.nextLine();
                    if(scan3.equals("y")) continue LOOP1; // ���� �������� ���ư�
                    if(scan3.equals("n")) { // n�� �ԷµǸ�
                        LOOP2 : // Order �������� �ݺ�
                        while(true){
                            System.out.println("Your final order is: ");
                            System.out.println(pizzastore.currentOrder.toString()); // order ���� ���
                            System.out.println("Do you want to change your order? (Y/N)");
                            String scancc = scan.nextLine();
                            if(scancc.equals("y")){
                                System.out.println("Waht do you want to do?");
                                System.out.println("1: Add a pizza, 2: Remove a pizza, 3: Nothing.");
                                String scan10 = scan.nextLine();
                                if(scan10.equals("1")) continue LOOP1; // ���� �������� ���ư�
                                if(scan10.equals("2")){
                                    System.out.println("Which pizza do you want to remove?");
                                    String scanrm = scan.nextLine();
                                    pizzastore.currentOrder.removePizza(Integer.parseInt(scanrm) - 1); // �ش� index�� ���� ����
                                    continue LOOP2; // �߰� Order ���� ���η� ���ư�
                                }
                                else { // nothing�� �ԷµǸ� Order ���� ���� �� Ȯ�� and �ܰ� �߰� and LOOPMAIN���� ���ư�
                                    pizzastore.cash += pizzastore.currentOrder.calculateOrderPrice(); // �����Ⱦ� �� �� �߰�
                                    break LOOP1;
                                }
                            }
                            else{ // Order ���� ���� ������ Order Ȯ�� �� �ܰ� �߰� and LOOPMAIN���� ���ư� (break LOOP1)
                                pizzastore.cash += pizzastore.currentOrder.calculateOrderPrice(); // �����Ⱦ� �� �� �߰�
                                break LOOP1;
                            } 
                        }
                    }
                }
            }
            else if(scan1.equals("2")){ // 2�� �ԷµǸ�
                while(true){ // ��� �߰� �۾��� �ݺ��ϱ� ���� ����(4 �Է½� ����)
                    System.out.println("What ingredients do you want to buy?");
                    System.out.println("1: peperoni, 2: mushrooms, 3:cheese, 4: none");
                    String scani = scan.nextLine();
                    if(scani.equals("1") && pizzastore.cash >= 1) // 1�� �Էµǰ� �ܰ� ����������
                        pizzastore.restockPeperoni(1);
                    else if(scani.equals("2") && pizzastore.cash >= 1.5) // 2�� �Էµǰ� �ܰ� ����������
                        pizzastore.restockMushrooms(1);
                    else if(scani.equals("3") && pizzastore.cash >= 0.75) // 3�� �Էµǰ� �ܰ� ����������
                        pizzastore.restockCheese(1);
                    else if(scani.equals("4")) // 4�� �ԷµǸ� ����
                        break;
                    else {
                        System.out.println("no money!"); // �ܰ� �����ϸ� �����޼��� ���
                    }
                    System.out.println(pizzastore.toString()); //��� ���� ��, ��� �� ��� �ܰ� ���
                }
            }
            else break LOOPMAIN; // 1,2 �̿��� ���� �ԷµǸ� ���� ����
        }
    }
}