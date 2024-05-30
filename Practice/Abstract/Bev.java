package Abstract;
import java.time.LocalDate;

public class Bev extends Car{
    private static int carNum;
    private static int co2emission;
    private final int GHGPERCAR = 25;
    public Bev(){};
    public Bev(String name, LocalDate date, int carNum){
        this.name = name;
        this.date = date;
        Bev.carNum = Bev.carNum + carNum;
        Bev.co2emission = Bev.co2emission + carNum * GHGPERCAR;
    }

    public boolean equals(Object obj){
        if(obj instanceof Ice){ // Ice Class의 인스턴스 인가?
            Ice newobj = (Ice)obj;
            if(newobj.name.equals(this.name) && newobj.date.equals(this.date)) return true;
            else return false;
        }
        else if(obj instanceof Bev){ // Bev Class의 인스턴스인가?
            Bev newobj = (Bev)obj;
            if(newobj.name.equals(this.name) && newobj.date.equals(this.date)) return true;
            else return false;
        }
        else return false;
    }
    public String toString(){
        String result;
        result = "name: " + name + ", date: " + date + ", carNum: " + carNum;
        return result;
    }
    public int totalCO2(){
        System.out.println("BEV emit CO2 most when generating electric energy");
        return co2emission;
    }
}
