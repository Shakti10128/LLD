

interface WalkableRobot{
    public abstract void walk();
}

class NormalWalk implements WalkableRobot{
    public  void walk() {
        System.out.println("Walking normally.....");
    }
}

class NoWalk implements WalkableRobot {
    public void walk() {
        System.out.println("Cannot walk");
    }
}

interface TalkableRobot{
    public abstract void talk();
}

class NormalTalk implements TalkableRobot {
    public void talk(){
        System.out.println("Talking normally.....");
    }
}

class NoTalk implements TalkableRobot{
    public void talk(){
        System.out.println("Cannot talk");
    }
}

interface FlyableRobot {
    public abstract void fly();
}

class NormalFly implements FlyableRobot {
    public void fly(){
        System.out.println("Flying normally......");
    }
}

class NoFly implements FlyableRobot {
    public void fly(){
        System.out.println("Cannot fly");
    }
}


abstract class Robot {
    private final WalkableRobot walkableRobot;
    private final TalkableRobot talkableRobot;
    private final FlyableRobot flyableRobot;

    public Robot(WalkableRobot walkableRobot,TalkableRobot talkableRobot, FlyableRobot flyableRobot) {
        this.walkableRobot = walkableRobot;
        this.talkableRobot = talkableRobot;
        this.flyableRobot = flyableRobot;
    }

    public void walk(){
        this.walkableRobot.walk();
    }

    public void talk(){
        this.talkableRobot.talk();
    }

    public void fly(){
        this.flyableRobot.fly();
    }

    public abstract void projection();
}

class CompanionRobot extends Robot {

    public CompanionRobot(WalkableRobot walkableRobot,TalkableRobot talkableRobot, FlyableRobot flyableRobot) {
        super(walkableRobot, talkableRobot, flyableRobot);
    }

    public void projection(){
        System.out.println("Displaying normal companion robot");
    }
}

class WorkerRobot extends Robot {
    public WorkerRobot(WalkableRobot walkableRobot,TalkableRobot talkableRobot, FlyableRobot flyableRobot) {
        super(walkableRobot, talkableRobot, flyableRobot);
    }

    public void projection(){
        System.out.println("Displaying normal worker robot");
    }
}

class CrowRobot extends Robot {
    public CrowRobot(WalkableRobot walkableRobot,TalkableRobot talkableRobot, FlyableRobot flyableRobot) {
        super(walkableRobot, talkableRobot, flyableRobot);
    }

    public void projection(){
        System.out.println("Displaying normal crow robot");
    }
}


public class StrategyDesingPattern {
    public static void main(String[] args) {
        Robot campanionRobot = new CompanionRobot(new NormalWalk(),new NormalTalk(),new NoFly());
        campanionRobot.walk();
        campanionRobot.talk();
        campanionRobot.projection();
        campanionRobot.fly();

        System.out.println("---------------------------------");

        Robot crowRobot =  new CrowRobot(new NoWalk(),new NormalTalk(),new NormalFly());
        crowRobot.walk();
        crowRobot.talk();
        crowRobot.projection();
        crowRobot.fly();
    }
}