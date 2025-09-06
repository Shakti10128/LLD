
public interface IChannel{

    public abstract void subscribe(ISubscriber subscriber);

    public abstract void unSubscribe(ISubscriber subscriber);

    public abstract void notifySubscribers(String data);

    public abstract String getChannelName();
}