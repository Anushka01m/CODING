public interface Mammals {
    void printMammalMessage();
}

public interface MarineAnimals {
    void printMarineAnimalMessage();
}

public class BlueWhale implements Mammals, MarineAnimals {

    @Override
    public void printMammalMessage() {
        System.out.println("I am a mammal.");
    }

    @Override
    public void printMarineAnimalMessage() {
        System.out.println("I am a marine animal.");
    }

    public void printBothCategories() {
        System.out.println("I belong to both the categories: Mammals as well as Marine Animals.");
    }
}

public class Main {
    public static void main(String[] args) {
        BlueWhale blueWhale = new BlueWhale();

        // Call methods from the interfaces
        blueWhale.printMammalMessage();
        blueWhale.printMarineAnimalMessage();
        blueWhale.printBothCategories();
    }
}
