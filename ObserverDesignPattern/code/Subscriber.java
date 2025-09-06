public class Subscriber implements ISubscriber{
    private final String userName;
    public Subscriber(String name){
        this.userName = name;
    }
    public void update(IChannel channel,String data) {
        System.out.println("Hey " + userName + ": " + channel.getChannelName()
                + " uploaded a new video → " + data);
    }

    @Override
    public String getUserName(){
        return this.userName;
    }
}
