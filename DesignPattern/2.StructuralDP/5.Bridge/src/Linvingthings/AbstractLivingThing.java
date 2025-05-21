package Linvingthings;

public abstract  class AbstractLivingThing {
   protected LivingThing livingThing;

    public AbstractLivingThing(LivingThing livingThing) {
        this.livingThing = livingThing;
    }
    public abstract void performAction();
}
