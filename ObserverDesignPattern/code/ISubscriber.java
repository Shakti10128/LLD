public interface ISubscriber {
    public abstract void update(IChannel channel,String data);

    public String getUserName();
}
