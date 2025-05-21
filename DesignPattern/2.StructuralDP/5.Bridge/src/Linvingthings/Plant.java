package Linvingthings;

public class Plant extends AbstractLivingThing{
    public Plant(LivingThing livingThing) {
        super(livingThing);
    }
    @Override
    public void performAction() {
        System.out.println("I am planting");
        livingThing.breatheOrPhotosynthesize();
    }
}
