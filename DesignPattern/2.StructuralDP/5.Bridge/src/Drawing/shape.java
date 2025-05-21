package Drawing;

public abstract class shape {
    protected Renderer renderer;
    public shape(Renderer renderer){
        this.renderer = renderer;
    }
    public abstract void draw();
}
