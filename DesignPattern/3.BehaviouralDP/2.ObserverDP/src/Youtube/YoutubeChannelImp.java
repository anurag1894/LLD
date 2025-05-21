package Youtube;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannelImp implements YoutubeChannel {
    List<Subscriber> subscribers;
    List<String> videoList;
    public YoutubeChannelImp() {
        subscribers = new ArrayList<Subscriber>();
        videoList = new ArrayList<>();
    }
    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String video) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(video);
        }
    }

    void addVideo(String video) {
        videoList.add(video);
        notifySubscribers(video);
    }

}
