package TomatoFoodDelivery.Code.models;

public class MenuItem {
    private String code;
    private String name;
    private int price;

    public MenuItem(String code,String name,int price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
    
}
