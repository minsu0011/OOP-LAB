
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Account{

    private String name;
    private double yearlyInterest;
    private double balance;
    private LocalDate created;

    public Account(String name, double yearlyInterest, LocalDate created){
        this.name = name;
        this.yearlyInterest = yearlyInterest;
        this.created = created;
        this.balance = 0;
    }

    public double getBalance(){
        return this.balance;
    }

    public LocalDate getCreated(){
        return this.created; 
    }

    public void increaseYearlyInterest(int byPercent){
        this.yearlyInterest = this.yearlyInterest + byPercent;
    }

    public void receiveIncome(double income){
        this.balance = this.balance + income;
    }

    public void receiveInterest(){
        this.balance = this.balance + this.balance*this.yearlyInterest/1200;
    }

    public String toString(){
        String a; //convertedDate << ���� �ٲپ ���
        String convertedDate = created.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        a = "�̸� : " + this.name + " ������ : " + String.valueOf(this.yearlyInterest) + " �ܰ� : " + String.valueOf(this.balance) + " ������ : " + convertedDate; 
        return a;
    }
}