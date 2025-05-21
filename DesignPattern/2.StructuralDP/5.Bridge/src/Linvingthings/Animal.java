package Linvingthings;

public class Animal extends AbstractLivingThing{

    public Animal(LivingThing livingThing){
          super(livingThing);
    }
    @Override
    public void performAction() {
        System.out.println("I am an animal");
        livingThing.breatheOrPhotosynthesize();
    }
}
