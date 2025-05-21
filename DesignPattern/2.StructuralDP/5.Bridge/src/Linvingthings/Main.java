package Linvingthings;

public class Main {
    public static void main(String[] args) {
        LivingThing breadth = new Breadth();
        LivingThing tree = new Tree();

        // Animal using breadth (breathing)
        AbstractLivingThing animal = new Animal(breadth);
        animal.performAction();  // Output: Animal: Breathing...

        // Plant using tree (photosynthesis)
        AbstractLivingThing plant = new Plant(tree);
        plant.performAction();  // Output: Plant: Performing photosynthesis...
    }
}
