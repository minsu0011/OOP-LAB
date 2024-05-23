import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TXTHandler implements IFileHandler{

    @SuppressWarnings("resource")
    public PizzaStore InitPizzaStore(String fileLocation){
        Scanner inputStream = null;
        String[] arr = new String[4];  // File에서 String의 순서
        double cash = 0;
        int[] res = new int[3]; // 재료의 개수 저장하는 배열
        arr[0] = "Money";arr[1] = "Cheese";arr[2] = "Peperoni";arr[3] = "Mushroom";
        try{
            FileInputStream fis = new FileInputStream(fileLocation); // FileInputStream 객체 생성
            inputStream = new Scanner(fis); // FileInputStream으로 입력받음
        } catch(FileNotFoundException e){ // fileLocation에 해당하는 File이 없으면 Exception
            System.out.println("File Not Found!");
            return null;
        }
        String input = null;
        try{
            inputStream.useDelimiter(";|\\r\\n|:"); // ;과 :과 개행(\r\n)을 delimiter로 가짐
            for(int count = 0 ; count < 8 ; count++){ // 8개의 Field 입력받음
                if(count % 2 == 0){ // Money 혹은 재료 이름(Cheese 등)
                    input = inputStream.next();
                    if(!(arr[count/2].equals(input))) throw new Exception(input);  // 입력받은 이름과 재료의 이름이 다르면 Exception
                }
                else if(count == 1){ // Money의 값 입력받음
                    input = inputStream.next();
                    cash = Double.parseDouble(input); // Double로 변환하여 저장
                }
                else if(count != 1 && count % 2 == 1){ // 재료의 개수 입력받음
                    input = inputStream.next();
                    res[count/2 - 1] = Integer.parseInt(input); // Integer로 변환하여 저장
                }
            }
        } catch(NumberFormatException e){ // Double, Integer 변환 과정에서 Exception 발생할 경우
            System.out.println("Input Type Error");
            return null;
        } catch(Exception e){
            System.out.println("Error : Unknown variable: " + e.getMessage());
            return null;
        }
        return new PizzaStore(cash, res[1], res[2], res[0]); // PizzaStore 객체 생성하여 리턴
    }
    public void writeToFile(String fileLocation, String text){
        try{
            PrintWriter outputStream = null;
            outputStream = new PrintWriter(new FileOutputStream(fileLocation)); // outputStream 설정
            outputStream.println(text); // text를 rewrite
            outputStream.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found!");
        }
    }
}
