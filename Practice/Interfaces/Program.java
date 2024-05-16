public class Program{
    public static void main(String[] args){
        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Tiger();
        animals[2] = new Turtle();
        Person person = new Person(){
            private int hp = 100;
            public void control(Animal animal){
                if(animal instanceof Tiger){
                    hp -= 80;
                    System.out.println("You have overpowered the Tiger");
                }
                else if(animal instanceof Dog){
                    hp -= 10;
                    System.out.println("You have overpowered the Dog");
                }
                else if(animal instanceof Turtle){
                    System.out.println("You have overpowered the Turtle");
                }
            }
            public void showInfo(){
                System.out.println("Person HP: " + hp);
            }
        };

        showResult(animals, person);
    }
    private static void showResult(Animal[] animals, Person p){
        for(int i = 0 ; i < animals.length ; i++){
            System.out.println("Animal" + (i+1) + ":" + animals[i].getName());
            if(animals[i] instanceof Tiger){
                System.out.println("Animal" + (i+1) + " barked " + ((Tiger) animals[i]).bark());
            }
            else if(animals[i] instanceof Dog){
                System.out.println("Animal" + (i+1) + " barked " + ((Dog) animals[i]).bark());
            }
            p.control(animals[i]);
            p.showInfo();
        }
    }
}
