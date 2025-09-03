package TomatoFoodDelivery.Code.models;

public class User {
    private static int nextUserId;
    private int userId;
    private String name;
    private String address;
    private Cart cart;


    public User(String name,String address) {
        this.name = name;
        this.address = address;
        this.cart = new Cart();
        this.userId = ++nextUserId;
    }

    public int getUserId(){
        return this.userId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    public Cart getCart(){
        return this.cart;
    }
}
