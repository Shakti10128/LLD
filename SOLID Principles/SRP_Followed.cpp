#include<bits/stdc++.h>
using namespace std;


class Product{
private:
    string name;
    double price;

public:

    Product(string name,double price) {
        this->name = name;
        this->price = price;
    }

    string getName(){
        return this->name;
    }

    double getPrice(){
        return this->price;
    }
};


// 1: ShoppingCart only responsible for cart related business logic
class ShoppingCart{
private:
    vector<Product*> products;

public:
    // add the product into the cart
    void addProduct(Product * product){
        this->products.push_back(product);
    }

    // get all the product of the cart
    vector<Product*>& getProducts(){    
        return this->products;
    }   

    // calculating the totalPrice of the cart products
    double getTotalPrice(){
        double totalPrice = 0;
        for(Product* p: this->products) {
            totalPrice+= p->getPrice();
        }
        return totalPrice;
    }
};

class ShoppingCartPrinter{
private:
    ShoppingCart * cart;

public:
    ShoppingCartPrinter(ShoppingCart* cart){
        this->cart = cart;
    }

    void printInvoice(){
        cout<<"Shopping cart Invoice"<<endl;
        for(Product * p: this->cart->getProducts()) {
            cout<<p->getName()<<" - $"<<p->getPrice()<<endl;
        }
        cout<<"Total Price: $"<<this->cart->getTotalPrice()<<endl;
    }
};

class ShoppingCartStorage{
private:
    ShoppingCart * cart;
public:

    ShoppingCartStorage(ShoppingCart * cart){
        this->cart = cart;
    }

    void saveToDB(){
        cout<<"Saving Shopping Cart to DB"<<endl;
    }
};


int main(){
    ShoppingCart * cart = new ShoppingCart(); 
    cart->addProduct(new Product("Laptop",1500));
    cart->addProduct(new Product("Mouse",500));

    ShoppingCartPrinter * printer = new ShoppingCartPrinter(cart);
    printer->printInvoice();

    ShoppingCartStorage * db = new ShoppingCartStorage(cart);
    db->saveToDB();
}