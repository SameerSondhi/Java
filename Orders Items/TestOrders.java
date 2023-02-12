public class TestOrders {
    public static void main(String[] args) {
    
        //ALL ITEMS
        Item item1 = new Item("mocha", 3.5);
        
        Item item2 = new Item("latte", 3.2);

        Item item3 = new Item("drip coffee", 1.5);

        Item item4 = new Item("capuccino", 2.5);
    
        //ALL ORDERS.
        //GUEST ORDERS
        Order order1 = new Order();
        
        Order order2 = new Order();


        //ORDERS WITH NAMES
        Order order3 = new Order("Noah");

        Order order4 = new Order("Sam");
    
        Order order5 = new Order("Cindhuri");


        //ADD ITEMS TO ORDERS
        order3.addItem(item1);
        order3.addItem(item2);

        order4.addItem(item3);
        order4.addItem(item4);

        order5.addItem(item1); 
        order5.addItem(item4);


        //STATUS MESSAGES
        System.out.println(order3.getStatusMessage());
        order3.setReady(true);
        System.out.println(order3.getStatusMessage());


        //GETTING ORDER TOTALS
        System.out.println(order3.getOrderTotal());
        

        //DISPLAY ORDER
        order3.display();
    }   


}
        
