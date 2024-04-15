import java.time.*;

public class AccountManager {
    public static void main(String[] args){
        int cnt = 0;
        int flag = 0;
        LocalDate created = LocalDate.of(2021,12,01); //������ ��¥
        int year = 2021;
        int month = 12;
        int day = 01;
        Account account = new Account("Jeon", 5, created); //���� ����
        System.out.println(account.toString()); //ó������ ���
        while(account.getBalance() <= 10000){ // �ݺ��� ����
            cnt++; // �Ѵ��� ���������� ī��Ʈ
            month++; // �Ѵ� ����
            if(month >= 13){ // 12�� ���� 1���� �Ѿ��
                year++;
                month = 1;
            }
            account.receiveIncome(100); // 100 �߰�
            account.receiveInterest(); // ���� ����
            
            if((cnt / 12) >= 1 && month == 1){ // �̺�Ʈ ����
                if((int)(Math.random()*10) % 10 == 1){ // 0~9 ���������� 10%Ȯ��
                    System.out.println("�̺�Ʈ ��÷!");
                    account.receiveIncome(100); // ��÷�� ����
                }
            }
            if(cnt % 36 == 0 && flag == 0){ // 3��� �ѹ� ������ �λ�
                System.out.println("���� �� 3���� ������ �������� 2% �λ�Ǿ����ϴ�");
                flag = 1;
                account.increaseYearlyInterest(2);
            }
        }
        String result = account.toString() + ", 1�� ������ �� : ";
        System.out.printf("%s%d-%d-%d", result, year, month, day);
    }
}
