package Drawing;




public class Circle extends shape {
    private int radius;
    public Circle(Renderer renderer,int radius) {
        super(renderer);
        this.radius = radius;
    }
    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }
}
