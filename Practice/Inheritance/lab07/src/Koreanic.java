public class Koreanic extends Language {
    public Koreanic(String name, int numSpeakers){
        super(name, numSpeakers, null, null);
        this.regionsSpoken = "Korean peninsula(South Korea, North Korea, Jeju) and several prefectures of China";
        this.wordOrder = "subject-object-verb";
        this.name = name;
        this.numSpeakers = numSpeakers;
        if(name.contains("Jeju")) this.regionsSpoken = "Jeju island";
    }
}
