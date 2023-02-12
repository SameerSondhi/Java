import java.util.ArrayList;

public class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

//CONSTRUCTOR 
public Order(){
    this.name = "Guest";
    this.items = new ArrayList<Item>();
}

//OVERLOADED CONSTRUCTOR
public Order(String name){
    this.name=name;
    this.items = new ArrayList<Item>();
}

//ORDER METHODS GO HERE
//ADD ITEMS
public void addItem(Item item){
        items.add(item);

}

//GET STATUS MESSAGE
public String getStatusMessage(){
    if(this.ready){
        return "Your order is ready.";
    }
    else{
        return "Thank you for waiting, your order will be ready soon.";
    }
}

//GET TOTAL FOR ORDER
public double getOrderTotal(){
    double total = 0;
    for(Item item : items){
        total += item.getPrice();
    }
    return total;

}

//DISPLAY METHOD
public void display(){
    System.out.println("Customer Name: " + this.name);
    for(Item item : items){
        System.out.println(item.getName() + " : $" + item.getPrice());
    }
    System.out.println("Your total is: $" + getOrderTotal());
}


//GETTER for name
public String getName(){
    return this.name;
}

//SETTER for name
public void setName(String name){
    this.name = name;
}

//GETTER for price
public boolean getReady(){
    return this.ready;
}

//SETTER for price
public void setReady(boolean ready){
    this.ready = ready;
}

//GETTER for items
public ArrayList<Item> items(){
    return this.items;
}

//SETTER for items
public void setItems(ArrayList<Item> items){
    this.items = items;
}
}