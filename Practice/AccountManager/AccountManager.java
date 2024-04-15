import java.time.*;

public class AccountManager {
    public static void main(String[] args){
        int cnt = 0;
        int flag = 0;
        LocalDate created = LocalDate.of(2021,12,01); //생성된 날짜
        int year = 2021;
        int month = 12;
        int day = 01;
        Account account = new Account("Jeon", 5, created); //계좌 생성
        System.out.println(account.toString()); //처음정보 출력
        while(account.getBalance() <= 10000){ // 반복문 수행
            cnt++; // 한달이 지날때마다 카운트
            month++; // 한달 증가
            if(month >= 13){ // 12월 다음 1월로 넘어가기
                year++;
                month = 1;
            }
            account.receiveIncome(100); // 100 추가
            account.receiveInterest(); // 이자 받음
            
            if((cnt / 12) >= 1 && month == 1){ // 이벤트 수행
                if((int)(Math.random()*10) % 10 == 1){ // 0~9 랜덤수생성 10%확률
                    System.out.println("이벤트 당첨!");
                    account.receiveIncome(100); // 당첨금 수령
                }
            }
            if(cnt % 36 == 0 && flag == 0){ // 3년뒤 한번 이자율 인상
                System.out.println("가입 후 3년이 지나서 이자율이 2% 인상되었습니다");
                flag = 1;
                account.increaseYearlyInterest(2);
            }
        }
        String result = account.toString() + ", 1억 모으기 끝 : ";
        System.out.printf("%s%d-%d-%d", result, year, month, day);
    }
}
