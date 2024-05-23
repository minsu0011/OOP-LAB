public interface IFileHandler { // interface 생성
    PizzaStore InitPizzaStore(String fileLocation);
    void writeToFile(String fileLocation, String text);
}
