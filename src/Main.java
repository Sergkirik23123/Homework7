public class Main {
    public static void main(String[] args) {

        Animal dog = new Animal("Рекс", 1, "Шпиц", 1000);

        dog.displayInfo();

    }
}

class Animal{
    String name;
    int age;
    String breed;
    int prise;

    public Animal(){
        name = "Unknown";
        age = 0;
        breed = "Unknown";
        prise = 0;

    }

    public Animal(String name, int age, String breed, int prise) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.prise = prise;
    }

    public void displayInfo(){
        System.out.println("Кличка - " + name + ": " + "Возраст - " + age + ": " + "Порода - " + breed + ": " + "Цена - " + prise);

    }

}