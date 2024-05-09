import java.util.Scanner;
public class Market{
    public static void main(String[] args){
        Wallet wallet = new Wallet("abc");
        Scanner scan = new Scanner(System.in);
        while(true){
            try{
                wallet.empty();
                System.out.print("Enter price: ");
                int num = scan.nextInt();
                if(num < 0){
                    throw new NegativeException();
                }
                else if(num > 100){
                    throw new TooMuchExpenseException(num);
                }
                else if(num > wallet.getBalance()){
                    throw new TooMuchExpenseException();
                }
                else{ // 0 <= num <= wallet.balance
                    System.out.println("peace~~");
                    wallet.increaseIndex();
                    wallet.decreaseBalance(num);
                }
            } catch(NegativeException e){
                System.out.println(e);
                System.out.println("\tat " + e.getStackTrace()[0]);
                System.out.println("on, sorry!");
            } catch(TooMuchExpenseException e){
                System.out.println(e);
                System.out.println("\tat " + e.getStackTrace()[0]);
                if(e.getMessage().equals("Over the limit!"))
                    System.out.println("you pay " + e.getInputNum());
                System.out.println("oh, my!");
            } catch(Exception e){ 
                if(e.getMessage().equals("Go Home")){
                    System.out.println(e);
                    System.out.println("\tat " + e.getStackTrace()[0]);
                    System.out.println("the end...");
                    scan.close();
                    return;
                }
            } finally{
                System.out.println(wallet.toString());
                System.out.println("--transaction complete--\n");
            }
        }
    }
}