package FactoryDesignPattern.SimpleFactory;


enum BurgerType{
    BASIC,
    STANDARD,
    PREMUIM
}

interface Burger {
    public abstract void prepare();
}


class BasicBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("preparing basic burger with bun, patty, and catchup!");
    }
}

class StandardBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("preparing standard burger with bun,pattey,cheese, and lettuce");
    }
}

class PremiumBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("preparing premuim burger with govermet bun,pattey,cheese, and lettuce and secret souce");
    }
}

class BurgerFactory{
    public Burger createBurger(BurgerType type) {
        if(type.equals(BurgerType.BASIC)) {
            return new BasicBurger();
        }
        else if(type.equals(BurgerType.STANDARD)) {
            return new StandardBurger();
        }
        else if(type.equals(BurgerType.PREMUIM)) {
            return new PremiumBurger();
        }
        else{
            System.out.println("Invalid Burger type");
            return null;
        }
    }
}



public class SimpleFactory {

    public static void main(String[] args) {
        BurgerFactory factory = new BurgerFactory();
        Burger standardBurger = factory.createBurger(BurgerType.STANDARD);
        standardBurger.prepare();
    }
}