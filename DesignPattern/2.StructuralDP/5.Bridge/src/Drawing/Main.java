package Drawing;

public class Main {
    public static void main(String[] args) {
        Renderer rasterRenderer = new RasterRenderer();
        Renderer vectorRenderer = new VectorRenderer();
        shape rasterCircle = new Circle(rasterRenderer, 5);
        shape vectorCircle = new Circle(vectorRenderer, 5);
        shape rasterRectangle = new Rectangle(rasterRenderer, 10, 5);
        shape vectorRectangle = new Rectangle(vectorRenderer, 10, 5);
        rasterCircle.draw();
        vectorCircle.draw();
        rasterRectangle.draw();
        vectorRectangle.draw();
    }
}
