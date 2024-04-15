import java.util.Scanner;

public class PizzaStore {
    private double cash = 2.5;
    private Order currentOrder;
    private int peperoniStock = 1;
    private int mushroomStock = 1;
    private int cheeseStock = 1;

    public PizzaStore(){} // ������
    public void createOrder(int pizzaSize, boolean hasPeperoni, boolean hasMushrooms, boolean hasCheese){
        currentOrder = new Order(); // ���ο� Order ����
        currentOrder.addPizza(pizzaSize, hasPeperoni, hasMushrooms, hasCheese);
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
    public String toString(){ // �ܰ�� ����Ȳ ���
        String result = "cash : " + cash + " stock : " + Integer.toString(peperoniStock) + "peperonis " + Integer.toString(mushroomStock) + "mushrooms " + Integer.toString(cheeseStock) + "cheeses\n";
        if (currentOrder == null) return result; // Order�� ������ �״�� ����
        else return (result + currentOrder.toString()); // Order�� ������ Order ���뵵 �߰�
    }

    public static void main(String[] args){
        PizzaStore pizzastore = new PizzaStore(); // pizzastore �ν��Ͻ� ����
        Scanner scan = new Scanner(System.in); // scanner �ν��Ͻ� ����
        while(true){ // �۾��� ��� �ݺ��ϱ� ���� ���� (1, 2�� �Էµ��� ������ ���� ����)
            System.out.printf("PizzaStore: cash: $%.2f, peperoni: %d, mushrooms: %d, cheeses: %d.%n", pizzastore.cash, pizzastore.peperoniStock, pizzastore.mushroomStock, pizzastore.cheeseStock); // �ܰ� �� ��� ��Ȳ ���
            System.out.println("What would you like to do: ");
            System.out.println("1: place an order, 2: buy ingredients");
            String scan1 = scan.nextLine();
            if(scan1.equals("1")){ // 1�� �ԷµǸ�
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
                if(pizzastore.currentOrder != null){ // ���� �ϳ��� Order�� ���� + �ƴ� �� �����޼��� ���
                    System.out.println("Only 1 order allowed this time");
                    continue;
                }
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
                pizzastore.createOrder(s, p, m, c);
                pizzastore.cash += pizzastore.currentOrder.calculateOrderPrice(); // �����Ⱦ� �� �� �߰�
                System.out.println("Your total will be $" + Double.toString(pizzastore.currentOrder.calculateOrderPrice()) + "."); // ������ ���� ���
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
                    System.out.printf("PizzaStore: cash: $%.2f, peperoni: %d, mushrooms: %d, cheeses: %d.%n", pizzastore.cash, pizzastore.peperoniStock, pizzastore.mushroomStock, pizzastore.cheeseStock); //��� ���� ��, ��� �� ��� �ܰ� ���
                }
            }
            else { // 1,2 �̿��� ���� �ԷµǸ� ���� ����
                break;
            }
        }
    }
}
