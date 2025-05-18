public class Main {
    public static void main(String[] args) {
        Image proxyImage = new ProxyImage("Anurag");
        proxyImage.display(); // First time proxy will show but hiding how the real image are creating.
        proxyImage.display();
    }
}
