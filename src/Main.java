public class Main {
    public static void main(String[] args) {
        ZooShop shop = new ZooShop(5);

        shop.addAnimal(new Animal("Рекс", 1, "Шпиц", 1000));
        shop.addAnimal(new Animal("Мурка", 2, "Персидская", 800));
        shop.addAnimal(new Animal("Кеша", 3, "Ара", 1500));


        shop.removeAnimal("Мурка");

        shop.displayAnimals();

//        Animal found = shop.findAnimal("Кеша");
//        if (found != null) {
//            found.displayInfo();
//        } else {
//            System.out.println("Животное не найдено.");
//        }
    }
}

class Animal {
    String name;
    int age;
    String breed;
    int price;

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
    private Animal[] animals;
    private int count;

    public ZooShop(int size) {
        this.animals = new Animal[size];
        this.count = 0;
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

    public Animal findAnimal(String name) {
        for (int i = 0; i < count; i++) {
            if (animals[i].name.equals(name)) {
                return animals[i];
            }
        }
        return null;
    }
}
