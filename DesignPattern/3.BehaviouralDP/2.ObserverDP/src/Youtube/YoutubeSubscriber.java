package Youtube;

public class YoutubeSubscriber implements Subscriber {
    String name;
    public YoutubeSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void update(String videoTitle) {
        System.out.println(name + " received video title: " + videoTitle);
    }
}
