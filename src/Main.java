public class Main {
    public static void main(String[] args) {
        ZooShop shop = new ZooShop(10);

        Animal cat = new Animal("Барсик", 3, "Сибірська", 500);
        Animal dog = new Animal("Рекс", 5, "Німецька вівчарка", 1000);

        shop.addAnimal(cat);
        shop.addAnimal(dog);

        shop.displayAnimals();

        Customer customer = new Customer("Іван", 1200);
        customer.displayInfo();

        customer.buyAnimal(shop, "Рекс");
        customer.displayInfo();

        shop.displayAnimals();



    }
}

class Animal {
    String name;
    int age;
    String breed;
    int price;


    public Animal(){
        this.name = "Неизвестно";
        this.age = 0;
        this.breed = "Неизвестно";
        this.price = 0;

    }

    public Animal(String name, int age, String breed, int price) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Кличка: " + name + ", Возраст: " + age +
                ", Порода: " + breed + ", Цена: " + price);
    }
}

class ZooShop {
     Animal[] animals;
     public static int count = 0;

    public ZooShop(int size) {
        this.animals = new Animal[size];

    }

    public void addAnimal(Animal animal) {
        if (count < animals.length) {
            animals[count] = animal;
            count++;
        } else {
            System.out.println("Магазин заполнен.");
        }
    }

    public void removeAnimal(String name) {
        for (int i = 0; i < count; i++) {
            if (animals[i] != null && animals[i].name.equals(name)) {
                for (int j = i; j < count - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }

    public void displayAnimals() {
        if (count == 0) {
            System.out.println("Магазин пуст.");
        } else {
            System.out.println("Животные в магазине:");
            for (int i = 0; i < count; i++) {
                animals[i].displayInfo();
            }
        }
    }


    public void displayAnimalInfo(String name) {
        for (int i = 0; i < count; i++) {
            if (animals[i] != null && animals[i].name.equals(name)) {
                animals[i].displayInfo();
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }
}

class Customer{
    String name;
    int money;


    public Customer(String name, int money){
        this.name = name;
        this.money = money;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Баланс: " + money);
    }

    public void buyAnimal(ZooShop shop, String animalName){

        for (int i = 0; i < ZooShop.count; i++) {
            if (shop.animals[i] != null && shop.animals[i].name.equals(animalName) && shop.animals[i].price <= money) {
                money -= shop.animals[i].price;
                for (int j = i; j < ZooShop.count - 1; j++) {
                    shop.animals[j] = shop.animals[j + 1];

                }
                shop.animals[ZooShop.count - 1] = null;

                System.out.println("Поздравляем! Вы успешно купили животное!");

                ZooShop.count--;
                return;
            }else if (shop.animals[i].price > money){
                System.out.println("Ошибка: У вас недостадочно денег");
                return;

            }else if (shop.animals[i] == null){
                System.out.println("Извините магазин пуст");
                return;
            }else if (shop.animals[i].name.equals(animalName)){
                System.out.println("Ошибка: Животного с таким именем не найдено");
            }
        }


    }


}
