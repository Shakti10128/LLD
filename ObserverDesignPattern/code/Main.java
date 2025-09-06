public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel("Coder army");

        ISubscriber subscriber1 = new Subscriber("Shakti kumar");
        ISubscriber subscriber2 = new Subscriber("Nikhil taprania");
        ISubscriber subscriber3 = new Subscriber("Sagar kumar");

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);
        channel.subscribe(subscriber3);

        // all subscriber will get notified
        channel.uploadVideo("Dijkstra Algorithm");
        System.out.println();

        // shakti has unsubscribe the channel
        channel.unSubscribe(subscriber1);
        
        System.out.println();
        // only Nikhil & Sagar will get notified as Shakti has unSubscribe the channel
        channel.uploadVideo("DSA Series");
    }
}
