public class ProxyImage implements Image{
    RealImage realImage;
    String file;
    public ProxyImage(String file){
        this.file =file;
    }

    @Override
    public void display() {
        if(realImage ==null){
            realImage = new RealImage(file);
            System.out.println("This is proxy image display");
        }
        realImage.display();
    }
}
