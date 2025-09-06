import java.util.ArrayList;
import java.util.List;

public class Channel implements IChannel{
    private final String channelName;
    private final List<ISubscriber> subscribers = new ArrayList<ISubscriber>();

    public Channel(String channelName) {
        this.channelName = channelName;
    }
    
    @Override
    public void subscribe(ISubscriber subscriber) {
        if(!this.subscribers.contains(subscriber)) {
            this.subscribers.add(subscriber);
        }
    }

    @Override
    public void unSubscribe(ISubscriber subscriber){
        if (subscribers.remove(subscriber)) {
            System.out.println(subscriber.getUserName() + " has unsubscribed from " + channelName);
        }
    }

    @Override
    public void notifySubscribers(String data){
        for(ISubscriber subscriber: subscribers) {
            subscriber.update(this,data);
        }
    }

    public void uploadVideo(String videoData) {
        System.out.println("\nChannel " + channelName + " uploaded: " + videoData);
        notifySubscribers(videoData);
    }

    @Override
    public String getChannelName(){
        return this.channelName;
    }
}
