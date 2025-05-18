public class RealImage implements Image{
    String file;
    public RealImage(String file){
        this.file = file;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + file);
    }
    @Override
    public void display() {
        System.out.println("This is real image");
    }
}
