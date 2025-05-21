package Drawing;

public class Rectangle extends shape{
    private int length;
    private int width;
    public Rectangle(Renderer renderer,int length, int width) {
        super(renderer);
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        renderer.renderRectangle(length,width);
    }
}
