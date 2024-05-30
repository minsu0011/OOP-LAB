package Abstract;
import java.time.LocalDate;
public abstract class Car {
    protected String name;
    protected LocalDate date;
    public Car(){
        name = "Car Frame";
        date = null;
    }
    public abstract int totalCO2();
}
