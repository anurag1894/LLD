package Youtube;

public class Main {
    public static void main(String[] args) {
        YoutubeChannelImp channel = new YoutubeChannelImp();

        Subscriber subscriberEmail1 = new EmailSubscriber("anuragjha","Anurag Jha");
        Subscriber subscriberEmail2 = new EmailSubscriber("anu","monika upadhyay");
        channel.addSubscriber(subscriberEmail1);
        channel.addSubscriber(subscriberEmail2);
        channel.addVideo("Engagement Video");

        Subscriber subscriberYoutube1    = new YoutubeSubscriber("Anshu jha");
        Subscriber subscriberYoutube2    = new YoutubeSubscriber("monika upadhyay");
        channel.addSubscriber(subscriberYoutube1);
        channel.addSubscriber(subscriberYoutube2);
        channel.removeSubscriber(subscriberEmail1);
        channel.addVideo("shadhi Video");

    }
}
