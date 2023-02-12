public class Item{
      private String name;
      private double price;


//CONSTRUCTOR
public Item(String name, double price){
      this.name= name;
      this.price= price;
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
public double getPrice(){
      return this.price;

}

//SETTER for price
public void setPrice(double price){
      this.price = price;

}

}