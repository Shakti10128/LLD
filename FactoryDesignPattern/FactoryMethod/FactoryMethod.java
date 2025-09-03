package FactoryDesignPattern.FactoryMethod;


enum BurgerType{
    BASIC,
    STANDARD,
    PREMUIM
}

interface Burger{
    public abstract void prepare();
}

// NORMAL BURGER
class BasicBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("preparing basic Burger with bun, patty,cheese, and ketchup");
    }
}

class StandardBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("preparing standard Burger with bun, patty,cheese, and lettuce");
    }
}

class PremuimBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("preparing premuim Burger with gourmet bun, patty,cheese, and ketchup and secret souce");
    }
}

// WHEAT BURGER
class BasicWheatBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("preparing basic wheat Burger with bun, patty,cheese, and ketchup");
    }
}

class StandardWheatBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("preparing standard wheat Burger with bun, patty,cheese, and lettuce");
    }
}

class PremuimWheatBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("preparing premuim wheat Burger with gourmet bun, patty,cheese, and ketchup and secret souce");
    }
}


// BURGER FACTORY
interface BurgerFactory{
    public abstract Burger createBurger(BurgerType type);
}

// make normal burgers based on type
class SinghBurgerFactory implements BurgerFactory{
    @Override
    public Burger createBurger(BurgerType type) {
        if(type.equals(BurgerType.BASIC)) {
            return new BasicBurger();
        }
        else if(type.equals(BurgerType.STANDARD)) {
            return new StandardBurger();
        }
        else if(type.equals(BurgerType.PREMUIM)) {
            return new PremuimBurger();
        }
        else {
            System.out.println("Invalid burger type");
            return null;
        }
    }
}

// make wheat burgers based on type
class KingBurgerFactory implements BurgerFactory{
    @Override
    public Burger createBurger(BurgerType type) {
        if(type.equals(BurgerType.BASIC)) {
            return new BasicWheatBurger();
        }
        else if(type.equals(BurgerType.STANDARD)) {
            return new StandardWheatBurger();
        }
        else if(type.equals(BurgerType.PREMUIM)) {
            return new PremuimWheatBurger();
        }
        else {
            System.out.println("Invalid burger type");
            return null;
        }
    }
}


public class FactoryMethod {
    public static void main(String[] args) {
        BurgerFactory factory = new KingBurgerFactory();
        Burger premuimBurger = factory.createBurger(BurgerType.STANDARD);
        premuimBurger.prepare();
    }
}
