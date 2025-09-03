package FactoryDesignPattern.AbstractFactoryMethod;

// Enums for product variations
enum BurgerType {
    BASIC, STANDARD, PREMIUM
}

enum GarlicBreadType {
    BASIC, STANDARD, PREMIUM
}

// ------------------ Product Interfaces ------------------
interface Burger {
    void prepare();
}

interface GarlicBread {
    void prepare();
}

// ------------------ Concrete Burgers ------------------
class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, cheese, and ketchup");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, patty, cheese, ketchup, and secret sauce");
    }
}

// ------------------ Concrete Garlic Breads ------------------
class BasicGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Garlic Bread");
    }
}

class StandardGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Garlic Bread");
    }
}

class PremiumGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Garlic Bread");
    }
}

// ------------------ Wheat Burgers ------------------
class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, cheese, and ketchup");
    }
}

class StandardWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce");
    }
}

class PremiumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with gourmet bun, patty, cheese, ketchup, and secret sauce");
    }
}

// ------------------ Wheat Garlic Breads ------------------
class BasicWheatGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Garlic Bread");
    }
}

class StandardWheatGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Wheat Garlic Bread");
    }
}

class PremiumWheatGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Wheat Garlic Bread");
    }
}

// ------------------ Abstract Factory ------------------
interface MealFactory {
    Burger createBurger(BurgerType type);
    GarlicBread createGarlicBread(GarlicBreadType type);
}

// ------------------ Concrete Factories ------------------
class SinghFactory implements MealFactory {
    @Override
    public Burger createBurger(BurgerType type) {
        return switch (type) {
            case BASIC -> new BasicBurger();
            case STANDARD -> new StandardBurger();
            case PREMIUM -> new PremiumBurger();
        };
    }

    @Override
    public GarlicBread createGarlicBread(GarlicBreadType type) {
        return switch (type) {
            case BASIC -> new BasicGarlicBread();
            case STANDARD -> new StandardGarlicBread();
            case PREMIUM -> new PremiumGarlicBread();
        };
    }
}

class KingFactory implements MealFactory {
    @Override
    public Burger createBurger(BurgerType type) {
        return switch (type) {
            case BASIC -> new BasicWheatBurger();
            case STANDARD -> new StandardWheatBurger();
            case PREMIUM -> new PremiumWheatBurger();
        };
    }

    @Override
    public GarlicBread createGarlicBread(GarlicBreadType type) {
        return switch (type) {
            case BASIC -> new BasicWheatGarlicBread();
            case STANDARD -> new StandardWheatGarlicBread();
            case PREMIUM -> new PremiumWheatGarlicBread();
        };
    }
}

// ------------------ Client ------------------
public class AbstractFactoryMethod {
    public static void main(String[] args) {
        // Choose factory (SinghFactory (Regular) / KingFactory (Wheat))
        MealFactory factory = new KingFactory();

        Burger standardBurger = factory.createBurger(BurgerType.STANDARD);
        GarlicBread premiumBread = factory.createGarlicBread(GarlicBreadType.PREMIUM);

        standardBurger.prepare();
        premiumBread.prepare();
    }
}
